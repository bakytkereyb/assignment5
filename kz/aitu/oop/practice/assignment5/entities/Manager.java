package kz.aitu.oop.practice.assignment5.entities;

public class Manager extends Employee{

    public Manager(int EmpId, String Name, String Address, String Department, int Salary){
        super(EmpId, Name, Address, Department, Salary);
        super.setType("Manager");
    }

    @Override
    public String getWorkStatus() {
        return super.getName() + " works in IT company as " + getType();
    }

    @Override
    public String getResponsibility() {
        return "This employee checks and manages the whole process of project.";
    }

    @Override
    public String getInfo(){
        String out = super.getInfo();
        out += getWorkStatus() + " in " + getDepartment() + " department" + "\n";
        out += getSalary() + "\n";
        out += getResponsibility() + "\n";
        return out;
    }
}
