package kz.aitu.oop.practice.assignment5.repositories.interfaces;

import kz.aitu.oop.practice.assignment5.entities.Project;

import java.util.List;

public interface IProjectRepository {
    // method to add project into database
    boolean createProject(Project project);

    // method to get list of all projects from database
    List<Project> getAllProjects();
}
