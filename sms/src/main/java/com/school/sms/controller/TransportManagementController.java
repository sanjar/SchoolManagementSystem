package com.school.sms.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.school.sms.constants.Constants;
import com.school.sms.model.Customer;
import com.school.sms.model.Department;
import com.school.sms.model.TransportRoute;
import com.school.sms.model.TransportRoutePickUp;
import com.school.sms.model.TransportVehicle;
import com.school.sms.model.VariableFeeBatchYearMonth;
import com.school.sms.service.TransportManagementService;


@Controller
public class TransportManagementController {
	
	@Resource(name = "transportManagementService")
	private TransportManagementService transportService;
	
	private List<TransportRoutePickUp> transportRoutePickUpList = new ArrayList<TransportRoutePickUp>();
	private List<TransportRoute> routeCodeList = new ArrayList<TransportRoute>();
	private List<TransportVehicle> vehicleList = new ArrayList<TransportVehicle>();
	
	private Integer transportRoutePickUpIndex;
	
	@RequestMapping(value = "admin/transportManagement", method = RequestMethod.GET)
	public ModelAndView feeManagement() {

		
		ModelAndView model = new ModelAndView();
		/*
		 * model.addObject("title", "Spring Security Custom Login Form");
		 * model.addObject("message", "This is protected page!");
		 */

		this.transportRoutePickUpList=transportService.loadTransportStructures();

		model.addObject("listTransportStructure", transportRoutePickUpList);
		
		model.setViewName("transportManagement");

		return model;

	}
	/*@RequestMapping(value = "/admin/manageTransportFee", method = RequestMethod.POST)
	public ModelAndView manageVariableFeeStructure() {
		List<TransportRoutePickUp> list = transportService.loadTransportStructures();
		if (null != list) {
			this.transporManageFeeList= list;
		}
		ModelAndView modelAndView = new ModelAndView("transport-fees", "command",
				new TransportRoutePickUp());
		
		 * model.addObject("title", "Spring Security Custom Login Form");
		 * model.addObject("message", "This is protected page!");
		 
	
		modelAndView.addObject("TransportManagementFee",this.transporManageFeeList);
			// model.setViewName("fixed-fees");

		return modelAndView;

	}*/
	
	@RequestMapping(value = "/admin/transportManagement/manageTransportFee", method = RequestMethod.GET)
	public ModelAndView manageCustomer() {
		transportRoutePickUpIndex=-1;
		
		ModelAndView model = new ModelAndView("transport-fees","command",new TransportRoutePickUp());
		
		initializeTransportRoutePickUpList();

		model.addObject("listTransportStructure", transportRoutePickUpList);
		model.addObject("routeCodeList", routeCodeList);
		model.addObject("vehicleList", vehicleList);
		//model.setViewName("purchase_form");

		return model;

	}
	
	private void initializeTransportRoutePickUpList() {
		this.transportRoutePickUpList=transportService.loadTransportStructures();
		this.routeCodeList= transportService.loadTransportRouteCodeList();
		this.vehicleList= transportService.loadTransportVehicleListList();
		
	}
	
	public boolean isNumeric(String s) {  
	    return s.matches("[-+]?\\d*\\.?\\d+");  
	}  
	
	@RequestMapping(value = "/admin/transportManagement/manageTransportFee", method = RequestMethod.POST)
	public ModelAndView manageTransportFee(@ModelAttribute("transportRoutePickUp")TransportRoutePickUp transportRoutePickUp,
			@RequestParam(value = "action",required = false) String action,HttpServletRequest request) {
		ModelAndView modelAndView;
		if("new".equalsIgnoreCase(action)){
			modelAndView = new ModelAndView("transport-fees","command",new TransportRoutePickUp());
		}
		else if("search".equalsIgnoreCase(action)){
			Integer routeCode= Integer.valueOf(request.getParameter("routeCode"));
			Integer pickUpId= isNumeric(request.getParameter("pickUpId"))? Integer.valueOf(request.getParameter("pickUpId")):null;
			String pickUpName= (String)(request.getParameter("pickUpName"));
			Integer vehicleId= isNumeric(request.getParameter("vehicleId"))?Integer.valueOf(request.getParameter("vehicleId")):null;
			String pickUpTime= (String)(request.getParameter("pickUpTime"));
			if(routeCode!=-1 && pickUpId!=null && vehicleId !=null && vehicleId!=-1){
				TransportRoutePickUp transportRoutePickUp2 = transportService
						.findTransportRoutePickUp(routeCode,pickUpId,pickUpName,vehicleId,pickUpTime);
				if(null==transportRoutePickUp2){
					modelAndView = new ModelAndView("transport-fees","command",transportRoutePickUp);
					modelAndView.addObject("noTransportRoutePickUpFound",true);
					
				}
				else{
				modelAndView = new ModelAndView("transport-fees","command",transportRoutePickUp2);
				transportRoutePickUpIndex = getExacttransportRoutePickUpIndex(transportRoutePickUp2);
				}
			}
			else{
				modelAndView = new ModelAndView("transport-fees","command",transportRoutePickUp);
				modelAndView.addObject("isFormIncomplete",true);
			}
						
		}
		else if("save".equalsIgnoreCase(action)) {
			if (null != transportRoutePickUp.getRouteCode()
					&& !transportRoutePickUp.getPickUpId().isEmpty()
					&& null!=transportRoutePickUp.getVehicleId()
					&& !transportRoutePickUp.getPickUpTime().isEmpty()) {
			TransportRoutePickUp pickup= transportService.updateTransportRoutePickUpMaster(transportRoutePickUp);
			initializeTransportRoutePickUpList();
			modelAndView = new ModelAndView("transport-fees","command",pickup);
			transportRoutePickUpIndex = getExacttransportRoutePickUpIndex(pickup);
			modelAndView.addObject("transportRoutePickUpSaved",true);
			}
			else{
				modelAndView = new ModelAndView("transport-fees","command",transportRoutePickUp);
				modelAndView.addObject("isFormIncomplete",true);
			}
		}
		
		else if("delete".equalsIgnoreCase(action)) {
			transportService.deleteTransportRoutePickUpIndex(transportRoutePickUp);
			initializeTransportRoutePickUpList();
			modelAndView = new ModelAndView("transport-fees","command",new TransportRoutePickUp());
			transportRoutePickUpIndex= transportRoutePickUpIndex-1;
			modelAndView.addObject("transportRoutePickUpDeleted",true);
		}
		
		else if("next".equalsIgnoreCase(action)) {
			modelAndView = new ModelAndView("transport-fees","command",this.transportRoutePickUpList.get(++transportRoutePickUpIndex));
		}
		else if("previous".equalsIgnoreCase(action)) {
			modelAndView = new ModelAndView("transport-fees","command",this.transportRoutePickUpList.get(--transportRoutePickUpIndex));
		}
		else if("first".equalsIgnoreCase(action)) {
			transportRoutePickUpIndex =0;
			modelAndView = new ModelAndView("transport-fees","command",this.transportRoutePickUpList.get(transportRoutePickUpIndex));
		}
		else if("last".equalsIgnoreCase(action)) {
			transportRoutePickUpIndex =this.transportRoutePickUpList.size()-1;
			modelAndView = new ModelAndView("transport-fees","command",this.transportRoutePickUpList.get(transportRoutePickUpIndex));
		}
		else{
			modelAndView = new ModelAndView("transport-fees","command",transportRoutePickUp);
		}
		if(transportRoutePickUpIndex==this.transportRoutePickUpList.size()-1){
			modelAndView.addObject("disableNext", true);
		}
		if(transportRoutePickUpIndex<=0){
			modelAndView.addObject("disablePrevious", true);
		}
		modelAndView.addObject("listTransportStructure", transportRoutePickUpList);
		modelAndView.addObject("routeCodeList", routeCodeList);
		modelAndView.addObject("vehicleList", vehicleList);
		return modelAndView;

	}
	
	private Integer getExacttransportRoutePickUpIndex(TransportRoutePickUp transportRoutePickUp) {
		int i=0;
		for(TransportRoutePickUp routePickUp : transportRoutePickUpList){
			if(routePickUp.equals(transportRoutePickUp)){
				return i;
			}
			i++;
		}
		return 0;
	}
}
