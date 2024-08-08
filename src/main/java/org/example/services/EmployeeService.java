package org.example.services;

import org.example.daos.EmployeeDao;
import org.example.models.EmployeeRequest;
import org.example.models.EmployeeResponse;
import org.example.models.SalesEmployeeRequest;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {

    EmployeeDao employeeDao;

    public EmployeeService(final EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public int createEmployee(final EmployeeRequest employeeRequest)
            throws SQLException {
        return employeeDao.createProduct(employeeRequest);

    }

    public int createEmployee(final SalesEmployeeRequest employeeRequest)
            throws SQLException {
        return employeeDao.createProduct(employeeRequest);


    }

    public List<EmployeeResponse> getAllEmployees() throws SQLException {
        return  employeeDao.getAllEmployees();
    }

    public Object getAllSalesEmployees() throws SQLException {
        return  employeeDao.getAllSalesEmployees();
    }
}
