package com.group53.dao;

import com.group53.beans.EntityParameter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class EntityParameterDAOImpl implements EntityParameterDAO {
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

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

        if (getParameter(entityParameter.getEntityId(), entityParameter.getParameterId()) != null) {
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


}
