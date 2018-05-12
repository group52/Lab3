package com.group53.beans;

public class Tutor extends University {

    private static long tutorID = 0;

    protected long parent_id;
    protected String name;
    protected String surname;
    protected String patronymic;
    byte access_level;


    public Tutor(String title, String login, String password, long parent_id, String name, String surname,
                 String patronymic, boolean isTutorAdmin) {
        super(title, login, password);
        tutorID ++;
        this.id = tutorID;
        this.parent_id = parent_id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;

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

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setAccess_level(byte access_level) {
        this.access_level = access_level;
    }

    public byte getAccess_level() {
        return access_level;
    }
}
