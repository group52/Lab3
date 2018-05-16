package com.group53.beans;

public class Student extends Person {

    private int record_book;

    public Student(Long id, String title, Long parent_id, String name, String surname, String patronymic) {
        super(id, title, parent_id, name, surname, patronymic);
        setEntityType(3);
    }


    public int getRecord_book() {
        return record_book;
    }

    public void setRecord_book(int record_book) {
        this.record_book = record_book;
    }
}
