package com.group53.dao;

import com.group53.beans.EntityParameter;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public interface EntityParameterDAO {
    List<EntityParameter> getAllParameters(Long entityId);
    void saveParameterDB(EntityParameter entityParameter);
    void deleteParameterDB(Long entityId, Long parameterID);
    EntityParameter getParameter(Long entityId, Long parameterID);
    EntityParameter getParameter(Long entityId, Long parameterID, Date date);
    TreeSet<Date> getAllDatesByStudyLoad(Long idValue);
    Map<Date, Double> getAllMarksByStudent(TreeSet<Date> dates, Long idValue, Long entityId);
    TreeSet<Date> getAllDatesByStudent(Long idValue);
    TreeSet<Long> getStudyLoadByGroup(Long idValue);
    TreeSet<Long> getStudyLoadByTutor(Long id);
    EntityParameter checkLogin(String login);
    EntityParameter checkPassword(Long entityId, String password);
}
