package com.school.sms.dao;

import java.util.List;

import com.school.sms.model.Customer;
import com.school.sms.model.GeneralLedgerEntry;
import com.school.sms.model.Product;
import com.school.sms.model.PurchaseReceipt;
import com.school.sms.model.SalesReceipt;

public interface PurchaseDao {

	

	void updateCustomer(Customer customer);

	List<Customer> loadCustomerList();

	void deleteCustomer(Customer customer);

	Customer findCustomer(String customerCode);

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

	SalesReceipt findSalesReceipt(Integer challanNo);

	List<PurchaseReceipt> loadPurchaseReceipts();

	List<SalesReceipt> loadSalesReceipts();

	List<GeneralLedgerEntry> loadGeneralLedgers();

	GeneralLedgerEntry findGeneralLedgerEntry(Integer glCode);

	GeneralLedgerEntry updateSalesReceipt(GeneralLedgerEntry entry);

	void deleteGeneralLedgerEntry(GeneralLedgerEntry generalLedger);

}
