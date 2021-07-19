package com.spe.mncManagement.services;

import com.spe.mncManagement.bean.Employee;
import com.spe.mncManagement.bean.Project;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface EmployeeService {

    public Employee add(Employee employee);
    public Optional<Employee> getEmployee(Long id);
    public Employee updateEmpDetails(Employee employee);
    public boolean deleteEmployee(Long empId);
}
