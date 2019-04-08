package com.acc.open.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.acc.open.model.Customer;
import com.acc.open.service.ReportService;

@Controller
public class ReportController {
	
	@Autowired
	ReportService repServ;

	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String account(ModelMap model) {
		return "report/list";
	}
	
	@RequestMapping(value = "/reportresult", method = RequestMethod.POST)
	public String getReportResult(ModelMap model) {
		
		List<Customer>  c = repServ.getData();
		model.addAttribute("ActReport",c);
		return "report/reportresult";
	}
	
}
