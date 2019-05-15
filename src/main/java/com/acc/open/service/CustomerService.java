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

import com.acc.open.model.AoCustomerInfo;

@Service
public class CustomerService {
    @Value("${spring.datasource.url}")
    private String restURI;
    

	public List<AoCustomerInfo> getCustomer()
	{
	    final String uri = restURI + "/api/customers/";

	    RestTemplate restTemplate = new RestTemplate();
	    //String result = restTemplate.getForObject(uri, String.class);
	    ResponseEntity<List<AoCustomerInfo>> response = restTemplate.exchange(uri, HttpMethod.GET,null, new ParameterizedTypeReference<List<AoCustomerInfo>>(){});
	    List<AoCustomerInfo> aoCusts = response.getBody();

	    return aoCusts;
	}

	public AoCustomerInfo getCustomerById(String id)
	{
	    final String uri = restURI + "/api/customers/{id}";
	    RestTemplate restTemplate = new RestTemplate();
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("id", id);

	    ResponseEntity<AoCustomerInfo> response = restTemplate.exchange(uri, HttpMethod.GET,null, new ParameterizedTypeReference<AoCustomerInfo>(){},params);
	    AoCustomerInfo customer = response.getBody();

	    return customer;
	}
	
	public List<AoCustomerInfo> getCustomerSearch(String cif,String fname,String lname,String citizen,String acctno)
	{
	    final String uri = restURI + "/api/customers?cif={cif}&fname={fname}&lname={lname}&citizen={citizen}&acctno={acctno}";
	    RestTemplate restTemplate = new RestTemplate();
	    Map<String, String> params = new HashMap<String, String>();
	    List<AoCustomerInfo> customer = null;
	    params.put("cif", cif);
	    params.put("fname", fname);
	    params.put("lname", lname);
	    params.put("citizen", citizen);
	    params.put("acctno", acctno); 
	    try {
	    	ResponseEntity<List<AoCustomerInfo>> response = restTemplate.exchange(uri, HttpMethod.GET,null, new ParameterizedTypeReference<List<AoCustomerInfo>>(){},params);
	    	customer = response.getBody();
	    } catch (HttpClientErrorException e) {

	    }
	    return customer;
	}
}
