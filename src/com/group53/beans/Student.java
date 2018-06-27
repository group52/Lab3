package com.group53.beans;

import java.util.Objects;

/** class Student is the class for describe student object */
public class Student extends Person {

    public static final byte studentEntityType = 4;

    private int recordBook;

    /**
     * Constructor
     * @param id is the auto-generate unice number
     * @param title is title of entity
     * @param parent_id is id of the entity parent
     * @param name is the name
     * @param surname is the surname
     * @param patronymic is the patronymic
     */
    public Student(Long id, String title, Long parent_id, String name, String surname, String patronymic) {
        super(id, title, parent_id, name, surname, patronymic);
        setEntityType(studentEntityType);
    }

    /**
     * Return the record book
     * @return record book
     */
    public int getRecord_book() {
        return recordBook;
    }

    /**
     * Setup the record book
     * @param recordBook record book
     */
    public void setRecord_book(int recordBook) {
        this.recordBook = recordBook;
    }

    /**
     * Return the student type
     * @return student type
     */
    public static byte getStudentEntityType() {
        return studentEntityType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return recordBook == student.recordBook;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), recordBook);
    }

    @Override
    public String toString() {
        return "Student{" +
                "recordBook=" + recordBook +
                '}';
    }
}
