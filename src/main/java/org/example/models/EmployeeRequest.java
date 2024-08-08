package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeRequest {
    private String name;
    private double salary;
    private String bankAccount;
    private String insuranceNumber;

    @JsonCreator
    public EmployeeRequest(@JsonProperty("name") String name,
                           @JsonProperty("salary") double salary,
                           @JsonProperty("bankAccount") String bankAccount,
                           @JsonProperty("insuranceNumber") String insuranceNumber) {
        this.name = name;
        this.salary = salary;
        this.bankAccount = bankAccount;
        this.insuranceNumber = insuranceNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }
}
