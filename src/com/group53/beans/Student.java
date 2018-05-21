package com.group53.beans;

public class Student extends Person {

    public static final byte student_entity_type = 4;

    private int record_book;

    public Student(Long id, String title, Long parent_id, String name, String surname, String patronymic) {
        super(id, title, parent_id, name, surname, patronymic);
        setEntityType(student_entity_type);
    }


    public int getRecord_book() {
        return record_book;
    }

    public void setRecord_book(int record_book) {
        this.record_book = record_book;
    }

    public static byte getStudent_entity_type() {
        return student_entity_type;
    }
}
