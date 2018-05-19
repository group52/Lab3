package com.group53.dao;

import com.group53.beans.Entity;

import java.util.List;

public interface EntityDAO {
    List<Entity> getAllEntitys();
    public void saveOrUpdateEntityDB(Entity entity);
    public void deleteEntityDB(Long id);
    public Entity getEntity(Long id);
    public List<Entity> getChildEntitys(Long id);
}
