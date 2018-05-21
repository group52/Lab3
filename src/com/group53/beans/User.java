package com.group53.beans;

import java.util.Map;

public class User extends Entity {

    public static final byte user_entity_type = 7;

    private Person person;
    private Map<Entity, Byte> map;

    public User(Long id, String title) {
        super(id, title, null, user_entity_type);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Map<Entity, Byte> getMap() {
        return map;
    }

    public void setMap(Map<Entity, Byte> map) {
        this.map = map;
    }

    public static byte getUser_entity_type() {
        return user_entity_type;
    }
}
