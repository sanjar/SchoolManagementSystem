package com.school.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.school.sms.dao.PayrollDao;
import com.school.sms.dao.PurchaseDao;
import com.school.sms.model.Customer;
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

	
	
}
