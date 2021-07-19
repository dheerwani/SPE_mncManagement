package com.spe.mncManagement.dao;

import com.spe.mncManagement.bean.Credentials;
import com.spe.mncManagement.bean.EmpProject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpProjectDao extends JpaRepository<EmpProject, Long> {

    List<EmpProject> findAllByEmpId(Long empId);


    void deleteEmpProjectByEmpId(Long empId);


    void deleteEmpProjectByProjectId(String projectId);
}
