package com.group53.controllers;

import com.group53.beans.Subject;
import com.group53.dao.SubjectDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class SubjectController {

    @Autowired
    private SubjectDAOImpl subjectDAO;

    @RequestMapping("/viewAllSubjects")
    public ModelAndView showAllSubjects(){
        List<Subject> subjectList = subjectDAO.getAllSubjects();
        return new ModelAndView("subjects", "list", subjectList);
    }

}
