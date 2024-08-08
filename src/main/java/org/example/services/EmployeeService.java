package org.example.services;

import org.example.daos.EmployeeDao;
import org.example.models.EmployeeRequest;
import org.example.models.EmployeeResponse;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {

    EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public int createEmployee(EmployeeRequest employeeRequest) throws SQLException {
        int id = employeeDao.createProduct(employeeRequest);

        return id;
    }

    public List<EmployeeResponse> getAllEmployees() throws SQLException {
        return  employeeDao.getAllEmployees();
    }
}
