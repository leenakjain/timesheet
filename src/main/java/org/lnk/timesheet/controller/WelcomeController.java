package org.lnk.timesheet.controller;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.lnk.timesheet.web.helpers.EntityGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
@RequestMapping("/welcome1")
public class WelcomeController {
 
  /*  @Autowired
    private EntityGenerator entityGenerator;
 
    @RequestMapping(method = RequestMethod.GET)
    public String showMenu(Model model) {
        model.addAttribute("today", new Date());
        return "index";
    }
 
    @PostConstruct
    public void prepareFakeDomain() {
        entityGenerator.deleteDomain();
        entityGenerator.generateDomain();
    }*/
 
}