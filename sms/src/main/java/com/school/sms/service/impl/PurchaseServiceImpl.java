package com.school.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.school.sms.dao.PayrollDao;
import com.school.sms.dao.PurchaseDao;
import com.school.sms.model.Customer;
import com.school.sms.model.GeneralLedgerEntry;
import com.school.sms.model.Product;
import com.school.sms.model.PurchaseReceipt;
import com.school.sms.model.SalesReceipt;
import com.school.sms.service.PurchaseService;

@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService{

	@Resource(name = "purchaseDaoService")
	private PurchaseDao purchaseDao;

	@Override
	public Customer findCustomer(String customerCode) {
		return purchaseDao.findCustomer(customerCode);
	}

	@Override
	public void updateCustomer(Customer customer) {
		purchaseDao.updateCustomer(customer);
		
	}

	@Override
	public List<Customer> loadCustomerList() {
		return purchaseDao.loadCustomerList();
	}

	@Override
	public void deleteCustomer(Customer customer) {
		purchaseDao.deleteCustomer(customer);
		
	}

	@Override
	public List<Product> loadProductList() {
		return purchaseDao.loadProductList();
	}

	@Override
	public Product findProduct(String productParentCode) {
		return purchaseDao.findProduct(productParentCode);
	}

	@Override
	public void updateProduct(Product product) {
		purchaseDao.updateProduct(product);
		
	}

	@Override
	public void deleteProduct(Product product) {
		purchaseDao.deleteProduct(product);
		
	}

	@Override
	public void updatePurchaseReceipt(PurchaseReceipt purchaseReceipt) {
		purchaseDao.updatePurchaseReceipt(purchaseReceipt);
		
	}

	@Override
	public void deletePurchaseReceipt(PurchaseReceipt purchaseReceipt) {
		purchaseDao.deletePurchaseReceipt(purchaseReceipt);
		
	}

	@Override
	public PurchaseReceipt findPurchaseReceipt(Integer receiptNo) {
		return purchaseDao.findPurchaseReceipt(receiptNo);
	}

	@Override
	public Integer getcurrentReceiptNo() {
		return purchaseDao.getcurrentReceiptNo();
	}

	@Override
	public Integer getCurrentCustomerCode() {
		return purchaseDao.getCurrentCustomerCode();
	}

	@Override
	public Integer getCurrentProductCode() {
		// TODO Auto-generated method stub
		return purchaseDao.getCurrentProductCode();
	}

	@Override
	public Integer getcurrentChallanNo() {
		// TODO Auto-generated method stub
		return purchaseDao.getcurrentChallanNo();
	}

	@Override
	public void updateSalesReceipt(SalesReceipt salesReceipt) {
		purchaseDao.updateSalesReceipt(salesReceipt);
		
	}

	@Override
	public void deleteSalesReceipt(SalesReceipt salesReceipt) {
		purchaseDao.deleteSalesReceipt(salesReceipt);
		
	}

	@Override
	public SalesReceipt findSalesReceipt(Integer challanNo) {
		return purchaseDao.findSalesReceipt(challanNo);
	}

	@Override
	public List<PurchaseReceipt> loadPurchaseReceipts() {
		// TODO Auto-generated method stub
		return purchaseDao.loadPurchaseReceipts();
	}

	@Override
	public List<SalesReceipt> loadSalesReceipts() {
		// TODO Auto-generated method stub
		return purchaseDao.loadSalesReceipts();
	}

	@Override
	public List<GeneralLedgerEntry> loadGeneralLedgers() {
		return purchaseDao.loadGeneralLedgers();
	}

	
	
}
