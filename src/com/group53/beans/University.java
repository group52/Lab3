package com.group53.beans;


public class University extends Entity {

    private String name;

    public University(String title, Long id) {
        super(id, title, null,1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
