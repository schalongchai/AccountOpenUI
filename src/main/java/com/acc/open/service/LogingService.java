package com.acc.open.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.acc.open.model.AoUser;

@Service
public class LogingService {
	@Value("${spring.datasource.url}")
	private String restURI;

	public AoUser getUserByUserName(final String username) {
		final String uri = restURI + "/api/users/{id}";
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> params = new HashMap<String, String>();

		AoUser user = null;
		params.put("id", username);

		try {
			ResponseEntity<AoUser> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<AoUser>(){}, params);
			user = response.getBody();
		} catch (RestClientException e) {
			user = null;
		}

		return user;
	}


	public AoUser getUserLogin() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		AoUser user = (AoUser) auth.getPrincipal();
		return user;
	}
	
	@Deprecated
	public void destroyUserLogin(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
	}

}
