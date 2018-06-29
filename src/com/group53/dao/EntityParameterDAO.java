package com.group53.dao;

import com.group53.beans.EntityParameter;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * Interface EntityParameterDAO for operation with entites from the table GRP5_Entity_Parameter
 */
public interface EntityParameterDAO {
    /**
     * Return the all parameters for entity
     * @param entityId id of the entity
     * @return all parameters for entity
     */
    List<EntityParameter> getAllParameters(Long entityId);

    /**
     * Save the parameter for entity
     * @param entityParameter the entity parameter
     */
    void saveParameterDB(EntityParameter entityParameter);

    /**
     * Delete the parameter for entity
     * @param entityId id of the entity
     * @param parameterID id of the parameter
     */
    void deleteParameterDB(Long entityId, Long parameterID);

    /**
     * Return the parameter for entity
     * @param entityId id of the entity
     * @param parameterID id of the parameter
     * @return the parameter for entity
     */
    EntityParameter getParameter(Long entityId, Long parameterID);

    /**
     * Return the parameter for entity by the date
     * @param entityId id of the entity
     * @param parameterID id of the parameter
     * @param date date value of the parameter
     * @return the parameter for entity by the date
     */
    EntityParameter getParameter(Long entityId, Long parameterID, Date date);

    /**
     * Return the dates of lessons for the studyload
     * @param idValue id value of the parameter
     * @return the dates of lessons for the studyload
     */
    TreeSet<Date> getAllDatesParameter(Long idValue);

    /**
     * Return the all marks for the student
     * @param dates date value of the parameter
     * @param idValue id value of the parameter
     * @param entityId id of the entity
     * @return all marks for the student
     */
    Map<Date, Double> getAllDecimalParameter(TreeSet<Date> dates, Long idValue, Long entityId);

    /**
     * Return the dates of lessons for the student
     * @param idValue id value of the parameter
     * @return the dates of lessons for the student
     */
    TreeSet<Date> getDatesByEntityParameter(Long idValue);

    /**
     * Return the all subjects for the group
     * @param idValue id value of the parameter
     * @return the all subjects for the group
     */
    TreeSet<Long> getRelationByGroupParameter(Long idValue);

    /**
     * Return the all subjects for the tutor
     * @param id tutor id
     * @return all subjects for the tutor
     */
    TreeSet<Long> getRelationByTutorParameter(Long id);

    /**
     * Check the login-password and return parameter of the entity
     * @param login login-paswword for the user
     * @return parameter of the entity
     */
    EntityParameter getLoginParameter(String login);
}
