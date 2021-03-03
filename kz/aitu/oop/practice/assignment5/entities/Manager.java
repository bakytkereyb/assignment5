package kz.aitu.oop.practice.assignment5.entities;

public class Manager extends Employee{

    public Manager(int EmpId, String Name, String Address, String Department, int Salary){
        super(EmpId, Name, Address, Department, Salary);
        super.setType("Manager");
    }
    public Manager(String Name, String Address, String Department, int Salary){
        super(Name, Address, Department, Salary);
        super.setType("Manager");
    }

    @Override
    public String getWorkStatus() {
        return getType();
    }

    @Override
    public String getInfo(){
        String out = super.getInfo();
        out += getWorkStatus() + " | ";
        out += getSalary() + " | ";
        return out;
    }
}
