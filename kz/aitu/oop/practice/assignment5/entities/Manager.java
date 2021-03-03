package kz.aitu.oop.practice.assignment5.entities;

// this classes is inherited by class Employee
public class Manager extends Employee{

    // Constructor for creating a new manager
    public Manager(int EmpId, String Name, String Address, String Department, int Salary){
        super(EmpId, Name, Address, Department, Salary);
        super.setType("Manager");
    }
    // Constructor for creating a new manager without adding id number
    public Manager(String Name, String Address, String Department, int Salary){
        super(Name, Address, Department, Salary);
        super.setType("Manager");
    }

    // overriding abstract method
    @Override
    public String getWorkStatus() {
        return getType();
    }

    // overriding method of getting information
    @Override
    public String getInfo(){
        String out = super.getInfo();
        out += getWorkStatus() + " | ";
        out += getSalary() + " | ";
        return out;
    }
}
