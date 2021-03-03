package kz.aitu.oop.practice.assignment5.entities;

public class FrontendDeveloper extends Employee{

    public FrontendDeveloper(int EmpId, String Name, String Address, String Department, int Salary){
        super(EmpId, Name, Address, Department, Salary);
        super.setType("Frontend Developer");
    }
    public FrontendDeveloper(String Name, String Address, String Department, int Salary){
        super(Name, Address, Department, Salary);
        super.setType("Frontend Developer");
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
