package com.group53.dao;

import com.group53.beans.Subject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SubjectDAOImpl {
    private JdbcTemplate template;

    public int insertSubject(Subject subject) {
        String insertSQL = "INSERT INTO ENTITY"
                + "(ID, TITLE,PARENT_ID, ENTITY_TYPE) VALUES" +
                + subject.getId()+ ","
                + subject.getTitle() + ","
                + subject.getParentId() + ","
                + subject.getEntityType();
        return template.update(insertSQL);
    }

    public int updateSubject(Subject subject){
        String sql="UPDATE ENTITY SET TITLE ='"+subject.getTitle()+"', where id="+subject.getId()+"";
        return template.update(sql);
    }

    public int removeSubject(long id){
        String sql="DELETE FROM ENTITY where id="+id+"";
        return template.update(sql);
    }
    public Subject selectSubjectById(long subject_id){
        String sql="SELECT * FROM ENTITY where id=?";
        return template.queryForObject(sql, new Object[]{subject_id},new BeanPropertyRowMapper<Subject>(Subject.class));
    }

    public List<Subject> getAllSubjects() {
        return template.query("SELECT * FROM ENTITY WHERE  ENTITY_TYPE = 5", new RowMapper<Subject>() {
            public Subject mapRow(ResultSet resultSet, int i) throws SQLException {
                long id = resultSet.getLong(1);
                String title = resultSet.getString(2);
                return new Subject(id, title);
            }
        });
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public JdbcTemplate getTemplate() {
        return template;
    }
}
