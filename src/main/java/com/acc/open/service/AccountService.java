package com.acc.open.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.acc.open.model.AoAccountInfo;

@Service
public class AccountService {
    @Value("${spring.datasource.url}")
    private String restURI;
    

	public List<AoAccountInfo> getAccountById(final String cif)
	{
		List<AoAccountInfo> aoAccts = null;
		final String uri = restURI + "/api/customers/{cif}/accounts/";
		try {
		    RestTemplate restTemplate = new RestTemplate();
		    Map<String, String> params = new HashMap<String, String>();
		    params.put("cif", cif);
		    ResponseEntity<List<AoAccountInfo>> response = restTemplate.exchange(uri, HttpMethod.GET,null, new ParameterizedTypeReference<List<AoAccountInfo>>(){},params);
		    aoAccts = response.getBody();
		} catch (HttpClientErrorException e) {
			
		}
		

	    return aoAccts;
	}

		
	
}
