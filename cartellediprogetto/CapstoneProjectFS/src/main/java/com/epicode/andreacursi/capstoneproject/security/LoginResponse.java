package com.epicode.andreacursi.capstoneproject.security;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {

	private String token;
	private final String type = "Bearer";
	private int id;
	private String username;
	private String email;
	private List<String> roles;
	private Date expirationTime;
	
}
