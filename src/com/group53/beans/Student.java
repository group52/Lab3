package com.group53.beans;

public class Student extends Group {

    private static long studentID = 0;

    private int record_book;

    public Student(String title, long parent_id, int record_book, String login, String password, String name, String surname, String patronomic) {
        super(title, parent_id);
        studentID ++;
        this.id = studentID;

        this.access_level = University.student_access_level;
        this.record_book = record_book;
        this.parent_id = parent_id;
        this.name = name;
        this.surname = surname;
        this.patronomic = patronomic;
    }

    public int getRecord_book() {
        return record_book;
    }

    public void setRecord_book(int record_book) {
        this.record_book = record_book;
    }
}
