package kz.aitu.oop.practice.assignment5.repositories;

import kz.aitu.oop.practice.assignment5.data.interfaces.IDB;
import kz.aitu.oop.practice.assignment5.entities.*;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.IEmployeeRepository;

import java.util.*;
import java.sql.*;

public class EmployeeRepository implements IEmployeeRepository {
    // constant variable to connect with database
    private final IDB db;

    // Constructor for creating a new EmployeeRepository
    public EmployeeRepository(IDB db) {
        this.db = db;
    }

    // Overriding method to add employee into database
    @Override
    public boolean createEmployee(Employee employee) {
        Connection con = null;
        try {
            // connecting with database
            con = db.getConnection();

            // Creating SQL statement
            String InsertStatement_project = "INSERT INTO employees(emp_id, name, address, department, empType, salary) VALUES (?,?,?,?,?,?);";
            PreparedStatement st = con.prepareStatement(InsertStatement_project);

            // Setting parameters into prepared SQL statement
            st.setInt(1, employee.getEmpId());
            st.setString(2, employee.getName());
            st.setString(3, employee.getAddress());
            st.setString(4, employee.getDepartment());
            st.setString(5, employee.getType());
            st.setInt(6, employee.getSalary());

            // executing SQL statement in database
            st.execute();

            // if everything is successfully done, return true
            return true;
        } catch (SQLException throwables) {
            // if there are some exceptions
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // this will be done whether exception occur or not
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        // otherwise return false, if nothing happens
        return false;
    }

    // Overriding method to get all employees from database
    @Override
    public List<Employee> getAllEmployee() {
        Connection con = null;
        try {
            // connecting with database
            con = db.getConnection();

            // Creating SQL statement
            String SelectStatement = "SELECT * FROM employees ";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SelectStatement);
            List<Employee> employees = new LinkedList<>();

            // while there is a result, do this
            while (rs.next()) {
                // if type or work status of employee is "Frontend Developer"
                if (rs.getString("empType").equals("Frontend Developer")) {
                    Employee employee = new FrontendDeveloper(
                            rs.getInt("emp_id"),
                            rs.getString("name"),
                            rs.getString("address"),
                            rs.getString("department"),
                            rs.getInt("salary"));

                    employees.add(employee);
                }

                // if type or work status of employee is "Backend Developer"
                if (rs.getString("empType").equals("Backend Developer")) {
                    Employee employee = new BackendDeveloper(
                            rs.getInt("emp_id"),
                            rs.getString("name"),
                            rs.getString("address"),
                            rs.getString("department"),
                            rs.getInt("salary"));

                    employees.add(employee);
                }

                // if type or work status of employee is "Manager"
                if (rs.getString("empType").equals("Manager")) {
                    Employee employee = new Manager(
                            rs.getInt("emp_id"),
                            rs.getString("name"),
                            rs.getString("address"),
                            rs.getString("department"),
                            rs.getInt("salary"));

                    employees.add(employee);
                }
            }
            // return result array of list of employee in database
            return employees;
        } catch (SQLException throwables) {
            // if there are some exceptions
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // this will be done whether exception occur or not
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        // otherwise return null, if nothing happens
        return null;
    }

    // Overriding method to get employee by id number from database
    @Override
    public Employee getEmployeeById(int id) {
        Connection con = null;
        try {
            // connecting with database
            con = db.getConnection();

            // Creating SQL statement
            String SelectStatement = "SELECT * FROM employees WHERE emp_id=?";
            PreparedStatement st = con.prepareStatement(SelectStatement);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            // if there is a result, do this
            if (rs.next()) {
                // if type or work status of employee is "Frontend Developer"
                if (rs.getString("empType").equals("Frontend Developer")) {
                    Employee employee = new FrontendDeveloper(
                            rs.getInt("emp_id"),
                            rs.getString("name"),
                            rs.getString("address"),
                            rs.getString("department"),
                            rs.getInt("salary"));

                    // return result employee from database
                    return employee;
                }

                // if type or work status of employee is "Backend Developer"
                if (rs.getString("empType").equals("Backend Developer")) {
                    Employee employee = new BackendDeveloper(
                            rs.getInt("emp_id"),
                            rs.getString("name"),
                            rs.getString("address"),
                            rs.getString("department"),
                            rs.getInt("salary"));

                    // return result employee from database
                    return employee;
                }

                // if type or work status of employee is "Manager"
                if (rs.getString("empType").equals("Manager")) {
                    Employee employee = new Manager(
                            rs.getInt("emp_id"),
                            rs.getString("name"),
                            rs.getString("address"),
                            rs.getString("department"),
                            rs.getInt("salary"));

                    // return result employee from database
                    return employee;
                }
            }
        } catch (SQLException throwables) {
            // if there are some exceptions
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // this will be done whether exception occur or not
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        // otherwise return null, if nothing happens
        return null;
    }

}
