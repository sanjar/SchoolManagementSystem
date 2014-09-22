package com.school.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="send_custom_sms")
public class SendCustomSMS {

	@Id
	@GeneratedValue
	@Column(name="custom_sms_id")
	private Integer customSMSId;
	
	@Column(name="mobile_no")
	private String mobileNo;
	
	@Column(name="date")
	private String date;
	
	@Column(name="sms_content")
	private String smsContent;

	public Integer getCustomSMSId() {
		return customSMSId;
	}

	public void setCustomSMSId(Integer customSMSId) {
		this.customSMSId = customSMSId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSmsContent() {
		return smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}
}
