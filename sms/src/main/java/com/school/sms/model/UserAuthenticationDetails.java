package com.school.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.school.sms.constants.Constants.UserType;

@Entity
@Table(name="sms_user_authentication_details")
public class UserAuthenticationDetails {

	@Id
	@Column(name="user_id")
	private String userId;
	
	@Column(name="password")
	private String password;
	
	@Column(name="user_type")
	private String userType;
	
	@Column(name="enabled")
	private String enabled;
	
	@Column(name="mobile_no")
	private String mobileNo;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="full_name")
	private String fullName;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
}
