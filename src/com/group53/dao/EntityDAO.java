package com.group53.dao;

import com.group53.beans.Entity;
import com.group53.beans.StudyLoad;

import java.util.List;

/**
 * Interface EntityDAO for operation with entites from the table GRP5_Entity
 */
public interface EntityDAO {
    /**
     * Return the all entites from the table GRP5_Entity
     * @return the all entites from the table GRP5_Entity
     */
    List<Entity> getAllEntitys();

    /**
     * Save or update the entity object in the table GRP5_Entity
     * @param entity the entity object
     */
    void saveOrUpdateEntityDB(Entity entity);

    /**
     * Delete the entity object in the table GRP5_Entity
     * @param id id of the entity
     */
    void deleteEntityDB(Long id);

    /**
     * Return the entity by id
     * @param id id of the entity
     * @return the entity by id
     */
    Entity getEntity(Long id);

    /**
     * Return the id of the parameter entity by the title
     * @param title title of the entity
     * @return the id of the parameter entity by the title
     */
    Long getId(String title);

    /**
     * Return the children of the entity by the id
     * @param id id of the entity
     * @return the children of the entity by the id
     */
    List<Entity> getChildEntitys(Long id);

    /**
     * Return all entities by the type
     * @param entityType the type of the entity
     * @return all entities by the type
     */
    List<Entity> getAllByType(int entityType);

    /**
     * Return the studyload entity by id
     * @param id id of the entity
     * @return the studyload entity by id
     */
    StudyLoad getStudyLoad(Long id);

    /**
     * Return unice long number for id
     * @return unice long number for id
     */
    Long getNextId();
}
