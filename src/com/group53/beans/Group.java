package com.group53.beans;

public class Group extends Entity {

    public static final byte group_entity_type = 3;

    private String faculty;
    private String speciality;

    public Group(Long id, String title, Long parentId) {
        super(id, title, parentId, group_entity_type);
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

    public static byte getGroup_entity_type() {
        return group_entity_type;
    }
}
