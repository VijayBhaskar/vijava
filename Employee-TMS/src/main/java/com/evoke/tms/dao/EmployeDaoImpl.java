package com.evoke.tms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.evoke.tms.model.Employe;


@Repository("EmployeDaoImpl")
public class EmployeDaoImpl implements IEmployeDao {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeDaoImpl.class);
	 @PersistenceContext
	   EntityManager entityManager;

	private Session openSession() {
		return entityManager.unwrap(Session.class);
	}
	
	@Transactional
	public Employe getEmploye(String loginId) {
		logger.info("In getEmploye--------"+loginId);
		List<Employe> employeList = new ArrayList<Employe>();
		//Criteria cr = openSession().createCriteria(Employe.class);
		//cr.add(Restrictions.eq("empId",Integer.parseInt(login.toString())));
		Employe emp = (Employe) openSession().load(Employe.class, loginId);
		
		//List<Employe> empList = cr.list();
		return emp;
		
		/*Query query = openSession().createQuery("from employe u where u.empId = :login");
		query.setParameter("login", login);
		employeList = query.list();
		logger.info("Employe Size--------"+employeList.size());
		if (employeList.size() > 0)
			return employeList.get(0);
		else
			return null;*/	
	}

}
