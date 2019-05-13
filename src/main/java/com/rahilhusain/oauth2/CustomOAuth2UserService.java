package com.rahilhusain.oauth2;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2User oAuth2User = super.loadUser(userRequest);
		String registrationId = userRequest.getClientRegistration().getRegistrationId();
		switch (registrationId) {
		case "google":
			return new GoogleUser(oAuth2User.getAttributes());
		case "facebook":
			return new FacebookUser(oAuth2User.getAttributes());
		case "github":
			return new GitHubUser(oAuth2User.getAttributes());
		default:
			OAuth2Error oauth2Error = new OAuth2Error("unknown_registration_id",
					"Unknown Registration Id :" + registrationId, null);
			throw new OAuth2AuthenticationException(oauth2Error, oauth2Error.toString());
		}
	}
}
