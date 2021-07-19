package com.spe.mncManagement.bean;

import javax.persistence.*;

@Entity
@Table(name="emp_project")
public class EmpProject {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "empId")
    private Long empId;

    @Column(name = "projectId")
    private String projectId;


    public EmpProject() {
    }

    public EmpProject(Long id, Long empId, String projectId) {
        this.id = id;
        this.empId = empId;
        this.projectId = projectId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
