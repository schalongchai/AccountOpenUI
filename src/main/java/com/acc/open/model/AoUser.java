package com.acc.open.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * The persistent class for the AO_USERS database table.
 * 
 */

public class AoUser implements UserDetails {

	private static final long serialVersionUID = 1L;

	private long userId;

	private String brnUser;

	private String firstname;

	private String lastname;

	private String username;
	

	private String password;


	private AoUsersRole aoUsersRole;


	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getBrnUser() {
		return this.brnUser;
	}

	public void setBrnUser(String brnUser) {
		this.brnUser = brnUser;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public AoUsersRole getAoUsersRole() {
		return this.aoUsersRole;
	}

	public void setAoUsersRole(AoUsersRole aoUsersRole) {
		this.aoUsersRole = aoUsersRole;
	}

	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

}