package org.example.models;

import java.sql.Date;

public class ClientWithDetails {
    private int id;
    private String name;
    private String sales_employee;
    private String projects;

    public ClientWithDetails(int id, String name, String sales_employee, String projects) {
        this.id = id;
        this.name = name;
        this.sales_employee = sales_employee;
        this.projects = projects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSales_employee() {
        return sales_employee;
    }

    public void setSales_employee(String sales_employee) {
        this.sales_employee = sales_employee;
    }

    public String getProjects() {
        return projects;
    }

    public void setProjects(String projects) {
        this.projects = projects;
    }
}
