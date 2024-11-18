package com.example.management;

public class Contractor extends Employee {
    private double hourlyRate;
    private double maxHours;

    public Contractor(String name, double hourlyRate, double maxHours) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.maxHours = maxHours;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * maxHours;
    }

    @Override
    public String getEmployeeType() {
        return "Contractor";
    }
}

