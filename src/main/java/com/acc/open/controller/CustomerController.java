package com.acc.open.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.acc.open.model.AoCustomerInfo;
import com.acc.open.service.CustomerService;
import com.acc.open.service.LogingService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService cs;
	@Autowired
	private LogingService loginService;
	
	
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public String homePath(ModelMap model) {
		return "customer/custsearch";
	}

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String CustomerGet(ModelMap model,HttpServletRequest request) {
		List<AoCustomerInfo> c = cs.getCustomer();
		model.addAttribute("customers", c);
		model.addAttribute("current_user_login",loginService.getUserLogin(request));
		model.addAttribute("tabActive","Customer");
		return "customer/custsearch";
	}


	@RequestMapping(value = "/customerinfo", method = RequestMethod.GET)
	public String search(@RequestParam("cif") Long cif, ModelMap model) {
		String ret="";
		AoCustomerInfo c = cs.getCustomerById(cif.toString());
		if(c!=null){
			model.addAttribute("customer", c);
			ret = "customer/info";
		}else {
			model.addAttribute("response", "Customer not found!");
			ret = "error/error";
		}
		return ret;
	}

}
