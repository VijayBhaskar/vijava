package com.evoke.tms.model;

import java.sql.Date;
import java.util.Collection;

public interface IEmploye {
	public Integer getEmp_Id();
	public void setEmp_Id(Integer emp_Id);
	 
	public String getLogin_Id(); 
	public void setLogin_Id(String login_Id);

	public Integer getMobile_Number();
	public void setMobile_Number(Integer mobile_Number);

	public Date getCreate_Date();
	public void setCreate_Date(Date create_Date);

	public Date getModified_Date();
	public void setModified_Date(Date modified_Date);

	public String getSecurity_Question();
	public void setSecurity_Question(String security_Question);

	public String getSecurity_Question_Answer();
	public void setSecurity_Question_Answer(String security_Question_Answer);

	public String getLogin_Attempts();
	public void setLogin_Attempts(String login_Attempts);

	public String getPassword();
	public void setPassword(String password);

	public String getFirst_name();
	public void setFirst_name(String first_name);

	public String getLast_name();
	public void setLast_name(String last_name);

	public String getEmail();
	public void setEmail(String email);

	public String getAddress();
	public void setAddress(String address);

	public Collection<Role> getRole();
	public void setRole(Collection<Role> role);
}
