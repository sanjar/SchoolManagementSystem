package com.school.sms.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
import com.school.sms.model.OtherPayments;
import com.school.sms.model.PurchaseReceipt;
import com.school.sms.model.SalesReceipt;
import com.school.sms.model.Student;
import com.school.sms.model.StudentFeeDetails;
import com.school.sms.model.TransportRoutePickUp;
import com.school.sms.service.FeeManagementService;
import com.school.sms.service.PurchaseService;
import com.school.sms.service.ReportService;
import com.school.sms.service.TransportManagementService;

@Controller
public class ReportGenerationController {

	List<StudentFeeDetails> studentFixedFeeDetails = new ArrayList<StudentFeeDetails>();
	Set<String> batchList;
	Set<String> sessionList;
	Map<String,String> enrolementFatherMap;
	List<TransportRoutePickUp> pickUps = new ArrayList<TransportRoutePickUp>();
	
	@Resource(name = "reportService")
	private ReportService reportService;
	
	@Resource(name = "feeManagementService")
	private FeeManagementService fixedFee;
	
	@Resource(name = "transportManagementService")
	private TransportManagementService transportService;
	
	@Resource(name = "purchaseService")
	private PurchaseService purchaseService;
	
	@RequestMapping(value = "/admin/generateReport**", method = RequestMethod.GET)
	public ModelAndView generateReport(HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		
		studentFixedFeeDetails = reportService.loadStudentFixedFeeDetailsList();
		pickUps = transportService.loadTransportStructures();
		
		getBatchAndSessionList();
		model.addObject("batchList", batchList);
		model.addObject("sessionList", sessionList);
		model.addObject("routeCodeList", transportService.loadTransportRouteCodeList());
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
	public ModelAndView processReport(HttpServletRequest request) throws ParseException {
		ModelAndView model = new ModelAndView();
		if(request.getParameter("action").equalsIgnoreCase("view")){
	        if("feeCollectionRequest".equalsIgnoreCase(request.getParameter("feeCollectionRequest"))){
	        	model.addObject("feeCollectionRequest", "feeCollectionRequest");
	        	model.addObject("studentFixedFeeDetails", studentFixedFeeDetails);
	        	model.addObject("enrolementFatherMap", enrolementFatherMap);
	        	model.addObject("month", request.getParameter("month"));
	        	model.addObject("session", request.getParameter("session"));
	        	model.addObject("batch", request.getParameter("batch"));
	        }
	        else if("feeCollectionRequestDateWise".equalsIgnoreCase(request.getParameter("feeCollectionRequestDateWise"))){
	        	model.addObject("feeCollectionRequestDateWise", "feeCollectionRequestDateWise");
	        	model.addObject("fromDate", request.getParameter("fromDate"));
	        	model.addObject("toDate", request.getParameter("toDate"));
	        	model.addObject("studentFixedFeeDetails", studentFixedFeeDetails);
	        	model.addObject("fixedFeeList", fixedFee.loadFeeStructures());
	        }
	        else if("feeCollectionDateSessionBatchWise".equalsIgnoreCase(request.getParameter("feeCollectionType"))){
	        	model.addObject("fromDate", request.getParameter("fromDate"));
	        	model.addObject("toDate", request.getParameter("toDate"));
	        	
				model.addObject(
						"feeCollectionDateSessionBatchWiseList",
						getFeeCollectionDateSessionBatchWiseList(
								request.getParameter("fromDate"),
								request.getParameter("toDate"),
								request.getParameter("session"),
								request.getParameter("batch")));
	        	model.addObject("session", request.getParameter("session"));
	        	model.addObject("batch", request.getParameter("batch"));
	        	model.addObject("feeCollectionType", "feeCollectionDateSessionBatchWise");
	        }
	        else if("transportfeePending".equalsIgnoreCase(request.getParameter("reportType"))){
	        	model.addObject("reportType", "transportfeePending");
	        	
	        	List<StudentFeeDetails> details=getstudentFixedFeeDetailsList(request.getParameter("routeCode"),request.getParameter("session"),request.getParameter("month"));
	        	model.addObject("studentFixedFeeDetails", details);
	        	model.addObject("enrolementFatherMap", enrolementFatherMap);
	        	model.addObject("month", request.getParameter("month"));
	        }
	        
	        else if("dayBook".equalsIgnoreCase(request.getParameter("reportType"))){
	        	model.addObject("reportType", "dayBook");
	        	Double totalFeeCollection =0.00;
	        	String date = request.getParameter("dayBookDate");
	        	for(StudentFeeDetails details: studentFixedFeeDetails){
	        		if(details.getDateOfPayment().equals(date) && null != details.getAmountReceived()){
	        			totalFeeCollection = totalFeeCollection + details.getAmountReceived();
	        		}
	        	}
	        	model.addObject("totalFeeCollection", totalFeeCollection);
	        	
	        	List<PurchaseReceipt> purchaseReceipts = purchaseService.loadPurchaseReceipts();
	        	Double totalPurchaseAmount=0.00;
	        	for(PurchaseReceipt receipt : purchaseReceipts){
	        		if(receipt.getReceiptDate().equals(date) && null!=receipt.getNetValue()){
	        			totalPurchaseAmount=totalPurchaseAmount+receipt.getNetValue();
	        		}
	        	}
	        	
	        	model.addObject("totalPurchaseAmount", totalPurchaseAmount);
	        	
	        	List<SalesReceipt> salesReceipts = purchaseService.loadSalesReceipts();
	        	Double totalSalesAmount=0.00;
	        	for(SalesReceipt receipt : salesReceipts){
	        		if(receipt.getChallanDate().equals(date) && null!=receipt.getNetValue()){
	        			totalSalesAmount=totalSalesAmount+receipt.getNetValue();
	        		}
	        	}
	        	model.addObject("totalSalesAmount", totalSalesAmount);
	        	
	        	List<OtherPayments> otherPayments = fixedFee.loadOtherPayments();
	        	Double totalOtherPaymentsAmount=0.00;
	        	for(OtherPayments payment : otherPayments){
	        		if(payment.getPaymentDate().equals(date) && null!=payment.getPaymentAmount()){
	        			totalOtherPaymentsAmount=totalOtherPaymentsAmount+payment.getPaymentAmount();
	        		}
	        	}
	        	model.addObject("totalOtherPaymentsAmount", totalOtherPaymentsAmount);
	        	model.addObject("date", date);
	        	//model.addObject("totalOtherPaymentsAmount", totalOtherPaymentsAmount);
	        }
	        
		}
      /*  request.getParameter("session");
        request.getParameter("batch");
        request.getParameter("month");*/
        
        
		
		

		model.setViewName("pdfView");

		return model;

	}

	private List<StudentFeeDetails> getstudentFixedFeeDetailsList(String batch,
			String session, String month) {
		List<StudentFeeDetails> details = new ArrayList<StudentFeeDetails>();
		for(StudentFeeDetails f: studentFixedFeeDetails){
			if(session.equalsIgnoreCase(f.getSession()) && month.equalsIgnoreCase(f.getMonth()) && batch.equalsIgnoreCase(f.getBatch())){
				details.add(f);
			}
		}
		
		return details;
		
	}

	private Integer getRouteCode(Integer pickUpMasterId) {
		for(TransportRoutePickUp pickUp : pickUps){
			if(pickUp.getPickUpMasterId().equals(pickUpMasterId)){
				return pickUp.getRouteCode();
			}
		}
		return -1;
	}

	private List<StudentFeeDetails> getFeeCollectionDateSessionBatchWiseList(String fromDate,
			String toDate, String session, String batch) throws ParseException {
		
		List<StudentFeeDetails> list = new ArrayList<StudentFeeDetails>();
		SimpleDateFormat format = new SimpleDateFormat("DD/MM/YYYY");
		Date fromDate1 = format.parse(fromDate);
		Date toDate1 = format.parse(toDate);
		for(StudentFeeDetails detail: studentFixedFeeDetails){
			if (!detail.getDateOfPayment().isEmpty()
					&& fromDate1.compareTo(format.parse(detail
							.getDateOfPayment())) <= 0
					&& toDate1
							.compareTo(format.parse(detail.getDateOfPayment())) >= 0) {
				if(detail.getSession().equals(session) && detail.getBatch().equalsIgnoreCase(batch)){
					list.add(detail);
				}

			}
		}
		return list;
	}
	
}
