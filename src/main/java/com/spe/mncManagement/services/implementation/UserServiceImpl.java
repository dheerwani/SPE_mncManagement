package com.spe.mncManagement.services.implementation;

import com.spe.mncManagement.bean.Credentials;
import com.spe.mncManagement.bean.Employee;
import com.spe.mncManagement.dao.EmployeeDao;
import com.spe.mncManagement.dao.LoginDao;
import com.spe.mncManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private LoginDao loginDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Credentials signup(Credentials credentials){
        System.out.println("in service");
        if(loginDao.findByUsernameEquals(credentials.getUsername()) == null)
        {
            System.out.println("\nusername does not exists");
            return loginDao.save(credentials);
        }
        else{
            System.out.println("\nusername exists");

        }
        return null;
    }

    @Override
    public Credentials login(String username, String password){
        System.out.println("service "+username+"  "+password);
        return loginDao.findByUsernameEqualsAndPasswordEquals(username,password);

    }

    @Override
    public Employee update_employee_details(Employee employee){
        System.out.println("populating employee details at the time of signup\n");
        return employeeDao.save(employee);
    }

    @Override
    public List<Credentials> getUserList(){
        return  loginDao.findAll();
    }

    @Override
    public List<Employee> getDevList(){

        List<Credentials> allUsers = loginDao.findAll();
        List<Employee> dev = employeeDao.findAll();

        List<Long> temp = new ArrayList<>();
        for (int i = 0; i < allUsers.size(); i++) {

            if(allUsers.get(i).getUser_type().equalsIgnoreCase("dev") ){
                System.out.println("user type: "+allUsers.get(i).getUser_type());
                temp.add(allUsers.get(i).getEmpId());
            }

        }


        for(int i=0; i< dev.size() ; i++){
            if(temp.contains(dev.get(i).getEmpId())){
                System.out.println("contains: "+dev.get(i).getEmpId());
            }
            else dev.remove(i);
        }

        return dev;

    }

}
