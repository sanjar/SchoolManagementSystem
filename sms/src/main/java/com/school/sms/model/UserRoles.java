package com.school.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sms_user_roles")
public class UserRoles {

	@Id
	@GeneratedValue
	@Column(name="user_role_id")
	private Integer userRoleId;
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name="role")
	private String role;

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
