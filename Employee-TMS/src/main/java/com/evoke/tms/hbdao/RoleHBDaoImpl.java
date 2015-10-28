package com.evoke.tms.hbdao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.evoke.tms.model.Role;

@Repository("RoleHBDaoImpl")
public class RoleHBDaoImpl implements IRoleHBDao {
	
	@Autowired	
	SessionFactory sessionFactory; 	
	
	@Override
	public Role getRole(int id) {
		Role role = (Role) sessionFactory.openSession().load(Role.class, id);
		return role;
	}

}
