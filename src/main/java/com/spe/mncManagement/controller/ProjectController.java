package com.spe.mncManagement.controller;

import com.spe.mncManagement.bean.Project;
import com.spe.mncManagement.bean.Request;
import com.spe.mncManagement.services.ProjectService;
import com.spe.mncManagement.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/project")
@CrossOrigin(origins = "http://localhost:3001")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private RequestService requestService;

    // add a new project
    @PostMapping(path = "/add",
            produces = {"application/json"},
            consumes = {"application/json"})
    public Project add(@RequestBody Project project){
        System.out.println("------------ controller : add project ---------------\n");
        return projectService.add(project);

    }

    // list of all the projects
    @GetMapping("/list")
    public ResponseEntity<List<Project>> getProjectList(){
        return new ResponseEntity<>(projectService.getProjectList(), HttpStatus.OK);
    }

    // get project by ID
    @GetMapping("/view/{projectId}")
    public Optional<Project> getProject(@PathVariable String projectId){
        System.out.println("-------------- view a given project -----------\n");
        return projectService.getProject(Long.parseLong(projectId));
    }

    // update a project
    @PutMapping("/update")
    public Project updateProject(@RequestBody Project project){
        System.out.println("controller : update a given project -----------\n"+project.getId()+"---"+project.getName()+
                "---"+project.getProjectId()+"---"+
                project.getStatus()+"---"+project.getTechnology()+
                "---"+project.getManager_id());
        return projectService.updateProject(project);
    }

    // delete project
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteProject(@PathVariable String id){
        System.out.println("deleting project with id: "+ id);
        projectService.deleteProject(Long.parseLong(id));
        return new ResponseEntity<>(true,HttpStatus.OK);

        // remove it from the employee_project and requests table
    }

    // add a request
    @PostMapping(path = "/request/add",
            produces = {"application/json"},
            consumes = {"application/json"})
    public Request add(@RequestBody Request request){
        System.out.println("------------ controller : add project ---------------\n");
        return requestService.add(request);

    }

    // get all the requests
    @GetMapping("/request/list")
    public ResponseEntity<List<Request>> getRequestList(){
        return new ResponseEntity<>(requestService.getRequestList(), HttpStatus.OK);
    }

    // update request
    @PutMapping("/request/update")
    public Request updateRequest(@RequestBody Request request){
        System.out.println("controller : update a given request : "+ request.getStatus());
        // if approved : add it to emp_project table
        if(request.getStatus().equalsIgnoreCase("approved")){
            projectService.updateEmpProject(request);
        }
        // if rejected
        return requestService.updateRequest(request);
    }

    // list of requests based on Emp ID
    @GetMapping(path = "/request/getEmpReq/{empId}")
    public List<Request> getEmpReq(@PathVariable String empId){
        System.out.println("-------------- view emp requests -----------\n");
        System.out.println("emp id is: "+empId);
        return projectService.getEmpReq(Long.parseLong(empId));
    }

    // projects available for Emp ID
    @GetMapping(path = "/available/{empId}")
    public List<Project> getAvailableProjects(@PathVariable String empId){
        System.out.println("in controller : get available projects");
        return projectService.getAvailableProjects(Long.parseLong(empId));
    }

    // get the list of active projects for EmpID
    @GetMapping(path = "/active/{empId}")
    public List<Project> getActiveProjects(@PathVariable String empId){
        System.out.println("\n fetching the list of active projects\n");
        return projectService.getActiveProjects(Long.parseLong(empId));
    }

    // get the list of completed projects for EmpID
    @GetMapping(path = "/complete/{empId}")
    public List<Project> getCompletedProjects(@PathVariable String empId){
        System.out.println("\n fetching the list of active projects\n");
        return projectService.getCompletedProjects(Long.parseLong(empId));
    }

    // get list of all the projects for EmpID - for the pie chart, to show the distribution of technology worked on.
}
