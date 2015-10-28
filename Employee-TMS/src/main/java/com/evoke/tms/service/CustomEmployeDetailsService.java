package com.evoke.tms.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.evoke.tms.hbdao.IEmployeHBDao;
import com.evoke.tms.model.Employe;
import com.evoke.tms.model.Role;

@Service
public class CustomEmployeDetailsService implements UserDetailsService {
	
	public CustomEmployeDetailsService() {
		
	}
	
	@Autowired
	private IEmployeHBDao employeHBDao;	

	public UserDetails loadUserByUsername(String loginId)
			throws UsernameNotFoundException {
		
		Employe domainEmploye = employeHBDao.getEmploye(loginId);
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		return new User(
				domainEmploye.getLogin_Id(),
				domainEmploye.getPassword(), 
				enabled, 
				accountNonExpired, 
				credentialsNonExpired, 
				accountNonLocked,
				getAuthorities(domainEmploye.getRole())
		);
	}
	
	public Collection<GrantedAuthority> getAuthorities(Collection<Role> role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
		return authList;
	}
	
	public List<String> getRoles(Collection<Role> role) {
		List<String> roles = new ArrayList<String>();
		Iterator<Role> itr =role.iterator();
		while(itr.hasNext())
			roles.add(itr.next().getRole_Code());
		return roles;
	}
	
	public static List<GrantedAuthority> getGrantedAuthorities(Collection<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

}
