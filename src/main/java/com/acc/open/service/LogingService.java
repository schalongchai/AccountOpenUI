package com.acc.open.service;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.acc.open.model.AoUser;
import com.google.common.hash.Hashing;

@Service
public class LogingService {
	@Value("${spring.datasource.url}")
	private String restURI;

	public boolean validateLogin(String username, String password) {
		AoUser u = getUserByUserName(username);
		boolean loginResult = false;
		if (u != null) {
			// Check password
			String sha256hash = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
			if (password != null && u.getPassword().equals(sha256hash)) {
				loginResult = true;
			}
		}

		return loginResult;
	}

	public AoUser getUserByUserName(final String username) {
		final String uri = restURI + "/api/users/{id}";
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> params = new HashMap<String, String>();
		AoUser user = new AoUser();
		params.put("id", username);

		try {
			ResponseEntity<AoUser> response = restTemplate.exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<AoUser>() {
					}, params);
			user = response.getBody();
		} catch (RestClientException e) {
			user = null;
		}

		return user;
	}

	public AoUser getUserLogin(HttpServletRequest request) {
		AoUser user = (AoUser) request.getSession().getAttribute("SESSION_USER");
		return user;
	}

	public void setUserLogin(HttpServletRequest request, final AoUser user) {
		request.getSession().setAttribute("SESSION_USER", user);
	}
	
	public void destroyUserLogin(HttpServletRequest request) {
		request.getSession().removeAttribute("SESSION_USER");
		request.getSession().invalidate();
	}
}
