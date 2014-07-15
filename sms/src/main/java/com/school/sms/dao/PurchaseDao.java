package com.school.sms.dao;

import java.util.List;

import com.school.sms.model.Customer;
import com.school.sms.model.Product;

public interface PurchaseDao {

	

	void updateCustomer(Customer customer);

	List<Customer> loadCustomerList();

	void deleteCustomer(Customer customer);

	Customer findCustomer(String customerCode);

	List<Product> loadProductList();

	Product findProduct(String productParentCode);

	void updateProduct(Product product);

	void deleteProduct(Product product);

}
