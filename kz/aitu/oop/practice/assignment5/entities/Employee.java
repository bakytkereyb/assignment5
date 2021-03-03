package kz.aitu.oop.practice.assignment5.entities;

public abstract class Employee {
    // id number of employee
    private int EmpId;
    // name of employee
    private String Name;
    // address of employee
    private String Address;
    // department of employee
    private String Department;
    // type or work status of employee
    private String EmpType;
    // salary of employee
    private int Salary;

    // Constructor for creating a new employee without adding id number
    public Employee(String Name, String Address, String Department, int Salary){
        setName(Name);
        setAddress(Address);
        setDepartment(Department);
        setSalary(Salary);
    }
    // Constructor for creating a new employee
    public Employee(int EmpId, String Name, String Address, String Department, int Salary){
        setEmpId(EmpId);
        setName(Name);
        setAddress(Address);
        setDepartment(Department);
        setSalary(Salary);
    }

    public void setDepartment(String department){
        this.Department=department;
    }
    public String getDepartment(){
        return Department;
    }

    public void setEmpId(int EmpId){
        this.EmpId = EmpId;
    }
    public int getEmpId(){
        return EmpId;
    }

    public void setName(String name){
        this.Name = name;
    }
    public String getName(){
        return Name;
    }

    public void setAddress(String add){
        this.Address = add;
    }
    public String getAddress(){
        return Address;
    }

    public void setType(String type) {
        EmpType = type;
    }
    public String getType() {
        return EmpType;
    }

    public void setSalary(int money) {
        this.Salary = money;
    }
    public int getSalary() {
        return Salary;
    }

    // abstract method for employee, because each type of employee has own implementation for this method
    public abstract String getWorkStatus();

    // method to get information about employee
    public String getInfo(){
        String out = "";
        out += getEmpId() + " | " + getName()+ " | "+ getAddress() + " | " + getDepartment() + " | ";
        return out;
    }


}
