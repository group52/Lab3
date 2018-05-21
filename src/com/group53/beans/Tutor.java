package com.group53.beans;

public class Tutor extends Person {

    public static final byte tutor_entity_type = 2;

    private String faculty;
    private String speciality;

    public Tutor(Long id, String title, Long parent_id, String name, String surname, String patronymic) {
        super(id, title, parent_id, name, surname, patronymic);
        setEntityType(tutor_entity_type);
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

    public static byte getTutor_entity_type() {
        return tutor_entity_type;
    }
}
