package org.lnk.timesheet.web.editors;

import org.lnk.timesheet.domain.Task;
import org.lnk.timesheet.service.dao.TaskDao;

import java.beans.PropertyEditorSupport;

public class TaskEditor extends PropertyEditorSupport {

    private TaskDao taskDao;

    public TaskEditor(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        long id = Long.parseLong(text);
        Task task = taskDao.find(id);
        setValue(task);
    }
}
