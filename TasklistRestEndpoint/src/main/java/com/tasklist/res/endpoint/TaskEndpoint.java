package com.tasklist.res.endpoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class TaskEndpoint {
    static int num = 0;
    
    @Path("/saveTask/{name}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveTask(String task, @PathParam("name") String sku) {
        return Response.status(200).entity("Task saved successfully").build();
    }
    
    @POST
    @Path("/updateTask")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTask(String task) {        
        return Response.status(200).entity("Task saved successfully").build();

    }
    
    @DELETE
    @Path("/deleteTask/{id}")
    public Response deleteTask(@PathParam("id") Integer id) {
        return Response.status(200).entity("Task deleted successfully").build();
    }

    @GET
    @Path("/getExecutors")
    @Produces(MediaType.APPLICATION_JSON)
    public String getExecutors() {
        String[] executors = new String[6];
        executors[0] = "Luccy";
        executors[1] = "Grace";
        executors[2] = "Nadia";
        executors[3] = "Glory";
        executors[4] = "Andrew";
        executors[5] = "Lissa";
//executors[num] = null; 
num++;if(num > 5) num=0;
                
        ObjectMapper mapper = new ObjectMapper();
        String response;
        try {
            response = mapper.writeValueAsString(executors);
        } catch (JsonProcessingException ex) {
            response = ex.toString();
        }
        return response;
    }
    
    @GET
    @Path("/getTasklist")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTasklist() {
        Task[] taskList = new Task[4];
        String[] executorsTabulating = new String[3];
        executorsTabulating[0] = "Luccy";
        executorsTabulating[1] = "Grace";
        executorsTabulating[2] = "Nadia";
        String[] executorsPanchCardSorting = new String[3];
        executorsPanchCardSorting[0] = "Faith";
        executorsPanchCardSorting[1] = "Maria";
        executorsPanchCardSorting[2] = "Patti";
        String[] executorsMagtneticTapeInstall = new String[3];
        executorsMagtneticTapeInstall[0] = "Glory";
        executorsMagtneticTapeInstall[1] = "Andrew";
        executorsMagtneticTapeInstall[2] = "Lissa";
        String[] executorsMagneticDrumCleaning = new String[3];
        executorsMagneticDrumCleaning[0] = "Helen";
        executorsMagneticDrumCleaning[1] = "Peter";
        executorsMagneticDrumCleaning[2] = "Clay";
        Task taskTabulating = new Task("1", "tabulating", "1.1.1920", "2.2.1920", executorsTabulating);
        Task taskPanchcardSorting = new Task("1", "panch card sorting", "1.1.1921", "3.3.1921", executorsPanchCardSorting);
        Task taskMagneticTapeInstall = new Task("1", "magnetic tape install", "1.1.1922", "4.4.1922", executorsMagtneticTapeInstall);
        Task taskMagneticDrumCleaning = new Task("1", "magnetic drum cleaning", "1.1.1923", "5.5.1923", executorsMagneticDrumCleaning);
        taskList[0] = taskTabulating;
        taskList[1] = taskPanchcardSorting;
        taskList[2] = taskMagneticTapeInstall;
        taskList[3] = taskMagneticDrumCleaning;

        ObjectMapper mapper = new ObjectMapper();
        String response;
        try {
            response = mapper.writeValueAsString(taskList);
        } catch (JsonProcessingException ex) {
            response = ex.toString();
        }
        return response;
    }
}
