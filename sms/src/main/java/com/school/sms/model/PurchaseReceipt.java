package com.school.sms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sms_purchase_receipt")
public class PurchaseReceipt {

	@Id
	@Column(name="receipt_no")
	private Integer receiptNo;
	
	
	@Column(name="receipt_date")
	private String receiptDate;
	
	@Column(name="ag_st1")
	private String agSt1;
	
	@Column(name="purchase_type")
	private String purchaseType;
	
	@Column(name="invoice_no")
	private Integer invoiceNo;
	
	@Column(name="invoice_date")
	private String invoiceDate;
	
	@Column(name="company")
	private String company;
	
	@Column(name="cheque_no")
	private String chequeNo;
	
	@Column(name="cheque_date")
	private String chequeDate;
	
	@Column(name="amount")
	private Double amount;
	
	@Column(name="stk_pnt")
	private String stkPnt;
	
	@OneToMany(mappedBy = "purchaseReceipt")
	private List<PurchaseReceiptItem> purchaseReceiptItemList = new ArrayList<PurchaseReceiptItem>();

	public Integer getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(Integer receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(String receiptDate) {
		this.receiptDate = receiptDate;
	}

	public String getAgSt1() {
		return agSt1;
	}

	public void setAgSt1(String agSt1) {
		this.agSt1 = agSt1;
	}

	public String getPurchaseType() {
		return purchaseType;
	}

	public void setPurchaseType(String purchaseType) {
		this.purchaseType = purchaseType;
	}

	public Integer getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(Integer invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getChequeDate() {
		return chequeDate;
	}

	public void setChequeDate(String chequeDate) {
		this.chequeDate = chequeDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getStkPnt() {
		return stkPnt;
	}

	public void setStkPnt(String stkPnt) {
		this.stkPnt = stkPnt;
	}

	public List<PurchaseReceiptItem> getPurchaseReceiptItemList() {
		return purchaseReceiptItemList;
	}

	public void setPurchaseReceiptItemList(
			List<PurchaseReceiptItem> purchaseReceiptItemList) {
		this.purchaseReceiptItemList = purchaseReceiptItemList;
	}
}
