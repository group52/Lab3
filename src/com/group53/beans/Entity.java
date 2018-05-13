package com.group53.beans;

public class Entity {

    public static final byte admin_access_level = 1;
    public static final byte tutor_access_level = 2;
    public static final byte student_access_level = 3;

    public static final byte university_entity_type = 1;
    public static final byte tutor_entity_type = 2;
    public static final byte student_entity_type = 3;
    public static final byte group_entity_type = 4;
    public static final byte subject_entity_type = 5;
    public static final byte person_entity_type = 6;
    public static final byte user_entity_type = 7;
    public static final byte studyload_entity_type = 8;


    private Long id = null;
    private String title = null;
    private Long parentId = null;
    private int entityType;


    public Entity() {
    }

    public Entity(Long id, String title, Long parentId, int entityType) {
        this.id = id;
        this.title = title;
        this.parentId = parentId;
        this.entityType = entityType;
    }

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
