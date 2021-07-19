package com.spe.mncManagement.dao;

import com.spe.mncManagement.bean.Credentials;
import com.spe.mncManagement.bean.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeDao extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmpId(Long id);
    void deleteEmployeeByEmpId(Long id);
}
