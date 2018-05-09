package com.group53.beans;

public class Group extends Tutor {

    private long group_id;
    private String group_title;

    public Group(long university_id, String university_title, String tutor_id, String tutor_name, String tutor_surname,
                 String tutor_patronymic, boolean isTutorAdmin, String tutor_login, String tutor_password,
                 long group_id, String group_title) {
        super(university_id, university_title, tutor_id, tutor_name, tutor_surname, tutor_patronymic, isTutorAdmin,
                tutor_login, tutor_password);
        this.group_id = group_id;
        this.group_title = group_title;
    }

    public long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(long group_id) {
        this.group_id = group_id;
    }

    public String getGroup_title() {
        return group_title;
    }

    public void setGroup_title(String group_title) {
        this.group_title = group_title;
    }
}
