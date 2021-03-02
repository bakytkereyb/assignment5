package kz.aitu.oop.practice.assignment5.entities;

public class BackendDeveloper extends Employee{

    public BackendDeveloper(int EmpId, String Name, String Address, String Department, int Salary){
        super(EmpId, Name, Address, Department, Salary);
        super.setType("Backend Developer");
    }

    @Override
    public String getWorkStatus() {
        return super.getName() + " works in IT company as " + getType();
    }

    @Override
    public String getResponsibility() {
        return "This employee writes Java.";
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
