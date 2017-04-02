package org.lnk.timesheet.service.dao;

import org.lnk.timesheet.domain.Timesheet;
import org.lnk.timesheet.service.GenericDao;
 
/**
 * DAO of Timesheet.
 */
public interface TimesheetDao extends GenericDao<Timesheet, Long> {
    // no additional business operations atm
}