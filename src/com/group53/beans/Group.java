package com.group53.beans;

public class Group extends Tutor {

    private static long groupID = 0;
    private String faculty;
    private String speciality;

    public Group(String title, long parent_id, String faculty, String speciality) {
        super(title, parent_id);

        groupID ++;
        this.id = groupID;
        this.faculty = faculty;
        this.speciality = speciality;
    }

    public Group(String title, long parent_id) {
        super(title, parent_id);

        groupID ++;
        this.id = groupID;
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
