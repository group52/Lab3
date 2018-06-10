package com.group53.controllers;

import com.group53.beans.User;
import com.group53.dao.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AdminController {
    @Autowired
    public UserService userService;
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView showAdminPage(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("admin");
        mav.addObject("user", new User());
        return mav;
    }
    @RequestMapping(value = "/adminProcess", method = RequestMethod.POST)
    public ModelAndView updateUser(HttpServletRequest request, HttpServletResponse response,
                                @ModelAttribute("user") User user) {
        userService.updateRole(user);
        return new ModelAndView("redirect:/viewAll");
    }
}
