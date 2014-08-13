package com.school.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sms_purchase_receipt_item")
public class SalesReceiptItem {

	@Id
	@GeneratedValue
	@Column(name="item_id")
	private Integer itemId;
	
	@ManyToOne
	@JoinColumn(name="challan_no")
	private SalesReceipt salesReceipt;
	
	@Column(name="product_code")
	private String productCode;
	
	@Column(name="description")
	private String description;
	
	@Column(name="type")
	private String type	;
	
	@Column(name="quantity_box")
	private Double quantityBox;
	
	
	
	@Column(name="discount")
	private Double discount;  /// may be in percentage....
	
	@Column(name="total_amount")
	private Double totalAmount;

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public Double getQuantityBox() {
		return quantityBox;
	}

	public void setQuantityBox(Double quantityBox) {
		this.quantityBox = quantityBox;
	}

	

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public SalesReceipt getSalesReceipt() {
		return salesReceipt;
	}

	public void setSalesReceipt(SalesReceipt salesReceipt) {
		this.salesReceipt = salesReceipt;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
