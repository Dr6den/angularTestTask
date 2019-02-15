package com.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author andrew
 */
@Entity
@Table(name = "task")
public class Task {
    @Id
    @Column(name = "id", unique = true)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "startDate")
    private String startDate;
    @Column(name = "endDate")
    private String endDate;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    
    
}
