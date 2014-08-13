package com.school.sms.controller;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.school.sms.model.PurchaseReceipt;
import com.school.sms.model.PurchaseReceiptItem;
import com.school.sms.model.SalesReceipt;
import com.school.sms.model.SalesReceiptItem;
import com.school.sms.service.PurchaseService;

@Controller
public class SalesController {

	@Resource(name = "purchaseService")
	private PurchaseService purchaseService;
	
	@RequestMapping(value = "admin/purchase/salesReceipt", method = RequestMethod.GET)
	public ModelAndView salesReceipt() {
		SalesReceipt salesReceipt = new SalesReceipt();
		salesReceipt.setChallanNo(purchaseService.getcurrentChallanNo()+1);
		ModelAndView model = new ModelAndView("sales_receipt","command",salesReceipt);
		model.addObject("saleTypeList", Arrays.asList(Constants.PURCHASE_TYPE_ARRAY));
		return model;

	}

	@RequestMapping(value = "/admin/purchase/processSalesReceipt", method = RequestMethod.POST)
	public ModelAndView processSalesReceipt(@ModelAttribute("salesReceipt")SalesReceipt salesReceipt,
			@RequestParam(value = "action",required = false) String action,HttpServletRequest request) {
		SalesReceipt salesReceipt1 = new SalesReceipt();
		salesReceipt1.setChallanNo(purchaseService.getcurrentChallanNo()+1);
		ModelAndView modelAndView=new ModelAndView("sales_receipt","command",salesReceipt1);
		
		if("search".equalsIgnoreCase(action)){
			SalesReceipt receipt= purchaseService.findSalesReceipt(Integer.valueOf(request.getParameter("challanNo")));
			if(null==receipt){
				modelAndView = new ModelAndView("sales_receipt","command",salesReceipt);
				modelAndView.addObject("noSalesReceiptFound",true);
				
			}
			else{
			modelAndView = new ModelAndView("sales_receipt","command",receipt);
			}
						
		}
		else if("save".equalsIgnoreCase(action)) {
			if (null != salesReceipt.getChallanNo() && !salesReceipt.getChallanDate().isEmpty()) {
				gatherAddedItems(salesReceipt);
				calculateAmount(salesReceipt);
				purchaseService.updateSalesReceipt(salesReceipt);
				modelAndView = new ModelAndView("sales_receipt","command",salesReceipt);
				modelAndView.addObject("salesReceiptSaved",true);
			}
			else{
				modelAndView = new ModelAndView("","command",salesReceipt);
				modelAndView.addObject("isFormIncomplete",true);
			}
		}
		
		else if("delete".equalsIgnoreCase(action)) {
			purchaseService.deleteSalesReceipt(salesReceipt);
			modelAndView.addObject("salesReceiptDeleted",true);
		}
		else if("calculate".equalsIgnoreCase(action)) {
			calculateAmount(salesReceipt);
			modelAndView = new ModelAndView("sales_receipt","command",salesReceipt);
		}
	   modelAndView.addObject("yesNoList", Arrays.asList(Constants.YES_NO_ARRAY));
	   modelAndView.addObject("saleTypeList", Arrays.asList(Constants.PURCHASE_TYPE_ARRAY));
		return modelAndView;
	}
	
	private void calculateAmount(SalesReceipt salesReceipt) {
		Double grossValue= 0.00;
		Double discount= 0.00;
		for(SalesReceiptItem item: salesReceipt.getSalesReceiptItemList()){
			discount = discount+item.getDiscount();
			grossValue = grossValue+item.getTotalAmount();
		}
		salesReceipt.setGrossValue(grossValue);
		salesReceipt.setDiscount(discount);
		salesReceipt.setNetValue(grossValue-discount);
	}

	private void gatherAddedItems(SalesReceipt salesReceipt) {
		List<SalesReceiptItem> list = new ArrayList<SalesReceiptItem>();
		
		for(SalesReceiptItem item:salesReceipt.getSalesReceiptItemList()){
			if(!item.getProductCode().isEmpty()){
				item.getSalesReceipt().setChallanNo(salesReceipt.getChallanNo());
				list.add(item);
			}
		}
		salesReceipt.setSalesReceiptItemList(list);
	}
	
	public PurchaseService getPurchaseService() {
		return purchaseService;
	}

	public void setPurchaseService(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}
}
