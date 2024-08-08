package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesEmployeeResponse extends EmployeeRequest{
    private double commissionRate;

    @JsonCreator
    public SalesEmployeeResponse(@JsonProperty("name") String name,
                                 @JsonProperty("salary") double salary,
                                 @JsonProperty("bankAccount") String bankAccount,
                                 @JsonProperty("insuranceNumber") String insuranceNumber,
                                 @JsonProperty("commissionRate") double commissionRate) {
        super(name, salary, bankAccount, insuranceNumber);
        this.commissionRate = commissionRate;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }
}
