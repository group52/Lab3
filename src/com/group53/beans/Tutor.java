package com.group53.beans;

/** class Tutor is the class for describe tutor object */
public class Tutor extends Person {

    public static final byte tutor_entity_type = 2;

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
        setEntityType(tutor_entity_type);
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
    public static byte getTutor_entity_type() {
        return tutor_entity_type;
    }
}
