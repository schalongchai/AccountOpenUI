package com.acc.open.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReportController {

	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String account(ModelMap model,HttpServletRequest request) {
		model.addAttribute("tabActive","Report");
		return "report/list";
	}
}
