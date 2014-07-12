package com.school.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sms_discounts_conscessions_student")
public class DiscountsAndConcessions {
	
	@Id
	@GeneratedValue
	@Column(name="discounts_conscessions_id")
	private Integer discountsConscessionsId;
	
	@Column(name="batch")
	private String batch;
	
	@Column(name="session")
	private String session;
	
	@Column(name="month")
	private String month;
	
	@Column(name="student_name_class_roll")
	private String studentNameClassRoll;
	
	@Column(name="admission_charges_discount")
	private Integer addmissionChargesDiscount;
	
	@Column(name="activity_fee_discount")
	private Integer activityFeeDiscount;
	
	@Column(name="hostel_charges_discount")
	private Integer hostelChargesDiscount;
	
	@Column(name="cce_charges_discount")
	private Integer cceChargesDiscount;
	
	@Column(name="maintainance_fee_discount")
	private Integer maintainanceFeeDiscount;
	
	@Column(name="music_fee_discount")
	private Integer musicFeeDiscount;
	
	@Column(name="misc_fee_discount")
	private Integer miscFeeDiscount;
	
	@Column(name="examination_fee_discount")
	private Integer examinationFeeDiscount;
	
	@Column(name="book_fee_discount")
	private Integer bookFeeDiscount;
	
	@Column(name="icard_fee_discount")
	private Integer icardFeeDiscount;

	@Column(name="library_fee_discount")
	private Integer LibraryFeeDiscount;
	
	@Column(name="admission_charges_discount_percentage")
	private Integer addmissionChargesDiscountPercentage;
	
	@Column(name="activity_fee_discount_percentage")
	private Integer activityFeeDiscountPercentage;
	
	@Column(name="hostel_charges_discount_percentage")
	private Integer hostelChargesDiscountPercentage;
	
	@Column(name="cce_charges_discount_percentage")
	private Integer cceChargesDiscountPercentage;
	
	@Column(name="maintainance_fee_discount_percentage")
	private Integer maintainanceFeeDiscountPercentage;
	
	@Column(name="music_fee_discount_percentage")
	private Integer musicFeeDiscountPercentage;
	
	@Column(name="misc_fee_discount_percentage")
	private Integer miscFeeDiscountPercentage;
	
	@Column(name="examination_fee_discount_percentage")
	private Integer examinationFeeDiscountPercentage;
	
	@Column(name="book_fee_discount_percentage")
	private Integer bookFeeDiscountPercentage;
	
	@Column(name="icard_fee_discount_percentage")
	private Integer icardFeeDiscountPercentage;

	@Column(name="library_fee_discount_percentage")
	private Integer LibraryFeeDiscountPercentage;

	

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
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

	public Integer getAddmissionChargesDiscount() {
		return addmissionChargesDiscount;
	}

	public void setAddmissionChargesDiscount(Integer addmissionChargesDiscount) {
		this.addmissionChargesDiscount = addmissionChargesDiscount;
	}

	public Integer getActivityFeeDiscount() {
		return activityFeeDiscount;
	}

	public void setActivityFeeDiscount(Integer activityFeeDiscount) {
		this.activityFeeDiscount = activityFeeDiscount;
	}

	public Integer getHostelChargesDiscount() {
		return hostelChargesDiscount;
	}

	public void setHostelChargesDiscount(Integer hostelChargesDiscount) {
		this.hostelChargesDiscount = hostelChargesDiscount;
	}

	public Integer getCceChargesDiscount() {
		return cceChargesDiscount;
	}

	public void setCceChargesDiscount(Integer cceChargesDiscount) {
		this.cceChargesDiscount = cceChargesDiscount;
	}

	public Integer getMaintainanceFeeDiscount() {
		return maintainanceFeeDiscount;
	}

	public void setMaintainanceFeeDiscount(Integer maintainanceFeeDiscount) {
		this.maintainanceFeeDiscount = maintainanceFeeDiscount;
	}

	public Integer getMusicFeeDiscount() {
		return musicFeeDiscount;
	}

	public void setMusicFeeDiscount(Integer musicFeeDiscount) {
		this.musicFeeDiscount = musicFeeDiscount;
	}

	public Integer getMiscFeeDiscount() {
		return miscFeeDiscount;
	}

	public void setMiscFeeDiscount(Integer miscFeeDiscount) {
		this.miscFeeDiscount = miscFeeDiscount;
	}

	public Integer getExaminationFeeDiscount() {
		return examinationFeeDiscount;
	}

	public void setExaminationFeeDiscount(Integer examinationFeeDiscount) {
		this.examinationFeeDiscount = examinationFeeDiscount;
	}

	public Integer getBookFeeDiscount() {
		return bookFeeDiscount;
	}

	public void setBookFeeDiscount(Integer bookFeeDiscount) {
		this.bookFeeDiscount = bookFeeDiscount;
	}

	public Integer getIcardFeeDiscount() {
		return icardFeeDiscount;
	}

	public void setIcardFeeDiscount(Integer icardFeeDiscount) {
		this.icardFeeDiscount = icardFeeDiscount;
	}

	public Integer getLibraryFeeDiscount() {
		return LibraryFeeDiscount;
	}

	public void setLibraryFeeDiscount(Integer libraryFeeDiscount) {
		LibraryFeeDiscount = libraryFeeDiscount;
	}

	public Integer getAddmissionChargesDiscountPercentage() {
		return addmissionChargesDiscountPercentage;
	}

	public void setAddmissionChargesDiscountPercentage(
			Integer addmissionChargesDiscountPercentage) {
		this.addmissionChargesDiscountPercentage = addmissionChargesDiscountPercentage;
	}

	public Integer getActivityFeeDiscountPercentage() {
		return activityFeeDiscountPercentage;
	}

	public void setActivityFeeDiscountPercentage(
			Integer activityFeeDiscountPercentage) {
		this.activityFeeDiscountPercentage = activityFeeDiscountPercentage;
	}

	public Integer getHostelChargesDiscountPercentage() {
		return hostelChargesDiscountPercentage;
	}

	public void setHostelChargesDiscountPercentage(
			Integer hostelChargesDiscountPercentage) {
		this.hostelChargesDiscountPercentage = hostelChargesDiscountPercentage;
	}

	public Integer getCceChargesDiscountPercentage() {
		return cceChargesDiscountPercentage;
	}

	public void setCceChargesDiscountPercentage(Integer cceChargesDiscountPercentage) {
		this.cceChargesDiscountPercentage = cceChargesDiscountPercentage;
	}

	public Integer getMaintainanceFeeDiscountPercentage() {
		return maintainanceFeeDiscountPercentage;
	}

	public void setMaintainanceFeeDiscountPercentage(
			Integer maintainanceFeeDiscountPercentage) {
		this.maintainanceFeeDiscountPercentage = maintainanceFeeDiscountPercentage;
	}

	public Integer getMusicFeeDiscountPercentage() {
		return musicFeeDiscountPercentage;
	}

	public void setMusicFeeDiscountPercentage(Integer musicFeeDiscountPercentage) {
		this.musicFeeDiscountPercentage = musicFeeDiscountPercentage;
	}

	public Integer getMiscFeeDiscountPercentage() {
		return miscFeeDiscountPercentage;
	}

	public void setMiscFeeDiscountPercentage(Integer miscFeeDiscountPercentage) {
		this.miscFeeDiscountPercentage = miscFeeDiscountPercentage;
	}

	public Integer getExaminationFeeDiscountPercentage() {
		return examinationFeeDiscountPercentage;
	}

	public void setExaminationFeeDiscountPercentage(
			Integer examinationFeeDiscountPercentage) {
		this.examinationFeeDiscountPercentage = examinationFeeDiscountPercentage;
	}

	public Integer getBookFeeDiscountPercentage() {
		return bookFeeDiscountPercentage;
	}

	public void setBookFeeDiscountPercentage(Integer bookFeeDiscountPercentage) {
		this.bookFeeDiscountPercentage = bookFeeDiscountPercentage;
	}

	public Integer getIcardFeeDiscountPercentage() {
		return icardFeeDiscountPercentage;
	}

	public void setIcardFeeDiscountPercentage(Integer icardFeeDiscountPercentage) {
		this.icardFeeDiscountPercentage = icardFeeDiscountPercentage;
	}

	public Integer getLibraryFeeDiscountPercentage() {
		return LibraryFeeDiscountPercentage;
	}

	public void setLibraryFeeDiscountPercentage(Integer libraryFeeDiscountPercentage) {
		LibraryFeeDiscountPercentage = libraryFeeDiscountPercentage;
	}

	public Integer getDiscountsConscessionsId() {
		return discountsConscessionsId;
	}

	public void setDiscountsConscessionsId(Integer discountsConscessionsId) {
		this.discountsConscessionsId = discountsConscessionsId;
	}
}
