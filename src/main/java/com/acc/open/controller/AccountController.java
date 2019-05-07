package com.acc.open.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.acc.open.model.AoUser;
import com.acc.open.service.LogingService;

@Controller
public class AccountController {
	@Autowired
	LogingService loginService;
	
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String account(ModelMap model,HttpServletRequest request) {
		AoUser u = loginService.getUserLogin(request);
		model.addAttribute("current_user_login",u);
		model.addAttribute("tabActive","Account");
		return "bulkaccount/list";
		
	}
}
