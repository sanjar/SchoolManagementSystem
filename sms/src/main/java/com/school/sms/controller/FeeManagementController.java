package com.school.sms.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.school.sms.model.Student;
import com.school.sms.model.StudentFeeDetails;
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
	private Set<String> studentClassBatchList = new TreeSet<String>();
	private Map<String,Map<String,String>> batchStudentFatherEnrolementMap=  new HashMap<String,Map<String,String>>();
	private boolean isAllDiscountsAndConcessionListPopulated;
	private List<Student> studentsList = new ArrayList<Student>();
	private Integer variableFeeIndex;
	private Integer fixedFeeIndex;
	private List<StudentFeeDetails> details = new ArrayList<StudentFeeDetails>();
	Map<String,Double> feeHeaderFeeMap =  new HashMap<String, Double>();
	
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
		variableFeeIndex=-1;
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
		modelAndView.addObject("monthList", Arrays.asList(Constants.MONTH_ARRAY));
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
			if(null==fee){
				modelAndView = new ModelAndView("variable-fees","command",variableFee);
				modelAndView.addObject("noFeeStructureFound",true);
				fee= new VariableFeeBatchYearMonth();
			}
			
			else{
				modelAndView = new ModelAndView("variable-fees","command",fee);
				variableFeeIndex = getExactVariableFeeIndex(fee);
			}
		}
		else if("save".equalsIgnoreCase(action)) {
			if(!variableFee.getBatch().equals("-1") && !variableFee.getMonth().equals("-1") && !variableFee.getSession().equals("-1")){
			modelAndView = new ModelAndView("variable-fees","command",variableFee);
			feeService.updateVariableFee(variableFee);
			isAllVariableSessionMonthBatchListPopulated=false;
			variableFeeIndex = getExactVariableFeeIndex(variableFee);
			}
			else{
				modelAndView = new ModelAndView("variable-fees","command",variableFee);
				modelAndView.addObject("isFormIncomplete",true);
			}
		}
		
		else if("delete".equalsIgnoreCase(action)) {
			feeService.deleteVariableFee(variableFee);
			initializeVariableFeeList();
			modelAndView = new ModelAndView("variable-fees","command",new VariableFeeBatchYearMonth());
			variableFeeIndex= variableFeeIndex-1;
			modelAndView.addObject("variableFeeIndexDeleted",true);
		}
		
		else if("next".equalsIgnoreCase(action)) {
			modelAndView = new ModelAndView("variable-fees","command",this.variableFeeStructureList.get(++variableFeeIndex));
		}
		else if("previous".equalsIgnoreCase(action)) {
			modelAndView = new ModelAndView("variable-fees","command",this.variableFeeStructureList.get(--variableFeeIndex));
		}
		else if("first".equalsIgnoreCase(action)) {
			variableFeeIndex =0;
			modelAndView = new ModelAndView("variable-fees","command",this.variableFeeStructureList.get(variableFeeIndex));
		}
		else if("last".equalsIgnoreCase(action)) {
			variableFeeIndex =this.variableFeeStructureList.size()-1;
			modelAndView = new ModelAndView("variable-fees","command",this.variableFeeStructureList.get(variableFeeIndex));
		}
		else{
			modelAndView = new ModelAndView("variable-fees","command",variableFee);
		}
		if(variableFeeIndex==this.variableFeeStructureList.size()-1){
			modelAndView.addObject("disableNext", true);
		}
		if(variableFeeIndex<=0){
			modelAndView.addObject("disablePrevious", true);
		}
		
		if(!isAllVariableSessionMonthBatchListPopulated){
			populateVariableSessionBatchMonthLists();
		}
		
		
		modelAndView.addObject("sessionList", Arrays.asList(Constants.SESSION_ARRAY));
		modelAndView.addObject("batchList", Arrays.asList(Constants.BATCH_ARRAY));
		modelAndView.addObject("monthList", Arrays.asList(Constants.MONTH_ARRAY));
		modelAndView.addObject("studentNameClassRollList", this.studentNameClassRollList);
	//	modelAndView.setViewName("fixed-fees");
		
		
		return modelAndView;

	}
	private Integer getExactVariableFeeIndex(VariableFeeBatchYearMonth variableFeeBatchYearMonth) {
		int i=0;
		for(VariableFeeBatchYearMonth fee : variableFeeStructureList){
			if(fee.equals(variableFeeBatchYearMonth)){
				return i;
			}
			i++;
		}
		return 0;
	}
	private void initializeVariableFeeList() {
		this.variableFeeStructureList=feeService.loadVariableFeeStructures();
		
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
		fixedFeeIndex=-1;
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
			if(null==fee){
				modelAndView = new ModelAndView("fixed-fees","command",fixedFee);
				modelAndView.addObject("noFeeStructureFound",true);
			}
			else{
				modelAndView = new ModelAndView("fixed-fees","command",fee);
				fixedFeeIndex = getExactFixedFeeIndex(fee);
			}
			
		}
		else if("save".equalsIgnoreCase(action)) {
			if(!fixedFee.getBatchId().equals(-1) && fixedFee.getMonth().equals("-1") && fixedFee.getSession().equals("-1")){
			modelAndView = new ModelAndView("fixed-fees","command",fixedFee);
			feeService.updateFixedFee(fixedFee);
			initializeFixedFeeList();
			isAllSessionMonthBatchListPopulated=false;
			}
			else{
				modelAndView = new ModelAndView("fixed-fees","command",fixedFee);
			}
		}
		else if("delete".equalsIgnoreCase(action)) {
			feeService.deleteFixedFee(fixedFee);
			initializeFixedFeeList();
			modelAndView = new ModelAndView("fixed-fees","command",new FixedFeeBatchYearMonth());
			fixedFeeIndex = getExactFixedFeeIndex(fixedFee);
			fixedFeeIndex= fixedFeeIndex-1;
			modelAndView.addObject("fixedFeeDeleted",true);
		}
		
		else if("next".equalsIgnoreCase(action)) {
			modelAndView = new ModelAndView("fixed-fees","command",this.fixedFeeStructureList.get(++fixedFeeIndex));
		}
		else if("previous".equalsIgnoreCase(action)) {
			modelAndView = new ModelAndView("fixed-fees","command",this.fixedFeeStructureList.get(--fixedFeeIndex));
		}
		else if("first".equalsIgnoreCase(action)) {
			fixedFeeIndex =0;
			modelAndView = new ModelAndView("fixed-fees","command",this.fixedFeeStructureList.get(fixedFeeIndex));
		}
		else if("last".equalsIgnoreCase(action)) {
			fixedFeeIndex =this.fixedFeeStructureList.size()-1;
			modelAndView = new ModelAndView("fixed-fees","command",this.fixedFeeStructureList.get(fixedFeeIndex));
		}
		else{
			modelAndView = new ModelAndView("fixed-fees","command",fixedFee);
		}
		if(fixedFeeIndex==this.fixedFeeStructureList.size()-1){
			modelAndView.addObject("disableNext", true);
		}
		if(fixedFeeIndex<=0){
			modelAndView.addObject("disablePrevious", true);
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

	private void initializeFixedFeeList() {
		this.fixedFeeStructureList=feeService.loadFeeStructures();
		
	}

	private Integer getExactFixedFeeIndex(FixedFeeBatchYearMonth fixedFeeBatchYearMonth) {
		int i=0;
		for(FixedFeeBatchYearMonth fee : fixedFeeStructureList){
			if(fee.equals(fixedFeeBatchYearMonth)){
				return i;
			}
			i++;
		}
		return 0;
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
		modelAndView.addObject("monthList", Arrays.asList(Constants.MONTH_ARRAY));
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
		modelAndView.addObject("monthList", Arrays.asList(Constants.MONTH_ARRAY));
		modelAndView.addObject("studentNameClassRollList", this.discountsAndConcessionList);
	//	modelAndView.setViewName("fixed-fees");
		
		
		return modelAndView;

	}
	
	
	
	/******* fee payment  start*******/
	
	@RequestMapping(value = "/admin/feePayment", method = RequestMethod.GET)
	public ModelAndView feePayment() {

		ModelAndView model = new ModelAndView("fee_payment_form", "command",
				new StudentFeeDetails());
		
		studentsList = feeService.loadStudentsList();
		initalizeBatchAndStudentFatherEnrolementMap();
		model.addObject("studentsList", this.studentsList);
		model.addObject("modeOfPaymentList", Arrays.asList(Constants.MODE_OF_PAYMENT));
		model.addObject("studentClassBatchList", /*this.studentClassBatchList*/ Arrays.asList(Constants.BATCH_ARRAY));
		model.addObject("monthList", Arrays.asList(Constants.MONTH_ARRAY));
		// model.setViewName("fixed-fees");

		return model;

	}
	
	private void initalizeBatchAndStudentFatherEnrolementMap() {
		for(Student student: studentsList){
			if(null!=student.getCurrentClassBatch()){
			studentClassBatchList.add(student.getCurrentClassBatch());
			}
		}
		
	}

	@RequestMapping(value = "/admin/feePayment", method = RequestMethod.POST)
	public ModelAndView processFeePayment(@ModelAttribute("studentFeeDeatils")StudentFeeDetails studentFeeDeatils,
			@RequestParam(value = "action",required = false) String action,HttpServletRequest request) {
		ModelAndView model = new ModelAndView("fee_payment_form", "command",
				new StudentFeeDetails());
		if("getDetails".equalsIgnoreCase(action)){
			Student student = getStudent(studentFeeDeatils.getEnrolementNo());/*feeService.loadStudentDeatil(studentFeeDeatils.getEnrolementNo());*/
			if(student!=null){
			String middleName= student.getMiddleName() != null?student.getMiddleName():"";
			String lastName=student.getLastName()!=null?student.getLastName():"";
			studentFeeDeatils.setStudentName(student.getFirstName() + " "+middleName+" "+lastName);
			studentFeeDeatils.setBatch(request.getParameter("batch"));
			//studentFeeDeatils.setSession(student.g);
		    this.details = feeService.loadStudentFeeDetails(studentFeeDeatils.getEnrolementNo());
			if(!studentFeeDeatils.getMonth().equals("-1") && studentFeeDeatils.getSession()!=null && !studentFeeDeatils.getSession().isEmpty()){
				FixedFeeBatchYearMonth fixedFee=getFixedFee(studentFeeDeatils.getMonth(),studentFeeDeatils.getSession());/*feeService.loadFixedFeeBatchYearMonth(studentFeeDeatils.getMonth(),studentFeeDeatils.getSession());*/
				if(null!=fixedFee){
					this.feeHeaderFeeMap = prepareFeeHeaderFeeMap(fixedFee);
					Double amount=calculatePayableAmountOfMonth(feeHeaderFeeMap);
					studentFeeDeatils.setTotalAmount(amount);
						
					//model.addObject("fixedFee", fixedFee);
				}
			}
			}
			
		}
		else if("save".equalsIgnoreCase(action)){
			feeService.saveStudentFeeDetails(studentFeeDeatils);
			
		}
		else if("calculate".equalsIgnoreCase(action)){
			calculateFinalAmount(studentFeeDeatils);
		}
		if("getDetails".equalsIgnoreCase(action) || "save".equalsIgnoreCase(action) || "calculate".equalsIgnoreCase(action)){
			model = new ModelAndView("fee_payment_form", "command",
					studentFeeDeatils);
			model.addObject("fixedFeeMap", feeHeaderFeeMap);
			model.addObject("studenFeeDetailstList", details);
		}
		model.addObject("modeOfPaymentList", Arrays.asList(Constants.MODE_OF_PAYMENT));
		model.addObject("studentClassBatchList", this.studentClassBatchList);
		model.addObject("monthList", Arrays.asList(Constants.MONTH_ARRAY));
		// model.setViewName("fixed-fees");

		return model;

	}
	
	private void calculateFinalAmount(StudentFeeDetails studentFeeDeatils) {
		Double amountTobeAdded = studentFeeDeatils.getPreviousDue()+studentFeeDeatils.getLateFine()+studentFeeDeatils.getOtherFine();
		Double amountTobeSubstracted = studentFeeDeatils.getConcession()+studentFeeDeatils.getDiscount();
		studentFeeDeatils.setTotalAmount(studentFeeDeatils.getTotalAmount()+amountTobeAdded-amountTobeSubstracted);
		
	}

	private Double calculatePayableAmountOfMonth(Map<String, Double> map) {
		Double amount=0.00;
		for(Double value:map.values()){
			amount=amount+value;
		}
		return amount;
	}

	private FixedFeeBatchYearMonth getFixedFee(String month, String session) {
		for(FixedFeeBatchYearMonth fixedFee:this.fixedFeeStructureList){
			if(fixedFee.getMonth().equalsIgnoreCase(month) && fixedFee.getSession().equals(session)){
				return fixedFee;
			}
		}
		return null;
	}

	private Map<String, Double> prepareFeeHeaderFeeMap(
			FixedFeeBatchYearMonth fixedFee) {
		Map <String,Double> map = new HashMap<String, Double>();
		map.put("Tuition Fee", fixedFee.getTuitionFee());
		map.put("Examination Fee", fixedFee.getExaminationFee());
		map.put("Maintainance Fee", fixedFee.getMaintainanceFee());
		map.put("ReportCard Fee", fixedFee.getReportCardFee());
		map.put("Book Fee", fixedFee.getBookFee());
		map.put("Icard Fee", fixedFee.getIcardFee());
		map.put("Water Electricity Fee", fixedFee.getWaterElectricFee());
		map.put("Misc Fee", fixedFee.getMiscFee());
		map.put("Sports Culture Fee", fixedFee.getSportsCultureFee());
		map.put("Activity Fee", fixedFee.getActivityFee());
		map.put("Registration Fee", fixedFee.getRegistrationFee());
		
		return map;
	}

	private Student getStudent(String enrolementNo) {
		for(Student student: studentsList){
			if(null!=student.getEnrolementNo() && student.getEnrolementNo().equalsIgnoreCase(enrolementNo)){
			return student;
			}
		}
		return null;
	}

	/******* fee payment  ends*******/
	
	
	
	
	
	
	
	
	
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
