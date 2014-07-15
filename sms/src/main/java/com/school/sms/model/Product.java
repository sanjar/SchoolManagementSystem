package com.school.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sms_product")
public class Product {

	@Id
	@Column(name="product_parent_code")
	private String productParentCode;
	
	@Column(name="description")
	private String description;
	
	@Column(name="mrp")
	private Double MRP;
	
	@Column(name="offer_price")
	private Double offerPrice;
	
	@Column(name="tax_code")
	private String taxCode;
	
	@Column(name="sale_price")
	private Double salePrice;
	
	@Column(name="category")
	private String category;
	
	@Column(name="product_uom")
	private String productUOM;

	public String getProductParentCode() {
		return productParentCode;
	}

	public void setProductParentCode(String productParentCode) {
		this.productParentCode = productParentCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getMRP() {
		return MRP;
	}

	public void setMRP(Double mRP) {
		MRP = mRP;
	}

	public Double getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(Double offerPrice) {
		this.offerPrice = offerPrice;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProductUOM() {
		return productUOM;
	}

	public void setProductUOM(String productUOM) {
		this.productUOM = productUOM;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Product){
			if(((Product)obj).getProductParentCode().equalsIgnoreCase(this.productParentCode)){
				return true;
			}
		}
		return super.equals(obj);
	}
	
}
