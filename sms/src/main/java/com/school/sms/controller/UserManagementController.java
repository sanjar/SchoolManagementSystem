package com.school.sms.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.school.sms.model.Student;
import com.school.sms.service.UserManagementService;

@Controller
public class UserManagementController {
	
	@Resource(name = "userManagementService")
	private UserManagementService userManagementService;

	@RequestMapping(value = "/admin/userManagement/manageStudent**", method = RequestMethod.GET)
	public ModelAndView manageStudent() {

		ModelAndView modelAndView = new ModelAndView("manageStudent", "command",
				new Student());
		return modelAndView;

	}
	@RequestMapping(value = "/admin/userManagement/manageStudent", method = RequestMethod.POST)
	public ModelAndView manageStudent(@ModelAttribute("student")Student student,
			@RequestParam(value = "action",required = false) String action,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("manageStudent", "command",
				student);
		if("search".equalsIgnoreCase(action)){
			Student student1= userManagementService.findStudent((String)request.getParameter("enrolementNo"));
			if(null==student1){
				modelAndView = new ModelAndView("manageStudent","command",student);
				modelAndView.addObject("noStudentFound",true);
				student1= new Student();
			}
			
			else{
				modelAndView = new ModelAndView("manageStudent","command",student1);
				
			}
		}
		else if("save".equalsIgnoreCase(action)) {
			student.setStatus(true);
			if(null==student.getEnrolementNo() || student.getEnrolementNo().isEmpty()){
				createEnrolementNo(student);
			}
			
			userManagementService.updateStudent(student);
			modelAndView.addObject("studentSaved",true);
			
		}
		
		else if("deactivate".equalsIgnoreCase(action)) {
			userManagementService.deactivateStudent(student);
			
			modelAndView = new ModelAndView("manageStudent","command",student);
			modelAndView.addObject("studentDeactivated",true);
		}
		
		else if("reset".equalsIgnoreCase(action)) {
			modelAndView = new ModelAndView("manageStudent","command",new Student());
		}

	
	//	modelAndView.setViewName("fixed-fees");
		
		
		return modelAndView;

	}
	
	
	private void createEnrolementNo(Student student) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/DD/YYYY");
			dateFormat.parse(student.getDateOfAdmission());
			String  enrolementNo= dateFormat.getCalendar().get(Calendar.YEAR) + "/"+	student.getCurrentClassBatch().charAt(0)+student.getCurrentClassSection()+"/"+student.getRoll();
			student.setEnrolementNo(enrolementNo);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "admin/userManagement", method = RequestMethod.GET)
	public ModelAndView userManagement() {

		ModelAndView model = new ModelAndView();
		/*
		 * model.addObject("title", "Spring Security Custom Login Form");
		 * model.addObject("message", "This is protected page!");
		 */

		model.setViewName("userManagement");

		return model;

	}
}
