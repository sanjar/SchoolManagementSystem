package com.school.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.school.sms.dao.TransportFeeDao;
import com.school.sms.model.TransportRoutePickUp;
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
	public void updateTransportFee(TransportRoutePickUp feeTransport) {
		// TODO Auto-generated method stub
		
	}

}
