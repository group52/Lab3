package com.group53.beans;

public class Group extends Entity {

    private String faculty;
    private String speciality;

    public Group(Long id, String title, Long parentId, int entityType) {
        super(id, title, parentId, 4);
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
