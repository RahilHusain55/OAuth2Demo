package com.rahilhusain.oauth2;

import org.springframework.security.oauth2.core.user.OAuth2User;

public interface ExtendedOAuthUser extends OAuth2User {
	String getEmail();

	String getImageUrl();

	String getProviderId();

	String getName();

	OAuthProvider getOAuthProvider();

}
