package com.revature.services;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.revature.models.User;
import com.revature.utils.PasswordUtil;

public class AuthPrincipal implements UserDetails {
	private static final long serialVersionUID = 1L;

	private User user;
	
	private String username;
	
	private String password;
	
	public AuthPrincipal(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return this.password = PasswordUtil.hashPassword(user.getPassword());
	}

	@Override
	public String getUsername() {
		return this.username = user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
