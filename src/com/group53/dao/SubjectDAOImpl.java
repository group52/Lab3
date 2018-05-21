package com.group53.dao;

import com.group53.beans.Subject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SubjectDAOImpl implements SubjectDAO {
    private JdbcTemplate template;

    public void insertSubject(Subject subject) {
        String insertSQL = "INSERT INTO ENTITY"
                + "(ID, TITLE,PARENT_ID, ENTITY_TYPE) VALUES"
                + "(?,?,?,?)";
        template.update(insertSQL, new Object[] { subject.getId(),
                subject.getTitle(),subject.getParentId(), subject.getEntityType()});
    }

    public void updateSubjectById(long subject_id, Subject subject) {
        template.update(
                "UPDATE ENTITY SET TITLE = ? where id = ?",
                subject.getTitle(), subject_id);
    }

    public void removeSubjectById(long subject_id) {
        String query = "delete from ENTITY where id = ?";
        Object[] object = new Object[] {subject_id};
        template.update(query, object);
    }

    public Subject selectSubjectById(long subject_id) {
        String sql = "SELECT * FROM ENTITY WHERE ID = ?";
        Subject subject = (Subject)template.queryForObject(
                sql, new Object[] { subject_id }, new BeanPropertyRowMapper(Subject.class));
        return subject;
    }

    public Subject selectSubjectByTitle(String title) {
        String sql = "SELECT * FROM ENTITY WHERE TITLE = ?";
        Subject subject = (Subject)template.queryForObject(
                sql, new Object[] { title }, new BeanPropertyRowMapper(Subject.class));
        return subject;
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
