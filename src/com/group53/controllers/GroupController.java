package com.group53.controllers;

import com.group53.beans.Group;
import com.group53.dao.GroupDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class GroupController {

    @Autowired
    private GroupDAOImpl groupDAO;

    @RequestMapping("/viewAll")
    public ModelAndView showAllStudents(){
        List<Group> groupList = groupDAO.getAllGroups();
        return new ModelAndView("group_journal", "list", groupList);
    }
}
