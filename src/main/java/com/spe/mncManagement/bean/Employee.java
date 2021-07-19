package com.spe.mncManagement.bean;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="employee_details")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long Id;

    @Column(name = "empId")
    private Long empId;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "area_of_expertise")
    private String area_of_expertise;

    public Employee(){}

    public Employee(Long id, Long empId, String first_name, String last_name, String area_of_expertise) {
        Id = id;
        this.empId = empId;
        this.first_name = first_name;
        this.last_name = last_name;
        this.area_of_expertise = area_of_expertise;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getArea_of_expertise() {
        return area_of_expertise;
    }

    public void setArea_of_expertise(String area_of_expertise) {
        this.area_of_expertise = area_of_expertise;
    }
}
