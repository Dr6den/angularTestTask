package com.tasklist.dao;

import com.model.entities.Task;
import com.tasklist.hibernate.util.HibernateSessionFactory;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author andrew
 */
public class TaskDaoService implements AutoCloseable {
    private final SessionFactory sessionFactory;

    public TaskDaoService() {
        sessionFactory = HibernateSessionFactory.getSessionFactory();
    }
    
    public Task[] getTasklist() {
        Task[] result = new Task[0];
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Task> criteria = builder.createQuery(Task.class);
            criteria.from(Task.class);
            List<Task> listOfTasks = session.createQuery(criteria).getResultList();
            result = listOfTasks.toArray(new Task[listOfTasks.size()]);
        }
        return result;
    }
    
    public void saveTask(Task task) {
        
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(task);
            tx.commit();
        }
    }
    
    public Task getTaskById(int id) {
        Task task;
        try (Session session = sessionFactory.openSession()) {
            task = session.get(Task.class, id);
        }
        return task;
    }

    public void deleteTask(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Task task = session.get(Task.class, id);
            session.delete(task);
            tx.commit();
        }
    }

    @Override
    public void close() throws Exception {
        this.sessionFactory.close();
    }
}
