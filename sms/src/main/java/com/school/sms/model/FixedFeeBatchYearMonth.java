package com.school.sms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sms_fixed_fee_batch_year_month")
public class FixedFeeBatchYearMonth implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="fixed_fee_id")
	private Integer fixedFeeId;
	
	@Column(name="batch_id")
	private Integer batchId;
	
	@Column(name="session")
	private String session;
	
	@Column(name="month")
	private String month;
	
	@Column(name="examination_fee")
	private Integer examinationFee;
	
	@Column(name="maintainance_fee")
	private Integer maintainanceFee;
	
	@Column(name="tuition_fee")
	private Integer tuitionFee;
	
	@Column(name="report_card_fee")
	private Integer reportCardFee;
	
	@Column(name="book_fee")
	private Integer bookFee;
	
	@Column(name="icard_fee")
	private Integer icardFee;
	
	@Column(name="water_electric_fee")
	private Integer waterElectricFee;
	
	@Column(name="misc_Fee")
	private Integer miscFee;
	
	@Column(name="sports_culture_fee")
	private Integer sportsCultureFee;
	
	@Column(name="library_fee")
	private Integer libraryFee;
	
	@Column(name="activity_fee")
	private Integer activityFee;
	
	@Column(name="registration_fee")
	private Integer registrationFee;
	
	
	public Integer getFixedFeeId() {
		return fixedFeeId;
	}
	public void setFixedFeeId(Integer fixedFeeId) {
		this.fixedFeeId = fixedFeeId;
	}
	public Integer getBatchId() {
		return batchId;
	}
	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
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
	public Integer getExaminationFee() {
		return examinationFee;
	}
	public void setExaminationFee(Integer examinationFee) {
		this.examinationFee = examinationFee;
	}
	public Integer getMaintainanceFee() {
		return maintainanceFee;
	}
	public void setMaintainanceFee(Integer maintainanceFee) {
		this.maintainanceFee = maintainanceFee;
	}
	public Integer getTuitionFee() {
		return tuitionFee;
	}
	public void setTuitionFee(Integer tuitionFee) {
		this.tuitionFee = tuitionFee;
	}
	public Integer getReportCardFee() {
		return reportCardFee;
	}
	public void setReportCardFee(Integer reportCardFee) {
		this.reportCardFee = reportCardFee;
	}
	public Integer getBookFee() {
		return bookFee;
	}
	public void setBookFee(Integer bookFee) {
		this.bookFee = bookFee;
	}
	public Integer getIcardFee() {
		return icardFee;
	}
	public void setIcardFee(Integer icardFee) {
		this.icardFee = icardFee;
	}
	public Integer getWaterElectricFee() {
		return waterElectricFee;
	}
	public void setWaterElectricFee(Integer waterElectricFee) {
		this.waterElectricFee = waterElectricFee;
	}
	public Integer getMiscFee() {
		return miscFee;
	}
	public void setMiscFee(Integer miscFee) {
		this.miscFee = miscFee;
	}
	public Integer getSportsCultureFee() {
		return sportsCultureFee;
	}
	public void setSportsCultureFee(Integer sportsCultureFee) {
		this.sportsCultureFee = sportsCultureFee;
	}
	public Integer getLibraryFee() {
		return libraryFee;
	}
	public void setLibraryFee(Integer libraryFee) {
		this.libraryFee = libraryFee;
	}
	public Integer getActivityFee() {
		return activityFee;
	}
	public void setActivityFee(Integer activityFee) {
		this.activityFee = activityFee;
	}
	public Integer getRegistrationFee() {
		return registrationFee;
	}
	public void setRegistrationFee(Integer registrationFee) {
		this.registrationFee = registrationFee;
	}
	
	
}
