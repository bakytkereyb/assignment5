package kz.aitu.oop.practice.assignment5.repositories.interfaces;

import kz.aitu.oop.practice.assignment5.entities.Employee;

import java.util.List;

public interface IEmployeeRepository {
    boolean createEmployee(Employee employee);
    List<Employee> getAllEmployee();
}
