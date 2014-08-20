package com.school.sms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.school.sms.model.GeneralLedgerEntry;
import com.school.sms.service.PurchaseService;

@Controller
public class GeneralLedgerController {

	@Resource(name = "purchaseService")
	private PurchaseService purchaseService;
	
	@RequestMapping(value = "admin/generalLedger", method = RequestMethod.GET)
	public ModelAndView getGeneralLedger() {
		List<GeneralLedgerEntry> generalLedgerEntries = new ArrayList<GeneralLedgerEntry>();
		generalLedgerEntries = purchaseService.loadGeneralLedgers();
		ModelAndView model = new ModelAndView("general_ledger_entry","command", new GeneralLedgerEntry());
		
		model.addObject("generalLedgerEntries", generalLedgerEntries);
		//model.setViewName("purchase_form");

		return model;

	}
}
