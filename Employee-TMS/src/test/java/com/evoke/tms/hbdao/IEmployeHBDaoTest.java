package com.evoke.tms.hbdao;

import org.hibernate.SessionFactory;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.evoke.tms.dao.IEmployeDao;

@RunWith(MockitoJUnitRunner.class)
public class IEmployeHBDaoTest {

@Mock
IEmployeDao iEmployeDao;

@Autowired
SessionFactory sessionFactory;
}
