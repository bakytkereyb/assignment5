package kz.aitu.oop.practice.assignment5.controllers;

import kz.aitu.oop.practice.assignment5.entities.Project;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.IProjectRepository;

import java.util.List;

public class ProjectController {
    private final IProjectRepository repo;

    // Constructor for creating a new ProjectController
    public ProjectController(IProjectRepository repo) {
        this.repo = repo;
    }

    // method to control new project addition
    public String createProject(Project project) {
        boolean created = repo.createProject(project);

        return (created ? "Project is successfully created in database!" : "Project addition was failed!");
    }

    // method to get list of all projects in database
    public List<Project> getAllProjects() {
        List<Project> projects = repo.getAllProjects();

        return projects;
    }
}
