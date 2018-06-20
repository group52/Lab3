package com.group53.dao;

import com.group53.beans.Entity;
import com.group53.beans.Parameter;
import com.group53.beans.StudyLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EntityDAOImpl implements EntityDAO {
    @Autowired
    private EntityParameterDAOImpl entityParameterDAO;

    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Entity> getAllEntitys() {
        return template.query("select * from GRP5_ENTITY", new RowMapper<Entity>() {
            @Override
            public Entity mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Entity(resultSet.getLong("id"), resultSet.getString("title"), resultSet.getLong("parent_Id"),resultSet.getInt("entity_Type"));
            }
        });
    }

    @Override
    public void saveOrUpdateEntityDB(Entity entity){
        if (entity.getId()!= null) {
            String sql = "UPDATE GRP5_ENTITY SET title=?, PARENT_ID=?, ENTITY_TYPE=? "
                    + "WHERE id=?";
            template.update(sql, entity.getTitle(), entity.getParentId(),
                    entity.getEntityType(), entity.getId());
        } else {
            String insertSQL = "INSERT INTO GRP5_ENTITY"
                    + "(ID, TITLE, PARENT_ID, ENTITY_TYPE) VALUES"
                    + "(?,?,?,?)";
            entity.setId(getNextId());
            template.update(insertSQL, entity.getId(), entity.getTitle(),
                    entity.getParentId(), entity.getEntityType());
        }
    }

    @Override
    public void deleteEntityDB(Long id){
        String sql = "DELETE FROM GRP5_ENTITY WHERE id=?";
        template.update(sql, id);
        entityParameterDAO.deleteAll(id);
    }

    @Override
    public Entity getEntity(final Long id) {
        String sql = "SELECT * FROM GRP5_ENTITY WHERE id=?";
        return template.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setLong(1, id);
            }
        }, new ResultSetExtractor<Entity>() {
            @Override
            public Entity extractData(ResultSet resultSet) throws SQLException {
                if (resultSet.next()) {
                    Entity entity = new Entity();
                    entity.setId(resultSet.getLong("id"));
                    entity.setTitle(resultSet.getString("title"));
                    entity.setParentId(resultSet.getLong("parent_Id"));
                    entity.setEntityType(resultSet.getInt("entity_Type"));
                    return entity;
                }
                return null;
            }

        });
    }


    @Override
    public List<Entity> getChildEntitys(final Long id) {
        String sql = "SELECT * FROM GRP5_ENTITY WHERE parent_id=?";
        return template.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setLong(1, id);
            }
        }, new RowMapper<Entity>() {
            @Override
            public Entity mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Entity(resultSet.getLong("id"), resultSet.getString("title"), resultSet.getLong("parent_Id"),resultSet.getInt("entity_Type"));
            }
        });
    }

    @Override
    public List<Entity> getAllByType(final int entityType) {
        String sql = "SELECT * FROM GRP5_ENTITY WHERE ENTITY_TYPE=?";
        return template.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, entityType);
            }
        }, new RowMapper<Entity>() {
            @Override
            public Entity mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Entity(resultSet.getLong("id"), resultSet.getString("title"), resultSet.getLong("parent_Id"),resultSet.getInt("entity_Type"));
            }
        });
    }

    @Override
    public List<Entity> getAllByTitle(final String title) {
        String sql = "SELECT * FROM GRP5_ENTITY WHERE TITLE=?";
        return template.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, title);
            }
        }, new RowMapper<Entity>() {
            @Override
            public Entity mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Entity(resultSet.getLong("id"), resultSet.getString("title"), resultSet.getLong("parent_Id"),resultSet.getInt("entity_Type"));
            }
        });
    }

    @Override
    public Long getId(final String title) {
        String sql = "SELECT * FROM GRP5_ENTITY WHERE TITLE=? and ENTITY_TYPE=?";
        return template.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,  title);
                ps.setInt(2, Parameter.parameter_entity_type);
            }
        }, new ResultSetExtractor<Long>() {
            @Override
            public Long extractData(ResultSet resultSet) throws SQLException {
                if (resultSet.next()) {
                    return resultSet.getLong("id");
                }
                return null;
            }
        });
    }

    @Override
    public StudyLoad getStudyLoad(final Long id) {
        String sql = "SELECT * FROM GRP5_ENTITY WHERE id=?";
        return template.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setLong(1, id);
            }
        }, new ResultSetExtractor<StudyLoad>() {
            @Override
            public StudyLoad extractData(ResultSet resultSet) throws SQLException {
                if (resultSet.next()) {
                    StudyLoad studyLoad = new StudyLoad();
                    studyLoad.setId(resultSet.getLong("id"));
                    studyLoad.setTitle(resultSet.getString("title"));
                    studyLoad.setParentId(resultSet.getLong("parent_Id"));
                    studyLoad.setEntityType(resultSet.getInt("entity_Type"));

                    studyLoad.setGroupId(entityParameterDAO.getParameter(id, getId("groupId")).getIdValue());
                    studyLoad.setTutorId(entityParameterDAO.getParameter(id, getId("tutorId")).getIdValue());

                    return studyLoad;
                }
                return null;
            }

        });
    }

    @Override
    public Long getNextId() {
        String sql = "SELECT id_entity.nextval as Id from dual";
        return template.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                /*ps.setLong(1, entityId);
                ps.setLong(2, parameterID);*/
            }
        }, new ResultSetExtractor<Long>() {
            @Override
            public Long extractData(ResultSet resultSet) throws SQLException {
                if (resultSet.next()) {
                    return resultSet.getLong("id");
                }
                return null;
            }
        });
    }
}
