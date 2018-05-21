package com.group53.beans;

public class Entity {

    public static final byte admin_access_level = 1;
    public static final byte tutor_access_level = 2;
    public static final byte student_access_level = 3;

    public static final byte entity_entity_type = 0;

    private Long id = null;
    private String title = null;
    private Long parentId = null;
    private int entityType = entity_entity_type;

    public Entity() {
    }

    public Entity(Long id, String title, Long parentId, int entityType) {
        this.id = id;
        this.title = title;
        this.parentId = parentId;
        this.entityType = entityType;
    }

    public void setId(Long id) { this.id = id; }

    public void setParentId(Long parentId) { this.parentId = parentId; }

    public Long getParentId() { return parentId; }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEntityType() {
        return entityType;
    }

    public void setEntityType(int entityType) {
        this.entityType = entityType;
    }

}
