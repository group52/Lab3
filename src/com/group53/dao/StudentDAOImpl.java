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
        return template.query("select * from STUDENTS", new RowMapper<Student>() {
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                /*
                Student student = new Student();
                student.setStudent_id(resultSet.getLong(1));
                student.setStudent_name(resultSet.getString(2));
                student.setGroup_title(resultSet.getString(3));
                */
                return null;
            }
        });
    }
}


