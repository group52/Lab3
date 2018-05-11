package com.group53.beans;

public class Tutor extends University {

    private static long tutorID = 0;

    long parent_id;
    String name;
    String surname;
    String patronomic;
    private boolean isTutorAdmin;
    byte access_level;


    public Tutor(String title, String login, String password, long parent_id, String name, String surname, String patronomic, boolean isTutorAdmin) {
        super(title, login, password);
        tutorID ++;
        this.id = tutorID;
        this.parent_id = parent_id;
        this.name = name;
        this.surname = surname;
        this.patronomic = patronomic;
        this.isTutorAdmin = isTutorAdmin;

        if (isTutorAdmin) access_level = University.admin_access_level;
        else access_level = University.tutor_access_level;
    }

    public Tutor(String title, long parent_id) {
        super(title);
        tutorID ++;
        this.id = tutorID;
        this.parent_id = parent_id;
    }

    public long getParent_id() {
        return parent_id;
    }

    public void setParent_id(long parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isTutorAdmin() {
        return isTutorAdmin;
    }

    public void setTutorAdmin(boolean tutorAdmin) {
        isTutorAdmin = tutorAdmin;
    }

    public byte getAccess_level() {
        return access_level;
    }
}
