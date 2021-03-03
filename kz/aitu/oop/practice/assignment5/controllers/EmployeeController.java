package kz.aitu.oop.practice.assignment5.controllers;

import kz.aitu.oop.practice.assignment5.entities.Employee;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.IEmployeeRepository;

import java.util.List;

public class EmployeeController {
    private final IEmployeeRepository repo;

    public EmployeeController(IEmployeeRepository repo) {
        this.repo = repo;
    }

    public String createEmployee(Employee employee) {
        boolean created = repo.createEmployee(employee);

        return (created ? "Employee is successfully created in database!" : "Employee addition was failed!");
    }

    public List<Employee> getAllEmployee() {
        List<Employee> employees = repo.getAllEmployee();

        return employees;
    }

    public Employee getEmployeeById(int id) {
        Employee employee = repo.getEmployeeById(id);

        return employee;
    }

}
