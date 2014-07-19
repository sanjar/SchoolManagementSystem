package com.school.sms.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.sms.dao.TransportFeeDao;
import com.school.sms.model.TransportRoute;
import com.school.sms.model.TransportRoutePickUp;
import com.school.sms.model.TransportVehicle;

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
	public TransportRoutePickUp updateTransportRoutePickUpMaster(
			TransportRoutePickUp transportRoutePickUp) {
		TransportRoutePickUp pickUp=  entityManager.merge(transportRoutePickUp);
		entityManager.flush();
		return pickUp;
	}

	@Override
	public void deleteTransportRoutePickUpIndex(
			TransportRoutePickUp transportRoutePickUp) {
		TransportRoutePickUp transportRoutePickUp2 = entityManager.find(TransportRoutePickUp.class,transportRoutePickUp.getPickUpMasterId());
		entityManager.remove(transportRoutePickUp2);
		entityManager.flush();
		
	}

	@Override
	public List<TransportRoute> loadTransportRouteCodeList() {
		Query query = entityManager.createQuery("FROM TransportRoute f order by f.routeCode");
		return query.getResultList();
	}

	@Override
	public List<TransportVehicle> loadTransportVehicleListList() {
		Query query = entityManager.createQuery("FROM TransportVehicle f order by f.vehicleId");
		return query.getResultList();
	}

	@Override
	public TransportRoutePickUp findTransportRoutePickUp(Integer routeCode,
			Integer pickUpId, String pickUpName, Integer vehicleId,
			String pickUpTime) {
String pickUpNameString = pickUpName.isEmpty()?"":" and t.pickUpName=" + "'"
		+ pickUpName + "'";
String pickTimeString = pickUpTime.isEmpty()? "":" and t.pickUpTime=" + "'"
		+ pickUpTime + "'";
		
		List list = entityManager.createQuery(
				"FROM TransportRoutePickUp t WHERE t.routeCode=" + "'"
						+ routeCode + "'" + " and t.pickUpId=" + "'"
						+ pickUpId + "'" + pickUpNameString + " and t.vehicleId=" + "'"
						+ vehicleId + "'" + pickTimeString).getResultList();
		if(list.size()>0){
			return (TransportRoutePickUp) list.get(0);
		}
		return null;
	}

	
}
