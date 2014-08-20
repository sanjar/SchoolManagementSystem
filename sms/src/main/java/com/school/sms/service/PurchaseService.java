package com.school.sms.service;

import java.util.List;

import com.school.sms.model.Customer;
import com.school.sms.model.Product;
import com.school.sms.model.PurchaseReceipt;
import com.school.sms.model.SalesReceipt;

public interface PurchaseService {

	Customer findCustomer(String customerCode);

	void updateCustomer(Customer customer);

	List<Customer> loadCustomerList();

	void deleteCustomer(Customer customer);

	List<Product> loadProductList();

	Product findProduct(String productParentCode);

	void updateProduct(Product product);

	void deleteProduct(Product product);

	void updatePurchaseReceipt(PurchaseReceipt purchaseReceipt);

	void deletePurchaseReceipt(PurchaseReceipt purchaseReceipt);

	PurchaseReceipt findPurchaseReceipt(Integer receiptNo);

	Integer getcurrentReceiptNo();

	Integer getCurrentCustomerCode();

	Integer getCurrentProductCode();

	Integer getcurrentChallanNo();

	void updateSalesReceipt(SalesReceipt salesReceipt);

	void deleteSalesReceipt(SalesReceipt salesReceipt);

	SalesReceipt findSalesReceipt(Integer valueOf);

	List<PurchaseReceipt> loadPurchaseReceipts();

	List<SalesReceipt> loadSalesReceipts();

}
