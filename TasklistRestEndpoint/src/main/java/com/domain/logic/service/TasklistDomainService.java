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
    
    public String[] getExecutors() {
        String[] result = new String[0];
        Set<String> uniqueExecutors = new HashSet<>();
        Task[] tasks = daoService.getTasklist();
        
        Stream.of(tasks).forEach((Task task) -> uniqueExecutors.add(task.getName()));
        
        result = uniqueExecutors.toArray(new String[uniqueExecutors.size()]);
        return result;
    }
    
    public Task[] getTasklist() {
        return daoService.getTasklist();
    }
    
    public void deleteTask(int id) {
        daoService.deleteTask(id);
    }
    
    public void saveTask(Task task) {
        daoService.saveTask(task);
    }

    @Override
    public void close() throws Exception {
        daoService.close();
    }
    
}