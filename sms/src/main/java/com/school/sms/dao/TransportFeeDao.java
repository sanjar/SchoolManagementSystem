package com.school.sms.dao;

import java.util.List;

import com.school.sms.model.TransportRoutePickUp;

public interface TransportFeeDao {
    public void updateTransportFee(TransportRoutePickUp feeTransport);
	public List<TransportRoutePickUp> loadTransportStructures();
}
