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
public class PurchaseReceiptItem {
	
	@Id
	@GeneratedValue
	@Column(name="item_id")
	private Integer itemId;
	
	@ManyToOne
	@JoinColumn(name="receipt_no")
	private PurchaseReceipt purchaseReceipt;
	
	@Column(name="product_code")
	private String productCode;
	
	@Column(name="description")
	private String description;
	
	@Column(name="purchase_price")
	private Double purchasePrice;
	
	@Column(name="quantity_box")
	private Double quantityBox;
	
	@Column(name="quantity_unit")
	private Double quantityUnit;
	
	@Column(name="skt_type")
	private String sktType;
	
	@Column(name="discount")
	private String discount;  /// may be in percentage....
	
	@Column(name="total_amount")
	private Double totalAmount;
	
	@Column(name="ap")
	private String AP;

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

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Double getQuantityBox() {
		return quantityBox;
	}

	public void setQuantityBox(Double quantityBox) {
		this.quantityBox = quantityBox;
	}

	public Double getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(Double quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	public String getSktType() {
		return sktType;
	}

	public void setSktType(String sktType) {
		this.sktType = sktType;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getAP() {
		return AP;
	}

	public void setAP(String aP) {
		AP = aP;
	}

	public PurchaseReceipt getPurchaseReceipt() {
		return purchaseReceipt;
	}

	public void setPurchaseReceipt(PurchaseReceipt purchaseReceipt) {
		this.purchaseReceipt = purchaseReceipt;
	}
	
	

}
