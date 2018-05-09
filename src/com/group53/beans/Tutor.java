package com.group53.beans;

public class Tutor extends University {

    private String tutor_id;
    private String tutor_name;
    private String tutor_surname;
    private String tutor_patronymic;
    private boolean isTutorAdmin;
    private final byte tutor_access_level;
    private String tutor_login;
    private String tutor_password;

    public Tutor(long university_id, String university_title, String tutor_id, String tutor_name, String tutor_surname,
                 String tutor_patronymic, boolean isTutorAdmin, String tutor_login, String tutor_password) {
        super(university_id, university_title);

        this.tutor_id = tutor_id;
        this.tutor_name = tutor_name;
        this.tutor_surname = tutor_surname;
        this.tutor_patronymic = tutor_patronymic;
        this.tutor_login = tutor_login;
        this.tutor_password = tutor_password;

        if (isTutorAdmin) tutor_access_level = University.admin_access_level;
        else tutor_access_level = University.tutor_access_level;
    }

    public String getTutor_id() {
        return tutor_id;
    }

    public void setTutor_id(String tutor_id) {
        this.tutor_id = tutor_id;
    }

    public String getTutor_name() {
        return tutor_name;
    }

    public void setTutor_name(String tutor_name) {
        this.tutor_name = tutor_name;
    }

    public String getTutor_surname() {
        return tutor_surname;
    }

    public void setTutor_surname(String tutor_surname) {
        this.tutor_surname = tutor_surname;
    }

    public String getTutor_patronymic() {
        return tutor_patronymic;
    }

    public void setTutor_patronymic(String tutor_patronymic) {
        this.tutor_patronymic = tutor_patronymic;
    }

    public String getTutor_login() {
        return tutor_login;
    }

    public void setTutor_login(String tutor_login) {
        this.tutor_login = tutor_login;
    }

    public String getTutor_password() {
        return tutor_password;
    }

    public void setTutor_password(String tutor_password) {
        this.tutor_password = tutor_password;
    }

    public byte getTutor_access_level() {
        return tutor_access_level;
    }

    public boolean isTutorAdmin() {
        return isTutorAdmin;
    }
}
