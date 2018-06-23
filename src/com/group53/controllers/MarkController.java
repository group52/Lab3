package com.group53.controllers;

import com.group53.beans.Entity;
import com.group53.beans.EntityParameter;
import com.group53.beans.StudyLoad;
import com.group53.dao.EntityDAOImpl;
import com.group53.dao.EntityParameterDAOImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * Class for operation under the mark of the students
 */
@Controller
public class MarkController {
    private static final Logger logger = Logger.getLogger(MarkController.class);
    @Autowired
    private EntityParameterDAOImpl entityParameterDAO;
    @Autowired
    private EntityDAOImpl entityDAO;

    /**
     * Add mark on group_journal.jsp for some student and return  group_journal.jsp with all mark fot the studyload
     * @param request id of the entity
     * @return group_journal.jsp with all mark fot the studyload
     */
    @RequestMapping(value = "/editMark", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        StudyLoad newStudyLoad = entityDAO.getStudyLoad(id);
        TreeSet<Date> dateTreeSet = entityParameterDAO.getAllDatesByStudyLoad(id);
        ModelAndView model = new ModelAndView("group_journal", "dates", dateTreeSet);
        HashMap<Entity, Map<Date, Double>> journal = new HashMap<Entity, Map<Date, Double>>();
        List<Entity> students = entityDAO.getChildEntitys(newStudyLoad.getGroupId());
        for (Entity entity : students){
            journal.put(entity, entityParameterDAO.getAllMarksByStudent(dateTreeSet,id,entity.getId()));
        }
        model.addObject("journal", journal);
        model.addObject("students", students);
        model.addObject("group", entityDAO.getEntity(newStudyLoad.getGroupId()));
        model.addObject("subject", entityDAO.getEntity(newStudyLoad.getParentId()));
        model.addObject("tutor", entityDAO.getEntity(newStudyLoad.getTutorId()));
        EntityParameter newEntityParameter = new EntityParameter();
        newEntityParameter.setParameterId(entityDAO.getId("mark"));
        newEntityParameter.setIdValue(id);
        logger.info("Mark,  id = " + id + " was edited");
        model.addObject("entityParameter", newEntityParameter);
        return model;
    }

    /**
     * View all marks for all subjects for the student
     * @param request id of the entity
     * @return progress.page with marks for all subjects for the student
     */
    @RequestMapping(value = "/mark", method = RequestMethod.GET)
    public ModelAndView mark(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        Entity student = entityDAO.getEntity(id);
        TreeSet<Date> dateTreeSet = entityParameterDAO.getAllDatesByStudent(id);
        ModelAndView model = new ModelAndView("progress", "dates", dateTreeSet);
        HashMap<String, Map<Date, Double>> journal = new HashMap<String, Map<Date, Double>>();
        TreeSet<Long> studyLoads = entityParameterDAO.getStudyLoadByGroup(student.getParentId());
        for (Long studyLoadId : studyLoads){
            journal.put(entityDAO.getEntity(entityDAO.getStudyLoad(studyLoadId).getParentId()).getTitle(), entityParameterDAO.getAllMarksByStudent(dateTreeSet,studyLoadId,id));
        }
        model.addObject("journal", journal);
        model.addObject("student", student);
        logger.info("Student marks were updated");
        return model;
    }

    /**
     * Add mark on group_journal.jsp for some student and return all mark fot the studyload
     * @param entityParameter mark parameter for the entity
     * @return all mark fot the studyload
     */
    @RequestMapping(value = "/saveMark", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute EntityParameter entityParameter) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            java.util.Date date = dateFormat.parse(entityParameter.getDateString());
            entityParameter.setDateValue(new Date(date.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
            logger.error("ParseException: ", e);
        }

        entityParameterDAO.saveParameterDB(entityParameter);
        logger.info("The param with entity id = " + entityParameter.getEntityId() + " was saved");
        return new ModelAndView("redirect://editMark?id=" + entityParameter.getIdValue());
    }
}
