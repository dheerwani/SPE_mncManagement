package com.spe.mncManagement.services;

import com.spe.mncManagement.bean.Project;
import com.spe.mncManagement.bean.Request;

import java.util.*;

public interface ProjectService {

    public Project add(Project project);
    public List<Project> getProjectList();
    public Optional<Project> getProject(Long id);
    public Project updateProject(Project project);
    public void deleteProject(Long id);
    public void updateEmpProject(Request request);
    public List<Request> getEmpReq(Long empId);
    public List<Project> getAvailableProjects(Long empId);
    public List<Project> getActiveProjects(Long empId);
    public List<Project> getCompletedProjects(Long empId);
}
