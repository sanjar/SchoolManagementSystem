package com.school.sms.dao;

import java.util.List;

import com.school.sms.model.TransportRoute;
import com.school.sms.model.TransportRoutePickUp;
import com.school.sms.model.TransportVehicle;

public interface TransportFeeDao {
   
	public List<TransportRoutePickUp> loadTransportStructures();
	
	public TransportRoutePickUp updateTransportRoutePickUpMaster(
			TransportRoutePickUp transportRoutePickUp);
	public void deleteTransportRoutePickUpIndex(
			TransportRoutePickUp transportRoutePickUp);
	public TransportRoutePickUp findTransportRoutePickUp(Integer routeCode,
			Integer pickUpId, String pickUpName, Integer vehicleId,
			String pickUpTime);

	public List<TransportRoute> loadTransportRouteCodeList();

	public List<TransportVehicle> loadTransportVehicleListList();
}
