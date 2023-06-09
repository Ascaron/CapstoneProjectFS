package com.epicode.andreacursi.capstoneproject.security;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.epicode.andreacursi.capstoneproject.entities.Utente;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class UserDetailsImpl implements UserDetails{

	private int id;
	private String username;
	private String email;
	@JsonIgnore
	private String password;
	private boolean accountNonLocked = true;
	private boolean accountNonExpired = false;
	private boolean credentialsNonExpired = true;
	private boolean enabled = true;
	private Date expirationTime;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(int id, String username, String email, String password, boolean enabled,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.accountNonLocked = enabled;
		this.accountNonExpired = enabled;
		this.credentialsNonExpired = enabled;
		this.enabled = enabled;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(Utente utente) {
		List<GrantedAuthority> authorities = utente.getRuoli().stream()
				.map(role -> new SimpleGrantedAuthority(role.getTipoRuolo().name())).collect(Collectors.toList());
		return new UserDetailsImpl(utente.getId(), utente.getUsername(), utente.getEmail(), utente.getPassword(),
				utente.getAttivo(), authorities);
	}
	
}
