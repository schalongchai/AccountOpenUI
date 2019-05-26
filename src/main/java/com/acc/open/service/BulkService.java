package com.acc.open.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.acc.open.model.AoBulkFile;

@Service
public class BulkService {
    @Value("${spring.datasource.url}")
    private String restURI;
    

	public List<AoBulkFile> getAllBulks()
	{
		List<AoBulkFile> bulkFile = null;
		final String uri = restURI + "/api/bulkfiles/";
		try {
		    RestTemplate restTemplate = new RestTemplate();
		    ResponseEntity<List<AoBulkFile>> response = restTemplate.exchange(uri, HttpMethod.GET,null, new ParameterizedTypeReference<List<AoBulkFile>>(){});
		    bulkFile = response.getBody();
		} catch (HttpClientErrorException e) {
			
		}
		

	    return bulkFile;
	}
	
	public List<AoBulkFile> addBulkFile()
	{
		List<AoBulkFile> bulkFile = null;
		final String uri = restURI + "/api/bulkfiles/";
		try {
		    RestTemplate restTemplate = new RestTemplate();
		    ResponseEntity<List<AoBulkFile>> response = restTemplate.exchange(uri, HttpMethod.POST,null, new ParameterizedTypeReference<List<AoBulkFile>>(){});
		    bulkFile = response.getBody();
		} catch (HttpClientErrorException e) {
			
		}
		

	    return bulkFile;
	}

		
	
}
