package com.tasklist.rest.endpoint;

import com.domain.logic.service.TasklistDomainService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.entities.Task;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class TasklistEndpoint implements AutoCloseable {
    private TasklistDomainService service;
    
    public TasklistEndpoint() {
        service = new TasklistDomainService();
    }
    
    @Path("/saveTask/{name}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveTask(String taskJson, @PathParam("name") String sku) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Task task = mapper.readValue(taskJson, Task.class);
            service.saveTask(task);
        } catch (IOException ex) {
            return Response.status(500).entity("ServerError" + ex.getMessage()).build();
        }
        return Response.status(200).entity("Task saved successfully").build();
    }
   
    @DELETE
    @Path("/deleteTask/{id}")
    public Response deleteTask(@PathParam("id") Integer id) {
        service.deleteTask(id);
        return Response.status(200).entity("Task deleted successfully").build();
    }

    @GET
    @Path("/getExecutors")
    @Produces(MediaType.APPLICATION_JSON)
    public String getExecutors() {
        String[] executors = service.getExecutors();
                
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
        Task[] taskList = service.getTasklist();

        ObjectMapper mapper = new ObjectMapper();
        String response;
        try {
            response = mapper.writeValueAsString(taskList);
        } catch (JsonProcessingException ex) {
            response = ex.toString();
        }
        return response;
    }

    @Override
    public void close() throws Exception {
        this.service.close();
    }
}
