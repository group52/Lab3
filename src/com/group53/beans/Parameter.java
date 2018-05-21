package com.group53.beans;

public class Parameter extends Entity{

    public static final byte parameter_entity_type = 9;

    public Parameter(Long id, String title) {
        super(id, title, null, parameter_entity_type);
    }

    public static byte getParameter_entity_type() {
        return parameter_entity_type;
    }
}
