package com.school.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sms_department")
public class Department {
	
	@Id
	@Column(name="department_id")
	private String departmentId;

	@Column(name="department_name")
	private String departmentName;

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Department){
			if(((Department)obj).getDepartmentId().equalsIgnoreCase(this.departmentId) && ((Department)obj).getDepartmentName().equalsIgnoreCase(this.departmentName)){
				return true;
			}
		}
		return super.equals(obj);
	}
}
