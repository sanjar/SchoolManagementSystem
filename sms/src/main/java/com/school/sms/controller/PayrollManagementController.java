package com.school.sms.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.school.sms.model.FixedFeeBatchYearMonth;

@Controller
public class PayrollManagementController {

	@RequestMapping(value = "admin/payrollManagement", method = RequestMethod.GET)
	public ModelAndView userManagement() {

		ModelAndView model = new ModelAndView();
		/*List<FixedFeeBatchYearMonth> list = payrollService.loadFeeStructures();
		if (null != list) {
			this.fixedFeeStructureList = list;
		}

		model.addObject("listFixedFeeStructure", list);*/

		model.setViewName("payrollManagement");

		return model;

	}
}
