package com.group53.dao;

import com.group53.beans.EntityParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class EntityParameterDAOImpl implements EntityParameterDAO {
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Autowired
    private EntityDAOImpl entityDAO;

    @Override
    public List<EntityParameter> getAllParameters(Long entityId) {
        String sql = "SELECT * FROM ENTITY_PARAMETER WHERE ENTITY_ID=" + entityId;
        return template.query(sql, new RowMapper<EntityParameter>() {
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

        if ((getParameter(entityParameter.getEntityId(), entityParameter.getParameterId()) != null &&
                (long) entityParameter.getParameterId() != (long) entityDAO.getId("mark")) ||
                ((getParameter(entityParameter.getEntityId(), entityParameter.getParameterId(), entityParameter.getDateValue()) != null &&
                        (long) entityParameter.getParameterId() != (long) entityDAO.getId("mark")))) {

                String updateSQL = "UPDATE ENTITY_PARAMETER  SET string_Value=?, int_Value=?, decimal_Value=?," +
                        " id_Value=?, date_Value=? where parameter_id=? and entity_id=?";


                template.update(updateSQL, entityParameter.getStringValue(), entityParameter.getIntValue(),
                        entityParameter.getDecimalValue(), entityParameter.getIdValue(), entityParameter.getDateValue(),
                        entityParameter.getParameterId(), entityParameter.getEntityId());

        }
        else {
            String insertSQL = "INSERT INTO ENTITY_PARAMETER"
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
        String sql = "DELETE FROM ENTITY_PARAMETER WHERE entity_Id=? AND parameter_id=?";
        template.update(sql, entityId, parameterID);
    }

    @Override
    public EntityParameter getParameter(Long entityId, Long parameterID) {
        String sql = "SELECT * FROM ENTITY_PARAMETER WHERE  entity_Id=" + entityId + " and parameter_id=" + parameterID;
        return template.query(sql, new ResultSetExtractor<EntityParameter>() {
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
    public EntityParameter getParameter(Long entityId, Long parameterID, Date date) {
        String sql = "SELECT * FROM ENTITY_PARAMETER WHERE  entity_Id=" + entityId + " and parameter_id=" + parameterID +
                " and DATE_VALUE=to_date('" + date + "', 'yyyy-mm-dd')" ;
        return template.query(sql, new ResultSetExtractor<EntityParameter>() {
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
    public TreeSet<Date> getAllDatesByStudyLoad(Long idValue) {
        String sql = "SELECT * FROM ENTITY_PARAMETER WHERE ID_VALUE=" + idValue;
        List<Date> list = new ArrayList<Date>();

        list = template.query(sql, new RowMapper<Date>() {
            @Override
            public Date mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getDate("date_value");
            }
        });
        return new TreeSet<Date>(list);
    }

    @Override
    public Map<Date, Double> getAllMarksByStudent(TreeSet<Date> dates, Long idValue, Long entityId) {

        Map<Date, Double> treeMap = new TreeMap<Date, Double>();
        for (Date date : dates){
            String sql = "SELECT * FROM ENTITY_PARAMETER WHERE ID_VALUE=" + idValue +
                    " and ENTITY_ID =" + entityId + " and DATE_VALUE =to_date('" + date + "', 'yyyy-mm-dd')" ;
            treeMap.put(date, template.query(sql, new ResultSetExtractor<Double>() {
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
    public TreeSet<Date> getAllDatesByStudent(Long id) {
        String sql = "SELECT * FROM ENTITY_PARAMETER WHERE ENTITY_ID=" + id
                + " and PARAMETER_ID=" + entityDAO.getId("mark");
        List<Date> list = template.query(sql, new RowMapper<Date>() {
            @Override
            public Date mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getDate("date_value");
            }
        });
        return new TreeSet<Date>(list);
    }

    @Override
    public TreeSet<Long> getStudyLoadByGroup(Long id) {
        String sql = "SELECT * FROM ENTITY_PARAMETER WHERE ID_VALUE=" + id
                + " and PARAMETER_ID=" + entityDAO.getId("groupId");
        List<Long> list =  template.query(sql, new RowMapper<Long>() {
            @Override
            public Long mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getLong("entity_id");
            }
        });
        return new TreeSet<Long>(list);
    }

    @Override
    public TreeSet<Long> getStudyLoadByTutor(Long id) {
        String sql = "SELECT * FROM ENTITY_PARAMETER WHERE ID_VALUE=" + id
                + " and PARAMETER_ID=" + entityDAO.getId("tutorId");
        List<Long> list =  template.query(sql, new RowMapper<Long>() {
            @Override
            public Long mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getLong("entity_id");
            }
        });
        return new TreeSet<Long>(list);
    }

    @Override
    public EntityParameter checkLogin(String login) {
        Long id_Login = entityDAO.getId("login");
        String sql = "SELECT * FROM ENTITY_PARAMETER WHERE  STRING_VALUE='" + login + "' and PARAMETER_ID=" + id_Login;
        return template.query(sql, new ResultSetExtractor<EntityParameter>() {
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
    public EntityParameter checkPassword(Long entityId, String password) {
        Long id_Login = entityDAO.getId("password");
        String sql = "SELECT * FROM ENTITY_PARAMETER WHERE  STRING_VALUE='" + password + "' and PARAMETER_ID=" + id_Login
                + " and ENTITY_ID=" + entityId;
        return template.query(sql, new ResultSetExtractor<EntityParameter>() {
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
