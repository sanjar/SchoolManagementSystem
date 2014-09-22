package com.school.sms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.ListUtils;

@Entity
@Table(name="sms_sales_receipt")
public class SalesReceipt {

	@Id
	@GeneratedValue
	@Column(name="challan_no")
	private Integer challanNo;
	
	
	@Column(name="challan_date")
	private String challanDate;
	
	@Column(name="customer_type")
	private String customerType;
	
	
	
	@Column(name="customer_code")
	private Integer customerCode;
	
	@Column(name="sale_type")
	private String saleType;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="invoice_no")
	private Integer invoiceNo;
	
	@Column(name="commission")
	private Double commission=0.00;
	
	@Column(name="scheme")
	private Double scheme=0.00;
	
	@Column(name="tds")
	private Double TDS=0.00;
	
	@Column(name="discount")
	private Double discount=0.00;
	
	@Column(name="tax")
	private Double tax=0.00;
	
	@Column(name="gross_value")
	private Double grossValue=0.00;
	
	@Column(name="net_value")
	private Double netValue=0.00;
	
	@OneToMany(mappedBy = "salesReceipt",cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	private List<SalesReceiptItem> salesReceiptItemList = ListUtils.lazyList(new ArrayList<SalesReceiptItem>(), FactoryUtils.instantiateFactory(SalesReceiptItem.class));

	public Integer getChallanNo() {
		return challanNo;
	}

	public void setChallanNo(Integer challanNo) {
		this.challanNo = challanNo;
	}

	public String getChallanDate() {
		return challanDate;
	}

	public void setChallanDate(String challanDate) {
		this.challanDate = challanDate;
	}

	public Integer getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(Integer customerCode) {
		this.customerCode = customerCode;
	}

	

	public Integer getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(Integer invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public List<SalesReceiptItem> getSalesReceiptItemList() {
		return salesReceiptItemList;
	}

	public void setSalesReceiptItemList(List<SalesReceiptItem> salesReceiptItemList) {
		this.salesReceiptItemList = salesReceiptItemList;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getSaleType() {
		return saleType;
	}

	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}

	public Double getCommission() {
		return commission;
	}

	public void setCommission(Double commission) {
		this.commission = commission;
	}

	public Double getScheme() {
		return scheme;
	}

	public void setScheme(Double scheme) {
		this.scheme = scheme;
	}

	public Double getTDS() {
		return TDS;
	}

	public void setTDS(Double tDS) {
		TDS = tDS;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getGrossValue() {
		return grossValue;
	}

	public void setGrossValue(Double grossValue) {
		this.grossValue = grossValue;
	}

	public Double getNetValue() {
		return netValue;
	}

	public void setNetValue(Double netValue) {
		this.netValue = netValue;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	
	
}
