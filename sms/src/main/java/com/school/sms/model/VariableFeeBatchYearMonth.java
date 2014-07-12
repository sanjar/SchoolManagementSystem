package com.school.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sms_variable_fee_batch_year_month")
public class VariableFeeBatchYearMonth {

	@Id
	@GeneratedValue
	@Column(name="variable_fee_id")
	private Integer variableFeeId;
	
	@Column(name="batch")
	private String batch;
	
	@Column(name="session")
	private String session;
	
	@Column(name="month")
	private String month;
	
	@Column(name="student_name_class_roll")
	private String studentNameClassRoll;
	
	@Column(name="admission_charges")
	private Integer addmissionCharges;
	
	@Column(name="transport_charges")
	private Integer transportCharges;
	
	@Column(name="hostel_charges")
	private Integer hostelCharges;
	
	@Column(name="registration_fee")
	private Integer registrationFee;
	
	@Column(name="maintainance_fee")
	private Integer maintainanceFee;
	
	@Column(name="music_fee")
	private Integer musicFee;
	
	@Column(name="misc_fee")
	private Integer miscFee;
	
	
	public Integer getVariableFeeId() {
		return variableFeeId;
	}
	public void setVariableFeeId(Integer variableFeeId) {
		this.variableFeeId = variableFeeId;
	}
	
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getStudentNameClassRoll() {
		return studentNameClassRoll;
	}
	public void setStudentNameClassRoll(String studentNameClassRoll) {
		this.studentNameClassRoll = studentNameClassRoll;
	}
	public Integer getAddmissionCharges() {
		return addmissionCharges;
	}
	public void setAddmissionCharges(Integer addmissionCharges) {
		this.addmissionCharges = addmissionCharges;
	}
	public Integer getTransportCharges() {
		return transportCharges;
	}
	public void setTransportCharges(Integer transportCharges) {
		this.transportCharges = transportCharges;
	}
	public Integer getHostelCharges() {
		return hostelCharges;
	}
	public void setHostelCharges(Integer hostelCharges) {
		this.hostelCharges = hostelCharges;
	}
	public Integer getRegistrationFee() {
		return registrationFee;
	}
	public void setRegistrationFee(Integer registrationFee) {
		this.registrationFee = registrationFee;
	}
	public Integer getMaintainanceFee() {
		return maintainanceFee;
	}
	public void setMaintainanceFee(Integer maintainanceFee) {
		this.maintainanceFee = maintainanceFee;
	}
	public Integer getMusicFee() {
		return musicFee;
	}
	public void setMusicFee(Integer musicFee) {
		this.musicFee = musicFee;
	}
	public Integer getMiscFee() {
		return miscFee;
	}
	public void setMiscFee(Integer miscFee) {
		this.miscFee = miscFee;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	
}
