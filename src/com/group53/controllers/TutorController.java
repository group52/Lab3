package com.group53.controllers;

import com.group53.beans.Tutor;
import com.group53.dao.TutorDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class TutorController {

    @Autowired
    private TutorDAOImpl tutorDAO;

    @RequestMapping("/viewAllTutors")
    public ModelAndView showAllTutors(){
        List<Tutor> tutorList = tutorDAO.getAllTutors();
        return new ModelAndView("group_journal", "list", tutorList);
    }

}
