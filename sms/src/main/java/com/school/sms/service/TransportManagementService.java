package com.school.sms.service;

import java.util.List;

import com.school.sms.model.TransportRoutePickUp;

public interface TransportManagementService {
	public List<TransportRoutePickUp> loadTransportStructures();
    public void updateTransportFee(TransportRoutePickUp feeTransport);

}
