package com.group53.dao;

import com.group53.beans.EntityParameter;

import java.util.List;

public interface EntityParameterDAO {
    public List<EntityParameter> getAllParameters(Long entityId);
    public void saveParameterDB(EntityParameter entityParameter);
    public void deleteParameterDB(Long entityId, Long parameterID);
    public EntityParameter getParameter(Long entityId, Long parameterID);
}
