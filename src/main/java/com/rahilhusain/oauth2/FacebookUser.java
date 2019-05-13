package com.rahilhusain.oauth2;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class FacebookUser implements ExtendedOAuthUser {
	private final Map<String, Object> attributes;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public Map<String, Object> getAttributes() {
		return this.attributes;
	}

	@Override
	public String getEmail() {
		return (String) this.attributes.get("email");
	}

	@Override
	public String getImageUrl() {
		return (String) this.attributes.get("picture");
	}

	@Override
	public String getProviderId() {
		return (String) this.attributes.get("id");
	}

	@Override
	public String getName() {
		return (String) this.attributes.get("name");
	}

	@Override
	public OAuthProvider getOAuthProvider() {
		return OAuthProvider.facebook;
	}

	public FacebookUser(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

}
