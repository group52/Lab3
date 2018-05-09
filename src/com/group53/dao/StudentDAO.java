package com.group53.dao;

import com.group53.beans.Student;

import java.util.List;

public interface StudentDAO {

    void insertStudent(Student student);
    void updateStudentById(long student_id);
    void selectStudentById(long student_id);
    Student getStudent();
    List<Student> getAllStudents();
}
