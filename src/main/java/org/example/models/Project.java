package org.example.models;

public class Project {
    private int id;
    private String name;
    private double value;
    private ProjectStatus status;

    // do zmiany na obiekty
    private int clientId;
    private int techleadId;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(final double value) {
        this.value = value;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(final ProjectStatus status) {
        this.status = status;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(final int clientId) {
        this.clientId = clientId;
    }

    public int getTechleadId() {
        return techleadId;
    }

    public void setTechleadId(final int techleadId) {
        this.techleadId = techleadId;
    }
}
