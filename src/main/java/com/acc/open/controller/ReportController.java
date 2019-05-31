package com.acc.open.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.acc.open.service.ReportService;

@Controller
public class ReportController {
	
	@Autowired
	ReportService rs;
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public String reportDownload(ModelMap model,
			@RequestParam(name="sdate") String sdate,
			@RequestParam(name="edate") String edate,
			@RequestParam(name="branch") String branch) {

		final String link = rs.getReport(sdate, edate, branch);
		
		if(!link.equals("")) {
			model.addAttribute("downloadLink",link);
		}
		model.addAttribute("sdate",sdate);
		model.addAttribute("edate",edate);
		model.addAttribute("branch",branch);
		model.addAttribute("tabActive","Report");
		
		return "report/list";
	}
	
	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String report(ModelMap model) {
	    model.addAttribute("tabActive","Report");
		return "report/list";
	}
	
	
	
}
