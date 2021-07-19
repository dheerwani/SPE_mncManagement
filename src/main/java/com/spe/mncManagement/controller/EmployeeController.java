package com.spe.mncManagement.controller;

import com.spe.mncManagement.bean.Employee;
import com.spe.mncManagement.bean.Project;
import com.spe.mncManagement.bean.Request;
import com.spe.mncManagement.services.EmployeeService;
import com.spe.mncManagement.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:3001")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;


    //get employee by ID
    @GetMapping("/view/{empId}")
    public Optional<Employee> getEmployee(@PathVariable String empId){
        System.out.println("-------------- get emp by id -----------\n");

        return employeeService.getEmployee(Long.parseLong(empId));
    }

    // get all the employees : in main controller as of now.

    // add new employee : signup. Implemented in main controller

    // update employee details
    @PutMapping("/updateDetails")
    public Employee updateEmpDetails(@RequestBody Employee employee){
        return employeeService.updateEmpDetails(employee);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable String empId){
        System.out.println("deleting employee");
        employeeService.deleteEmployee(Long.parseLong(empId));
        return new ResponseEntity<>(true,HttpStatus.OK);
    }


}
