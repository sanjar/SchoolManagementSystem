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
	private Double examinationFee;
	
	@Column(name="maintainance_fee")
	private Double maintainanceFee;
	
	@Column(name="tuition_fee")
	private Double tuitionFee;
	
	@Column(name="report_card_fee")
	private Double reportCardFee;
	
	@Column(name="book_fee")
	private Double bookFee;
	
	@Column(name="icard_fee")
	private Double icardFee;
	
	@Column(name="water_electric_fee")
	private Double waterElectricFee;
	
	@Column(name="misc_Fee")
	private Double miscFee;
	
	@Column(name="sports_culture_fee")
	private Double sportsCultureFee;
	
	@Column(name="library_fee")
	private Double libraryFee;
	
	@Column(name="activity_fee")
	private Double activityFee;
	
	@Column(name="registration_fee")
	private Double registrationFee;
	
	
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
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof FixedFeeBatchYearMonth){
			if(((FixedFeeBatchYearMonth)obj).getFixedFeeId().equals(this.fixedFeeId)){
				return true;
			}
		}
		return super.equals(obj);
	}
	public Double getExaminationFee() {
		return examinationFee;
	}
	public void setExaminationFee(Double examinationFee) {
		this.examinationFee = examinationFee;
	}
	public Double getMaintainanceFee() {
		return maintainanceFee;
	}
	public void setMaintainanceFee(Double maintainanceFee) {
		this.maintainanceFee = maintainanceFee;
	}
	public Double getTuitionFee() {
		return tuitionFee;
	}
	public void setTuitionFee(Double tuitionFee) {
		this.tuitionFee = tuitionFee;
	}
	public Double getReportCardFee() {
		return reportCardFee;
	}
	public void setReportCardFee(Double reportCardFee) {
		this.reportCardFee = reportCardFee;
	}
	public Double getBookFee() {
		return bookFee;
	}
	public void setBookFee(Double bookFee) {
		this.bookFee = bookFee;
	}
	public Double getIcardFee() {
		return icardFee;
	}
	public void setIcardFee(Double icardFee) {
		this.icardFee = icardFee;
	}
	public Double getWaterElectricFee() {
		return waterElectricFee;
	}
	public void setWaterElectricFee(Double waterElectricFee) {
		this.waterElectricFee = waterElectricFee;
	}
	public Double getMiscFee() {
		return miscFee;
	}
	public void setMiscFee(Double miscFee) {
		this.miscFee = miscFee;
	}
	public Double getSportsCultureFee() {
		return sportsCultureFee;
	}
	public void setSportsCultureFee(Double sportsCultureFee) {
		this.sportsCultureFee = sportsCultureFee;
	}
	public Double getLibraryFee() {
		return libraryFee;
	}
	public void setLibraryFee(Double libraryFee) {
		this.libraryFee = libraryFee;
	}
	public Double getActivityFee() {
		return activityFee;
	}
	public void setActivityFee(Double activityFee) {
		this.activityFee = activityFee;
	}
	public Double getRegistrationFee() {
		return registrationFee;
	}
	public void setRegistrationFee(Double registrationFee) {
		this.registrationFee = registrationFee;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
