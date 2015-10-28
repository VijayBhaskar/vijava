package com.evoke.tms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evoke.tms.hbdao.IEmployeHBDao;
import com.evoke.tms.model.Employe;

@Service
public class EmployeServiceImpl implements IEmployeService {
	
	@Autowired
	private IEmployeHBDao iEmployeHBDao;

	public Employe getEmploye(String loginId) {
		return iEmployeHBDao.getEmploye(loginId);
	}

}
