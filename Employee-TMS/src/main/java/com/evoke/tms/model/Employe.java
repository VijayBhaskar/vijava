package com.evoke.tms.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employe")
public class Employe implements IEmploye, Serializable {
	
	
	private static final long serialVersionUID = 3539505455231361934L;

	@Column(name="emp_Id", nullable=false)
	private Integer emp_Id;
	
	@Id
	@GeneratedValue
	@Column(name="login_Id", nullable=false)
	private String login_Id;
	
	@Column(name="Password", nullable=false)
	private String Password;
	
	@Column(name="first_name", nullable=false)
	private String first_name;
	
	@Column(name="last_name", nullable=false)
	private String last_name;
	
	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="address", nullable=false)
	private String address;
	
	@Column(name="mobile_Number", nullable=false)
	private Integer mobile_Number;
	
	@Column(name="create_Date", nullable=false)
	private Date create_Date;
	
	@Column(name="modified_Date", nullable=false)
	private Date modified_Date;
	
	@Column(name="security_Question")
	private String security_Question;
	
	@Column(name="security_Question_Answer")
	private String security_Question_Answer;
	
	@Column(name="login_Attempts")
	private String login_Attempts;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="employe_role",
	joinColumns = {@JoinColumn(name="login_Id")},
	inverseJoinColumns = {@JoinColumn(name="role_Id")})
	private Collection<Role> role;//need to change name

	public Integer getEmp_Id() {
		return emp_Id;
	}

	public void setEmp_Id(Integer emp_Id) {
		this.emp_Id = emp_Id;
	}

	public String getLogin_Id() {
		return login_Id;
	}

	public void setLogin_Id(String login_Id) {
		this.login_Id = login_Id;
	}

	public Integer getMobile_Number() {
		return mobile_Number;
	}

	public void setMobile_Number(Integer mobile_Number) {
		this.mobile_Number = mobile_Number;
	}

	public Date getCreate_Date() {
		return create_Date;
	}

	public void setCreate_Date(Date create_Date) {
		this.create_Date = create_Date;
	}

	public Date getModified_Date() {
		return modified_Date;
	}

	public void setModified_Date(Date modified_Date) {
		this.modified_Date = modified_Date;
	}

	public String getSecurity_Question() {
		return security_Question;
	}

	public void setSecurity_Question(String security_Question) {
		this.security_Question = security_Question;
	}

	public String getSecurity_Question_Answer() {
		return security_Question_Answer;
	}

	public void setSecurity_Question_Answer(String security_Question_Answer) {
		this.security_Question_Answer = security_Question_Answer;
	}

	public String getLogin_Attempts() {
		return login_Attempts;
	}

	public void setLogin_Attempts(String login_Attempts) {
		this.login_Attempts = login_Attempts;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Collection<Role> getRole() {
		return role;
	}

	public void setRole(Collection<Role> role) {
		this.role = role;
	}

}
