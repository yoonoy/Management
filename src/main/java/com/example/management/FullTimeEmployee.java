package com.example.management;

public class FullTimeEmployee extends Employee {
    private double annualSalary;

    public FullTimeEmployee(String name, double annualSalary) {
        super(name);
        this.annualSalary = annualSalary;
    }

    @Override
    public double calculateSalary() {
        return annualSalary;
    }

    @Override
    public String getEmployeeType() {
        return "Full-time";
    }
}

