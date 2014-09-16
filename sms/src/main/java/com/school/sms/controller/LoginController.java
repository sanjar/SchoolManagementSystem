package com.school.sms.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is welcome page!");
		model.setViewName("hello");
		return model;

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage(HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");

		return model;

	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public View homePage(HttpServletRequest request) {
		String userType = (String) request.getSession().getAttribute("userType");
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		String currentSession = String.valueOf(year)+"-" + String.valueOf(year+1);
		if("Admin".equalsIgnoreCase(userType)){
			request.getSession().setAttribute("currentSavedSession",currentSession);
			return new RedirectView("/sms/admin");
		}
		if("User".equalsIgnoreCase(userType)){
			request.getSession().setAttribute("currentSavedSession",currentSession);
			return new RedirectView("/sms/user");
		}
		return new RedirectView("/sms/login");

	}
	@RequestMapping(value = "/user**", method = RequestMethod.GET)
	public ModelAndView userPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is protected page!");
		model.setViewName("user");

		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
			
		}
		if(request.getParameterMap().keySet().contains("accountDisabled")){
				model.addObject("error", "Account Disabled");
		}
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
			model.setViewName("logout");
			return model;
		}
		if (request.getSession().getAttribute("user_type") != null) {
			model.addObject("user_type", request.getSession().getAttribute("user_type"));
		}
		else{
			model.addObject("user_type", "User");
		}
		request.getSession().removeAttribute("user_type");
		model.setViewName("login");

		return model;

	}

}