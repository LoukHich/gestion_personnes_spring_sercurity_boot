package com.ensah.core.bo;

import lombok.Data;

import java.util.Date;

import javax.persistence.*;

@Entity @Data
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;

	@Column(length = 200)
	private String password;

	private Date lastAccessDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id", referencedColumnName = "id")
	private Role role;

	@ManyToOne
	@JoinColumn(name = "idPerson")
	private Person person;

	private boolean accountNonExpired = true;

	private boolean accountNonLocked= true;

	private boolean credentialsNonExpired= true;

	private boolean enabled= true;



	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}



	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}



	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}



	public boolean isEnabled() {
		return enabled;
	}



}