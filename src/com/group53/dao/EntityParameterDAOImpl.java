package com.group53.dao;

import com.group53.beans.EntityParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Class EntityParameterDAOImpl is implementation of the class EntityParameterDAO
 */
public class EntityParameterDAOImpl implements EntityParameterDAO {
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Autowired
    private EntityDAOImpl entityDAO;

    @Override
    public List<EntityParameter> getAllParameters(final Long entityId) {
        String sql = "SELECT * FROM GRP5_ENTITY_PARAMETER WHERE ENTITY_ID=?";
        return template.query(sql,new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setLong(1, entityId);
            }
        }, new RowMapper<EntityParameter>() {
            @Override
            public EntityParameter mapRow(ResultSet resultSet, int i) throws SQLException {
                return new EntityParameter(resultSet.getLong("parameter_id"),
                        resultSet.getLong("entity_id"), resultSet.getString("string_value"),
                        resultSet.getInt("int_value"),resultSet.getDouble("decimal_value"),
                        resultSet.getLong("id_value"), resultSet.getDate("date_value"));
            }
        });
    }

    @Override
    public void saveParameterDB(EntityParameter entityParameter){

        if (entityParameter.getEntityId() !=null &&
                ((getParameter(entityParameter.getEntityId(), entityParameter.getParameterId()) != null &&
                (long) entityParameter.getParameterId() != (long) entityDAO.getId("mark")) ||
                ((getParameter(entityParameter.getEntityId(), entityParameter.getParameterId(), entityParameter.getDateValue()) != null &&
                        (long) entityParameter.getParameterId() != (long) entityDAO.getId("mark"))))) {

            String updateSQL = "UPDATE GRP5_ENTITY_PARAMETER  SET string_Value=?, int_Value=?, decimal_Value=?," +
                    " id_Value=?, date_Value=? where parameter_id=? and entity_id=?";


            template.update(updateSQL, entityParameter.getStringValue(), entityParameter.getIntValue(),
                    entityParameter.getDecimalValue(), entityParameter.getIdValue(), entityParameter.getDateValue(),
                    entityParameter.getParameterId(), entityParameter.getEntityId());

        }
        else {
            String insertSQL = "INSERT INTO GRP5_ENTITY_PARAMETER"
                    + "(parameter_id, entity_id, string_Value, int_Value, decimal_Value," +
                    " id_Value, date_Value) VALUES"
                    + "(?,?,?,?,?,?,?)";
            template.update(insertSQL, entityParameter.getParameterId(), entityParameter.getEntityId(),
                    entityParameter.getStringValue(), entityParameter.getIntValue(), entityParameter.getDecimalValue(),
                    entityParameter.getIdValue(), entityParameter.getDateValue());
        }

    }

    @Override
    public void deleteParameterDB(Long entityId, Long parameterID){
        String sql = "DELETE FROM GRP5_ENTITY_PARAMETER WHERE entity_Id=? AND parameter_id=?";
        template.update(sql, entityId, parameterID);
    }


    @Override
    public EntityParameter getParameter(final Long entityId, final Long parameterID) {
        String sql = "SELECT * FROM GRP5_ENTITY_PARAMETER WHERE  entity_Id=? and parameter_id=?";
        return template.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setLong(1, entityId);
                ps.setLong(2, parameterID);
            }
        }, new ResultSetExtractor<EntityParameter>() {
            @Override
            public EntityParameter extractData(ResultSet resultSet) throws SQLException {
                if (resultSet.next()) {
                    EntityParameter entityParameter = new EntityParameter();
                    entityParameter.setParameterId(resultSet.getLong("parameter_id"));
                    entityParameter.setEntityId(resultSet.getLong("entity_id"));
                    entityParameter.setStringValue(resultSet.getString("string_value"));
                    entityParameter.setIntValue(resultSet.getInt("int_value"));
                    entityParameter.setDecimalValue(resultSet.getDouble("decimal_value"));
                    entityParameter.setIdValue(resultSet.getLong("id_value"));
                    entityParameter.setDateValue(resultSet.getDate("date_value"));
                    return entityParameter;
                }
                return null;
            }
        });
    }

    @Override
    public EntityParameter getParameter(final Long entityId, final Long parameterID, final Date date) {
        String sql = "SELECT * FROM GRP5_ENTITY_PARAMETER WHERE  entity_Id=? and parameter_id=?" +
                " and DATE_VALUE=?" ;
        return template.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setLong(1, entityId);
                ps.setLong(2, parameterID);
                ps.setDate(3, date);
            }
        }, new ResultSetExtractor<EntityParameter>() {
            @Override
            public EntityParameter extractData(ResultSet resultSet) throws SQLException {
                if (resultSet.next()) {
                    EntityParameter entityParameter = new EntityParameter();
                    entityParameter.setParameterId(resultSet.getLong("parameter_id"));
                    entityParameter.setEntityId(resultSet.getLong("entity_id"));
                    entityParameter.setStringValue(resultSet.getString("string_value"));
                    entityParameter.setIntValue(resultSet.getInt("int_value"));
                    entityParameter.setDecimalValue(resultSet.getDouble("decimal_value"));
                    entityParameter.setIdValue(resultSet.getLong("id_value"));
                    entityParameter.setDateValue(resultSet.getDate("date_value"));
                    return entityParameter;
                }
                return null;
            }
        });
    }

    @Override
    public TreeSet<Date> getAllDatesByStudyLoad(final Long idValue) {
        String sql = "SELECT * FROM GRP5_ENTITY_PARAMETER WHERE ID_VALUE=?";
        List<Date> list = template.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setLong(1, idValue);
            }
        }, new RowMapper<Date>() {
            @Override
            public Date mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getDate("date_value");
            }
        });
        return new TreeSet<Date>(list);
    }

    @Override
    public Map<Date, Double> getAllMarksByStudent(TreeSet<Date> dates, final Long idValue, final Long entityId) {

        Map<Date, Double> treeMap = new TreeMap<Date, Double>();
        for (final Date date : dates){
            String sql = "SELECT * FROM GRP5_ENTITY_PARAMETER WHERE ENTITY_ID =? and ID_VALUE=? and DATE_VALUE =?" ;
            treeMap.put(date, template.query(sql, new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setLong(1, entityId);
                    ps.setLong(2, idValue);
                    ps.setDate(3, date);
                }
            }, new ResultSetExtractor<Double>() {
                @Override
                public Double extractData(ResultSet resultSet) throws SQLException {
                    if (resultSet.next()) {
                        return resultSet.getDouble("decimal_value");
                    }
                    return null;
                }
            }));
        }
        return treeMap;
    }

    @Override
    public TreeSet<Date> getAllDatesByStudent(final Long id) {
        String sql = "SELECT * FROM GRP5_ENTITY_PARAMETER WHERE ENTITY_ID=? and PARAMETER_ID=?";
        List<Date> list = template.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setLong(1, id);
                ps.setLong(2, entityDAO.getId("mark"));
            }
        }, new RowMapper<Date>() {
            @Override
            public Date mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getDate("date_value");
            }
        });
        return new TreeSet<Date>(list);
    }

    @Override
    public TreeSet<Long> getStudyLoadByGroup(final Long id) {
        String sql = "SELECT * FROM GRP5_ENTITY_PARAMETER WHERE ID_VALUE=? and PARAMETER_ID=?";
        List<Long> list =  template.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setLong(1, id);
                ps.setLong(2, entityDAO.getId("groupId"));
            }
        }, new RowMapper<Long>() {
            @Override
            public Long mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getLong("entity_id");
            }
        });
        return new TreeSet<Long>(list);
    }

    @Override
    public TreeSet<Long> getStudyLoadByTutor(final Long id) {
        String sql = "SELECT * FROM GRP5_ENTITY_PARAMETER WHERE ID_VALUE=? and PARAMETER_ID=?";
        List<Long> list =  template.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setLong(1, id);
                ps.setLong(2,  entityDAO.getId("tutorId"));
            }
        },  new RowMapper<Long>() {
            @Override
            public Long mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getLong("entity_id");
            }
        });
        return new TreeSet<Long>(list);
    }

    @Override
    public EntityParameter checkLogin(final String login) {

        String sql = "SELECT * FROM GRP5_ENTITY_PARAMETER WHERE  STRING_VALUE=? and PARAMETER_ID=?";
        return template.query(sql,  new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, login);
                ps.setLong(2, entityDAO.getId("login"));
            }
        }, new ResultSetExtractor<EntityParameter>() {
            @Override
            public EntityParameter extractData(ResultSet resultSet) throws SQLException {
                if (resultSet.next()) {
                    EntityParameter entityParameter = new EntityParameter();
                    entityParameter.setParameterId(resultSet.getLong("parameter_id"));
                    entityParameter.setEntityId(resultSet.getLong("entity_id"));
                    entityParameter.setStringValue(resultSet.getString("string_value"));
                    entityParameter.setIntValue(resultSet.getInt("int_value"));
                    entityParameter.setDecimalValue(resultSet.getDouble("decimal_value"));
                    entityParameter.setIdValue(resultSet.getLong("id_value"));
                    entityParameter.setDateValue(resultSet.getDate("date_value"));
                    return entityParameter;
                }
                return null;
            }
        });
    }
}
