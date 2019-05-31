package com.acc.open.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    @Value("${spring.datasource.url}")
    private String restURI;
    
	
	public String getReport(String sdate,String edate,String branch) {
		
		if(branch.equals("")) {
			branch="all";
		}
		
		final String uri = restURI + "/api/report/account.rpt?sdate="+sdate+"&edate="+edate+"&branch="+branch;
		return uri;
		
	   
	}
}
