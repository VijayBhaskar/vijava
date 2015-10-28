package com.evoke.tms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evoke.tms.hbdao.IRoleHBDao;
import com.evoke.tms.model.Role;

@Service
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	private IRoleHBDao iRoleHBDao;

	public Role getRole(int id) {
		return iRoleHBDao.getRole(id);
	}

}
