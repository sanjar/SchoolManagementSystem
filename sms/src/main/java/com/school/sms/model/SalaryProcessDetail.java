package com.school.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sms_salary_process_detail")
public class SalaryProcessDetail {

	@Id
	@GeneratedValue
	@Column(name="salary_process_id")
	private Integer salaryProcessId;
	
	@ManyToOne
	@JoinColumn(name="salary_id")
	private SalaryMaster salaryMaster;
	
	@Column(name="year")
	private String year;
	
	@Column(name="month")
	private String month;
	
	@Column(name="processing_date")
	private String processingDate;
	
	@Column(name="is_salary_processed")
	private Boolean isSalaryProcessed;
	
	@Column(name="comments")
	private String comments;

	public Integer getSalaryProcessId() {
		return salaryProcessId;
	}

	public void setSalaryProcessId(Integer salaryProcessId) {
		this.salaryProcessId = salaryProcessId;
	}

	public SalaryMaster getSalaryMaster() {
		return salaryMaster;
	}

	public void setSalaryMaster(SalaryMaster salaryMaster) {
		this.salaryMaster = salaryMaster;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getProcessingDate() {
		return processingDate;
	}

	public void setProcessingDate(String processingDate) {
		this.processingDate = processingDate;
	}

	public Boolean getIsSalaryProcessed() {
		return isSalaryProcessed;
	}

	public void setIsSalaryProcessed(Boolean isSalaryProcessed) {
		this.isSalaryProcessed = isSalaryProcessed;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
