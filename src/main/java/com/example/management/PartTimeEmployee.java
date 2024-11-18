package com.example.management;

public class PartTimeEmployee extends Employee {
    private double hourlyWage;
    private double hoursWorked;

    public PartTimeEmployee(String name, double hourlyWage, double hoursWorked) {
        super(name);
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyWage * hoursWorked;
    }

    @Override
    public String getEmployeeType() {
        return "Part-time";
    }
}

