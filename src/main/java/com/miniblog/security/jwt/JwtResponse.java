package com.miniblog.security.jwt;

import com.miniblog.model.dto.UserInfoDTO;

public class JwtResponse {
	
	private String token;
	private String type = "Bearer";
	private UserInfoDTO userInfo;

	public JwtResponse(String accessToken, UserInfoDTO userInfo) {
		this.token = accessToken;
		this.userInfo = userInfo;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public UserInfoDTO getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfoDTO userInfo) {
		this.userInfo = userInfo;
	}

}