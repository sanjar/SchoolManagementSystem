package com.school.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sms_grade_master")
public class GradeMaster {

	@Id
	@Column(name="grade_id")
	private String gradeId;
	
	@Column(name="grade_name")
	private String gradeName;


	public String getGradeId() {
		return gradeId;
	}


	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}


	public String getGradeName() {
		return gradeName;
	}


	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof GradeMaster){
			if(((GradeMaster)obj).getGradeId().equalsIgnoreCase(this.gradeId) && ((GradeMaster)obj).getGradeName().equalsIgnoreCase(this.gradeName)){
				return true;
			}
		}
		return super.equals(obj);
	}
}
