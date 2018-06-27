package com.group53.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

/** class Entity is the parent class for all entities */
@XmlRootElement(name="entity")
@XmlAccessorType(XmlAccessType.NONE)
public class Entity {

    public static final byte entityEntityType = 0;

    @XmlAttribute
    private Long id = null;
    @XmlAttribute
    private String title = null;
    @XmlAttribute
    private Long parentId = null;
    @XmlAttribute
    private int entityType = entityEntityType;

    /** Empty constructor for Entity */
    public Entity() {
    }

    /** Constructor for each entity
     @param id is the auto-generate unice number
     @param title is title of the entity
     @param parentId is id of the entity parent
     @param entityType is the type of the entity */
    public Entity(Long id, String title, Long parentId, int entityType) {
        this.id = id;
        this.title = title;
        this.parentId = parentId;
        this.entityType = entityType;
    }

    /** Setup the ID of the entity
     @param id is the auto-generate unice number */
    public void setId(Long id) { this.id = id; }

    /** Setup the id of the entity parent
     @param parentId is id of the entity parent */
    public void setParentId(Long parentId) { this.parentId = parentId; }

    /** Return the id of the entity parent
     @return id of the entity parent */
    public Long getParentId() { return parentId; }

    /** Return the id of the entity
     @return id is the auto-generate unice number */
    public Long getId() {
        return id;
    }

    /** Return the title of entity
     @return title is title of entity */
    public String getTitle() {
        return title;
    }

    /** Setup the title of entity
     @param title is title of entity */
    public void setTitle(String title) {
        this.title = title;
    }

    /** Return the type of the entity
     @return entityType is the type of the entity */
    public int getEntityType() {
        return entityType;
    }

    /** Setup the type of the entity
     @param entityType is the type of the entity */
    public void setEntityType(int entityType) {
        this.entityType = entityType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entity)) return false;
        Entity entity = (Entity) o;
        return getEntityType() == entity.getEntityType() &&
                Objects.equals(getId(), entity.getId()) &&
                Objects.equals(getTitle(), entity.getTitle()) &&
                Objects.equals(getParentId(), entity.getParentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getParentId(), getEntityType());
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", parentId=" + parentId +
                ", entityType=" + entityType +
                '}';
    }
}
