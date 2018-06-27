package com.group53.beans;

/** class Parameter is the class for describe parameter object */
public class Parameter extends Entity{

    public static final byte parameterEntityType = 9;

    /**
     * Constructor
     @param id is the auto-generate unice number
     @param title is title of entity
     */
    public Parameter(Long id, String title) {
        super(id, title, null, parameterEntityType);
    }

    /**
     * Return the parameter type
     * @return parameter type
     */
    public static byte getParameterEntityType() {
        return parameterEntityType;
    }
}
