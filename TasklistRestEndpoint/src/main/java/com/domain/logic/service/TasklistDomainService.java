package com.domain.logic.service;

import com.model.entities.Task;
import com.tasklist.dao.TaskDaoService;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 *
 * @author andrew
 */
public class TasklistDomainService implements AutoCloseable {
    private TaskDaoService daoService;

    public TasklistDomainService() {
        daoService = new TaskDaoService();
    }

    public TasklistDomainService(TaskDaoService daoService) {
        this.daoService = daoService;
    }
    
    public String[] getExecutors() {
        String[] result = new String[0];
        Set<String> uniqueExecutors = new HashSet<>();
        Task[] tasks = daoService.getTasklist();
        
        Stream.of(tasks).forEach((Task task) -> task.getExecutors().stream()
                .forEach((String executorName) -> uniqueExecutors.add(executorName)));
        
        result = uniqueExecutors.toArray(new String[uniqueExecutors.size()]);
        return result;
    }
    
    public Task[] getTasklist() {
        return daoService.getTasklist();
    }
    
    public void deleteTask(int id) {
        daoService.deleteTask(id);
    }
    
    public void saveTask(String id, Task task) {
        if(!id.equals("undefined")) {
            Integer idInt = Integer.valueOf(id);
            Task persistedTask = daoService.getTaskById(idInt);
            persistedTask.setName(task.getName());
            persistedTask.setStartDate(task.getStartDate());
            persistedTask.setEndDate(task.getEndDate());
            persistedTask.setExecutors(task.getExecutors());
            daoService.saveTask(persistedTask);
        } else {
            daoService.saveTask(task);
        }
    }

    @Override
    public void close() throws Exception {
        daoService.close();
    }

}
