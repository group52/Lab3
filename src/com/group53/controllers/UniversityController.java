package com.group53.controllers;

import com.group53.beans.University;
import com.group53.dao.UniversityDAOIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class UniversityController {

    @Autowired
    private UniversityDAOIml universityDAOIml;

    @RequestMapping("/viewAll")
    public ModelAndView showAllUniversities(){
        List<University> universityList = universityDAOIml.getAllUniversities();
        return new ModelAndView("group_journal", "list", universityList);
    }
}
