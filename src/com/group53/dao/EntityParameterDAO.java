package com.group53.dao;

import com.group53.beans.EntityParameter;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public interface EntityParameterDAO {
    public List<EntityParameter> getAllParameters(Long entityId);
    public void saveParameterDB(EntityParameter entityParameter);
    public void deleteParameterDB(Long entityId, Long parameterID);
    public EntityParameter getParameter(Long entityId, Long parameterID);
    public EntityParameter getParameter(Long entityId, Long parameterID, Date date);
    public TreeSet<Date> getAllDatesByStudyLoad(Long idValue);
    public Map<Date, Double> getAllMarksByStudent(TreeSet<Date> dates, Long idValue, Long entityId);
    public TreeSet<Date> getAllDatesByStudent(Long idValue);
    public TreeSet<Long> getStudyLoadByGroup(Long idValue);
    public TreeSet<Long> getStudyLoadByTutor(Long id);
}
