package com.group53.controllers;


import com.group53.beans.*;
import com.group53.dao.EntityDAOImpl;
import com.group53.dao.EntityParameterDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class EntityController {
    private static final Logger logger = Logger.getLogger(EntityController.class);

    @Autowired
    private EntityDAOImpl entityDAO;
    @Autowired
    private EntityParameterDAOImpl entityParameterDAO;

    @RequestMapping("viewAll")
    public ModelAndView showAllEntitys(){
        List<Entity> entityList = entityDAO.getAllEntitys();
        ModelAndView model = new ModelAndView("show", "list", entityList);
        Entity newEntity = new Entity();
        model.addObject("entity", newEntity);
        logger.info("Entities were added to show.jsp");
        return model;
    }

    @RequestMapping(value = "/deleteEntity", method = RequestMethod.GET)
    public ModelAndView deleteEntity(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        entityDAO.deleteEntityDB(id);
        logger.info("The entity with id = " + id + " was deleted");
        return new ModelAndView("redirect:/viewAll");
    }

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

    @RequestMapping(value = "/childEntity", method = RequestMethod.GET)
    public ModelAndView child(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        Entity entity = entityDAO.getEntity(id);
        Entity newEntity = new Entity();
        List<Entity> entityList = entityDAO.getChildEntitys(id);
        ModelAndView model = new ModelAndView("show", "list", entityList);


        int entityType = entity.getEntityType();
        switch (entityType) {
            case Student.student_entity_type:   return new ModelAndView("redirect:/mark?id=" + id);

            case Group.group_entity_type:       newEntity.setParentId(id);
                                                model.addObject("entity", newEntity);
                                                return model;

            case Tutor.tutor_entity_type:       entityList.clear();
                                                for (Long idStudyLoad : entityParameterDAO.getStudyLoadByTutor(id))
                                                    entityList.add(entityDAO.getEntity(idStudyLoad));
                                                model.addObject("list", entityList);
                                                model.addObject("entity", newEntity);
                                                return model;

            case Subject.subject_entity_type:   newEntity.setParentId(id);
                                                model.addObject("entity", newEntity);
                                                return model;

            case University.university_entity_type:   newEntity.setParentId(id);
                                                model.addObject("entity", newEntity);
                                                return model;

            case StudyLoad.studyload_entity_type:   return new ModelAndView("redirect:/editMark?id=" + id);

            default:                            return new ModelAndView("redirect:/viewAll");
        }
    }

    @RequestMapping(value = "/saveEntity", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Entity entity) {
        entityDAO.saveOrUpdateEntityDB(entity);
        if (entity.getEntityType() == Student.getStudent_entity_type() ||
                entity.getEntityType() == Tutor.getTutor_entity_type() ||
                entity.getEntityType() == University.getUniversity_entity_type()) {
            EntityParameter entityParameter = new EntityParameter();
            entityParameter.setParameterId(entityDAO.getId("login"));
            entityParameter.setEntityId(entity.getId());
            entityParameter.setStringValue(entity.getTitle());
            entityParameterDAO.saveParameterDB(entityParameter);
            entityParameter.setParameterId(entityDAO.getId("password"));
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(entity.getId().toString());
            entityParameter.setStringValue(hashedPassword);
            entityParameterDAO.saveParameterDB(entityParameter);
        }
        logger.info("The entity with id = " + entity.getId() + " was saved");
        return new ModelAndView("redirect:/viewAll");

    }

    @RequestMapping(value = "/paramEntity", method = RequestMethod.GET)
    public ModelAndView param(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        return new ModelAndView("redirect:/viewParam?id=" + id);
    }

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
