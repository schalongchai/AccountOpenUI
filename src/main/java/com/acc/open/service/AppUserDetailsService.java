package com.acc.open.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.acc.open.model.AoUser;
import com.acc.open.service.LogingService;

@Service
public class AppUserDetailsService implements UserDetailsService {
	@Autowired
	private LogingService loginService;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		AoUser activeUserInfo = loginService.getUserByUserName(userName);
		
		if (activeUserInfo == null) {
            throw new UsernameNotFoundException(userName);
        }
		
		return activeUserInfo;
	}

	

}
