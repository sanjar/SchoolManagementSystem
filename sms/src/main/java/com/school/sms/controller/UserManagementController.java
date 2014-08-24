package com.school.sms.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
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
import com.school.sms.constants.Constants.UserType;
import com.school.sms.model.Student;
import com.school.sms.model.UserAuthenticationDetails;
import com.school.sms.service.UserManagementService;

@Controller
public class UserManagementController {
	
	@Resource(name = "userManagementService")
	private UserManagementService userManagementService;

	@RequestMapping(value = "/admin/userManagement/manageStudent**", method = RequestMethod.GET)
	public ModelAndView manageStudent() {

		ModelAndView modelAndView = new ModelAndView("manageStudent", "command",
				new Student());
		modelAndView.addObject("batchList", Arrays.asList(Constants.BATCH_ARRAY));
		return modelAndView;

	}
	
	@RequestMapping(value = "/admin/userManagement/manageAdminUsers", method = RequestMethod.GET)
	public ModelAndView manageAdminUsers() {

		ModelAndView modelAndView = new ModelAndView("manageAdminUsers", "command",
				new UserAuthenticationDetails());
		
		return modelAndView;

	}
	@RequestMapping(value = "/admin/userManagement/manageStudent", method = RequestMethod.POST)
	public ModelAndView manageStudent(@ModelAttribute("student")Student student,
			@RequestParam(value = "action",required = false) String action,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("manageStudent", "command",
				student);
		if("search".equalsIgnoreCase(action)){
			Student student1= userManagementService.findStudent((String)request.getParameter("searchEnrolementNo"));
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
			if(null==student.getRoll() || student.getRoll()==0){
				createRollNo(student);
			}
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
		
		modelAndView.addObject("batchList", Arrays.asList(Constants.BATCH_ARRAY));
		return modelAndView;

	}
	@RequestMapping(value = "/admin/userManagement/manageAdminUsers", method = RequestMethod.POST)
	public ModelAndView manageAdminUsers(@ModelAttribute("user")UserAuthenticationDetails user,
			@RequestParam(value = "action",required = false) String action,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("manageAdminUsers", "command",
				user);
		if("search".equalsIgnoreCase(action)){
			UserAuthenticationDetails user1= userManagementService.findUser((String)request.getParameter("userId"));
			if(null==user1){
				modelAndView = new ModelAndView("manageAdminUsers","command",user);
				modelAndView.addObject("noUserFound",true);
				user1= new UserAuthenticationDetails();
			}
			
			else{
				modelAndView = new ModelAndView("manageAdminUsers","command",user1);
				
			}
		}
		else if("save".equalsIgnoreCase(action)) {
			UserAuthenticationDetails user1= userManagementService.findUser((String)request.getParameter("userId"));
			if(user1==null){
			user.setEnabled("TRUE");
			user.setUserType(UserType.ADMIN.toString());			
			userManagementService.updateUser(user);
			userManagementService.updateUserRoles(user.getUserId(),"ROLE_ADMIN");
			modelAndView.addObject("userSaved",true);
			}
			else{
				modelAndView.addObject("userAlreadyExists",true);
			}
			
		}
		
		else if("deactivate".equalsIgnoreCase(action)) {
			userManagementService.deactivateUser(user);
			
			modelAndView = new ModelAndView("manageAdminUsers","command",user);
			modelAndView.addObject("userDeactivated",true);
		}
		
		else if("reset".equalsIgnoreCase(action)) {
			modelAndView = new ModelAndView("manageAdminUsers","command",new UserAuthenticationDetails());
		}
		return modelAndView;

	}
	
	
	private void createRollNo(Student student) {
		Integer maxRoll = userManagementService.getMaxRollInClassAndSection(student.getCurrentClassBatch(),student.getCurrentClassSection());
		student.setRoll(maxRoll+1);
		
	}
	private void createEnrolementNo(Student student) {
		//	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/DD/YYYY");
		//	dateFormat.parse(student.getDateOfAdmission());
			String  enrolementNo= Calendar.getInstance().get(Calendar.YEAR) + "/"+	student.getCurrentClassBatch().charAt(0)+student.getCurrentClassSection()+"/"+student.getRoll();
			student.setEnrolementNo(enrolementNo);
		
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
