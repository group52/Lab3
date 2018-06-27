package com.group53.beans;

import java.util.Objects;

/** class Tutor is the class for describe tutor object */
public class Tutor extends Person {

    public static final byte tutorEntityType = 2;

    private String faculty;
    private String speciality;

    /**
     * Constructor
     * @param id is the auto-generate unice number
     * @param title is title of entity
     * @param parent_id is id of the entity parent
     * @param name is the name
     * @param surname is the surname
     * @param patronymic is the patronymic
     */
    public Tutor(Long id, String title, Long parent_id, String name, String surname, String patronymic) {
        super(id, title, parent_id, name, surname, patronymic);
        setEntityType(tutorEntityType);
    }

    /**
     * Return the faculty of the university
     * @return faculty of the university
     */
    public String getFaculty() {
        return faculty;
    }

    /**
     * Setup the faculty of the university
     * @param faculty faculty of the university
     */
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    /**
     * Return the speciality of the university
     * @return speciality of the university
     */
    public String getSpeciality() {
        return speciality;
    }

    /**
     * Setup the speciality of the university
     * @param speciality speciality of the university
     */
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    /**
     * Return the tutor type
     * @return tutor type
     */
    public static byte getTutorEntityType() {
        return tutorEntityType;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "faculty='" + faculty + '\'' +
                ", speciality='" + speciality + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tutor)) return false;
        if (!super.equals(o)) return false;
        Tutor tutor = (Tutor) o;
        return Objects.equals(getFaculty(), tutor.getFaculty()) &&
                Objects.equals(getSpeciality(), tutor.getSpeciality());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getFaculty(), getSpeciality());
    }
}
