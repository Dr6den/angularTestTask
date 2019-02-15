package com.tasklist.res.endpoint;

/**
 *
 * @author andrew
 */
public class Task {
    private String id;
    private String name;
    private String startDate;
    private String endDate;
    private String executors[];

    public Task(String id, String name, String startDate, String endDate, String[] executors) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.executors = executors;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String[] getExecutors() {
        return executors;
    }

    public void setExecutors(String[] executors) {
        this.executors = executors;
    }
    
    
}
