package com.school.sms.service;

import java.util.List;

import com.school.sms.model.Customer;

public interface PurchaseService {

	Customer findCustomer(String customerCode);

	void updateCustomer(Customer customer);

	List<Customer> loadCustomerList();

	void deleteCustomer(Customer customer);

}
