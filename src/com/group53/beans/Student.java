package com.group53.beans;

public class Student extends Group {

    private long student_id;
    private String student_name;
    private String student_surname;
    private String student_patronymic;
    private final byte student_access_level = University.student_access_level;
    private String student_login;
    private String student_password;
    private int record_book;
    private String faculty;
    private String speciality;

    public Student(long university_id, String university_title, String tutor_id, String tutor_name,
                   String tutor_surname, String tutor_patronymic, boolean isTutorAdmin, String tutor_login,
                   String tutor_password, long group_id, String group_title, long student_id, String student_name,
                   String student_surname, String student_patronymic, String student_login, String student_password,
                   int record_book, String faculty, String speciality) {
        super(university_id, university_title, tutor_id, tutor_name, tutor_surname, tutor_patronymic, isTutorAdmin,
                tutor_login, tutor_password, group_id, group_title);
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_surname = student_surname;
        this.student_patronymic = student_patronymic;
        this.student_login = student_login;
        this.student_password = student_password;
        this.record_book = record_book;
        this.faculty = faculty;
        this.speciality = speciality;
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_surname() {
        return student_surname;
    }

    public void setStudent_surname(String student_surname) {
        this.student_surname = student_surname;
    }

    public String getStudent_patronymic() {
        return student_patronymic;
    }

    public void setStudent_patronymic(String student_patronymic) {
        this.student_patronymic = student_patronymic;
    }

    public byte getStudent_access_level() {
        return student_access_level;
    }

    public String getStudent_login() {
        return student_login;
    }

    public void setStudent_login(String student_login) {
        this.student_login = student_login;
    }

    public String getStudent_password() {
        return student_password;
    }

    public void setStudent_password(String student_password) {
        this.student_password = student_password;
    }

    public int getRecord_book() {
        return record_book;
    }

    public void setRecord_book(int record_book) {
        this.record_book = record_book;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
