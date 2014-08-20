package com.school.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sms_student_fixed_fee_details")
public class StudentFeeDetails {
	
	@Id
	@GeneratedValue
	@Column(name="receipt_no")
	private Integer receiptNo;
	
	@Column(name="enrolement_no")
	private String enrolementNo;
	
	@Column(name="batch")
	private String batch;
	
	@Column(name="student_name")
	private String studentName;
	
	@Column(name="month")
	private String month;
	
	@Column(name="fixed_fee_id")
	private Integer fixedFeeId;
	
	@Column(name="previous_due")
	private Double previousDue=0.00;
	
	@Column(name="late_fine")
	private Double lateFine=0.00;
	
	@Column(name="other_fine")
	private Double otherFine=0.00;

	@Column(name="discount")
	private Double discount=0.00;
	
	@Column(name="concession")
	private Double concession=0.00;
	
	@Column(name="total_amount")
	private Double totalAmount=0.00;
	
	@Column(name="amount_received")
	private Double amountReceived=0.00;

	@Column(name="session")
	private String session;
	
	@Column(name="date_of_payment")
	private String dateOfPayment;
	
	@Column(name="mode_of_payment")
	private String modeOfPayment;
	
	@Column(name="cheque_draft_no")
	private String chequeDraftNo;
	
	@Column(name="pick_up_master_id")
	private Integer pickUpMasterId;
	
	@Column(name="transport_dues")
	private Double transportDues;
	
	@Column(name="transport_amount_paid")
	private Double transportAmountPaid;
	
	@Column(name="cheque_draft_date")
	private String chequeDraftDate;
	
	public Integer getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(Integer receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getEnrolementNo() {
		return enrolementNo;
	}

	public void setEnrolementNo(String enrolementNo) {
		this.enrolementNo = enrolementNo;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Integer getFixedFeeId() {
		return fixedFeeId;
	}

	public void setFixedFeeId(Integer fixedFeeId) {
		this.fixedFeeId = fixedFeeId;
	}

	

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(String dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public String getChequeDraftNo() {
		return chequeDraftNo;
	}

	public void setChequeDraftNo(String chequeDraftNo) {
		this.chequeDraftNo = chequeDraftNo;
	}

	public String getChequeDraftDate() {
		return chequeDraftDate;
	}

	public void setChequeDraftDate(String chequeDraftDate) {
		this.chequeDraftDate = chequeDraftDate;
	}

	public Double getPreviousDue() {
		return previousDue;
	}

	public void setPreviousDue(Double previousDue) {
		this.previousDue = previousDue;
	}

	public Double getLateFine() {
		return lateFine;
	}

	public void setLateFine(Double lateFine) {
		this.lateFine = lateFine;
	}

	public Double getOtherFine() {
		return otherFine;
	}

	public void setOtherFine(Double otherFine) {
		this.otherFine = otherFine;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getConcession() {
		return concession;
	}

	public void setConcession(Double concession) {
		this.concession = concession;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getAmountReceived() {
		return amountReceived;
	}

	public void setAmountReceived(Double amountReceived) {
		this.amountReceived = amountReceived;
	}

	

	public Double getTransportDues() {
		return transportDues;
	}

	public void setTransportDues(Double transportDues) {
		this.transportDues = transportDues;
	}

	public Double getTransportAmountPaid() {
		return transportAmountPaid;
	}

	public void setTransportAmountPaid(Double transportAmountPaid) {
		this.transportAmountPaid = transportAmountPaid;
	}

	public Integer getPickUpMasterId() {
		return pickUpMasterId;
	}

	public void setPickUpMasterId(Integer pickUpMasterId) {
		this.pickUpMasterId = pickUpMasterId;
	}

	
}
