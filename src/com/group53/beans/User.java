package com.group53.beans;

import java.util.Map;

public class User extends Entity {

    public static final byte user_entity_type = 7;

    private String username;
    private String password;
    private String role;
    private String firstname;
    private String lastname;
    private Person person;
    private Map<Entity, Byte> map;

    public User(String username,String password, String role,String firstname, String lastname){
       this.username = username;
       this.password = password;
       this.role = role;
       this.firstname = firstname;
       this.lastname = lastname;
    }

    public User(Long id, String title) {
        super(id, title, null, user_entity_type);
    }

    public User() {

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

    public String getUserName() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


}
