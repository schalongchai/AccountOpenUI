package com.acc.open.model;

import java.util.Date;


/**
 * The persistent class for the AO_USERS_ROLES database table.
 * 
 */

public class AoUsersRole  {



	private String roleId;


	private Date createdDate;


	private Date modifiedDate;

	
	private String roleDesc;

	public AoUsersRole() {
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getRoleDesc() {
		return this.roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}




}