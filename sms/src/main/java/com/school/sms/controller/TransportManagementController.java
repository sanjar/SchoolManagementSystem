package com.school.sms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.school.sms.model.TransportRoutePickUp;
import com.school.sms.service.TransportManagementService;


@Controller
public class TransportManagementController {
	
	@Resource(name = "transportManagementService")
	private TransportManagementService transportService;
	
	private List<TransportRoutePickUp> transportStructureList = new ArrayList<TransportRoutePickUp>();
	
	@RequestMapping(value = "admin/transportManagement", method = RequestMethod.GET)
	public ModelAndView feeManagement() {

		ModelAndView model = new ModelAndView();
		/*
		 * model.addObject("title", "Spring Security Custom Login Form");
		 * model.addObject("message", "This is protected page!");
		 */

		List<TransportRoutePickUp> list = transportService.loadTransportStructures();
		if (null != list ) {
			this.transportStructureList = list;
		}

		model.addObject("listTransportStructure", list);
		model.setViewName("transportManagement");

		return model;

	}
}
