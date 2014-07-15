package com.school.sms.dao;

import java.util.List;

import com.school.sms.model.Customer;

public interface PurchaseDao {

	

	void updateCustomer(Customer customer);

	List<Customer> loadCustomerList();

	void deleteCustomer(Customer customer);

	Customer findCustomer(String customerCode);

}
