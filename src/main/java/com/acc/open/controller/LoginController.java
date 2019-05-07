package com.acc.open.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response,ModelMap model) {
		loginService.destroyUserLogin(request, response);
		return "redirect:/login?logout";
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
	
	
}
