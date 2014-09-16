package com.school.sms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.school.sms.model.EmployeeMaster;
import com.school.sms.model.GeneralLedgerEntry;
import com.school.sms.service.PurchaseService;

@Controller
public class GeneralLedgerController {

	@Resource(name = "purchaseService")
	private PurchaseService purchaseService;
	
	private Integer generalLedgerIndex;
	
	private List<GeneralLedgerEntry> generalLedgerList = new ArrayList<GeneralLedgerEntry>();
	
	@RequestMapping(value = "admin/listGeneralLedgers", method = RequestMethod.GET)
	public ModelAndView listGeneralLedgers() {
		List<GeneralLedgerEntry> ledgerEntries = new ArrayList<GeneralLedgerEntry>();
		ledgerEntries = purchaseService.loadGeneralLedgers();
		ModelAndView model = new ModelAndView("listGeneralLedgers");
		model.addObject("ledgerEntries", ledgerEntries);
		return model;

	}
	
	
	@RequestMapping(value = "admin/generalLedger", method = RequestMethod.GET)
	public ModelAndView getGeneralLedger() {
		generalLedgerIndex=-1;
		//List<GeneralLedgerEntry> generalLedgerEntries = new ArrayList<GeneralLedgerEntry>();
		//generalLedgerEntries = purchaseService.loadGeneralLedgers();
		ModelAndView model = new ModelAndView("general_ledger_entry","command", new GeneralLedgerEntry());
		initializeGeneralLedgerEntryList();
		model.addObject("generalLedgerEntries", generalLedgerList);
		//model.setViewName("purchase_form");

		return model;

	}
	
	@RequestMapping(value = "admin/generalLedger", method = RequestMethod.POST)
	public ModelAndView processGeneralLedger(@ModelAttribute("generalLedger")GeneralLedgerEntry generalLedger,
			@RequestParam(value = "action",required = false) String action,HttpServletRequest request) {
		ModelAndView modelAndView;
		if("search".equalsIgnoreCase(action)){
			GeneralLedgerEntry generalLedger1= purchaseService.findGeneralLedgerEntry(Integer.valueOf(request.getParameter("glCode")));
			if(null==generalLedger1){
				modelAndView = new ModelAndView("general_ledger_entry-form","command",generalLedger);
				modelAndView.addObject("noGeneralLedgerFound",true);
				
			}
			else{
			modelAndView = new ModelAndView("general_ledger_entry","command",generalLedger1);
			generalLedgerIndex = getGeneralLedgerIndex(generalLedger1);
			}
						
		}
		else if("save".equalsIgnoreCase(action)) {
			if (null != generalLedger.getName()) {
				generalLedger = purchaseService.updateGeneralLedgerEntry(generalLedger);
			initializeGeneralLedgerEntryList();
			modelAndView = new ModelAndView("general_ledger_entry","command",generalLedger);
			generalLedgerIndex = getGeneralLedgerIndex(generalLedger);
			modelAndView.addObject("generalLedgerSaved",true);
			}
			else{
				modelAndView = new ModelAndView("general_ledger_entry","command",generalLedger);
				modelAndView.addObject("isFormIncomplete",true);
			}
		}
		
		else if("delete".equalsIgnoreCase(action)) {
			purchaseService.deleteGeneralLedgerEntry(generalLedger);
			initializeGeneralLedgerEntryList();
			modelAndView = new ModelAndView("general_ledger_entry","command",new EmployeeMaster());
			generalLedgerIndex= generalLedgerIndex-1;
			modelAndView.addObject("generalLedgerDeleted",true);
		}
		
		else if("next".equalsIgnoreCase(action)) {
			modelAndView = new ModelAndView("general_ledger_entry","command",this.generalLedgerList.get(++generalLedgerIndex));
		}
		else if("previous".equalsIgnoreCase(action)) {
			modelAndView = new ModelAndView("general_ledger_entry","command",this.generalLedgerList.get(--generalLedgerIndex));
		}
		else if("first".equalsIgnoreCase(action)) {
			generalLedgerIndex =0;
			modelAndView = new ModelAndView("general_ledger_entry","command",this.generalLedgerList.get(generalLedgerIndex));
		}
		
		else if("last".equalsIgnoreCase(action)) {
			generalLedgerIndex =this.generalLedgerList.size()-1;
			modelAndView = new ModelAndView("general_ledger_entry","command",this.generalLedgerList.get(generalLedgerIndex));
		}
		else{
			modelAndView = new ModelAndView("general_ledger_entry","command",generalLedger);
		}
		if(generalLedgerIndex==this.generalLedgerList.size()-1){
			modelAndView.addObject("disableNext", true);
		}
		if(generalLedgerIndex<=0){
			modelAndView.addObject("disablePrevious", true);
		}
		if(generalLedgerIndex==this.generalLedgerList.size()-1){
			modelAndView.addObject("disableNext", true);
		}
		if(generalLedgerIndex<=0){
			modelAndView.addObject("disablePrevious", true);
		}
		
		return modelAndView;

	}
	
	private Integer getGeneralLedgerIndex(GeneralLedgerEntry generalLedgerEntry) {
		int i=0;
		for(GeneralLedgerEntry entry : generalLedgerList){
			if(entry.equals(generalLedgerEntry)){
				return i;
			}
			i++;
		}
		return 0;
	}
	private void initializeGeneralLedgerEntryList() {
		this.generalLedgerList=purchaseService.loadGeneralLedgers();
		
	}
	
}
