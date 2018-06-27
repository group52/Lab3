package com.group53.beans;

import java.util.Objects;

/** class Person is the class for describe person object */
public class Person extends Entity {

    public static final byte personEntityType = 6;

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
        super(id, title, parent_id, personEntityType);

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
    public static byte getPersonEntityType() {
        return personEntityType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        if (!super.equals(o)) return false;
        Person person = (Person) o;
        return Objects.equals(getName(), person.getName()) &&
                Objects.equals(getSurname(), person.getSurname()) &&
                Objects.equals(getPatronymic(), person.getPatronymic());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getName(), getSurname(), getPatronymic());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }
}
