package com.group53.beans;

/** class University is the class for describe university object */
public class University extends Entity {

    public static final byte university_entity_type = 1;

    private String name;

    /**
     * Constructor
     * @param id is the auto-generate unice number
     * @param title is title of entity id
     */
    public University(String title, Long id) {
        super(id, title, null,university_entity_type);
    }

    /**
     * Return the full name
     * @return full name
     */
    public String getName() {
        return name;
    }

    /**
     * Setup the full name
     * @param name full name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the university type
     * @return university type
     */
    public static byte getUniversity_entity_type() {
        return university_entity_type;
    }
}
