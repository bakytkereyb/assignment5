package kz.aitu.oop.practice.assignment5.repositories;

import kz.aitu.oop.practice.assignment5.data.interfaces.IDB;
import kz.aitu.oop.practice.assignment5.entities.*;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.IEmployeeRepository;

import java.util.*;
import java.sql.*;

public class EmployeeRepository implements IEmployeeRepository {
    private final IDB db;

    public EmployeeRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createEmployee(Employee employee) {
        Connection con = null;
        try {
            con = db.getConnection();
            String InsertStatement_project = "INSERT INTO employees(emp_id, name, address, department, empType, salary) VALUES (?,?,?,?,?,?);";
            PreparedStatement st = con.prepareStatement(InsertStatement_project);

            st.setInt(1, employee.getEmpId());
            st.setString(2, employee.getName());
            st.setString(3, employee.getAddress());
            st.setString(4, employee.getDepartment());
            st.setString(5, employee.getType());
            st.setInt(6, employee.getSalary());

            st.execute();

            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Employee> getAllEmployee() {
        Connection con = null;
        try {
            con = db.getConnection();
            String SelectStatement = "SELECT * FROM employees ";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SelectStatement);
            List<Employee> employees = new LinkedList<>();

            while (rs.next()) {
                if (rs.getString("empType").equals("Frontend Developer")) {
                    Employee employee = new FrontendDeveloper(
                            rs.getInt("emp_id"),
                            rs.getString("name"),
                            rs.getString("address"),
                            rs.getString("department"),
                            rs.getInt("salary"));

                    employees.add(employee);
                }

                if (rs.getString("empType").equals("Backend Developer")) {
                    Employee employee = new BackendDeveloper(
                            rs.getInt("emp_id"),
                            rs.getString("name"),
                            rs.getString("address"),
                            rs.getString("department"),
                            rs.getInt("salary"));

                    employees.add(employee);
                }

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
            return employees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

}
