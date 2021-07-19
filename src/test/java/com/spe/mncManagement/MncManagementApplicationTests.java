package com.spe.mncManagement;

import com.spe.mncManagement.bean.Credentials;
import com.spe.mncManagement.bean.Employee;
import com.spe.mncManagement.bean.Project;
import com.spe.mncManagement.dao.EmployeeDao;
import com.spe.mncManagement.dao.LoginDao;
import com.spe.mncManagement.dao.ProjectDao;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MncManagementApplicationTests {
	@Autowired
	LoginDao loginDao;

	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	ProjectDao projectDao;

	@Test
	public void login() {
		Credentials c = loginDao.findByUsernameEqualsAndPasswordEquals("admin","admin");
		String a = c.getUsername();
		Assert.assertNotNull(c);
		Assert.assertEquals("admin",a);
		Assert.assertNotEquals("dheer",a);

		Credentials c1 = loginDao.findByUsernameEqualsAndPasswordEquals("dheerwani","12345");
		String a1 = c1.getUsername();
		Assert.assertNotNull(c1);
		Assert.assertEquals("dheerwani",a1);
		Assert.assertNotEquals("dheer",a1);

		Credentials c2 = loginDao.findByUsernameEqualsAndPasswordEquals("nupurbanerjee","12345");
		String a2 = c2.getUsername();
		Assert.assertNotNull(c2);
		Assert.assertEquals("nupurbanerjee",a2);
		Assert.assertNotEquals("nupur",a2);
	}

	@Test
	public void allemployee()
	{
		List<Employee> emp = employeeDao.findAll();
		int num=2;
		Assert.assertEquals(num,emp.size());
	}

//		@Test
//		public void add_project()
//		{
//			Project p = new Project(1L,"parking","active","frontend",100L,"e_20")
//			projectDao.save(p);
//		}

}
