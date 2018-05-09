package com.group53.beans;

public class University {

    public static byte admin_access_level = 1;
    public static byte tutor_access_level = 2;
    public static byte student_access_level = 3;

    private long university_id;
    private String university_title;

    public University(long university_id, String university_title) {
        this.university_id = university_id;
        this.university_title = university_title;
    }

    public long getUniversity_id() {
        return university_id;
    }

    public void setUniversity_id(long university_id) {
        this.university_id = university_id;
    }

    public String getUniversity_title() {
        return university_title;
    }

    public void setUniversity_title(String university_title) {
        this.university_title = university_title;
    }
}
