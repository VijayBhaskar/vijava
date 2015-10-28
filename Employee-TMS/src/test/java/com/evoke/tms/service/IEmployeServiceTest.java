package com.evoke.tms.service;

import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.evoke.tms.hbdao.IEmployeHBDao;
import com.evoke.tms.model.Employe;
import com.evoke.tms.model.Role;

@RunWith(MockitoJUnitRunner.class)
public class IEmployeServiceTest {
	
	@InjectMocks
	@Autowired
	public EmployeServiceImpl employeServiceImpl;
	
	@Mock
	public IEmployeHBDao iEmployeHBDao;
	
	@Mock
	public Employe employe;
	
	@Mock
	public Role role;
	
	@Before
	 public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void tesGetEmploye() throws Exception{
		
		String loginId = "sadmin1";
		Collection<Role> roles = new HashSet<Role>();
		
		role.setCreated_Date(Date.valueOf("2015-10-20"));
		role.setDiscription("Super Admin-1");
		role.setModified_Date(Date.valueOf("2015-10-20"));
		role.setRole_Code("ADMIN");
		role.setRole_Id(1);
		role.setRole_Name("Adminstrator");
		roles.add((Role) role);
		
		employe.setLogin_Id(loginId);
		employe.setPassword("sadmin1234");
		employe.setAddress("EVOKE TECHNOLOGIES,HYD");
		employe.setCreate_Date(Date.valueOf("2015-10-20")); 	
		employe.setEmail("vpedapudi@evoketechnologies.com");
		employe.setEmp_Id(1);
		employe.setFirst_name("super");
		employe.setLast_name("admin");
		employe.setLogin_Attempts("0");
		employe.setMobile_Number(868657522);
		employe.setModified_Date(Date.valueOf("2015-10-20"));
		employe.setRole(roles);
		employe.setSecurity_Question("password hint");
		employe.setSecurity_Question_Answer("name1234");
		
		Assert.assertNotNull(employeServiceImpl);
		Mockito.when(employeServiceImpl.getEmploye(loginId)).thenReturn((Employe) employe);
		
	}
}
