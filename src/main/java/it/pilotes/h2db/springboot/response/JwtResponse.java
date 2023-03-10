package it.pilotes.h2db.springboot.response;

import java.util.List;

public class JwtResponse {

	private String token;
	private String type = "Bearer";
	private String id;
	private String userName;
	private String email;
	private List<String> roles;

	public JwtResponse(String accessToken, String id, String userName, String email, List<String> roles) {

		this.token = accessToken;
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.roles = roles;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<String> getRoles() {
		return roles;
	}
}
