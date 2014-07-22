package com.school.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sms_extra_charges_in_percent")
public class ExtraCharges {

	@Id
	@GeneratedValue
	@Column(name="extra_charge_id")
	private Integer id;
	
	@Column(name="commision")
	private Double commision;
	
	@Column(name="scheme")
	private Double scheme;
	
	@Column(name="tds")
	private Double TDS;
	
	@Column(name="discount")
	private Double discount;
	
	@Column(name="tax")
	private Double tax;
	
	@Column(name="is_active")
	private Double isActive;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getCommision() {
		return commision;
	}

	public void setCommision(Double commision) {
		this.commision = commision;
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

	public Double getIsActive() {
		return isActive;
	}

	public void setIsActive(Double isActive) {
		this.isActive = isActive;
	}
	
}
