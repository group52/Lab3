package com.group53.dao;

import com.group53.beans.Subject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SubjectDAOImpl implements SubjectDAO {
    private JdbcTemplate template;

    public void insertSubject(Subject subject) {

    }

    public void updateSubjectById(long subject_id) {

    }

    public void selectSubjectById(long subject_id) {

    }

    public Subject getSubject() {
        return null;
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
