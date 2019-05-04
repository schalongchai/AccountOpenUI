package com.acc.open.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.acc.open.model.AoUser;
import com.acc.open.service.LogingService;

@Controller
public class LoginController implements ErrorController {
	
	@Autowired
	LogingService loginService;


	@RequestMapping("/")
    public String index(){
        return "login/login";
    }
	
	@RequestMapping("/login")
    public String login(){
        return "login/login";
    }
	
	@RequestMapping("/error")
    public String handleError(ModelMap model) {
		model.addAttribute("errorMsg","The page your request cannot access or has an error !");
        return "error/error";
    }
	
	@Override
	public String getErrorPath() {
		return "/error";
	}
	
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public String signout(ModelMap model,HttpServletRequest request) {
		loginService.destroyUserLogin(request);
		model.addAttribute("logOutMsg", "You have been logged out.");
		return "login/login";
	}
	

	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String login(ModelMap model,
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password,
	 		HttpServletRequest request) {
		
		Boolean loginOk = false;
		
		if (loginService.validateLogin(username, password)) {
			loginOk = true;
		}

		if (loginOk) {
			AoUser user = loginService.getUserByUserName(username);
			loginService.setUserLogin(request, user);
			model.addAttribute("current_user_login", user);
			model.addAttribute("tabActive","Account");
			return "bulkaccount/list";

		} else {
			model.addAttribute("errorMsg", "Sorry, The Username or Password entered is not valid. Please try again.");
			return "login/login";
		}
		
	}

	

}
