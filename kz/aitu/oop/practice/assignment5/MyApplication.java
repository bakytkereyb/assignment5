package kz.aitu.oop.practice.assignment5;

import kz.aitu.oop.practice.assignment5.controllers.EmployeeController;
import kz.aitu.oop.practice.assignment5.controllers.ProjectController;
import kz.aitu.oop.practice.assignment5.entities.BackendDeveloper;
import kz.aitu.oop.practice.assignment5.entities.Employee;
import kz.aitu.oop.practice.assignment5.entities.FrontendDeveloper;
import kz.aitu.oop.practice.assignment5.entities.Manager;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MyApplication {
    private final EmployeeController emp_controller;
    private final ProjectController project_controller;
    private final Scanner scanner;

    public MyApplication(EmployeeController emp_controller, ProjectController project_controller) {
        this.emp_controller = emp_controller;
        this.project_controller = project_controller;
        scanner = new Scanner(System.in);
    }

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
            emp.getInfo();
        }
    }

    public void addEmployee() {
        System.out.println("Write employee details in this format: 'id name address department salary");
        int id = scanner.nextInt();
        String name = scanner.next();
        String address = scanner.next();
        String department = scanner.next();
        int salary = scanner.nextInt();
        Employee emp;
        System.out.println("Write type-number of employee: 1) Frontend Developer; 2) Backend Developer; 3) Manager;");
        if (scanner.nextInt() == 1) {
            emp = new FrontendDeveloper(id, name, address, department, salary);
        } else if (scanner.nextInt() == 2) {
            emp = new BackendDeveloper(id, name, address, department, salary);
        } else if (scanner.nextInt() == 3) {
            emp = new Manager(id, name, address, department, salary);
        } else {
            System.out.println("Invalid Input!");
            return;
        }
        String response = emp_controller.createEmployee(emp);
        System.out.println(response);
    }
}
