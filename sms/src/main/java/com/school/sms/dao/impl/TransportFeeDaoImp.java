package com.school.sms.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.sms.dao.TransportFeeDao;
import com.school.sms.model.TransportRoutePickUp;

@Service("transportDaoService")
@Transactional
public class TransportFeeDaoImp implements TransportFeeDao {
	
	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	@Override
	public List<TransportRoutePickUp> loadTransportStructures() {
		Query query = entityManager.createQuery("FROM TransportRoutePickUp f order by f.pickUpMasterId");
		return query.getResultList();
	}

	@Override
	public void updateTransportFee(TransportRoutePickUp feeTransport) {
		// TODO Auto-generated method stub
		
	}

}
