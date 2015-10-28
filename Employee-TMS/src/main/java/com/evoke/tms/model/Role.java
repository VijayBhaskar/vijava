package com.evoke.tms.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role implements IRole, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6503355381507577385L;

	@Id
	@GeneratedValue
	@Column(name="role_Id")
	private Integer role_Id;
	
	@Column(name="role_Code", nullable=false)
	private String role_Code;
	
	@Column(name="role_Name", nullable=false)
	private String role_Name;
	
	@Column(name="discription", nullable=false)
	private String discription;
	
	@Column(name="created_Date")
	private Date created_Date;
	
	@Column(name="modified_Date")
	private Date modified_Date;

	public Integer getRole_Id() {
		return role_Id;
	}

	public void setRole_Id(Integer role_Id) {
		this.role_Id = role_Id;
	}

	public String getRole_Code() {
		return role_Code;
	}

	public void setRole_Code(String role_Code) {
		this.role_Code = role_Code;
	}

	public String getRole_Name() {
		return role_Name;
	}

	public void setRole_Name(String role_Name) {
		this.role_Name = role_Name;
	}

	public Date getCreated_Date() {
		return created_Date;
	}

	public void setCreated_Date(Date created_Date) {
		this.created_Date = created_Date;
	}

	public Date getModified_Date() {
		return modified_Date;
	}

	public void setModified_Date(Date modified_Date) {
		this.modified_Date = modified_Date;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
}
