package com.school.sms.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.school.sms.constants.Constants;
import com.school.sms.model.DiscountsAndConcessions;
import com.school.sms.model.FixedFeeBatchYearMonth;
import com.school.sms.model.VariableFeeBatchYearMonth;
import com.school.sms.service.FeeManagementService;

@Controller
public class FeeManagementController {

	@Resource(name = "feeManagementService")
	private FeeManagementService feeService;

	private Set<String> sessionList = new TreeSet<String>();
	private Set<Integer> batchList = new TreeSet<Integer>();
	private Set<String> monthList = new TreeSet<String>();
	private Set<String> studentNameClassRollList = new TreeSet<String>();
	private Boolean isAllSessionMonthBatchListPopulated = false;
	private Boolean isAllVariableSessionMonthBatchListPopulated = false;
	private List<FixedFeeBatchYearMonth> fixedFeeStructureList = new ArrayList<FixedFeeBatchYearMonth>();
	private List<VariableFeeBatchYearMonth> variableFeeStructureList = new ArrayList<VariableFeeBatchYearMonth>();

	private List<DiscountsAndConcessions> discountsAndConcessionList;
	private Set<String> studentNameClassRollDiscountList = new TreeSet<String>();
	private boolean isAllDiscountsAndConcessionListPopulated;

	@RequestMapping(value = "admin/feeManagement", method = RequestMethod.GET)
	public ModelAndView feeManagement() {

		ModelAndView model = new ModelAndView();
		/*
		 * model.addObject("title", "Spring Security Custom Login Form");
		 * model.addObject("message", "This is protected page!");
		 */

		List<FixedFeeBatchYearMonth> list = feeService.loadFeeStructures();
		if (null != list) {
			this.fixedFeeStructureList = list;
		}

		model.addObject("listFixedFeeStructure", list);
		model.setViewName("feeManagement");

		return model;

	}

	@RequestMapping(value = "/admin/manageVariableFee", method = RequestMethod.GET)
	public ModelAndView manageVariableFeeStructure() {
		List<VariableFeeBatchYearMonth> list = feeService.loadVariableFeeStructures();
		if (null != list) {
			this.variableFeeStructureList= list;
		}
		ModelAndView modelAndView = new ModelAndView("variable-fees", "command",
				new VariableFeeBatchYearMonth());
		/*
		 * model.addObject("title", "Spring Security Custom Login Form");
		 * model.addObject("message", "This is protected page!");
		 */
		if (!isAllVariableSessionMonthBatchListPopulated) {
			populateVariableSessionBatchMonthLists();
		}
		modelAndView.addObject("sessionList", Arrays.asList(Constants.SESSION_ARRAY));
		modelAndView.addObject("batchList", Arrays.asList(Constants.BATCH_ARRAY));
		modelAndView.addObject("monthList", Arrays.asList(Constants.YEAR_ARRAY));
		modelAndView.addObject("studentNameClassRollList", this.studentNameClassRollList);
		// model.setViewName("fixed-fees");

		return modelAndView;

	}
	
	@RequestMapping(value = "/admin/processVariableFee", method = RequestMethod.POST)
	public ModelAndView processVariableFee(@ModelAttribute("variableFee")VariableFeeBatchYearMonth variableFee,
			@RequestParam(value = "action",required = false) String action,HttpServletRequest request) {
		ModelAndView modelAndView;
		if("search".equalsIgnoreCase(action)){
			VariableFeeBatchYearMonth fee= feeService.findVariableFee((String)request.getParameter("session"), 
					String.valueOf(request.getParameter("batch")), (String)request.getParameter("month"),(String)request.getParameter("studentNameClassRoll"));
			boolean noVariableFeeStructureFound=false;
			if(null==fee){
				noVariableFeeStructureFound=true;
				fee= new VariableFeeBatchYearMonth();
			}
			modelAndView = new ModelAndView("variable-fees","command",fee);
			if(noVariableFeeStructureFound){
				modelAndView.addObject("noFeeStructureFound",noVariableFeeStructureFound);
			}
			
		}
		else if("save".equalsIgnoreCase(action)) {
			modelAndView = new ModelAndView("variable-fees","command",variableFee);
			feeService.updateVariableFee(variableFee);
			isAllVariableSessionMonthBatchListPopulated=false;
		}
		else{
			modelAndView = new ModelAndView("variable-fees","command",variableFee);
		}
		
		
		if(!isAllVariableSessionMonthBatchListPopulated){
			populateVariableSessionBatchMonthLists();
		}
		modelAndView.addObject("sessionList", Arrays.asList(Constants.SESSION_ARRAY));
		modelAndView.addObject("batchList", Arrays.asList(Constants.BATCH_ARRAY));
		modelAndView.addObject("monthList", Arrays.asList(Constants.YEAR_ARRAY));
		modelAndView.addObject("studentNameClassRollList", this.studentNameClassRollList);
	//	modelAndView.setViewName("fixed-fees");
		
		
		return modelAndView;

	}
	
	
	
	private void populateVariableSessionBatchMonthLists() {
		for (VariableFeeBatchYearMonth row : this.variableFeeStructureList) {
			this.studentNameClassRollList.add(row.getStudentNameClassRoll());
			this.isAllVariableSessionMonthBatchListPopulated= true;
		}
		
	}

	@RequestMapping(value = "/admin/manageFixedFee**", method = RequestMethod.GET)
	public ModelAndView manageFixedFeeStructure() {

		ModelAndView model = new ModelAndView("fixed-fees", "command",
				new FixedFeeBatchYearMonth());
		/*
		 * model.addObject("title", "Spring Security Custom Login Form");
		 * model.addObject("message", "This is protected page!");
		 */
		if (!isAllSessionMonthBatchListPopulated) {
			populateSessionBatchMonthLists();
		}
		model.addObject("sessionList", this.sessionList);
		model.addObject("batchList", this.batchList);
		model.addObject("monthList", this.monthList);
		// model.setViewName("fixed-fees");

		return model;

	}

	@RequestMapping(value = "/admin/processFixedFee**", method = RequestMethod.POST)
	public ModelAndView processFixedFee(@ModelAttribute("fixedFee")FixedFeeBatchYearMonth fixedFee,
			@RequestParam(value = "action",required = false) String action,HttpServletRequest request) {
		ModelAndView modelAndView;
		if("search".equalsIgnoreCase(action)){
			FixedFeeBatchYearMonth fee= feeService.findFixedFee((String)request.getParameter("session"), Integer.valueOf(request.getParameter("batchId")), (String)request.getParameter("month"));
			boolean noFeeStructureFound=false;
			if(null==fee){
				noFeeStructureFound=true;
				fee= new FixedFeeBatchYearMonth();
			}
			modelAndView = new ModelAndView("fixed-fees","command",fee);
			if(noFeeStructureFound){
				modelAndView.addObject("noFeeStructureFound",noFeeStructureFound);
			}
			
		}
		else if("save".equalsIgnoreCase(action)) {
			modelAndView = new ModelAndView("fixed-fees","command",fixedFee);
			feeService.updateFixedFee(fixedFee);
			isAllSessionMonthBatchListPopulated=false;
		}
		else{
			modelAndView = new ModelAndView("fixed-fees","command",fixedFee);
		}
		
		/*
		 * model.addObject("title", "Spring Security Custom Login Form");
		 * model.addObject("message", "This is protected page!");
		 */
		if(!isAllSessionMonthBatchListPopulated){
			populateSessionBatchMonthLists();
		}
		modelAndView.addObject("sessionList", this.sessionList);
		modelAndView.addObject("batchList", this.batchList);
		modelAndView.addObject("monthList", this.monthList);
	//	modelAndView.setViewName("fixed-fees");
		
		
		return modelAndView;

	}

	private void populateSessionBatchMonthLists() {
		for (FixedFeeBatchYearMonth row : this.fixedFeeStructureList) {
			this.sessionList.add(row.getSession());
			this.batchList.add(row.getBatchId());
			this.monthList.add(row.getMonth());
			this.isAllSessionMonthBatchListPopulated = true;
		}

	}

	
	@RequestMapping(value = "/admin/manageDiscountsAndConcessions", method = RequestMethod.GET)
	public ModelAndView manageDiscountsAndConcessions() {
		List<DiscountsAndConcessions> list = feeService.loadDiscountsAndConcession();
		if (null != list) {
			this.discountsAndConcessionList= list;
		}
		ModelAndView modelAndView = new ModelAndView("discountsAndConcessions", "command",
				new DiscountsAndConcessions());
		/*
		 * model.addObject("title", "Spring Security Custom Login Form");
		 * model.addObject("message", "This is protected page!");
		 */
		if (!isAllDiscountsAndConcessionListPopulated) {
			populateDiscountsAndConcessionStudentLists();
		}
		modelAndView.addObject("sessionList", Arrays.asList(Constants.SESSION_ARRAY));
		modelAndView.addObject("batchList", Arrays.asList(Constants.BATCH_ARRAY));
		modelAndView.addObject("monthList", Arrays.asList(Constants.YEAR_ARRAY));
		modelAndView.addObject("studentNameClassRollList", this.studentNameClassRollDiscountList);
		// model.setViewName("fixed-fees");

		return modelAndView;

	}
	
	private void populateDiscountsAndConcessionStudentLists() {
		for (DiscountsAndConcessions row : this.discountsAndConcessionList) {
			this.studentNameClassRollDiscountList.add(row.getStudentNameClassRoll());
			this.isAllDiscountsAndConcessionListPopulated= true;
		}
		
	}

	@RequestMapping(value = "/admin/processDiscountsAndConcessions", method = RequestMethod.POST)
	public ModelAndView processDiscountsAndConcessions(@ModelAttribute("discountsAndConcession")DiscountsAndConcessions discountsAndConcession,
			@RequestParam(value = "action",required = false) String action,HttpServletRequest request) {
		ModelAndView modelAndView;
		if("search".equalsIgnoreCase(action)){
			DiscountsAndConcessions discounts= feeService.findDiscountsAndConcession((String)request.getParameter("session"), 
					String.valueOf(request.getParameter("batch")), (String)request.getParameter("month"),(String)request.getParameter("studentNameClassRoll"));
			boolean noDiscountsAndConcessionStructureFound=false;
			if(null==discounts){
				noDiscountsAndConcessionStructureFound=true;
				discounts= new DiscountsAndConcessions();
			}
			modelAndView = new ModelAndView("discountsAndConcessions","command",discountsAndConcession);
			if(noDiscountsAndConcessionStructureFound){
				modelAndView.addObject("noFeeStructureFound",noDiscountsAndConcessionStructureFound);
			}
			
		}
		else if("save".equalsIgnoreCase(action)) {
			modelAndView = new ModelAndView("discountsAndConcessions","command",discountsAndConcession);
			feeService.updateDiscountsAndConcession(discountsAndConcession);
			isAllDiscountsAndConcessionListPopulated=false;
		}
		else{
			modelAndView = new ModelAndView("discountsAndConcessions","command",discountsAndConcession);
		}
		
		
		if(!isAllDiscountsAndConcessionListPopulated){
			populateDiscountsAndConcessionStudentLists();
		}
		modelAndView.addObject("sessionList", Arrays.asList(Constants.SESSION_ARRAY));
		modelAndView.addObject("batchList", Arrays.asList(Constants.BATCH_ARRAY));
		modelAndView.addObject("monthList", Arrays.asList(Constants.YEAR_ARRAY));
		modelAndView.addObject("studentNameClassRollList", this.discountsAndConcessionList);
	//	modelAndView.setViewName("fixed-fees");
		
		
		return modelAndView;

	}
	
	
	public List<FixedFeeBatchYearMonth> getFixedFeeStructureList() {
		return fixedFeeStructureList;
	}

	public Set<String> getSessionList() {
		return sessionList;
	}

	public Set<Integer> getBatchList() {
		return batchList;
	}

	public Set<String> getMonthList() {
		return monthList;
	}

	public List<VariableFeeBatchYearMonth> getVariableFeeStructureList() {
		return variableFeeStructureList;
	}

	public Set<String> getStudentNameClassRollDiscountList() {
		return studentNameClassRollDiscountList;
	}

}
