package com.school.sms.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.school.sms.constants.Constants;
import com.school.sms.model.StudentFeeDetails;
import com.school.sms.service.ReportService;

@Controller
public class SettingsController {
	
	List<StudentFeeDetails> studentFixedFeeDetails = new ArrayList<StudentFeeDetails>();
	Set<String> batchList;
	Set<String> sessionList;
	
	@Resource(name = "reportService")
	private ReportService reportService;
	
	@RequestMapping(value = "/admin/settings", method = RequestMethod.GET)
	public ModelAndView generateReport(HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		
		studentFixedFeeDetails = reportService.loadStudentFixedFeeDetailsList();
		
		getBatchAndSessionList();
		model.addObject("batchList", batchList);
		model.addObject("sessionList", sessionList);
		model.addObject("monthList", Arrays.asList(Constants.MONTH_ARRAY));
		model.setViewName("settings");

		return model;

	}

	@RequestMapping(value = "/admin/settings", method = RequestMethod.POST)
	public ModelAndView saveSettings(HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		request.getSession().setAttribute("currentSavedSession",request.getParameter("session"));
		model.addObject("sessionSaved",true);
		model.addObject("batchList", batchList);
		model.addObject("sessionList", sessionList);
		model.addObject("monthList", Arrays.asList(Constants.MONTH_ARRAY));
		model.setViewName("settings");

		return model;

	}
	private void getBatchAndSessionList() {
		batchList = new HashSet<String>();
		sessionList = new HashSet<String>();
		for(StudentFeeDetails detail: studentFixedFeeDetails){
			batchList.add(detail.getBatch());
			sessionList.add(detail.getSession());
		}
		Calendar now = Calendar.getInstance();
	    int year = now.get(Calendar.YEAR);
		String currentSession = String.valueOf(year)+"-" + String.valueOf(year+1);
		if(!sessionList.contains(currentSession)){
			sessionList.add(currentSession);
		}
	}
}
