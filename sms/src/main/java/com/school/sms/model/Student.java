package com.school.sms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sms_student")
public class Student {

	@Id
	@GeneratedValue
	@Column(name="student_id")
	private String studentId;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="middle_name")
	private String middleName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="date_of_birth")
	private String dateOfBirth;
	
	@Column(name="phone_no")
	private String phoneNo;
	
	@Column(name="mobile_no")
	private String mobileNo;
	
	@Column(name="father_name")
	private String fathername;
	
	@Column(name="parent_mobile_no")
	private String parentMobileNo;
	
	@Column(name="date_of_admission")
	private String dateOfAdmission;
	
	@Column(name="status")
	private Boolean status;
	
	@Column(name="last_login_date")
	private String lastLoginDate;
	
	@Column(name="enrolement_no")
	private String enrolementNo;
	
	@Column(name="mother_name")
	private String motherName;
	
	@Column(name="address")
	private String address;
	
	@Column(name="current_class_batch")
	private String currentClassBatch;
	
	@Column(name="current_class_section")
	private String currentClassSection;
	
	@Column(name="roll")
	private Integer roll;
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	
	public String getDateOfAdmission() {
		return dateOfAdmission;
	}
	public void setDateOfAdmission(String dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public String getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public String getEnrolementNo() {
		return enrolementNo;
	}
	public void setEnrolementNo(String enrolementNo) {
		this.enrolementNo = enrolementNo;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getCurrentClassBatch() {
		return currentClassBatch;
	}
	public void setCurrentClassBatch(String currentClassBatch) {
		this.currentClassBatch = currentClassBatch;
	}
	public String getCurrentClassSection() {
		return currentClassSection;
	}
	public void setCurrentClassSection(String currentClassSection) {
		this.currentClassSection = currentClassSection;
	}
	public Integer getRoll() {
		return roll;
	}
	public void setRoll(Integer roll) {
		this.roll = roll;
	}
	public String getParentMobileNo() {
		return parentMobileNo;
	}
	public void setParentMobileNo(String parentMobileNo) {
		this.parentMobileNo = parentMobileNo;
	}
	
	
	
	
	
}






