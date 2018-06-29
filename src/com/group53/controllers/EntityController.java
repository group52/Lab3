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
import java.util.List;

/**
 * class EntityController is controller for operation under the entities
 */
@Controller
public class EntityController {
    private static final Logger logger = Logger.getLogger(EntityController.class);

    @Autowired
    private EntityDAO entityDAO;
    @Autowired
    private EntityParameterDAO entityParameterDAO;

    /**
     * Return the view of the all entites from the table GRP5_Entity
     * @return show.jsp with the all entites from the table GRP5_Entity
     */
    @RequestMapping("viewAll")
    public ModelAndView showAllEntitys(){
        List<Entity> entityList = entityDAO.getAllEntitys();
        ModelAndView model = new ModelAndView("show", "list", entityList);
        Entity newEntity = new Entity();
        model.addObject("entity", newEntity);
        logger.info("Entities were added to show.jsp");
        return model;
    }

    /**
     * Delete the entity and return the all entites from the table GRP5_Entity
     * @param request id of the entity
     * @return the all entites from the table GRP5_Entity
     */
    @RequestMapping(value = "/deleteEntity", method = RequestMethod.GET)
    public ModelAndView deleteEntity(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        entityDAO.deleteEntityDB(id);
        logger.info("The entity with id = " + id + " was deleted");
        return new ModelAndView("redirect:/viewAll");
    }

    /**
     * Edit the entity and return the all entites from the table GRP5_Entity
     * @param request id of the entity
     * @return sh ow.jsp with the all entites from the table GRP5_Entity
     */
    @RequestMapping(value = "/editEntity", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        Entity newEntity = entityDAO.getEntity(id);
        List<Entity> entityList = entityDAO.getAllEntitys();
        ModelAndView model = new ModelAndView("show", "list", entityList);
        model.addObject("entity", newEntity);
        logger.info("The entity with id = " + id + " was edited");
        return model;
    }

    /**
     * Return the children entyties for the entity or other login for entity without children
     * @param request id of the entity
     * @return the children entyties for the entity or other login for entity without children
     */
    @RequestMapping(value = "/childEntity", method = RequestMethod.GET)
    public ModelAndView child(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        Entity entity = entityDAO.getEntity(id);
        Entity newEntity = new Entity();
        List<Entity> entityList = entityDAO.getChildEntitys(id);
        ModelAndView model = new ModelAndView("showChild", "list", entityList);


        int entityType = entity.getEntityType();
        switch (entityType) {
            case Student.studentEntityType:   return new ModelAndView("redirect:/mark?id=" + id);

            case Group.groupEntityType:       newEntity.setParentId(id);
                                                newEntity.setEntityType(Student.studentEntityType);
                                                model.addObject("entity", newEntity);
                                                return model;

            case Tutor.tutorEntityType:       entityList.clear();
                                                for (Long idStudyLoad : entityParameterDAO.getRelationByTutorParameter(id))
                                                    entityList.add(entityDAO.getEntity(idStudyLoad));
                                                model.addObject("list", entityList);
                                                model.addObject("entity", newEntity);
                                                return model;

            case Subject.subjectEntityType:   newEntity.setParentId(id);
                                                newEntity.setEntityType(StudyLoad.studyloadEntityType);
                                                model.addObject("entity", newEntity);
                                                return model;

            case University.universityEntityType:   newEntity.setParentId(id);
                                                newEntity.setEntityType(Group.groupEntityType);
                                                model.addObject("entity", newEntity);
                                                return model;

            case StudyLoad.studyloadEntityType:   return new ModelAndView("redirect:/editMark?id=" + id);

            default:                            return new ModelAndView("redirect:/viewAll");
        }
    }

    /**
     * Add child entity to the table GRP5_Entity and return the view of all children of the entity
     * @param entity the entity for save
     * @return the view of all children of the entity
     */
    @RequestMapping(value = "/saveChild", method = RequestMethod.POST)
    public ModelAndView saveChild(@ModelAttribute Entity entity) {
        entityDAO.saveOrUpdateEntityDB(entity);
        if (entity.getEntityType() == Student.getStudentEntityType() ||
                entity.getEntityType() == Tutor.getTutorEntityType() ||
                entity.getEntityType() == University.getUniversityEntityType()) {
            EntityParameter entityParameter =
                    new EntityParameter(entityDAO.getId("login"),entity.getId(),entity.getTitle());
            entityParameterDAO.saveParameterDB(entityParameter);
            entityParameter.setParameterId(entityDAO.getId("password"));
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(entity.getId().toString());
            entityParameter.setStringValue(hashedPassword);
            entityParameterDAO.saveParameterDB(entityParameter);
        }
        if (entity.getEntityType() == StudyLoad.getStudyloadEntityType()) {
            return new ModelAndView("redirect:/paramStudyLoad?id=" + entity.getId());
        }
        logger.info("The entity with id = " + entity.getId() + " was saved");
        Entity parentEntity = entityDAO.getEntity(entity.getParentId());
        Long id = parentEntity.getId();
        List<Entity> entityList = entityDAO.getChildEntitys(id);
        ModelAndView model = new ModelAndView("showChild", "list", entityList);
        Entity newEntity = new Entity();

        int entityType = parentEntity.getEntityType();
        switch (entityType) {
            case Student.studentEntityType:   return new ModelAndView("redirect:/mark?id=" + id);

            case Group.groupEntityType:       newEntity.setParentId(id);
                                                newEntity.setEntityType(Student.studentEntityType);
                                                model.addObject("entity", newEntity);
                                                return model;

            case Tutor.tutorEntityType:       entityList.clear();
                                                for (Long idStudyLoad : entityParameterDAO.getRelationByTutorParameter(id))
                                                entityList.add(entityDAO.getEntity(idStudyLoad));
                                                model.addObject("list", entityList);
                                                model.addObject("entity", newEntity);
                                                return model;

            case Subject.subjectEntityType:   newEntity.setParentId(id);
                                                newEntity.setEntityType(StudyLoad.studyloadEntityType);
                                                model.addObject("entity", newEntity);
                                                return model;

            case University.universityEntityType:   newEntity.setParentId(id);
                                                newEntity.setEntityType(Group.groupEntityType);
                                                model.addObject("entity", newEntity);
                                                return model;

            case StudyLoad.studyloadEntityType:   return new ModelAndView("redirect:/editMark?id=" + id);

            default:                            return new ModelAndView("redirect:/viewAll");
        }

    }

    /**
     * Add entity to the table GRP5_Entity and return the view of all entities
     * @param entity the entity for save
     * @return the view of all entities
     */
    @RequestMapping(value = "/saveEntity", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Entity entity) {
        entityDAO.saveOrUpdateEntityDB(entity);
        if (entity.getEntityType() == Student.getStudentEntityType() ||
                entity.getEntityType() == Tutor.getTutorEntityType() ||
                entity.getEntityType() == University.getUniversityEntityType()) {
            EntityParameter entityParameter =
                    new EntityParameter(entityDAO.getId("login"),entity.getId(),entity.getTitle());
            entityParameterDAO.saveParameterDB(entityParameter);
            entityParameter.setParameterId(entityDAO.getId("password"));
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(entity.getId().toString());
            entityParameter.setStringValue(hashedPassword);
            entityParameterDAO.saveParameterDB(entityParameter);
        }
        if (entity.getEntityType() == StudyLoad.getStudyloadEntityType()) {
            return new ModelAndView("redirect:/paramStudyLoad?id=" + entity.getId());
        }
        logger.info("The entity with id = " + entity.getId() + " was saved");
        return new ModelAndView("redirect:/viewAll");

    }

    /**
     * Return the view of the entity parameters
     * @param request id of the entity
     * @return view of the entity parameters
     */
    @RequestMapping(value = "/paramEntity", method = RequestMethod.GET)
    public ModelAndView param(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        return new ModelAndView("redirect:/viewParam?id=" + id);
    }

    /**
     * Return all entyties of the type
     * @param request type of the entity
     * @return all entyties of the type
     */
    @RequestMapping(value = "/viewByType", method = RequestMethod.GET)
    public ModelAndView viewByType(HttpServletRequest request) {
        int entityType = Integer.parseInt(request.getParameter("entityType"));
        List<Entity> entityList = entityDAO.getAllByType(entityType);
        Entity newEntity = new Entity();
        ModelAndView model = new ModelAndView("show", "list", entityList);
        model.addObject("entity", newEntity);
        return model;
    }
}
