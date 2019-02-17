package service.tests;

import com.domain.logic.service.TasklistDomainService;
import com.model.entities.Task;
import com.tasklist.dao.TaskDaoService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author andrew
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ TaskDaoService.class })
public class TasklistDomainServiceTest {
    private TaskDaoService taskDaoService = PowerMockito.mock(TaskDaoService.class);
    private TasklistDomainService tasklistDamainService = new TasklistDomainService(taskDaoService);
    
    @Before
    public void before() {
        Mockito.reset(taskDaoService);
    }
    
    @Test
    public void getExecutorsTest() {
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
        
        Task[] tasklistAnsw = {task1, task2, task3, task4};
        
        PowerMockito.when(taskDaoService.getTasklist()).thenReturn(tasklistAnsw);

        String[] executors = tasklistDamainService.getExecutors();
        assertNotNull(executors);
        assertTrue(executors.length == 6);
        List<String> retrievedExecutors = Arrays.asList(executors);
        assertTrue(retrievedExecutors.contains(executor1));
        assertTrue(retrievedExecutors.contains(executor2));
        assertTrue(retrievedExecutors.contains(executor3));
        assertTrue(retrievedExecutors.contains(executor4));
        assertTrue(retrievedExecutors.contains(executor5));
        assertTrue(retrievedExecutors.contains(executor6));
    }
    
}
