package com.school.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.school.sms.dao.TransportFeeDao;
import com.school.sms.model.TransportRoute;
import com.school.sms.model.TransportRoutePickUp;
import com.school.sms.model.TransportVehicle;
import com.school.sms.service.TransportManagementService;

@Service("transportManagementService")
public class TransportManagementServiceImp implements TransportManagementService {

	@Resource(name = "transportDaoService")
	private TransportFeeDao transportFeeDao;
	
	@Override
	public List<TransportRoutePickUp> loadTransportStructures() {
		return transportFeeDao.loadTransportStructures();
	}

	@Override
	public TransportRoutePickUp updateTransportRoutePickUpMaster(
			TransportRoutePickUp transportRoutePickUp) {
		return transportFeeDao.updateTransportRoutePickUpMaster(transportRoutePickUp);
		
	}

	@Override
	public void deleteTransportRoutePickUpIndex(
			TransportRoutePickUp transportRoutePickUp) {
		transportFeeDao.deleteTransportRoutePickUpIndex(transportRoutePickUp);
		
	}



	@Override
	public List<TransportRoute> loadTransportRouteCodeList() {
		return transportFeeDao.loadTransportRouteCodeList();
	}

	@Override
	public List<TransportVehicle> loadTransportVehicleListList() {
		return transportFeeDao.loadTransportVehicleListList();
	}

	@Override
	public TransportRoutePickUp findTransportRoutePickUp(Integer routeCode,
			Integer pickUpId, String pickUpName, Integer vehicleId,
			String pickUpTime) {
		return transportFeeDao.findTransportRoutePickUp(routeCode,pickUpId,pickUpName,vehicleId,pickUpTime);
	}

}
