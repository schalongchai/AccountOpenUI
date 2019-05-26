package com.acc.open.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.acc.open.model.AoAccountInfo;
import com.acc.open.model.AoBulkFile;
import com.acc.open.service.AccountService;
import com.acc.open.service.BulkService;
import com.acc.open.service.LogingService;

@Controller
public class AccountController {
	@Autowired
	LogingService loginService;
	
	@Autowired
	private AccountService cs;
	
	@Autowired
	private BulkService bs;
	
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String account(ModelMap model,HttpServletRequest request) {
		List<AoBulkFile> bo = bs.getAllBulks();
		model.addAttribute("tabActive","Account");
		model.addAttribute("bulkfiles", bo);
		return "bulkaccount/list";
		
	}
	
	@RequestMapping(value = "/accountinfo", method = RequestMethod.GET)
	public String getAccountInfo(@RequestParam("cif") String cif, ModelMap model) {
		String ret="";
		List<AoAccountInfo> accounts = cs.getAccountById(cif);
		if(accounts!=null){
			model.addAttribute("accounts", accounts);
			ret = "account/info";
		}else {
			model.addAttribute("response", "Account not found!");
			ret = "error/error";
		}
		return ret;
	}
}
