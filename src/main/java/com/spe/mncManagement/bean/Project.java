package com.spe.mncManagement.bean;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="projects")
@Data
public class Project {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long Id;

    @Column(name = "projectId")
    private String projectId;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "technology")
    private String technology;

    @Column(name = "manager_id")
    private Long manager_id;

    public Project(){}

    public Project(Long id, String name, String status, String technology, Long manager_id, String projectId) {
        Id = id;
        this.name = name;
        this.status = status;
        this.technology = technology;
        this.manager_id = manager_id;
        this.projectId = projectId;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public Long getManager_id() {
        return manager_id;
    }

    public void setManager_id(Long manager_id) {
        this.manager_id = manager_id;
    }
}
