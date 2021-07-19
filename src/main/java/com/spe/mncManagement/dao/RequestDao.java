package com.spe.mncManagement.dao;

import com.spe.mncManagement.bean.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface RequestDao extends JpaRepository<Request,Long> {

    List<Request> findByStatusEquals(String status);
    List<Request> findByEmpId(Long id);

    List<Request> findAllByEmpId(Long empId);

    void deleteRequestByEmpId(Long empId);


    void deleteRequestByProjectId(String projectId);
}
