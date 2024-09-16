package com.capturenoww.photographer.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Data
public class Customer implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 232556590466188952L;

	@Id
	private String id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private long phoneNo;

	@Lob
	@Column(name = "profile_photo", columnDefinition="LONGBLOB")
	private byte[] profilePhoto;//required

	@JsonManagedReference
	@OneToMany(mappedBy = "customer", orphanRemoval = true, cascade = CascadeType.PERSIST)
	private List<Booking> booking;
	
	private Date signupDateTime;

	private boolean status;

	private int signupVerificationKey;

	private int resetPasswordVerificationKey;

	private Date resetPasswordReqDateTime;
	
	private boolean isLogin;
	
	private String authToken;
	
	private String role = "ROLE_USER";

	public Customer(){
		this.id = generateCustomId();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(new SimpleGrantedAuthority(role));
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
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

	private String generateCustomId() {
		// Implement your custom ID generation logic here
		// Example: return UUID.randomUUID().toString();
		// You can use any logic to create a unique identifier
		return "CN-C" + UUID.randomUUID().toString();
	}
	
}
