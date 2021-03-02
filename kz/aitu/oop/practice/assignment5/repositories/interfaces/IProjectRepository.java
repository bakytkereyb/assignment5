package kz.aitu.oop.practice.assignment5.repositories.interfaces;

import kz.aitu.oop.practice.assignment5.entities.Project;

import java.util.List;

public interface IProjectRepository {
    boolean createProject(Project project);
    List<Project> getAllProjects();
}
