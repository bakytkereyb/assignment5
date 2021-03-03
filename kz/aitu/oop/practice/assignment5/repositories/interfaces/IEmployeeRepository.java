package kz.aitu.oop.practice.assignment5.repositories.interfaces;

import kz.aitu.oop.practice.assignment5.entities.Employee;

import java.util.List;

public interface IEmployeeRepository {
    // method to add employee into database
    boolean createEmployee(Employee employee);

    // method to get list of all employees from database
    List<Employee> getAllEmployee();

    // method to get employee by id from database
    Employee getEmployeeById(int id);
}
