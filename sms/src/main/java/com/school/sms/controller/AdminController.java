package com.school.sms.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.school.sms.model.FixedFeeBatchYearMonth;
import com.school.sms.service.FeeManagementService;

@Controller
public class AdminController {

	
	@RequestMapping(value = "/admin/createUser**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		/*
		 * model.addObject("title", "Spring Security Custom Login Form");
		 * model.addObject("message", "This is protected page!");
		 */

		model.setViewName("createStudent");

		return model;

	}
	
	
	
	@RequestMapping(value = "admin/userManagement", method = RequestMethod.GET)
	public ModelAndView userManagement() {

		ModelAndView model = new ModelAndView();
		/*
		 * model.addObject("title", "Spring Security Custom Login Form");
		 * model.addObject("message", "This is protected page!");
		 */

		model.setViewName("employee-form");

		return model;

	}
	
	

	@RequestMapping(value = "admin/databackupNrestore")
	public ModelAndView dataBackAndRestore(
			@RequestParam(value = "backup", required = false) String backup,
			@RequestParam(value = "restore", required = false) String restore,/*ServletContext sc,*/HttpServletRequest request ) {

		ModelAndView model = new ModelAndView();
		/*
		 * model.addObject("title", "Spring Security Custom Login Form");
		 * model.addObject("message", "This is protected page!");
		 */
		
		if(null!= backup && (null==request.getParameter("file") || request.getParameter("file").isEmpty())){
			model.addObject("fileSelectionError", "error");
		}
		else if (backup != null && null!=request.getParameter("file") && !request.getParameter("file").isEmpty()) {
			Process p = null;
			try {
				Runtime runtime = Runtime.getRuntime();
				String path="";
				if("windows".equals(System.getProperty("os.name"))){
					path ="C:\\" +request.getParameter("file");
				}
				else{
					path ="/tmp/"+request.getParameter("file");
				}
				p = runtime
						.exec(new String[]{"/bin/sh" ,"-c", "mysqldump -u root -proot --databases school_admission-system > " + path});
				// change the dbpass and dbname with your dbpass and dbname
				int processComplete = p.waitFor();

				if (processComplete == 0) {

					model.addObject("backup_status", "Success,BackUp Location: " +path);
					System.out.println("Backup created successfully!");

				} else {
					model.addObject("backup_status", "Fail");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		model.setViewName("database");

		return model;

	}
}
