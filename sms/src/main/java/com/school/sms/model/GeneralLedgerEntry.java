package com.school.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sms_general_ledger_entry")
public class GeneralLedgerEntry {

	@Id
	@GeneratedValue
	@Column(name="gl_code")
	private Integer glCode;
	
	@Column(name="name")
	private String name;
	
	@Column(name="sub_ledger_code_required")
	private boolean subLedgerCodeRequired= false;
	
	@Column(name="personal_code_required")
	private boolean personalCodeRequired= false;
	
	@Column(name="order_code_required")
	private boolean orderCodeRequired= false;
	
	@Column(name="telephone_required")
	private boolean telephoneRequired= false;
	
	@Column(name="plbs_code")
	private Integer PLBSCode;
	
	@Column(name="average_balance_code")
	private Integer averageBalanceCode;

	@Column(name="tds_percentage")
	private Double TDSPercentage;
	
	@Column(name="stx_percentage")
	private Double STXPercentage;
	
	@Column(name="investment")
	private Boolean investment;

	public Integer getGlCode() {
		return glCode;
	}

	public void setGlCode(Integer glCode) {
		this.glCode = glCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSubLedgerCodeRequired() {
		return subLedgerCodeRequired;
	}

	public void setSubLedgerCodeRequired(boolean subLedgerCodeRequired) {
		this.subLedgerCodeRequired = subLedgerCodeRequired;
	}

	public boolean isPersonalCodeRequired() {
		return personalCodeRequired;
	}

	public void setPersonalCodeRequired(boolean personalCodeRequired) {
		this.personalCodeRequired = personalCodeRequired;
	}

	public boolean isOrderCodeRequired() {
		return orderCodeRequired;
	}

	public void setOrderCodeRequired(boolean orderCodeRequired) {
		this.orderCodeRequired = orderCodeRequired;
	}

	public boolean isTelephoneRequired() {
		return telephoneRequired;
	}

	public void setTelephoneRequired(boolean telephoneRequired) {
		this.telephoneRequired = telephoneRequired;
	}

	public Integer getPLBSCode() {
		return PLBSCode;
	}

	public void setPLBSCode(Integer pLBSCode) {
		PLBSCode = pLBSCode;
	}

	public Integer getAverageBalanceCode() {
		return averageBalanceCode;
	}

	public void setAverageBalanceCode(Integer averageBalanceCode) {
		this.averageBalanceCode = averageBalanceCode;
	}

	public Double getTDSPercentage() {
		return TDSPercentage;
	}

	public void setTDSPercentage(Double tDSPercentage) {
		TDSPercentage = tDSPercentage;
	}

	public Double getSTXPercentage() {
		return STXPercentage;
	}

	public void setSTXPercentage(Double sTXPercentage) {
		STXPercentage = sTXPercentage;
	}

	public Boolean getInvestment() {
		return investment;
	}

	public void setInvestment(Boolean investment) {
		this.investment = investment;
	}
	
	
	
}
