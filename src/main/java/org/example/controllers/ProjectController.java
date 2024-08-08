package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.models.ProjectRequest;
import org.example.models.ProjectStatusRequest;
import org.example.services.ProjectService;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Project")
@Path("/api/projects")
public class ProjectController {
    ProjectService projectService;

    public ProjectController(final ProjectService projectService) {
        this.projectService = projectService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProject(final ProjectRequest projectRequest) {
        try {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(projectService.createProject(projectRequest))
                    .build();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return Response.serverError().build();

        }
//        catch (InvalidException e) {
//            return Response.status(Response.Status.BAD_REQUEST)
//            .entity(e.getMessage()).build();
//        }
    }

    @PUT
    @Path("/{id}/change-status")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProject(final @PathParam("id") int id,
                                  final ProjectStatusRequest status) {
        try {
            projectService.setStatus(id, status);
            return Response.noContent().build();
        }  catch (SQLException e) {
            return Response.serverError().build();
        }
    }
}
