package com.school.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sms_employee_master")
public class EmployeeMaster {

	@Id
	@Column(name="employee_id")
	private Integer employeeId;
	
	@Column(name="employee_name")
	private String employeeName;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="esi_no")
	private String ESINo;
	
	@Column(name="eps_no")
	private String EPSNo;
	
	@Column(name="date_of_birth")
	private String dateOfBirth;
	
	@Column(name="salary_code")
	private String salaryCode;
	
	@Column(name="icard_no")
	private String iCardNo;
	
	@Column(name="pf_no")
	private String PFNo;
	
	@Column(name="pan_no")
	private String PANNo;
	
	@Column(name="bank_account_no")
	private String bankAccountNo;
	
	@Column(name="date_of_joining")
	private String dateOfJoining;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	
	
	@Column(name="designation")
	private String designation;
	
	@ManyToOne
	@JoinColumn(name = "grade_id")
	private GradeMaster grade;
	
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getEPSNo() {
		return EPSNo;
	}
	public void setEPSNo(String ePSNo) {
		EPSNo = ePSNo;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getSalaryCode() {
		return salaryCode;
	}
	public void setSalaryCode(String salaryCode) {
		this.salaryCode = salaryCode;
	}
	public String getiCardNo() {
		return iCardNo;
	}
	public void setiCardNo(String iCardNo) {
		this.iCardNo = iCardNo;
	}
	public String getPFNo() {
		return PFNo;
	}
	public void setPFNo(String pFNo) {
		PFNo = pFNo;
	}
	public String getPANNo() {
		return PANNo;
	}
	public void setPANNo(String pANNo) {
		PANNo = pANNo;
	}
	public String getBankAccountNo() {
		return bankAccountNo;
	}
	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
		
	public String getESINo() {
		return ESINo;
	}
	public void setESINo(String eSINo) {
		ESINo = eSINo;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public GradeMaster getGrade() {
		return grade;
	}
	public void setGrade(GradeMaster grade) {
		this.grade = grade;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
