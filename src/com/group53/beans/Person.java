package com.group53.beans;

public class Person extends Entity {


    private String name;
    private String surname;
    private String patronymic;

    public Person() {
    }

    public Person(Long id, String title, Long parent_id, String name, String surname, String patronymic) {
        super(id, title, parent_id, 6);

        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }


}
