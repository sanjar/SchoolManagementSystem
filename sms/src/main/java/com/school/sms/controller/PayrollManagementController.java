package com.school.sms.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.school.sms.constants.Constants;
import com.school.sms.model.Department;
import com.school.sms.model.EmployeeMaster;
import com.school.sms.model.GradeMaster;
import com.school.sms.model.SalaryMaster;
import com.school.sms.model.SalaryProcessDetail;
import com.school.sms.service.PayrollManagementService;

@Controller
public class PayrollManagementController {

	@Resource(name = "payrollManagementService")
	private PayrollManagementService payrollService;
	
	//
	private List<EmployeeMaster> employeeMasterList = new ArrayList<EmployeeMaster>();
	
	
	//
	private List<GradeMaster> gradeMasterList = new ArrayList<GradeMaster>();
	
	private List<Department> departmentList = new ArrayList<Department>();
	
	private List<SalaryMaster> salaryMasterList = new ArrayList<SalaryMaster>();
	
	private Integer gradeIndex;
	private Integer departmentIndex;
	private Integer salaryIndex;
	
	private Integer employeeMasterIndex;
	
	
	private Map<GradeMaster,List<String>>  gradeSalaryCodeMap;
	
	@RequestMapping(value = "admin/payrollManagement", method = RequestMethod.GET)
	public ModelAndView userManagement() {

		ModelAndView model = new ModelAndView();
		List<EmployeeMaster> list = payrollService.loadEmployeeMasterList();
		if (null != list) {
			this.employeeMasterList = list;
		}

		model.addObject("employeeMasterList", list);

		model.setViewName("payrollManagement");

		return model;

	}

	public List<EmployeeMaster> getEmployeeMasterList() {
		return employeeMasterList;
	}
	
	/*********  Salary Process starts  ***************/
	@RequestMapping(value = "/admin/payrollManagement/processSalary", method = RequestMethod.GET)
	public ModelAndView processSalary() {
		initializeSalaryMasterList();
		ModelAndView model = new ModelAndView("salary_process", "command",
				new SalaryProcessDetail());
		model.addObject("salaryMasterList", this.salaryMasterList);
		model.addObject("monthList", Arrays.asList(Constants.MONTH_ARRAY));
		return model;

	}
	@RequestMapping(value = "/admin/payrollManagement/processSalary", method = RequestMethod.POST)
	public ModelAndView processSalaryNow(@ModelAttribute("salaryProcessDetail")SalaryProcessDetail salaryProcessDetail,
			@RequestParam(value = "action",required = false) String action,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("salary_process","command",new SalaryProcessDetail());
		
		if("process".equalsIgnoreCase(action)) {
			if (!salaryProcessDetail.getSalaryMaster().getSalaryId().equals("-1")
					&& !salaryProcessDetail.getYear().isEmpty() && !salaryProcessDetail.getMonth().isEmpty()) {
				salaryProcessDetail.setIsSalaryProcessed(true);
				salaryProcessDetail.setProcessingDate(new Date().toString());
			payrollService.updateSalaryProcessDetail(salaryProcessDetail);
			modelAndView.addObject("salaryProcessInitiated",true);
			}
			else{
				modelAndView = new ModelAndView("salary_process","command",salaryProcessDetail);
				modelAndView.addObject("isFormIncomplete",true);
			}
			
		}
		modelAndView.addObject("salaryMasterList", this.salaryMasterList);
		modelAndView.addObject("monthList", Arrays.asList(Constants.MONTH_ARRAY));
		return modelAndView;
	}
	
	
	/*********  Salary Process ends  ***************/
	
	/*********  Employee Master starts  ***************/
	@RequestMapping(value = "/admin/payrollManagement/manageEmployeeMaster", method = RequestMethod.GET)
	public ModelAndView manageEmployeeMaster() {
		employeeMasterIndex=-1;
		initializeDepartmentList();
		initializeGrandMasterList();
		initializeSalaryMasterList();
		createGradeSalaryCodeMap();
		ModelAndView model = new ModelAndView("employee-form", "command",
				new EmployeeMaster());
		model.addObject("departmentList", this.departmentList);
		model.addObject("gradeSalaryCodeMap", this.gradeSalaryCodeMap);
		return model;

	}
	
	
	private void createGradeSalaryCodeMap() {
		gradeSalaryCodeMap=  new HashMap<GradeMaster,List<String>>();
		for(GradeMaster grade: this.gradeMasterList){
			gradeSalaryCodeMap.put(grade, new ArrayList<String>());
			for(SalaryMaster salary: this.salaryMasterList){
				if(salary.getGrade().getGradeId().equalsIgnoreCase(grade.getGradeId())){
					gradeSalaryCodeMap.get(grade).add(salary.getSalaryId());
				}
			}
		}
		
	}

	
	@RequestMapping(value = "/admin/payrollManagement/processEmployeeMaster", method = RequestMethod.POST)
	public ModelAndView processEmpolyeeMaster(@ModelAttribute("department")EmployeeMaster employeeMaster,
			@RequestParam(value = "action",required = false) String action,HttpServletRequest request) {
		ModelAndView modelAndView;
		if("search".equalsIgnoreCase(action)){
			EmployeeMaster employeeMaster2= payrollService.findEmployeeMaster(Integer.valueOf(request.getParameter("employeeId")));
			if(null==employeeMaster2){
				modelAndView = new ModelAndView("employee-form","command",employeeMaster);
				modelAndView.addObject("noEmployeeMasterFound",true);
				
			}
			else{
			modelAndView = new ModelAndView("employee-form","command",employeeMaster2);
			employeeMasterIndex = getExactEmployeeMasterIndex(employeeMaster2);
			}
						
		}
		else if("save".equalsIgnoreCase(action)) {
			if (null != employeeMaster.getEmployeeId()
					&& !employeeMaster.getEmployeeName().isEmpty()
					&& !employeeMaster.getGrade().getGradeId().equals("-1") 
					&& !employeeMaster.getDepartment().getDepartmentId().equals("-1") 
					&& !employeeMaster.getSalaryCode().equals("-1")) {
			payrollService.updateEmployeeMaster(employeeMaster);
			initializeEmployeeMasterList();
			modelAndView = new ModelAndView("employee-form","command",employeeMaster);
			employeeMasterIndex = getExactEmployeeMasterIndex(employeeMaster);
			modelAndView.addObject("employeeSaved",true);
			}
			else{
				modelAndView = new ModelAndView("employee-form","command",employeeMaster);
				modelAndView.addObject("isFormIncomplete",true);
			}
		}
		
		else if("delete".equalsIgnoreCase(action)) {
			payrollService.deleteEmployeeMaster(employeeMaster);
			initializeEmployeeMasterList();
			modelAndView = new ModelAndView("employee-form","command",new EmployeeMaster());
			employeeMasterIndex= employeeMasterIndex-1;
			modelAndView.addObject("employeeDeleted",true);
		}
		
		else if("next".equalsIgnoreCase(action)) {
			modelAndView = new ModelAndView("employee-form","command",this.employeeMasterList.get(++employeeMasterIndex));
		}
		else if("previous".equalsIgnoreCase(action)) {
			modelAndView = new ModelAndView("employee-form","command",this.employeeMasterList.get(--employeeMasterIndex));
		}
		else if("first".equalsIgnoreCase(action)) {
			employeeMasterIndex =0;
			modelAndView = new ModelAndView("employee-form","command",this.employeeMasterList.get(employeeMasterIndex));
		}
		else if("last".equalsIgnoreCase(action)) {
			employeeMasterIndex =this.employeeMasterList.size()-1;
			modelAndView = new ModelAndView("employee-form","command",this.employeeMasterList.get(employeeMasterIndex));
		}
		else{
			modelAndView = new ModelAndView("employee-form","command",employeeMaster);
		}
		if(employeeMasterIndex==this.employeeMasterList.size()-1){
			modelAndView.addObject("disableNext", true);
		}
		if(employeeMasterIndex<=0){
			modelAndView.addObject("disablePrevious", true);
		}
		modelAndView.addObject("departmentList", this.departmentList);
		modelAndView.addObject("gradeSalaryCodeMap", this.gradeSalaryCodeMap);
		modelAndView.addObject("designationList", Arrays.asList(Constants.DESIGNATION_ARRAY));
		modelAndView.addObject("genderList", Arrays.asList(Constants.GENDER_ARRAY));
		return modelAndView;

	}
	
	private Integer getExactEmployeeMasterIndex(EmployeeMaster employeeMaster) {
		int i=0;
		for(EmployeeMaster employee : employeeMasterList){
			if(employee.equals(employeeMaster)){
				return i;
			}
			i++;
		}
		return 0;
	}
	private void initializeEmployeeMasterList() {
		this.employeeMasterList=payrollService.loadEmployeeMasterList();
		
	}
	
	/************  Employee Master ends   **************/

	
	
	/****************   Department Section   starts   **************/
	@RequestMapping(value = "/admin/payrollManagement/manageDepartmentMaster", method = RequestMethod.GET)
	public ModelAndView manageDepartmentMaster() {
		departmentIndex=-1;
		initializeDepartmentList();
		ModelAndView model = new ModelAndView("department_form", "command",
				new Department());
		return model;

	}
	

	private void initializeDepartmentList() {
		this.departmentList=payrollService.loadDepartmentList();
		
	}
	@RequestMapping(value = "/admin/payrollManagement/processDepartmentMaster", method = RequestMethod.POST)
	public ModelAndView processDepartmentMaster(@ModelAttribute("department")Department department,
			@RequestParam(value = "action",required = false) String action,HttpServletRequest request) {
		ModelAndView modelAndView;
		if("search".equalsIgnoreCase(action)){
			Department depart= payrollService.findDepartment((String)request.getParameter("departmentId"));
			if(null==depart){
				modelAndView = new ModelAndView("department_form","command",department);
				modelAndView.addObject("noDepartmentFound",true);
				
			}
			else{
			modelAndView = new ModelAndView("department_form","command",depart);
			departmentIndex = getExactDepartmentIndex(depart);
			}
						
		}
		else if("save".equalsIgnoreCase(action)) {
			if(!department.getDepartmentId().isEmpty() && !department.getDepartmentName().isEmpty()){
			payrollService.updateDepartmentMaster(department);
			initializeDepartmentList();
			modelAndView = new ModelAndView("department_form","command",department);
			departmentIndex = getExactDepartmentIndex(department);
			modelAndView.addObject("departmentSaved",true);
			}
			else{
				modelAndView = new ModelAndView("department_form","command",department);
				modelAndView.addObject("isFormIncomplete",true);
			}
		}
		
		else if("delete".equalsIgnoreCase(action)) {
			payrollService.deleteDepartment(department);
			initializeDepartmentList();
			modelAndView = new ModelAndView("department_form","command",new Department());
			departmentIndex= departmentIndex-1;
			modelAndView.addObject("departmentDeleted",true);
		}
		
		else if("next".equalsIgnoreCase(action)) {
			modelAndView = new ModelAndView("department_form","command",this.departmentList.get(++departmentIndex));
		}
		else if("previous".equalsIgnoreCase(action)) {
			modelAndView = new ModelAndView("department_form","command",this.departmentList.get(--departmentIndex));
		}
		else if("first".equalsIgnoreCase(action)) {
			departmentIndex =0;
			modelAndView = new ModelAndView("department_form","command",this.departmentList.get(departmentIndex));
		}
		else if("last".equalsIgnoreCase(action)) {
			departmentIndex =this.departmentList.size()-1;
			modelAndView = new ModelAndView("department_form","command",this.departmentList.get(departmentIndex));
		}
		else{
			modelAndView = new ModelAndView("department_form","command",department);
		}
		if(departmentIndex==this.departmentList.size()-1){
			modelAndView.addObject("disableNext", true);
		}
		if(departmentIndex<=0){
			modelAndView.addObject("disablePrevious", true);
		}
		return modelAndView;

	}
	
	private Integer getExactDepartmentIndex(Department depart) {
		int i=0;
		for(Department department : departmentList){
			if(department.equals(depart)){
				return i;
			}
			i++;
		}
		return 0;
	}

	/************  Department Section ends   **************/
	
	/******** Grade Master starts **********/
	
	@RequestMapping(value = "/admin/payrollManagement/manageGradeMaster", method = RequestMethod.GET)
	public ModelAndView manageGradeMaster() {
		gradeIndex=-1;
		initializeGrandMasterList();
		ModelAndView model = new ModelAndView("grade_master_form", "command",
				new GradeMaster());
		return model;

	}
	private void initializeGrandMasterList() {
		this.gradeMasterList = payrollService.loadGradeMasterList();
		
	}

	@RequestMapping(value = "/admin/payrollManagement/processGradeMaster", method = RequestMethod.POST)
	public ModelAndView processGradeMaster(@ModelAttribute("gradeMaster")GradeMaster gradeMaster,
			@RequestParam(value = "action",required = false) String action,HttpServletRequest request) {
		ModelAndView modelAndView;
		if("search".equalsIgnoreCase(action)){
			GradeMaster grade= payrollService.findGradeMaster((String)request.getParameter("gradeId"));
			if(null==grade){
				modelAndView = new ModelAndView("grade_master_form","command",gradeMaster);
				modelAndView.addObject("noGradeMasterFound",true);
				
			}
			else{
			modelAndView = new ModelAndView("grade_master_form","command",grade);
			gradeIndex = getExactGradeIndex(grade);
			}
						
		}
		else if("save".equalsIgnoreCase(action)) {
			if(!gradeMaster.getGradeId().isEmpty() && !gradeMaster.getGradeName().isEmpty()){
			payrollService.updateGradeMaster(gradeMaster);
			initializeGrandMasterList();
			modelAndView = new ModelAndView("grade_master_form","command",gradeMaster);
			gradeIndex = getExactGradeIndex(gradeMaster);
			modelAndView.addObject("gradeSaved",true);
			}
			else{
				modelAndView = new ModelAndView("grade_master_form","command",gradeMaster);
				modelAndView.addObject("isFormIncomplete",true);
			}
		}
		
		else if("delete".equalsIgnoreCase(action)) {
			payrollService.deleteGrade(gradeMaster);
			initializeGrandMasterList();
			modelAndView = new ModelAndView("grade_master_form","command",new GradeMaster());
			gradeIndex= gradeIndex-1;
			modelAndView.addObject("gradeDeleted",true);
		}
		
		else if("next".equalsIgnoreCase(action)) {
			modelAndView = new ModelAndView("grade_master_form","command",this.gradeMasterList.get(++gradeIndex));
		}
		else if("previous".equalsIgnoreCase(action)) {
			modelAndView = new ModelAndView("grade_master_form","command",this.gradeMasterList.get(--gradeIndex));
		}
		else if("first".equalsIgnoreCase(action)) {
			gradeIndex =0;
			modelAndView = new ModelAndView("grade_master_form","command",this.gradeMasterList.get(gradeIndex));
		}
		else if("last".equalsIgnoreCase(action)) {
			gradeIndex =this.gradeMasterList.size()-1;
			modelAndView = new ModelAndView("grade_master_form","command",this.gradeMasterList.get(gradeIndex));
		}
		else{
			modelAndView = new ModelAndView("grade_master_form","command",gradeMaster);
		}
		if(gradeIndex==this.gradeMasterList.size()-1){
			modelAndView.addObject("disableNext", true);
		}
		if(gradeIndex<=0){
			modelAndView.addObject("disablePrevious", true);
		}
		return modelAndView;

	}

	private Integer getExactGradeIndex(GradeMaster grade) {
		int i=0;
		for(GradeMaster gradeMaster : gradeMasterList){
			if(gradeMaster.equals(grade)){
				return i;
			}
			i++;
		}
		return 0;
	}
	
	/******** Grade Master ends **********/
	
/******** Salary Master starts **********/
	
	@RequestMapping(value = "/admin/payrollManagement/manageSalaryMaster", method = RequestMethod.GET)
	public ModelAndView manageSalaryMaster() {
		salaryIndex=-1;
		initializeSalaryMasterList();
		initializeGrandMasterList();
		ModelAndView model = new ModelAndView("salary_master_form", "command",
				new SalaryMaster());
		model.addObject("gradeList", this.gradeMasterList);
		return model;

	}
	private void initializeSalaryMasterList() {
		this.salaryMasterList = payrollService.loadSalaryMasterList();
		
	}

	@RequestMapping(value = "/admin/payrollManagement/processSalaryMaster", method = RequestMethod.POST)
	public ModelAndView processSalaryMaster(@ModelAttribute("salaryMaster")SalaryMaster salaryMaster,
			@RequestParam(value = "action",required = false) String action,HttpServletRequest request) {
		ModelAndView modelAndView;
		if("search".equalsIgnoreCase(action)){
			SalaryMaster salary= payrollService.findSalaryMaster((String)request.getParameter("salaryId"));
			if(null==salary){
				modelAndView = new ModelAndView("salary_master_form","command",salaryMaster);
				modelAndView.addObject("noSalaryMasterFound",true);
				
			}
			else{
			modelAndView = new ModelAndView("salary_master_form","command",salary);
			salaryIndex = getExactSalaryIndex(salary);
			}
						
		}
		else if("save".equalsIgnoreCase(action)) {
			if(!salaryMaster.getSalaryId().isEmpty() && !salaryMaster.getSalaryName().isEmpty() && !salaryMaster.getSalaryId().isEmpty() && !salaryMaster.getSalaryName().isEmpty() && !salaryMaster.getGrade().getGradeId().equals("-1")){
			payrollService.updateSalaryMaster(salaryMaster);
			initializeSalaryMasterList();
			modelAndView = new ModelAndView("salary_master_form","command",salaryMaster);
			salaryIndex = getExactSalaryIndex(salaryMaster);
			modelAndView.addObject("salarySaved",true);
			}
			else{
				modelAndView = new ModelAndView("salary_master_form","command",salaryMaster);
				modelAndView.addObject("isFormIncomplete",true);
			}
		}
		
		else if("delete".equalsIgnoreCase(action)) {
			payrollService.deleteSalary(salaryMaster);
			initializeSalaryMasterList();
			modelAndView = new ModelAndView("salary_master_form","command",new SalaryMaster());
			salaryIndex= salaryIndex-1;
			modelAndView.addObject("salaryDeleted",true);
		}
		
		else if("next".equalsIgnoreCase(action)) {
			modelAndView = new ModelAndView("salary_master_form","command",this.salaryMasterList.get(++salaryIndex));
		}
		else if("previous".equalsIgnoreCase(action)) {
			modelAndView = new ModelAndView("salary_master_form","command",this.salaryMasterList.get(--salaryIndex));
		}
		else if("first".equalsIgnoreCase(action)) {
			salaryIndex =0;
			modelAndView = new ModelAndView("salary_master_form","command",this.salaryMasterList.get(salaryIndex));
		}
		else if("last".equalsIgnoreCase(action)) {
			salaryIndex =this.salaryMasterList.size()-1;
			modelAndView = new ModelAndView("salary_master_form","command",this.salaryMasterList.get(salaryIndex));
		}
		else{
			modelAndView = new ModelAndView("salary_master_form","command",salaryMaster);
		}
		if(salaryIndex==this.salaryMasterList.size()-1){
			modelAndView.addObject("disableNext", true);
		}
		if(salaryIndex<=0){
			modelAndView.addObject("disablePrevious", true);
		}
		modelAndView.addObject("gradeList", this.gradeMasterList);
		return modelAndView;

	}

	private Integer getExactSalaryIndex(SalaryMaster salary) {
		int i=0;
		for(SalaryMaster salaryMaster : salaryMasterList){
			if(salaryMaster.equals(salary)){
				return i;
			}
			i++;
		}
		return 0;
	}
	
	/******** Salary Master ends **********/
}
