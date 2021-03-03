package kz.aitu.oop.practice.assignment5;

import kz.aitu.oop.practice.assignment5.controllers.EmployeeController;
import kz.aitu.oop.practice.assignment5.controllers.ProjectController;
import kz.aitu.oop.practice.assignment5.data.DB;
import kz.aitu.oop.practice.assignment5.data.interfaces.IDB;
import kz.aitu.oop.practice.assignment5.repositories.EmployeeRepository;
import kz.aitu.oop.practice.assignment5.repositories.ProjectRepository;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.IEmployeeRepository;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.IProjectRepository;

public class Main {
    public static void main(String[] args) {
        IDB db = new DB();
        IEmployeeRepository emp_repo = new EmployeeRepository(db);
        EmployeeController emp_controller = new EmployeeController(emp_repo);

        IProjectRepository project_repo = new ProjectRepository(db);
        ProjectController project_controller = new ProjectController(project_repo);

        MyApplication app = new MyApplication(emp_controller, project_controller);
        app.start();
    }
}
