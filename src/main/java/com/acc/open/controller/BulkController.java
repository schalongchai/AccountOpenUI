package com.acc.open.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.acc.open.model.AoBulkFile;
import com.acc.open.service.BulkService;
import com.acc.open.service.LogingService;

@Controller
public class BulkController {
	@Autowired
	LogingService loginService;
	
	@Autowired
	private BulkService bs;
	
	@RequestMapping(value = "/bulkupload", method = RequestMethod.POST)
	public String account(ModelMap model,HttpServletRequest request) {
	
		List<AoBulkFile> bo = bs.getAllBulks();
		model.addAttribute("tabActive","Account");
		model.addAttribute("bulkfiles", bo);
		return "bulkaccount/list";
		
	}
	
}
