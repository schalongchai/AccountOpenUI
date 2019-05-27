package com.acc.open.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.acc.open.model.AoBulkFile;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	
	public void addBulkFile(AoBulkFile bulkfile)
	{
		final String uri = restURI + "/api/bulkfiles/";
		try {
		    RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<AoBulkFile> response = restTemplate.postForEntity(uri, bulkfile, AoBulkFile.class);
			response.getBody();
		} catch (HttpClientErrorException e) {
			
		}
		


	}
	
	
	public AoBulkFile readFile(MultipartFile file) {
		 AoBulkFile a = null;
		 if (!file.isEmpty()) {
		        try {
		            byte[] bytes = file.getBytes();
		            String data = new String(bytes);
		            a = new  ObjectMapper().readValue(data, AoBulkFile.class);
		        }
		        catch (Exception e) {
		        	
		        }

		 }
		 return a;
	
	}
}
