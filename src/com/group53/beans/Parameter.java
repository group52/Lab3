package com.group53.beans;

/** class Parameter is the class for describe parameter object */
public class Parameter extends Entity{

    public static final byte parameter_entity_type = 9;

    /**
     * Constructor
     @param id is the auto-generate unice number
     @param title is title of entity
     */
    public Parameter(Long id, String title) {
        super(id, title, null, parameter_entity_type);
    }

    /**
     * Return the parameter type
     * @return parameter type
     */
    public static byte getParameter_entity_type() {
        return parameter_entity_type;
    }
}
