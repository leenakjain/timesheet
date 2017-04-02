package org.lnk.timesheet.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.lnk.timesheet.DomainAwareBase;
import org.lnk.timesheet.domain.Employee;
import org.lnk.timesheet.domain.Manager;
import org.lnk.timesheet.domain.Task;
import org.lnk.timesheet.domain.Timesheet;
import org.lnk.timesheet.service.dao.EmployeeDao;
import org.lnk.timesheet.service.dao.ManagerDao;
import org.lnk.timesheet.service.dao.TaskDao;
import org.lnk.timesheet.service.dao.TimesheetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
 
@ContextConfiguration(locations = "/persistence-beans.xml")
public class EmployeeDaoTest extends DomainAwareBase {
 
    @Autowired
    private EmployeeDao employeeDao;
 
    @Autowired
    private ManagerDao managerDao;
 
    @Autowired
    private TaskDao taskDao;
 
    @Autowired
    private TimesheetDao timesheetDao;
 
    @Test
    public void testAdd() {
        int size = employeeDao.list().size();
        employeeDao.add(new Employee("test-employee", "hackzorz"));
 
        // list should have one more employee now
        assertTrue (size < employeeDao.list().size());
    }
 
    @Test
    public void testUpdate() {
        Employee employee = new Employee("test-employee", "hackzorz");
        employeeDao.add(employee);
        employee.setName("updated");
 
        employeeDao.update(employee);
        Employee found = employeeDao.find(employee.getId());
        assertEquals("updated", found.getName());
    }
 
    @Test
    public void testFind() {
        Employee employee = new Employee("test-employee", "hackzorz");
        employeeDao.add(employee);
 
        Employee found = employeeDao.find(employee.getId());
        assertEquals(found, employee);
    }
 
    @Test
    public void testList() {
        assertEquals(0, employeeDao.list().size());
 
        List<Employee> employees = Arrays.asList(
                new Employee("test-1", "testers"),
                new Employee("test-2", "testers"),
                new Employee("test-3", "testers"));
        for (Employee employee : employees) {
            employeeDao.add(employee);
        }
 
        List<Employee> found = employeeDao.list();
        assertEquals(3, found.size());
        for (Employee employee : found) {
            assertTrue(employees.contains(employee));
        }
    }
 
    @Test
    public void testRemove() {
        Employee employee = new Employee("test-employee", "hackzorz");
        employeeDao.add(employee);
 
        // successfully added
        assertEquals(employee, employeeDao.find(employee.getId()));
 
        // try to remove
        employeeDao.remove(employee);
        assertNull(employeeDao.find(employee.getId()));
    }
 
    @Test
    public void testRemoveEmployee() {
        Manager manager = new Manager("task-manager");
        managerDao.add(manager);
 
        Employee employee = new Employee("Jaromir", "Hockey");
        employeeDao.add(employee);
 
        Task task = new Task("test-task", manager, employee);
        taskDao.add(task);
 
        Timesheet timesheet = new Timesheet(employee, task, 100);
        timesheetDao.add(timesheet);
 
        // try to remove -> shouldn't work
        assertFalse(employeeDao.removeEmployee(employee));
 
        // remove stuff
        timesheetDao.remove(timesheet);
        taskDao.remove(task);
 
        // should work -> employee is now free
        assertTrue(employeeDao.removeEmployee(employee));
    }
 
}