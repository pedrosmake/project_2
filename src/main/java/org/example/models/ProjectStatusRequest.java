package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectStatusRequest {
    private ProjectStatus projectStatus;

    @JsonCreator
    public ProjectStatusRequest(@JsonProperty("status") ProjectStatus projectStatus) {
        this.projectStatus = projectStatus;
    }

    public ProjectStatus getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(ProjectStatus projectStatus) {
        this.projectStatus = projectStatus;
    }
}
