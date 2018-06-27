package com.group53.beans;

import java.util.Objects;

/** class University is the class for describe university object */
public class University extends Entity {

    public static final byte universityEntityType = 1;

    private String name;

    /**
     * Constructor
     * @param id is the auto-generate unice number
     * @param title is title of entity id
     */
    public University(String title, Long id) {
        super(id, title, null,universityEntityType);
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
    public static byte getUniversityEntityType() {
        return universityEntityType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof University)) return false;
        if (!super.equals(o)) return false;
        University that = (University) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getName());
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                '}';
    }
}
