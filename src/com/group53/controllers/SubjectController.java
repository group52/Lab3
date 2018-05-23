package com.group53.controllers;

import com.group53.beans.Subject;
import com.group53.dao.SubjectDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class SubjectController {

    @Autowired
    private SubjectDAOImpl subjectDAO;

    @RequestMapping("/subjects")
    public ModelAndView showSubjects(){
        List<Subject> list=subjectDAO.getAllSubjects();
        return new ModelAndView("subjects","list", list);
    }

    @RequestMapping("/add_subject")
    public ModelAndView showAddForm(){
        return new ModelAndView("add_subject","command",new Subject());
    }

    @RequestMapping(value="/edit_subject/{id}")
    public ModelAndView showEditableSubject(@PathVariable long id){
        Subject subject = subjectDAO.selectSubjectById(id);
        return new ModelAndView("edit_subject","command", subject);
    }

    @RequestMapping(value="/insert_subject",method = RequestMethod.POST)
    public ModelAndView insertSubject(@ModelAttribute("subject") Subject subject){
        subjectDAO.insertSubject(subject);
        return new ModelAndView("redirect:/subjects");
    }

    @RequestMapping(value="/update_subject",method = RequestMethod.POST)
    public ModelAndView updateSubject(@ModelAttribute("subject") Subject subject){
        subjectDAO.updateSubject(subject);
        return new ModelAndView("redirect:/subjects");
    }

    @RequestMapping(value="/remove_subject/{id}",method = RequestMethod.GET)
    public ModelAndView removeSubject(@PathVariable long id){
        subjectDAO.removeSubject(id);
        return new ModelAndView("redirect:/subjects");
    }

}
