package org.lnk.timesheet.controller;

import java.util.List;

import org.lnk.timesheet.domain.Employee;
import org.lnk.timesheet.service.dao.EmployeeDao;
import org.lnk.timesheet.web.exceptions.EmployeeDeleteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeDao employeeDao;
	 
	@Autowired
	public void setEmployeeDao(EmployeeDao employeeDao) {
	    this.employeeDao = employeeDao;
	}

	
	
	@RequestMapping(method = RequestMethod.GET)
    public String showEmployees(Model model) {
        List<Employee> employees = employeeDao.list();
        model.addAttribute("employees", employees);
 
        return "employees/list";
    }
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getEmployee(@PathVariable("id") long id, Model model) {
	    Employee employee = employeeDao.find(id);
	    model.addAttribute("employee", employee);
	 
	    return "employees/view";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String addEmployee(Employee employee) {
	    employeeDao.add(employee);
	 
	    return "redirect:/employees";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String updateEmployee(@PathVariable("id") long id, Employee employee) {
	    employee.setId(id);
	    employeeDao.update(employee);
	 
	    return "redirect:/employees";
	}
	
	@RequestMapping(params = "new", method = RequestMethod.GET)
	public String createEmployeeForm(Model model) {
	    model.addAttribute("employee", new Employee());
	    return "employees/new";
	}

	/**
	 * Handles EmployeeDeleteException
	 * @param e Thrown exception with employee that couldn't be deleted
	 * @return binds employee to model and returns employees/delete-error
	 */
	@ExceptionHandler(EmployeeDeleteException.class)
	public ModelAndView handleDeleteException(EmployeeDeleteException e) {
	    ModelMap model = new ModelMap();
	    model.put("employee", e.getEmployee());
	    return new ModelAndView("employees/delete-error", model);
	}
	
}
