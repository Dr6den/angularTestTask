package orm.tests;

import com.model.entities.Task;
import com.tasklist.dao.TaskDaoService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author andrew
 */
public class OrmIntegrationTest {
    private static TaskDaoService taskDaoService;
    
    public OrmIntegrationTest() {
    }
    
    @Test
    public void saveTaskTest() { 
        String name = "do something, don't seat";
        String startDate = "1.1.1924";
        String endDate = "1.1.1925";
        String ex1 = "Nadia";
        String ex2 = "Tomaso";
        List<String> executors = new ArrayList();
        executors.add(ex1);
        executors.add(ex2);
        
        Task task = new Task(name, startDate, endDate, executors);
        taskDaoService.saveTask(task);
        Integer persistedId = task.getId();
        Task persistedTask = taskDaoService.getTaskById(persistedId);
        
        assertNotNull(persistedTask);
        assertEquals(persistedTask.getName(), name);
        assertEquals(persistedTask.getStartDate(), startDate);
        assertEquals(persistedTask.getEndDate(), endDate);
        List<String> persistedExe = persistedTask.getExecutors();
        assertNotNull(persistedExe);
        assertTrue(persistedExe.contains(ex2));
        assertTrue(persistedExe.contains(ex1));        
        taskDaoService.deleteTask(persistedId);
    }
    
    @Test
    public void deleteTaskTest() { 
        String name = "do something, don't seat";
        String startDate = "1.1.1924";
        String endDate = "1.1.1925";
        String ex1 = "Nadia";
        String ex2 = "Tomaso";
        List<String> executors = new ArrayList();
        executors.add(ex1);
        executors.add(ex2);
        
        Task task = new Task(name, startDate, endDate, executors);
        taskDaoService.saveTask(task);
        Integer persistedId = task.getId();
        taskDaoService.deleteTask(persistedId);
        
        Task persistedTask = taskDaoService.getTaskById(persistedId);
        assertNull(persistedTask);
    }
    
    @Test
    public void getTasklistTest() {
        Task[] tasklist = taskDaoService.getTasklist();
        assertNotNull(tasklist);
        assertTrue(tasklist.length > 0);
        List<String> executors = tasklist[0].getExecutors();
        assertNotNull(executors);
        assertTrue(executors.size() > 0);
    }
    
    @BeforeClass
    public static void init() {
        taskDaoService = new TaskDaoService();
    }
    
    @AfterClass
    public static void closeResources() {
        try {
            taskDaoService.close();
        } catch (Exception ex) {
            Logger.getLogger(OrmIntegrationTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
