package com.spe.mncManagement.services.implementation;

import com.spe.mncManagement.bean.Credentials;
import com.spe.mncManagement.bean.Employee;
import com.spe.mncManagement.bean.Project;
import com.spe.mncManagement.dao.EmpProjectDao;
import com.spe.mncManagement.dao.EmployeeDao;
import com.spe.mncManagement.dao.LoginDao;
import com.spe.mncManagement.dao.RequestDao;
import com.spe.mncManagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private LoginDao loginDao;
    @Autowired
    private EmpProjectDao empProjectDao;
    @Autowired
    private RequestDao requestDao;


    public Employee add(Employee employee){
        System.out.println("--------------- Adding employee ----------------\n");
        return employeeDao.save(employee);
    }

    public Optional<Employee> getEmployee(Long id){
        System.out.println("--------------- employee impl : get emp ----------------\n");
        Optional<Employee> e = employeeDao.findByEmpId(id);
        System.out.println(e);
        return  e;
    }

    // update employee details
    @Transactional
    public Employee updateEmpDetails(Employee employee){
        System.out.println("--------------- Service impl : update employee details ----------------\n");
        Employee e = new Employee();
        Long id = employee.getEmpId();
        System.out.println("before employee deleted");
        employeeDao.deleteEmployeeByEmpId(id);

        System.out.println("employee deleted");
        e.setLast_name(employee.getLast_name());
        e.setFirst_name(employee.getFirst_name());
        e.setArea_of_expertise(employee.getArea_of_expertise());
        e.setEmpId(employee.getEmpId());
        return employeeDao.save(e);

    }

    @Transactional
    public boolean deleteEmployee(Long empId){

        System.out.println("removing from employee");
        employeeDao.deleteEmployeeByEmpId(empId);
        System.out.println("removing from credentials");
        loginDao.deleteCredentialsByEmpId(empId);
        System.out.println("removing from emp project");
        empProjectDao.deleteEmpProjectByEmpId(empId);
        System.out.println("removing from request");
        requestDao.deleteRequestByEmpId(empId);


        return true;
    }


}
