package com.school.sms.service;

import java.util.List;

import com.school.sms.model.Customer;
import com.school.sms.model.Product;

public interface PurchaseService {

	Customer findCustomer(String customerCode);

	void updateCustomer(Customer customer);

	List<Customer> loadCustomerList();

	void deleteCustomer(Customer customer);

	List<Product> loadProductList();

	Product findProduct(String productParentCode);

	void updateProduct(Product product);

	void deleteProduct(Product product);

}
