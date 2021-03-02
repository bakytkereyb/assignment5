package kz.aitu.oop.practice.assignment5.entities;

public abstract class Employee {
    private int EmpId;
    private String Name;
    private String Address;
    private String Department;
    private String EmpType;
    private int Salary;

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

    public void setEmpId(int id){
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

    public abstract String getWorkStatus();
    public abstract String getResponsibility();

    public String getInfo(){
        String out = "";
        out += "Employee "+ getName()+ " with id "+getEmpId() + "\n";
        out += "Address: "+ getAddress() + "\n";
        out += "Department: " +getDepartment() + "\n";
        return out;
    }


}
