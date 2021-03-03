package kz.aitu.oop.practice.assignment5.entities;

import java.util.ArrayList;

public class Project {
    // id number of project
    private int Id;
    // name of project
    private String Name;
    // total cost of project
    private int TotalCost;
    // list of employee that project contains
    private ArrayList<Employee> Employees = new ArrayList<>();

    // Constructor for creating a new project
    public Project(int Id, String Name, int TotalCost) {
        setId(Id);
        setName(Name);
        setTotalCost(TotalCost);
    }

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public ArrayList<Employee> getEmployees() {
        return Employees;
    }
    public void setEmployees(ArrayList<Employee> employees) {
        Employees = employees;
    }

    // add employee into project
    public void addEmployee(Employee employee) {
        Employees.add(employee);
        setTotalCost(employee.getSalary());
    }

    // changing totalCost when new employee is added. TotalCost depends on employee's salary
    public void setTotalCost(int totalCost) {
        TotalCost += totalCost;
    }

    public int getTotalCost() {
        return TotalCost;
    }

    // method to get information about project
    public String getInfo() {
        String out = "";
        out += getId() + " | ";
        out += getName() + " | ";
        out += getTotalCost() + " | ";
        return out;
    }
}
