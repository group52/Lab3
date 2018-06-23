package com.group53.beans;

/** class Subject is the class for describe subject object */
public class Subject extends Entity{

    public static final byte subject_entity_type = 5;

    /**
     * Empty constructor
     */
    public Subject() {
    }

    /**
     * Constructor
     * @param id is the auto-generate unice number
     * @param title is title of entity
     */
    public Subject(Long id, String title) {
        super(id, title, null, subject_entity_type);
    }

    /**
     * Return the subject type
     * @return subject type
     */
    public static byte getSubject_entity_type() {
        return subject_entity_type;
    }
}