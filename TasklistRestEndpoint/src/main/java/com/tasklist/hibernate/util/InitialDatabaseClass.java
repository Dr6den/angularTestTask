package com.tasklist.hibernate.util;

import com.model.entities.Task;
import com.tasklist.dao.TaskDaoService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author andrew
 */
public class InitialDatabaseClass {

    public static void main(String[] args) {
        try (TaskDaoService factory = new TaskDaoService()) {
            String executor1 = "Helen";
            String executor2 = "Andrew";
            String executor3 = "Nadia";
            String executor4 = "Maria";
            String executor5 = "Lussi";
            String executor6 = "Peter";
            
            List<String> executors1 = new ArrayList();
            executors1.add(executor1);
            executors1.add(executor2);
            executors1.add(executor3);
            
            List<String> executors2 = new ArrayList();
            executors2.add(executor1);
            executors2.add(executor2);
            executors2.add(executor3);
            
            List<String> executors3 = new ArrayList();
            executors3.add(executor4);
            executors3.add(executor5);
            executors3.add(executor6);
            
            List<String> executors4 = new ArrayList();
            executors4.add(executor4);
            executors4.add(executor5);
            executors4.add(executor6);
            
            Task task1 = new Task("tabulating", "12.5.1920", "25.5.1920", executors1);
            Task task2 = new Task("magnetic tape installation", "12.5.1921", "25.5.1921", executors2);
            Task task3 = new Task("wires switching", "12.5.1922", "25.5.1922", executors3);
            Task task4 = new Task("magnetic drum cleaning", "12.5.1923", "25.5.1923", executors4);
            
            factory.saveTask(task1);
            factory.saveTask(task2);
            factory.saveTask(task3);
            factory.saveTask(task4);
            factory.close();
        } catch (Exception ex) {
            Logger.getLogger(InitialDatabaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
