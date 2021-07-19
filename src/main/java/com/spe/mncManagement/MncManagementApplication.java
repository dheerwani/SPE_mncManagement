package com.spe.mncManagement;

import com.spe.mncManagement.bean.Credentials;
import com.spe.mncManagement.bean.Employee;
import com.spe.mncManagement.dao.EmployeeDao;
import com.spe.mncManagement.dao.LoginDao;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication (exclude = HibernateJpaAutoConfiguration.class)
public class MncManagementApplication {

	@Autowired
	LoginDao loginDao;

	@Autowired
	EmployeeDao employeeDao;
	public static void main(String[] args) {
		SpringApplication.run(MncManagementApplication.class, args);
	}

	@Bean
	InitializingBean Credentials(){
		return () -> {
			loginDao.save(new Credentials(1L,"admin","admin","admin"));
			loginDao.save(new Credentials(2L,"dheerwani","12345","developer"));
			loginDao.save(new Credentials(3L,"nupurbanerjee","12345","manager"));

			employeeDao.save(new Employee(1L,100L,"dheer","wani","backend"));
			employeeDao.save(new Employee(2L,101L,"Nupur","Banerjee","frontend"));
		};
	}

}
