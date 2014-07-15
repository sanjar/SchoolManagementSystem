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
}
