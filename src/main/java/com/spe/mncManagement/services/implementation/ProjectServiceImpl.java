package com.spe.mncManagement.services.implementation;

import com.spe.mncManagement.bean.EmpProject;
import com.spe.mncManagement.bean.Project;
import com.spe.mncManagement.bean.Request;
import com.spe.mncManagement.dao.EmpProjectDao;
import com.spe.mncManagement.dao.EmployeeDao;
import com.spe.mncManagement.dao.ProjectDao;
import com.spe.mncManagement.dao.RequestDao;
import com.spe.mncManagement.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private EmpProjectDao empProjectDao;

    @Autowired
    private RequestDao requestDao;

    public Project add(Project project){
        System.out.println("--------------- Adding project ----------------\n");
        return projectDao.save(project);
    }

    public List<Project> getProjectList(){

        return projectDao.findAll();
//        return  projectDao.findByStatus();
    }

    public Optional<Project> getProject(Long id){
        System.out.println("--------------- Service impl : view project ----------------\n");
        return projectDao.findById(id);
    }

    // update a given project
    public Project updateProject(Project project){
        System.out.println("--------------- Service impl : update project ----------------\n");
        Project p = new Project();
        Long id = project.getId();
        projectDao.deleteById(id);
        p.setProjectId(project.getProjectId()); p.setManager_id(project.getManager_id()); p.setName(project.getName());
        p.setStatus(project.getStatus()); p.setTechnology(project.getTechnology());
        return projectDao.save(p);

    }

    @Transactional
    public void deleteProject(Long id){

        Optional<Project> p = projectDao.findById(id);
        projectDao.deleteById(id);

        System.out.println("project id is: "+p.get().getProjectId());
        empProjectDao.deleteEmpProjectByProjectId(p.get().getProjectId());
        requestDao.deleteRequestByProjectId(p.get().getProjectId());
    }

    public void updateEmpProject(Request request){
        System.out.println("\n\nin update emp project service\n\n");
        EmpProject ep = new EmpProject();
        ep.setEmpId(request.getEmpId());
        ep.setProjectId(request.getProjectId());
        empProjectDao.save(ep);
        System.out.println("emp project done: "+ ep.getProjectId() + " " +ep.getEmpId());
    }

    // list of requests made by an employee
    public List<Request> getEmpReq(Long id){
        return requestDao.findByEmpId(id);
    }

    // projects available for an employee
    // total - current - requested
    public List<Project> getAvailableProjects(Long empId){

        List<Project> total = projectDao.findAll();
        List<EmpProject> curr = empProjectDao.findAllByEmpId(empId);
        List<Request> requested = requestDao.findAllByEmpId(empId);

        List<String> not_available = new ArrayList<>();
        List<Project> available = new ArrayList<>();

        for(int i=0;i< curr.size();i++){
            not_available.add(curr.get(i).getProjectId());
        }

        for(int i=0;i< requested.size();i++){
            not_available.add(requested.get(i).getProjectId());
        }

        for (int i = 0; i < total.size(); i++) {
            if(not_available.contains(total.get(i).getProjectId())) continue;
            available.add(total.get(i));
            System.out.println("available : "+total.get(i).getProjectId());
        }
        return available;
    }

    // list of active projects for the given employee
    // list of current projects for employee
    public List<Project> getActiveProjects(Long empId){
        List<EmpProject> total = empProjectDao.findAllByEmpId(empId);
        List<Project> allProjects = projectDao.findAllByStatusEquals("active");

        // temp stores project ids for emp
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < total.size() ; i++) {
            temp.add(total.get(i).getProjectId());
        }
        System.out.println("\n size of all :"+allProjects.size());
        System.out.println("\n size of empPro :"+total.size());
        System.out.println("\n size of temp :"+temp.size());
        for (int i = 0; i < temp.size(); i++) {
            System.out.print(temp.get(i)+"  ");
        }
        for (int i = 0; i < allProjects.size() ; i++) {
            if(!temp.contains(allProjects.get(i).getProjectId()))
            {
                System.out.println("removed :"+allProjects.get(i));
                allProjects.remove(i);

            }
        }

        for (int i = 0; i < allProjects.size(); i++) {
            System.out.print(allProjects.get(i)+"  ");
        }
        return allProjects;
    }

    // list of all completed projects for the Emp
    public List<Project> getCompletedProjects(Long empId){
        List<EmpProject> total = empProjectDao.findAllByEmpId(empId);
        List<Project> allProjects = projectDao.findAllByStatusEquals("complete");

        // temp stores project ids for emp
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < total.size() ; i++) {
            temp.add(total.get(i).getProjectId());
        }

        for (int i = 0; i < allProjects.size() ; i++) {
            if(!temp.contains(allProjects.get(i).getProjectId()))
            {
                allProjects.remove(i);
            }
        }

        for (int i = 0; i < allProjects.size() ; i++) {
            System.out.println("complete : "+allProjects.get(i));
        }
        return allProjects;
    }

}
