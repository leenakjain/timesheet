package org.lnk.timesheet.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.lnk.timesheet.domain.Timesheet;
import org.lnk.timesheet.service.dao.TimesheetDao;
import org.springframework.stereotype.Repository;
 
@Repository("timesheetDao")
public class TimesheetDaoImpl extends HibernateDao<Timesheet, Long> implements TimesheetDao {
 
    @Override
    public List<Timesheet> list() {
        return currentSession().createCriteria(Timesheet.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
    }
}