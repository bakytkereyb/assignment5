package kz.aitu.oop.practice.assignment5.repositories;

import kz.aitu.oop.practice.assignment5.data.interfaces.IDB;
import kz.aitu.oop.practice.assignment5.entities.Employee;
import kz.aitu.oop.practice.assignment5.entities.Project;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.IProjectRepository;

import java.util.*;
import java.sql.*;

public class ProjectRepository implements IProjectRepository {
    private final IDB db;

    public ProjectRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createProject(Project project) {
        Connection con = null;
        try {
            con = db.getConnection();
            String InsertStatement_project = "INSERT INTO projects(id, name, totalCost) VALUES (?,?,?);";
            PreparedStatement st = con.prepareStatement(InsertStatement_project);

            st.setInt(1, project.getId());
            st.setString(2, project.getName());
            st.setInt(3, project.getTotalCost());

            st.execute();

            String InsertStatement_empIntoProject = "UPDATE employees SET project_id = ? WHERE emp_id = ?;";
            PreparedStatement st_2 = con.prepareStatement(InsertStatement_empIntoProject);


            for(Employee emp : project.getEmployees()) {
                st_2.setInt(1, project.getId());
                st_2.setInt(2, emp.getEmpId());

                st_2.execute();
            }

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
    public List<Project> getAllProjects() {
        Connection con = null;
        try {
            con = db.getConnection();
            String SelectStatement = "SELECT * FROM projects ";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SelectStatement);
            List<Project> projects = new LinkedList<>();
            while (rs.next()) {
                Project project = new Project(rs.getInt("project_id"),
                        rs.getString("name"),
                        rs.getInt("totalCost"));

                projects.add(project);
            }
            return projects;
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
