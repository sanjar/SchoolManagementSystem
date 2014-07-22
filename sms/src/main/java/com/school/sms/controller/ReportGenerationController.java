package com.school.sms.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.school.sms.constants.Constants;
import com.school.sms.model.Student;
import com.school.sms.model.StudentFeeDetails;
import com.school.sms.service.ReportService;

@Controller
public class ReportGenerationController {

	List<StudentFeeDetails> studentFixedFeeDetails = new ArrayList<StudentFeeDetails>();
	Set<String> batchList;
	Set<String> sessionList;
	Map<String,String> enrolementFatherMap;
	
	@Resource(name = "reportService")
	private ReportService reportService;
	
	@RequestMapping(value = "/admin/generateReport**", method = RequestMethod.GET)
	public ModelAndView generateReport(HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		
		studentFixedFeeDetails = reportService.loadStudentFixedFeeDetailsList();
		
		getBatchAndSessionList();
		model.addObject("batchList", batchList);
		model.addObject("sessionList", sessionList);
		model.addObject("monthList", Arrays.asList(Constants.MONTH_ARRAY));
		model.setViewName("reportGeneration");

		return model;

	}
	
	private void getBatchAndSessionList() {
		batchList = new HashSet<String>();
		sessionList = new HashSet<String>();
		enrolementFatherMap = new HashMap<String, String>();
		for(StudentFeeDetails detail: studentFixedFeeDetails){
			batchList.add(detail.getBatch());
			sessionList.add(detail.getSession());
			Student student =reportService.loadStudent(detail.getEnrolementNo());
			enrolementFatherMap.put(student.getEnrolementNo(), student.getFathername());
		}
		
	}

	@RequestMapping(value = "/admin/generateReport**", method = RequestMethod.POST)
	public ModelAndView processReport(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		if(request.getParameter("action").equalsIgnoreCase("view")){
	        if(request.getParameter("feeCollectionRequest").equalsIgnoreCase("feeCollectionRequest")){
	        	model.addObject("studentFixedFeeDetails", studentFixedFeeDetails);
	        	model.addObject("enrolementFatherMap", enrolementFatherMap);
	        	model.addObject("month", request.getParameter("month"));
	        }
		}
      /*  request.getParameter("session");
        request.getParameter("batch");
        request.getParameter("month");*/
        
        
		
		

		model.setViewName("pdfView");

		return model;

	}
	
}
