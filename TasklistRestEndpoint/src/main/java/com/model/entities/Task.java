package com.model.entities;

import com.tasklist.hibernate.util.Identifiable;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "task")
public class Task  implements java.io.Serializable, Identifiable<Integer> {

    @Id
    @GenericGenerator(
            name = "assigned-identity",
            strategy = "com.tasklist.hibernate.util.AssignedIdentityGenerator"
    )
    @GeneratedValue(
            generator = "assigned-identity",
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id")    
    private Integer id;    
    @Column(name = "name")
    private String name;
    @Column(name = "startDate")
    private String startDate;
    @Column(name = "endDate")
    private String endDate;
    
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "executor")
    @Column(name = "name")
    private List<String> executors;

    public Task() {
    }

    public Task(String name, String startDate, String endDate, List<String> executors) {
        this.endDate = endDate;
        this.name = name;
        this.startDate = startDate;
        this.executors = executors;
    }
    
    public Task(Integer id, String name, String startDate, String endDate, List<String> executors) {
        this.id = id;
        this.endDate = endDate;
        this.name = name;
        this.startDate = startDate;
        this.executors = executors;
    }

    public List<String> getExecutors() {
        return executors;
    }

    public void setExecutors(List<String> executors) {
        this.executors = executors;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

}


