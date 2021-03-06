package org.lnk.timesheet.web.exceptions;

import org.lnk.timesheet.domain.Employee;

/**
 * When employee cannot be deleted.
 */
public class EmployeeDeleteException extends Exception {
 
    private Employee employee;
 
    public EmployeeDeleteException(Employee employee) {
        this.employee = employee;
    }
 
    public Employee getEmployee() {
        return employee;
    }
}