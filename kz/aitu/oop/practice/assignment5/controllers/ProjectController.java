package kz.aitu.oop.practice.assignment5.controllers;

import kz.aitu.oop.practice.assignment5.entities.Project;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.IProjectRepository;

import java.util.List;

public class ProjectController {
    private final IProjectRepository repo;

    public ProjectController(IProjectRepository repo) {
        this.repo = repo;
    }

    public String createProject(Project project) {
        boolean created = repo.createProject(project);

        return (created ? "Project is successfully created in database!" : "Project addition was failed!");
    }

    public List<Project> getAllProjects() {
        List<Project> projects = repo.getAllProjects();

        return projects;
    }
}
