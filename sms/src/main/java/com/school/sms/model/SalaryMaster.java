package com.school.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sms_salary_master")
public class SalaryMaster {

	@Id
	@Column(name = "salary_id")
	private String salaryId;

	@Column(name = "salary_name")
	private String salaryName;

	@ManyToOne
	@JoinColumn(name = "grade_id")
	private GradeMaster grade;

	@Column(name = "basic_salary")
	private Double basicSalary;

	@Column(name = "hra")
	private Double HRA;

	@Column(name = "conveyance")
	private Double conveyance;

	@Column(name = "medical")
	private Double medical;

	@Column(name = "extra1")
	private Double extra1;

	@Column(name = "extra2")
	private Double extra2;

	@Column(name = "extra3")
	private Double extra3;

	public String getSalaryId() {
		return salaryId;
	}

	public void setSalaryId(String salaryId) {
		this.salaryId = salaryId;
	}

	public String getSalaryName() {
		return salaryName;
	}

	public void setSalaryName(String salaryName) {
		this.salaryName = salaryName;
	}

	public GradeMaster getGrade() {
		return grade;
	}

	public void setGrade(GradeMaster grade) {
		this.grade = grade;
	}

	public Double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(Double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public Double getHRA() {
		return HRA;
	}

	public void setHRA(Double hRA) {
		HRA = hRA;
	}

	public Double getConveyance() {
		return conveyance;
	}

	public void setConveyance(Double conveyance) {
		this.conveyance = conveyance;
	}

	public Double getMedical() {
		return medical;
	}

	public void setMedical(Double medical) {
		this.medical = medical;
	}

	public Double getExtra1() {
		return extra1;
	}

	public void setExtra1(Double extra1) {
		this.extra1 = extra1;
	}

	public Double getExtra2() {
		return extra2;
	}

	public void setExtra2(Double extra2) {
		this.extra2 = extra2;
	}

	public Double getExtra3() {
		return extra3;
	}

	public void setExtra3(Double extra3) {
		this.extra3 = extra3;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SalaryMaster) {
			if (((SalaryMaster) obj).getSalaryId().equalsIgnoreCase(
					this.salaryId)
					&& ((SalaryMaster) obj).getSalaryName().equalsIgnoreCase(
							this.salaryName)) {
				return true;
			}
		}
		return super.equals(obj);
	}
}
