package com.group53.beans;

import java.util.Map;

public class User extends Entity {

    private Person person;
    private Map<Entity, Byte> map;

    public User(Long id, String title, Long parent_id) {
        super(id, title, null, 7);
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

}
