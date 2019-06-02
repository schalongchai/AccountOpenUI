package com.acc.open.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.acc.open.model.AoBulkDetail;
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
		List<AoBulkDetail> bulkFileDetails = bs.readFile(file);
		
		if(!bulkFileDetails.isEmpty()) {
			AoBulkFile bulkFile = bs.extractBulkFileHeader(file.getOriginalFilename(), bulkFileDetails);
			bs.addBulkFile(bulkFile);
			for(int i=0;i<bulkFileDetails.size();i++) {
				bs.addBulkDetailFile(bulkFileDetails.get(i),bulkFileDetails.get(i).getId_file());
			}
		}
		List<AoBulkFile> bo = bs.getAllBulks();
		model.addAttribute("tabActive","Account");
		model.addAttribute("bulkfiles", bo);
		return "bulkaccount/list";
		
	}
	
	@RequestMapping(value = "/bulkdelete", method = RequestMethod.POST)
	public String account(ModelMap model,@RequestParam("deleteItems") String items) {
		if(!items.equals(null)) {
			String[] deleteItems = items.split(",");
			if(deleteItems.length>0 && !deleteItems[0].equals("")) {
			  bs.deleteBulkFiles(deleteItems);
			}
		}
		
		List<AoBulkFile> bo = bs.getAllBulks();
		model.addAttribute("tabActive","Account");
		model.addAttribute("bulkfiles", bo);
		return "bulkaccount/list";
		
	}
	
}