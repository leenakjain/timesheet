package org.lnk.timesheet.controller;

import org.lnk.timesheet.service.dao.EmployeeDao;
import org.lnk.timesheet.service.dao.ManagerDao;
import org.lnk.timesheet.service.dao.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/tasks")
public class TaskController {
 
    private TaskDao taskDao;
    private EmployeeDao employeeDao;
    private ManagerDao managerDao;
 
    @Autowired
    public void setTaskDao(TaskDao taskDao) {
        this.taskDao = taskDao;
    }
 
    @Autowired
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
 
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }
 
    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }
 
    public TaskDao getTaskDao() {
        return taskDao;
    }
 
    public ManagerDao getManagerDao() {
        return managerDao;
    }
    
    /**
     * Retrieves tasks, puts them in the model and returns corresponding view
     * @param model Model to put tasks to
     * @return tasks/list
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showTasks(Model model) {
        model.addAttribute("tasks", taskDao.list());
     
        return "tasks/list";
    }
}