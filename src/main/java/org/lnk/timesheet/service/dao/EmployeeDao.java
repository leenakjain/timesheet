package org.lnk.timesheet.service.dao;

import org.lnk.timesheet.domain.Employee;
import org.lnk.timesheet.service.GenericDao;
 
/**
 * DAO of employee.
 */
public interface EmployeeDao extends GenericDao<Employee, Long> {
 
    /**
     * Tries to remove employee from the system.
     * @param employee Employee to remove
     * @return {@code true} if employee is not assigned to any task
     * or timesheet. Else {@code false}.
     */
    boolean removeEmployee(Employee employee);
 
}