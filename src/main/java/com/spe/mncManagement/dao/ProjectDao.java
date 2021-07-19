package com.spe.mncManagement.dao;

import com.spe.mncManagement.bean.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectDao extends JpaRepository<Project, Long> {


    List<Project> findAllByStatusEquals(String active);

//    List<Project> findAllByStatus();
}
