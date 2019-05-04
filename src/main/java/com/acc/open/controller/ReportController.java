package com.acc.open.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.acc.open.service.LogingService;

@Controller
public class ReportController {
	@Autowired
	private LogingService loginService;
	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String account(ModelMap model,HttpServletRequest request) {
		model.addAttribute("current_user_login",loginService.getUserLogin(request));
		model.addAttribute("tabActive","Report");
		return "report/list";
	}
}
