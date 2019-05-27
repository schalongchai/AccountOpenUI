package com.acc.open.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	public String account(ModelMap model,@RequestParam("bulkfile") MultipartFile file) {
		AoBulkFile a = bs.readFile(file);
		if(a!=null) {
		 bs.addBulkFile(a);
		}
		List<AoBulkFile> bo = bs.getAllBulks();
		model.addAttribute("tabActive","Account");
		model.addAttribute("bulkfiles", bo);
		return "bulkaccount/list";
		
	}
	
}