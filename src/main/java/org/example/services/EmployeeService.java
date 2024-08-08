package org.example.services;

import org.example.daos.EmployeeDao;
import org.example.models.EmployeeRequest;

import java.sql.SQLException;

public class EmployeeService {

    EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public int createEmployee(EmployeeRequest employeeRequest) throws SQLException {
        int id = employeeDao.createProduct(employeeRequest);

        return id;
    }
}
