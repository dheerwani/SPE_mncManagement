package com.spe.mncManagement.bean;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="requests")
@Data
public class Request {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long Id;

    @Column(name = "projectId")
    private String projectId;

    @Column(name = "empId")
    private Long empId;

    @Column(name = "status")
    private String status;

    public Request(){};

    public Request(Long id, String projectId, Long empId, String status, String project_tech, String emp_tech) {
        Id = id;
        this.projectId = projectId;
        this.empId = empId;
        this.status = status;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
