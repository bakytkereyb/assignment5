package kz.aitu.oop.practice.assignment5.repositories;

import kz.aitu.oop.practice.assignment5.data.interfaces.IDB;
import kz.aitu.oop.practice.assignment5.entities.Employee;
import kz.aitu.oop.practice.assignment5.entities.Project;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.IProjectRepository;

import java.util.*;
import java.sql.*;

public class ProjectRepository implements IProjectRepository {
    // constant variable to connect with database
    private final IDB db;

    // Constructor for creating a new ProjectRepository
    public ProjectRepository(IDB db) {
        this.db = db;
    }

    // Overriding method to add project into database
    @Override
    public boolean createProject(Project project) {
        Connection con = null;
        try {
            // connecting with database
            con = db.getConnection();

            // Creating SQL statement
            String InsertStatement_project = "INSERT INTO projects(project_id, name, totalCost) VALUES (?,?,?);";
            PreparedStatement st = con.prepareStatement(InsertStatement_project);

            // Setting parameters into prepared SQL statement
            st.setInt(1, project.getId());
            st.setString(2, project.getName());
            st.setInt(3, project.getTotalCost());

            // executing SQL statement in database
            st.execute();

            // Creating SQL statement to set project for employees
            String InsertStatement_empIntoProject = "UPDATE employees SET project_id = ? WHERE emp_id = ?;";
            PreparedStatement st_2 = con.prepareStatement(InsertStatement_empIntoProject);


            for(Employee emp : project.getEmployees()) {
                // Setting parameters into second prepared SQL statement
                st_2.setInt(1, project.getId());
                st_2.setInt(2, emp.getEmpId());

                // executing SQL statement in database
                st_2.execute();
            }

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

    // Overriding method to get all projects from database
    @Override
    public List<Project> getAllProjects() {
        Connection con = null;
        try {
            // connecting with database
            con = db.getConnection();

            // Creating SQL statement
            String SelectStatement = "SELECT * FROM projects ";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SelectStatement);
            List<Project> projects = new LinkedList<>();

            // while there is a result, do this
            while (rs.next()) {
                // creating a project
                Project project = new Project(rs.getInt("project_id"),
                        rs.getString("name"),
                        rs.getInt("totalCost"));

                projects.add(project);
            }
            // return result array of list of employee in database
            return projects;
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
