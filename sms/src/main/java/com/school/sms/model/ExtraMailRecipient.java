package com.school.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sms_extra_mail_recipient")
public class ExtraMailRecipient {

	@Id
	@GeneratedValue
	@Column(name="extra_recipient_id")
	private Integer extraRecipientId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phoneNo")
	private String phoneNo;

	@Column(name="mail_ype")
	private String mailType;
	
	public Integer getExtraRecipientId() {
		return extraRecipientId;
	}

	public void setExtraRecipientId(Integer extraRecipientId) {
		this.extraRecipientId = extraRecipientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getMailType() {
		return mailType;
	}

	public void setMailType(String mailType) {
		this.mailType = mailType;
	}
	
	
}
