package com.group53.beans;

public class Subject extends Entity{

    public static final byte subject_entity_type = 5;

    public Subject() {
    }

    public Subject(Long id, String title) {
        super(id, title, null, subject_entity_type);
    }

    public static byte getSubject_entity_type() {
        return subject_entity_type;
    }
}
