package com.group53.controllers;

import com.group53.dao.StudentDAOImpl;
import com.group53.dao.SubjectDAOImpl;
import com.group53.dao.TutorDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class MarkController {
    @Autowired
    private TutorDAOImpl tutorDAO;
    @Autowired
    private StudentDAOImpl studentDAO;
    @Autowired
    private SubjectDAOImpl subjectDAO;
}
