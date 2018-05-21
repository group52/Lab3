package com.group53.beans;


public class University extends Entity {

    public static final byte university_entity_type = 1;

    private String name;

    public University(String title, Long id) {
        super(id, title, null,university_entity_type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static byte getUniversity_entity_type() {
        return university_entity_type;
    }
}
