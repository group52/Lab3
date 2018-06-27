package com.group53.beans;

/** class Person is the class for describe person object */
public class Person extends Entity {

    public static final byte person_entity_type = 6;

    private String name;
    private String surname;
    private String patronymic;

    /**
     * Empty constructor for the person
     */
    public Person() {
    }

    /**
     * Constructor
     * @param id is the auto-generate unice number
     * @param title is title of entity
     * @param parent_id is id of the entity parent
     * @param name is the name
     * @param surname is the surname
     * @param patronymic is the patronymic
     */
    public Person(Long id, String title, Long parent_id, String name, String surname, String patronymic) {
        super(id, title, parent_id, person_entity_type);

        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    /**
     * Return the name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setup the name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the surname
     * @return surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Setup the surname
     * @param surname surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Return the patronymic
     * @return the patronymic
     */
    public String getPatronymic() {
        return patronymic;
    }

    /**
     * Setup the patronymic
     * @param patronymic the patronymic
     */
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    /**
     * Return the person type
     * @return person type
     */
    public static byte getPerson_entity_type() {
        return person_entity_type;
    }
}
