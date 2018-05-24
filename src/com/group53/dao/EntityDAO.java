package com.group53.dao;

import com.group53.beans.Entity;
import com.group53.beans.StudyLoad;

import java.util.List;

public interface EntityDAO {
    List<Entity> getAllEntitys();
    public void saveOrUpdateEntityDB(Entity entity);
    public void deleteEntityDB(Long id);
    public Entity getEntity(Long id);
    public Long getId(String title);
    public List<Entity> getChildEntitys(Long id);
    public List<Entity> getAllByType(int entityType);
    public StudyLoad getStudyLoad(Long id);
}
