package com.school.sms.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import javassist.expr.NewArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.school.sms.constants.Constants;
import com.school.sms.model.Customer;
import com.school.sms.model.EmployeeMaster;
import com.school.sms.model.FixedFeeBatchYearMonth;
import com.school.sms.model.GradeMaster;
import com.school.sms.model.Product;
import com.school.sms.model.SalaryProcessDetail;
import com.school.sms.service.PayrollManagementService;
import com.school.sms.service.PurchaseService;

@Controller
public class PurchaseController {
	
	private Integer customerIndex;
	private List<Customer> customerList = new ArrayList<Customer>();
	
	private Integer productIndex;
	private List<Product> productList = new ArrayList<Product>();
	
	@Resource(name = "purchaseService")
	private PurchaseService purchaseService;

	@RequestMapping(value = "admin/purchase/manageCustomer", method = RequestMethod.GET)
	public ModelAndView manageCustomer() {
		customerIndex=-1;
		initializeCustomerList();
		ModelAndView model = new ModelAndView("purchase_form","command",new Customer());
		
		model.addObject("customerType", Arrays.asList(Constants.CUSTOMER_TYPE));
		//model.setViewName("purchase_form");

		return model;

	}
	
	@RequestMapping(value = "/admin/purchase/manageCustomer", method = RequestMethod.POST)
	public ModelAndView processCustomerCreation(@ModelAttribute("customer")Customer customer,
			@RequestParam(value = "action",required = false) String action,HttpServletRequest request) {
		ModelAndView modelAndView;
		if("search".equalsIgnoreCase(action)){
			Customer customer2= purchaseService.findCustomer((String)request.getParameter("customerCode"));
			if(null==customer2){
				modelAndView = new ModelAndView("purchase_form","command",customer);
				modelAndView.addObject("noCustomerFound",true);
				
			}
			else{
			modelAndView = new ModelAndView("purchase_form","command",customer2);
			customerIndex = getExactCustomerIndex(customer2);
			}
						
		}
		else if("save".equalsIgnoreCase(action)) {
			if (null != customer.getCustomerCode()
					&& !customer.getCustomerName().isEmpty()
					&& !customer.getCustomerType().equals("-1") 
					&& !customer.getAddress().isEmpty() 
					&& !customer.getContactPerson().isEmpty() 
					&& null!=customer.getPhone()
					&& null!=customer.getDateOfCreation()) {
			purchaseService.updateCustomer(customer);
			initializeCustomerList();
			modelAndView = new ModelAndView("purchase_form","command",customer);
			customerIndex = getExactCustomerIndex(customer);
			modelAndView.addObject("customerSaved",true);
			}
			else{
				modelAndView = new ModelAndView("purchase_form","command",customer);
				modelAndView.addObject("isFormIncomplete",true);
			}
		}
		
		else if("delete".equalsIgnoreCase(action)) {
			purchaseService.deleteCustomer(customer);
			initializeCustomerList();
			modelAndView = new ModelAndView("purchase_form","command",new Customer());
			customerIndex= customerIndex-1;
			modelAndView.addObject("customerDeleted",true);
		}
		
		else if("next".equalsIgnoreCase(action)) {
			modelAndView = new ModelAndView("purchase_form","command",this.customerList.get(++customerIndex));
		}
		else if("previous".equalsIgnoreCase(action)) {
			modelAndView = new ModelAndView("purchase_form","command",this.customerList.get(--customerIndex));
		}
		else if("first".equalsIgnoreCase(action)) {
			customerIndex =0;
			modelAndView = new ModelAndView("purchase_form","command",this.customerList.get(customerIndex));
		}
		else if("last".equalsIgnoreCase(action)) {
			customerIndex =this.customerList.size()-1;
			modelAndView = new ModelAndView("purchase_form","command",this.customerList.get(customerIndex));
		}
		else{
			modelAndView = new ModelAndView("purchase_form","command",customer);
		}
		if(customerIndex==this.customerList.size()-1){
			modelAndView.addObject("disableNext", true);
		}
		if(customerIndex<=0){
			modelAndView.addObject("disablePrevious", true);
		}
		modelAndView.addObject("customerList", this.customerList);
		modelAndView.addObject("customerType", Arrays.asList(Constants.CUSTOMER_TYPE));
		return modelAndView;
	}
	private Integer getExactCustomerIndex(Customer customer) {
		int i=0;
		for(Customer cus : customerList){
			if(cus.equals(customer)){
				return i;
			}
			i++;
		}
		return 0;
	}
	private void initializeCustomerList() {
		this.customerList=purchaseService.loadCustomerList();
		
	}
	
	
	@RequestMapping(value = "admin/purchase/manageProduct", method = RequestMethod.GET)
	public ModelAndView manageProduct() {
		productIndex=-1;
		initializeProductList();
		ModelAndView model = new ModelAndView("product_master_form","command",new Product());
		model.addObject("productList", this.productList);
		model.addObject("productUOMList", Arrays.asList(Constants.PRODUCT_UOM));

		return model;

	}
	
	@RequestMapping(value = "/admin/purchase/manageProduct", method = RequestMethod.POST)
	public ModelAndView processProductCreation(@ModelAttribute("product")Product product,
			@RequestParam(value = "action",required = false) String action,HttpServletRequest request) {
		ModelAndView modelAndView;
		if("search".equalsIgnoreCase(action)){
			Product product2= purchaseService.findProduct((String)request.getParameter("productParentCode"));
			if(null==product2){
				modelAndView = new ModelAndView("product_master_form","command",product);
				modelAndView.addObject("noProductFound",true);
				
			}
			else{
			modelAndView = new ModelAndView("product_master_form","command",product2);
			productIndex = getExactProductIndex(product2);
			}
						
		}
		else if("save".equalsIgnoreCase(action)) {
			if (null != product.getProductParentCode()
					&& null!=product.getMRP()) {
			purchaseService.updateProduct(product);
			initializeProductList();
			modelAndView = new ModelAndView("product_master_form","command",product);
			productIndex = getExactProductIndex(product);
			modelAndView.addObject("productSaved",true);
			}
			else{
				modelAndView = new ModelAndView("product_master_form","command",product);
				modelAndView.addObject("isFormIncomplete",true);
			}
		}
		
		else if("delete".equalsIgnoreCase(action)) {
			purchaseService.deleteProduct(product);
			initializeProductList();
			modelAndView = new ModelAndView("product_master_form","command",new Product());
			productIndex= productIndex-1;
			modelAndView.addObject("productDeleted",true);
		}
		
		else if("next".equalsIgnoreCase(action)) {
			modelAndView = new ModelAndView("product_master_form","command",this.productList.get(++productIndex));
		}
		else if("previous".equalsIgnoreCase(action)) {
			modelAndView = new ModelAndView("product_master_form","command",this.productList.get(--productIndex));
		}
		else if("first".equalsIgnoreCase(action)) {
			productIndex =0;
			modelAndView = new ModelAndView("product_master_form","command",this.productList.get(productIndex));
		}
		else if("last".equalsIgnoreCase(action)) {
			productIndex =this.productList.size()-1;
			modelAndView = new ModelAndView("product_master_form","command",this.productList.get(productIndex));
		}
		else{
			modelAndView = new ModelAndView("product_master_form","command",product);
		}
		if(productIndex==this.productList.size()-1){
			modelAndView.addObject("disableNext", true);
		}
		if(productIndex<=0){
			modelAndView.addObject("disablePrevious", true);
		}
		modelAndView.addObject("productList", this.productList);
		modelAndView.addObject("productUOMList", Arrays.asList(Constants.PRODUCT_UOM));
		return modelAndView;
	}
	private Integer getExactProductIndex(Product product) {
		int i=0;
		for(Product pro : productList){
			if(pro.equals(product)){
				return i;
			}
			i++;
		}
		return 0;
	}
	
	private void initializeProductList() {
		this.productList=purchaseService.loadProductList();
		
	}
}
