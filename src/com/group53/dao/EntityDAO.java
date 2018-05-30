package com.group53.dao;

import com.group53.beans.Entity;
import com.group53.beans.StudyLoad;

import java.util.List;

public interface EntityDAO {
    List<Entity> getAllEntitys();
    void saveOrUpdateEntityDB(Entity entity);
    void deleteEntityDB(Long id);
    Entity getEntity(Long id);
    Long getId(String title);
    List<Entity> getChildEntitys(Long id);
    List<Entity> getAllByType(int entityType);
    StudyLoad getStudyLoad(Long id);
}
