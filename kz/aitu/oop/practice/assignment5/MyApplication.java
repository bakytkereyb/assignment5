package kz.aitu.oop.practice.assignment5;

import kz.aitu.oop.practice.assignment5.controllers.EmployeeController;
import kz.aitu.oop.practice.assignment5.controllers.ProjectController;
import kz.aitu.oop.practice.assignment5.entities.*;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MyApplication {
    // constant variables to control employees and projects
    private final EmployeeController emp_controller;
    private final ProjectController project_controller;

    // constant variable for input system
    private final Scanner scanner;

    // Constructor for creating a new MyApplication
    public MyApplication(EmployeeController emp_controller, ProjectController project_controller) {
        this.emp_controller = emp_controller;
        this.project_controller = project_controller;
        scanner = new Scanner(System.in);
    }

    // method to start application
    public void start() {
        System.out.println("Hello, dear user! I am a bot from the wonderful programmer to control the database of medicine.");
        while (true) {
            System.out.println("Below you can see functions to control DB:");
            System.out.printf("%5s %1s","1:", "Show all employees in the database");
            System.out.println();
            System.out.printf("%5s %1s","2:", "Add new employee into database");
            System.out.println();
            System.out.printf("%5s %1s","3:", "Show all projects in the database");
            System.out.println();
            System.out.printf("%5s %1s","4:", "Add new projects into database");
            System.out.println();
            System.out.printf("%5s %1s","0:", "Close application");
            System.out.println();
            try {
                System.out.print("In order to control, write the number of function:");
                int numberF = scanner.nextInt();
                if (numberF == 1) {
                    getAllEmployees();
                } else if (numberF == 2) {
                    addEmployee();
                } else if (numberF == 3) {
                    getAllProjects();
                } else if (numberF == 4) {
                    addProject();
                } else{
                    break;
                }
            } catch (InputMismatchException i) {
                System.out.println("Input must be integer");
                scanner.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");
        }
    }

    public void getAllEmployees() {
        List<Employee> response = emp_controller.getAllEmployee();
        for (Employee emp : response) {
            System.out.println(emp.getInfo());
        }
    }

    public void addEmployee() {
        System.out.println("Write employee details in this format: 'id name address department salary'");
        int id = scanner.nextInt();
        String name = scanner.next();
        String address = scanner.next();
        String department = scanner.next();
        int salary = scanner.nextInt();
        Employee emp;
        System.out.println("Write type-number of employee: 1) Frontend Developer; 2) Backend Developer; 3) Manager;");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: emp = new FrontendDeveloper(id, name, address, department, salary); break;
            case 2: emp = new BackendDeveloper(id, name, address, department, salary); break;
            case 3: emp = new Manager(id, name, address, department, salary); break;
            default: System.out.println("Invalid Input!"); return;
        }

        String response = emp_controller.createEmployee(emp);
        System.out.println(response);
    }

    public void getAllProjects() {
        List<Project> response = project_controller.getAllProjects();
        for (Project project : response) {
            System.out.println(project.getInfo());
        }
    }

    public void addProject() {
        System.out.println("Write project details in this format: 'id name'");
        int id = scanner.nextInt();
        String name = scanner.next();
        System.out.println("Choose employees to add them into project:");
        getAllEmployees();
        System.out.println("Write just id with spaces, for ex: '1 2 3'");
        scanner.nextLine();
        String ids[]= scanner.nextLine().split(" ");
        List<Integer> id_list = new LinkedList<Integer>(); // List for storing input integers
        for(int i = 0 ;i < ids.length;i++){
            id_list.add(Integer.parseInt(ids[i])); // extracting integers and adding into list
        }
        Project project = new Project(id, name, 0);
        for (int i = 0 ;i < id_list.size(); i++) {
            Employee emp = emp_controller.getEmployeeById(id_list.get(i));
            project.addEmployee(emp); // adding each employee into project
        }
        String response = project_controller.createProject(project);
        System.out.println(response);
    }

}
