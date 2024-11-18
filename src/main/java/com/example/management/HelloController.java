package com.example.management;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private TableView<Employee> employeeTable;

    @FXML
    private TableColumn<Employee, String> nameColumn;

    @FXML
    private TableColumn<Employee, String> typeColumn;

    @FXML
    private TableColumn<Employee, Number> salaryColumn;

    @FXML
    private TextField nameField;

    @FXML
    private ComboBox<String> typeComboBox;

    @FXML
    private TextField salaryField;

    @FXML
    private TextField hourlyRateField;

    @FXML
    private TextField hoursField;

    private ObservableList<Employee> employees;

    public HelloController() {
        employees = FXCollections.observableArrayList();
    }

    @FXML
    public void initialize() {
        // Set up ComboBox
        typeComboBox.getItems().addAll("Full-time", "Part-time", "Contractor");

        // Initialize Table Columns
        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
        typeColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEmployeeType()));
        salaryColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().calculateSalary()));

        employeeTable.setItems(employees);
    }

    @FXML
    private void addEmployee() {
        String name = nameField.getText();
        String type = typeComboBox.getValue();
        String annualSalary = salaryField.getText();
        String hourlyRate = hourlyRateField.getText();
        String hoursWorked = hoursField.getText();

        try {
            Employee employee = null;
            if ("Full-time".equals(type)) {
                double salary = Double.parseDouble(annualSalary);
                employee = new FullTimeEmployee(name, salary);
            } else if ("Part-time".equals(type)) {
                double rate = Double.parseDouble(hourlyRate);
                double hours = Double.parseDouble(hoursWorked);
                employee = new PartTimeEmployee(name, rate, hours);
            } else if ("Contractor".equals(type)) {
                double rate = Double.parseDouble(hourlyRate);
                double hours = Double.parseDouble(hoursWorked);
                employee = new Contractor(name, rate, hours);
            }

            if (employee != null) {
                employees.add(employee);
            }

            clearInputFields();

        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Please enter valid numbers for salary, rate, and hours.");
        }
    }

    @FXML
    private void removeSelectedEmployee() {
        Employee selectedEmployee = employeeTable.getSelectionModel().getSelectedItem();
        if (selectedEmployee != null) {
            employees.remove(selectedEmployee);
        }
    }

    private void clearInputFields() {
        nameField.clear();
        salaryField.clear();
        hourlyRateField.clear();
        hoursField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
