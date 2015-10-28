package com.evoke.tms.model;

import java.sql.Date;

public interface IRole {

	public Integer getRole_Id();
	public void setRole_Id(Integer role_Id);

	public String getRole_Code();
	public void setRole_Code(String role_Code);

	public String getRole_Name();
	public void setRole_Name(String role_Name);

	public Date getCreated_Date();
	public void setCreated_Date(Date created_Date);

	public Date getModified_Date();
	public void setModified_Date(Date modified_Date);

	public String getDiscription();
	public void setDiscription(String discription);
}
