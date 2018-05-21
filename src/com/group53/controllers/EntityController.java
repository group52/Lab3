package com.group53.controllers;


import com.group53.beans.Entity;
import com.group53.dao.EntityDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class EntityController {

    @Autowired
    private EntityDAOImpl entityDAO;

    @RequestMapping("viewAll")
    public ModelAndView showAllEntitys(){
        List<Entity> entityList = entityDAO.getAllEntitys();
        ModelAndView model = new ModelAndView("show", "list", entityList);
        Entity newEntity = new Entity();
        model.addObject("entity", newEntity);
        return model;
    }

    @RequestMapping(value = "/deleteEntity", method = RequestMethod.GET)
    public ModelAndView deleteEntity(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        entityDAO.deleteEntityDB(id);
        return new ModelAndView("redirect:/viewAll");
    }

    @RequestMapping(value = "/editEntity", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        Entity newEntity = entityDAO.getEntity(id);
        List<Entity> entityList = entityDAO.getAllEntitys();
        ModelAndView model = new ModelAndView("show", "list", entityList);
        model.addObject("entity", newEntity);
        return model;

    }

    @RequestMapping(value = "/childEntity", method = RequestMethod.GET)
    public ModelAndView child(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        Entity entity = entityDAO.getEntity(id);
        if (entity.getEntityType() != 4) {
            Entity newEntity = new Entity();
            List<Entity> entityList = entityDAO.getChildEntitys(id);
            ModelAndView model = new ModelAndView("show", "list", entityList);
            newEntity.setParentId(id);
            model.addObject("entity", newEntity);
            return model;
        } else
        return new ModelAndView("redirect:/progress.jsp");
    }

    @RequestMapping(value = "/saveEntity", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Entity entity) {
        entityDAO.saveOrUpdateEntityDB(entity);
        return new ModelAndView("redirect:/viewAll");
    }

    @RequestMapping(value = "/paramEntity", method = RequestMethod.GET)
    public ModelAndView param(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        return new ModelAndView("redirect:/viewParam?id=" + id);
    }


}
