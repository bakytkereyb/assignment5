package kz.aitu.oop.practice.assignment5.entities;

import java.util.ArrayList;

public class Project {
    private int Id;
    private String Name;
    private int TotalCost;
    private ArrayList<Employee> Employees = new ArrayList<>();

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

    public void addEmployee(Employee employee) {
        Employees.add(employee);
        setTotalCost(employee.getSalary());
    }

    public void setTotalCost(int totalCost) {
        TotalCost += totalCost;
    }

    public int getTotalCost() {
        return TotalCost;
    }

    public String getInfo() {
        String out = "";
        out += getId() + " | ";
        out += getName() + " | ";
        out += getTotalCost() + " | ";
        return out;
    }
}
