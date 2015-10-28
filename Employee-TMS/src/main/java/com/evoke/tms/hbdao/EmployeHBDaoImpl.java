package com.evoke.tms.hbdao;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.evoke.tms.model.Employe;

@Repository("EmployeHBDaoImpl")
public class EmployeHBDaoImpl implements IEmployeHBDao {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeHBDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Employe getEmploye(String loginId) {
		Employe emp = null;
		try{
			emp = (Employe) sessionFactory.openSession().load(Employe.class, loginId);
		}catch(Exception exp){
			logger.error("Employe with login-Id {} Not Found"+loginId);
		}
		return emp;
	}

}
