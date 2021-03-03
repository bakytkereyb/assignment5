package kz.aitu.oop.practice.assignment5.entities;

// this classes is inherited by class Employee
public class FrontendDeveloper extends Employee{

    // Constructor for creating a new frontend developer
    public FrontendDeveloper(int EmpId, String Name, String Address, String Department, int Salary){
        super(EmpId, Name, Address, Department, Salary);
        super.setType("Frontend Developer");
    }
    // Constructor for creating a new frontend developer without adding id number
    public FrontendDeveloper(String Name, String Address, String Department, int Salary){
        super(Name, Address, Department, Salary);
        super.setType("Frontend Developer");
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
