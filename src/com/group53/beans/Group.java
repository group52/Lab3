package com.group53.beans;

import java.util.Objects;

/** class Group is the class for describe group object */
public class Group extends Entity {

    public static final byte groupEntityType = 3;

    private String faculty;
    private String speciality;

    /**
     * Constructor
     @param id is the auto-generate unice number
     @param title is title of entity
     @param parentId is id of the entity parent
     */
    public Group(Long id, String title, Long parentId) {
        super(id, title, parentId, groupEntityType);
    }

    /**
     * Return the faculty of the university
     * @return faculty of the university
     */
    public String getFaculty() {
        return faculty;
    }

    /**
     * Setup the faculty of the university
     * @param faculty faculty of the university
     */
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    /**
     * Return the speciality of the university
     * @return speciality of the university
     */
    public String getSpeciality() {
        return speciality;
    }

    /**
     * Setup the speciality of the university
     * @param speciality speciality of the university
     */
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    /**
     * Return the group type
     * @return group type
     */
    public static byte getGroupEntityType() {
        return groupEntityType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        if (!super.equals(o)) return false;
        Group group = (Group) o;
        return Objects.equals(getFaculty(), group.getFaculty()) &&
                Objects.equals(getSpeciality(), group.getSpeciality());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getFaculty(), getSpeciality());
    }

    @Override
    public String toString() {
        return "Group{" +
                "faculty='" + faculty + '\'' +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}
