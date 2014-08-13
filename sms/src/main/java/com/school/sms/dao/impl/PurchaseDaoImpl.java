package com.school.sms.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.sms.dao.PurchaseDao;
import com.school.sms.model.Customer;
import com.school.sms.model.GradeMaster;
import com.school.sms.model.Product;
import com.school.sms.model.PurchaseReceipt;
import com.school.sms.model.SalesReceipt;

@Service("purchaseDaoService")
@Transactional
public class PurchaseDaoImpl implements PurchaseDao {

private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager){
		this.entityManager = entityManager;
	}

	@Override
	public void updateCustomer(Customer customer) {
		entityManager.merge(customer);
		entityManager.flush();
		
	}

	@Override
	public List<Customer> loadCustomerList() {
		Query query = entityManager.createQuery("FROM Customer c order by c.customerCode ASC");
		return query.getResultList();
	}

	@Override
	public void deleteCustomer(Customer customer) {
		Customer grade = entityManager.find(Customer.class,customer.getCustomerCode());
		entityManager.remove(grade);
		entityManager.flush();
		
	}

	@Override
	public Customer findCustomer(String customerCode) {
		List list= entityManager.createQuery("FROM Customer c WHERE c.customerCode="+"'"+customerCode+"'").getResultList();
		if(list.size()>0){
			return (Customer) list.get(0);
		}
		return null;
	}

	@Override
	public List<Product> loadProductList() {
		Query query = entityManager.createQuery("FROM Product p order by p.productParentCode ASC");
		return query.getResultList();
	}

	@Override
	public Product findProduct(String productParentCode) {
		List list= entityManager.createQuery("FROM Product p WHERE p.productParentCode="+"'"+productParentCode+"'").getResultList();
		if(list.size()>0){
			return (Product) list.get(0);
		}
		return null;
	}

	@Override
	public void updateProduct(Product product) {
		entityManager.merge(product);
		entityManager.flush();
		
	}

	@Override
	public void deleteProduct(Product product) {
		Product grade = entityManager.find(Product.class,product.getProductParentCode());
		entityManager.remove(grade);
		entityManager.flush();
		
	}

	@Override
	public void updatePurchaseReceipt(PurchaseReceipt purchaseReceipt) {
		entityManager.merge(purchaseReceipt);
		entityManager.flush();
		
	}

	@Override
	public void deletePurchaseReceipt(PurchaseReceipt purchaseReceipt) {
		PurchaseReceipt purchaseReceipt1 = entityManager.find(PurchaseReceipt.class,purchaseReceipt.getReceiptNo());
		entityManager.remove(purchaseReceipt1);
		entityManager.flush();
		
	}

	@Override
	public PurchaseReceipt findPurchaseReceipt(Integer receiptNo) {
		List list= entityManager.createQuery("FROM PurchaseReceipt p WHERE p.receiptNo="+"'"+receiptNo+"'").getResultList();
		if(list.size()>0){
			return (PurchaseReceipt) list.get(0);
		}
		return null;
	}

	@Override
	public Integer getcurrentReceiptNo() {
		Integer max = (Integer) entityManager.createQuery("select max(p.receiptNo) from PurchaseReceipt p").getSingleResult();
		if(max==null){
			max=0;
		}
		return max;
	}

	@Override
	public Integer getCurrentCustomerCode() {
		Integer max = (Integer) entityManager.createQuery("select max(p.customerCode) from Customer p").getSingleResult();
		if(max==null){
			max=0;
		}
		return max;
	}

	@Override
	public Integer getCurrentProductCode() {
		Integer max = (Integer) entityManager.createQuery("select max(p.productParentCode) from Product p").getSingleResult();
		if(max==null){
			max=0;
		}
		return max;
	}

	@Override
	public Integer getcurrentChallanNo() {
		Integer max = (Integer) entityManager.createQuery("select max(p.challanNo) from SalesReceipt p").getSingleResult();
		if(max==null){
			max=0;
		}
		return max;
	}

	@Override
	public void updateSalesReceipt(SalesReceipt salesReceipt) {
		entityManager.merge(salesReceipt);
		entityManager.flush();
		
	}

	@Override
	public void deleteSalesReceipt(SalesReceipt salesReceipt) {
		SalesReceipt salesReceipt1 = entityManager.find(SalesReceipt.class,salesReceipt.getChallanNo());
		entityManager.remove(salesReceipt1);
		entityManager.flush();
		
	}

	@Override
	public SalesReceipt findSalesReceipt(Integer challanNo) {
		List list= entityManager.createQuery("FROM SalesReceipt p WHERE p.challanNo="+"'"+challanNo+"'").getResultList();
		if(list.size()>0){
			return (SalesReceipt) list.get(0);
		}
		return null;
	}
}
