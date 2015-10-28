package com.evoke.tms.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.evoke.tms.model.Role;

@Repository("RoleDAOImpl")
public class RoleDAOImpl implements IRoleDAO {
	
	/*@Autowired
	private SessionFactory sessionFactory;*/
	
	@PersistenceContext
	   EntityManager entityManager;
	
	private Session openSession() {
		//return sessionFactory.getCurrentSession();
		return entityManager.unwrap(Session.class);
	}
	
	private Session getCurrentSession() {
		//return sessionFactory.getCurrentSession();
		return entityManager.unwrap(Session.class);
	}

	public Role getRole(int id) {
		Role role = (Role) getCurrentSession().load(Role.class, id);
		return role;
	}

}
