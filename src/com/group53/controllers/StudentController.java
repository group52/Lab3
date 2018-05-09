package com.group53.controllers;


import com.group53.beans.Student;
import com.group53.dao.StudentDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class StudentController {

    @Autowired
    private StudentDAOImpl studentDAO;

    @RequestMapping("/viewAll")
    public ModelAndView showAllStudents(){
        List<Student> studentList = studentDAO.getAllStudents();
        return new ModelAndView("group_journal", "list", studentList);
    }
}
