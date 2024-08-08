package org.example.services;

import org.example.daos.ProjectDao;
import org.example.models.Project;
import org.example.models.ProjectRequest;
import org.example.models.ProjectStatusRequest;

import java.sql.SQLException;

public class ProjectService {
    ProjectDao projectDao;

    public ProjectService(final ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public int createProject(final ProjectRequest projectRequest)
            throws SQLException {
        //zwalidowac

        int id = projectDao.createProject(projectRequest);

//        if(id == -1){
//            throw new FailedToCreateException();
//        }
        return id;
    }

    public void setStatus(final int id, final ProjectStatusRequest status)
            throws SQLException {
        Project projectToUpdate = projectDao.getProjectByID(id);

//        do zrobienia
//        if(projectToUpdate == null) {
//            throw new DoesNotExistException();
//        }

        projectDao.updateProject(id, status.getProjectStatus());
    }

    public void removeEmployee(final int projectID, final int employeeID)
            throws SQLException {
        Project projectToRemove = projectDao.getProjectByID(projectID);
//        if (projectToRemove == null) {
//            throw new DoesNotExistException(Entity.PRODUCT);
//        }

        projectDao.removeEmployee(employeeID, projectID);
    }
}
