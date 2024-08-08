package org.example.daos;

import org.example.models.EmployeeRequest;
import org.example.models.EmployeeResponse;
import org.example.models.SalesEmployeeRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    public int createProduct(EmployeeRequest employeeRequest) throws SQLException {
        try(Connection connection = DatabaseConnector.getConnection()){
            String query = "INSERT INTO Employee (name, salary, bank_account_number,national_insurance_number) VALUES (?,?,?,?);";

            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, employeeRequest.getName());
            preparedStatement.setDouble(2, employeeRequest.getSalary());
            preparedStatement.setString(3, employeeRequest.getBankAccount());
            preparedStatement.setString(4, employeeRequest.getInsuranceNumber());


            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if(resultSet.next()){
                return resultSet.getInt(1);
            }

            return -1;
        }
    }

    public int createProduct(SalesEmployeeRequest employeeRequest) throws SQLException {
        int id = createProduct((EmployeeRequest) employeeRequest);

        if(id != -1){
            try (Connection connection = DatabaseConnector.getConnection()) {
                String query = "INSERT INTO Commission_Rate (id,value) VALUES (?,?);";
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                preparedStatement.setInt(1,id);
                preparedStatement.setDouble(2,employeeRequest.getCommissionRate());

                preparedStatement.executeUpdate();
            }
        }

        return id;
    }

    public List<EmployeeResponse> getAllEmployees() throws SQLException {
        List<EmployeeResponse> employees = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM `Employee`;"
            );

            while (resultSet.next()) {
                EmployeeResponse employeeResponse = new EmployeeResponse(
                        resultSet.getString("name"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("bank_account_number"),
                        resultSet.getString("national_insurance_number")
                );

                employees.add(employeeResponse);
            }

        }
        return employees;
    }
}
