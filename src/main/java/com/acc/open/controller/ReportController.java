package com.acc.open.controller;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.acc.open.service.ReportService;

@Controller
public class ReportController {

	@Autowired
	ReportService rs;

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> reportDownload(ModelMap model,
			@RequestParam(name = "sdate") String sdate, 
			@RequestParam(name = "edate") String edate,
			@RequestParam(name = "branch") String branch) {

		byte[] data = rs.downloadFile(sdate, edate, branch);
		ByteArrayInputStream in = new ByteArrayInputStream(data);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=accounts.xlsx");
		headers.add("Content-Type", "application/vnd.ms-excel; charset=utf-8");
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));

	}

	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String report(ModelMap model) {
		model.addAttribute("tabActive", "Report");
		return "report/list";
	}

}
