package com.group53.dao;

import com.group53.beans.Entity;
import com.group53.beans.Parameter;
import com.group53.beans.StudyLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

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
        return template.query("select * from ENTITY", new RowMapper<Entity>() {
            @Override
            public Entity mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Entity(resultSet.getLong("id"), resultSet.getString("title"), resultSet.getLong("parent_Id"),resultSet.getInt("entity_Type"));
            }
        });
    }


    @Override
    public void saveOrUpdateEntityDB(Entity entity){
        if (entity.getId()!= null) {
            String sql = "UPDATE ENTITY SET title=?, PARENT_ID=?, ENTITY_TYPE=? "
                    + "WHERE id=?";
            template.update(sql, entity.getTitle(), entity.getParentId(),
                    entity.getEntityType(), entity.getId());
        } else {
            String insertSQL = "INSERT INTO ENTITY"
                    + "(ID, TITLE, PARENT_ID, ENTITY_TYPE) VALUES"
                    + "(?,?,?,?)";
            template.update(insertSQL, entity.getId(), entity.getTitle(),
                    entity.getParentId(), entity.getEntityType());
        }
    }

    @Override
    public void deleteEntityDB(Long id){
        String sql = "DELETE FROM ENTITY WHERE id=?";
        template.update(sql, id);
    }

    @Override
    public Entity getEntity(Long id) {
        String sql = "SELECT * FROM ENTITY WHERE id=" + id;
        return template.query(sql, new ResultSetExtractor<Entity>() {
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
    public List<Entity> getChildEntitys(Long id) {
        String sql = "SELECT * FROM ENTITY WHERE parent_id=" + id;
        return template.query(sql, new RowMapper<Entity>() {
            @Override
            public Entity mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Entity(resultSet.getLong("id"), resultSet.getString("title"), resultSet.getLong("parent_Id"),resultSet.getInt("entity_Type"));
            }
        });
    }

    @Override
    public List<Entity> getAllByType(int entityType) {
        String sql = "SELECT * FROM ENTITY WHERE ENTITY_TYPE=" + entityType;
        return template.query(sql, new RowMapper<Entity>() {
            @Override
            public Entity mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Entity(resultSet.getLong("id"), resultSet.getString("title"), resultSet.getLong("parent_Id"),resultSet.getInt("entity_Type"));
            }
        });
    }

    @Override
    public Long getId(String title) {
        String sql = "SELECT * FROM ENTITY WHERE TITLE='" + title + "' and ENTITY_TYPE=" + Parameter.parameter_entity_type;
        return (Long) template.query(sql, new ResultSetExtractor<Long>() {
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
        String sql = "SELECT * FROM ENTITY WHERE id=" + id;
        return (StudyLoad) template.query(sql, new ResultSetExtractor<StudyLoad>() {
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
}
