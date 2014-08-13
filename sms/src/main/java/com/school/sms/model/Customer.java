package com.school.sms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sms_customer")
public class Customer {

	@Id
	@GeneratedValue
	@Column(name="customer_code")
	private Integer customerCode;
	
	@Column(name="customer_type")
	private String customerType;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="address")
	private String address;
	
	@Column(name="pin")
	private String pin;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="contactPerson")
	private String contactPerson;
	
	@Column(name="tinNo")
	private String tinNo;
	
	@Column(name="dateOfCreation")
	private String  dateOfCreation;

	

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	

	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Customer){
			if(((Customer)obj).getCustomerCode().equals(this.customerCode)){
				return true;
			}
		}
		return super.equals(obj);
	}

	public String getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(String dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTinNo() {
		return tinNo;
	}

	public void setTinNo(String tinNo) {
		this.tinNo = tinNo;
	}

	public Integer getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(Integer customerCode) {
		this.customerCode = customerCode;
	}
	
}
