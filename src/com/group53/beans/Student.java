package com.group53.beans;

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
}
