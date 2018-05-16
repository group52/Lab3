package com.group53.dao;

import com.group53.beans.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void insertStudent(Student student) {

    }

    public void updateStudentById(long student_id) {

    }

    public void selectStudentById(long student_id) {

    }

    public Student getStudent() {
        return null;
    }
    public List<Student> getAllStudents() {
        return template.query("SELECT * FROM ENTITY WHERE  ENTITY_TYPE = 3", new RowMapper<Student>() {
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                long parent_id =resultSet.getLong(3);
                return new Student(id, null, parent_id, name, null, null);
            }
        });
    }
}


