package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.models.EmployeeRequest;
import org.example.services.EmployeeService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Employee Controller")
@Path("/api/employees")
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEmployee(EmployeeRequest employeeRequest){

        try {
            return Response.ok().entity(employeeService.createEmployee(employeeRequest)).build();
        } catch (SQLException e) {
            return Response.serverError().build();
        }
    }
}
