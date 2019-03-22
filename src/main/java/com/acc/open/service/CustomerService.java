package com.acc.open.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.acc.open.model.Customer;

@Service
public class CustomerService {
    @Value("${spring.datasource.url}")
    private String restURI;

	public List<Customer> getCustomer()
	{
	    final String uri = restURI + "/api/customer/";

	    RestTemplate restTemplate = new RestTemplate();
	    //String result = restTemplate.getForObject(uri, String.class);
	    ResponseEntity<List<Customer>> response = restTemplate.exchange(uri, HttpMethod.GET,null, new ParameterizedTypeReference<List<Customer>>(){});
	    List<Customer> customers = response.getBody();

	    return customers;
	}

	public Customer getCustomerById(String id)
	{
	    final String uri = restURI + "/api/customer/{id}";
	    RestTemplate restTemplate = new RestTemplate();
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("id", id);

	    ResponseEntity<Customer> response = restTemplate.exchange(uri, HttpMethod.GET,null, new ParameterizedTypeReference<Customer>(){},params);
	    Customer customer = response.getBody();

	    return customer;
	}
}
