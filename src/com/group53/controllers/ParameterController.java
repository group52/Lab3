package com.group53.controllers;

import com.group53.beans.*;
import com.group53.dao.EntityDAO;
import com.group53.dao.EntityParameterDAO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Class ParameterController for work with parameters from the table GRP5_Entity_PARAMETER
 */
@Controller
public class ParameterController {

    private static final Logger logger = Logger.getLogger(ParameterController.class);
    private Long entityId;
    @Autowired
    private EntityParameterDAO entityParameterDAO;
    @Autowired
    private EntityDAO entityDAO;

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Return the view of the all parameters from the table GRP5_Entity_PARAMETER for the entity
     * @param request id of the entity
     * @return the view of the all parameters for the entity
     */
    @RequestMapping(value = "viewParam", method = RequestMethod.GET)
    public ModelAndView show(HttpServletRequest request){
        entityId = Long.parseLong(request.getParameter("id"));
        List<EntityParameter> paramList = entityParameterDAO.getAllParameters(entityId);
        List<Entity> parameters = entityDAO.getAllByType(Parameter.getParameterEntityType());
        ModelAndView model = new ModelAndView("param", "list", paramList);
        EntityParameter newEntityParameter = new EntityParameter();
        newEntityParameter.setEntityId(entityId);
        logger.info("New entity parameter, entity id = " + entityId);
        model.addObject("entityParameter", newEntityParameter);
        model.addObject("parameters", parameters);
        return model;
    }

    /**
     * Delete the parameter and return the view of the all parameters from the table GRP5_Entity_PARAMETER for the entity
     * @param request id of the entity parameter
     * @return the view of the all parameters for the entity
     */
    @RequestMapping(value = "/deleteParam", method = RequestMethod.GET)
    public ModelAndView delete(HttpServletRequest request) {
        Long parameterID = Long.parseLong(request.getParameter("param"));
        entityParameterDAO.deleteParameterDB(entityId, parameterID);
        logger.info("The param with entity id = " + entityId + " was deleted");
        return new ModelAndView("redirect:/viewParam?id=" + entityId);
    }

    /**
     * Edit the parameter and return the view of the all parameters from the table GRP5_Entity_PARAMETER for the entity
     * @param request id of the entity parameter
     * @return the view of the all parameters for the entity
     */
    @RequestMapping(value = "/editParam", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        Long parameterID = Long.parseLong(request.getParameter("param"));
        EntityParameter newEntityParameter = entityParameterDAO.getParameter(entityId, parameterID);
        List<EntityParameter> paramList = entityParameterDAO.getAllParameters(entityId);
        ModelAndView model = new ModelAndView("param", "list", paramList);
        model.addObject("entityParameter", newEntityParameter);
        List<Entity> parameters = entityDAO.getAllByType(Parameter.getParameterEntityType());
        logger.info("The param with entity id = " + entityId + " was edited");
        model.addObject("parameters", parameters);
        return model;
    }

    /**
     * Save the parameter and return the view of the all parameters from the table GRP5_Entity_PARAMETER for the entity
     * @param entityParameter entity parameter
     * @return the view of the all parameters for the entity
     */
    @RequestMapping(value = "/saveParam", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute EntityParameter entityParameter) {

        try {
            java.util.Date date = dateFormat.parse(entityParameter.getDateString());
            entityParameter.setDateValue(new Date(date.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
            logger.error("ParseException: ", e);
        }

        if ((long) entityParameter.getParameterId() == (long) (entityDAO.getId("password")))
        {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(entityParameter.getStringValue());
            entityParameter.setStringValue(hashedPassword);
        }

        entityParameterDAO.saveParameterDB(entityParameter);

        logger.info("The param with entity id = " + entityParameter.getEntityId() + " was saved");
        return new ModelAndView("redirect:/viewParam?id=" + entityId);
    }

    /**
     * Save the parameters for the studyLoad and return the view of the all parameters from the table GRP5_Entity_PARAMETER for the studyLoad
     * @param studyLoad studyload entity
     * @return the view of the all parameters for the studyLoad
     */
    @RequestMapping(value = "/saveStudyLoad", method = RequestMethod.POST)
    public ModelAndView saveStudyLoad(@ModelAttribute StudyLoad studyLoad) {
        EntityParameter entityParameter = new EntityParameter();
        entityParameter.setParameterId(entityDAO.getId("groupId"));
        entityParameter.setEntityId(studyLoad.getId());
        entityParameter.setIdValue(studyLoad.getGroupId());
        entityParameterDAO.saveParameterDB(entityParameter);
        entityParameter.setParameterId(entityDAO.getId("tutorId"));
        entityParameter.setIdValue(studyLoad.getTutorId());
        entityParameterDAO.saveParameterDB(entityParameter);

        logger.info("The param with entity id = " + entityParameter.getEntityId() + " was saved");
        return new ModelAndView("redirect:/paramStudyLoad?id=" + entityId);
    }

    /**
     * return the view of the all parameters from the table GRP5_Entity_PARAMETER for the studyLoad
     * @param request id of the studyload
     * @return the view of the all parameters for the studyLoad
     */
    @RequestMapping(value = "paramStudyLoad", method = RequestMethod.GET)
    public ModelAndView paramStudyLoad(HttpServletRequest request){
        entityId = Long.parseLong(request.getParameter("id"));
        Entity entity = entityDAO.getEntity(entityId);
        StudyLoad studyLoad = new StudyLoad();
        studyLoad.setId(entity.getId());
        studyLoad.setTitle(entity.getTitle());
        studyLoad.setParentId(entity.getParentId());
        List<Entity> groups = entityDAO.getAllByType(Group.getGroupEntityType());
        List<Entity> tutors = entityDAO.getAllByType(Tutor.getTutorEntityType());
        ModelAndView model = new ModelAndView("paramStudyLoad", "listGroup", groups);
        model.addObject("listTutor", tutors);
        model.addObject("studyLoad",studyLoad);
        List<EntityParameter> paramList = entityParameterDAO.getAllParameters(entity.getId());
        model.addObject("list",paramList);
        List<Entity> parameters = entityDAO.getAllByType(Parameter.getParameterEntityType());
        EntityParameter newEntityParameter = new EntityParameter();
        newEntityParameter.setEntityId(entity.getId());
        logger.info("New entity parameter, entity id = " + entity.getId());
        model.addObject("entityParameter", newEntityParameter);
        model.addObject("parameters", parameters);
        return model;
    }
}
