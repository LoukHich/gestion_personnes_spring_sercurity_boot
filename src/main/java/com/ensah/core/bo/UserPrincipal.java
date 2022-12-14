package com.ensah.core.bo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//Cette classe n'est pas pesistante

//Classe qui embale UserAccount et qui implémente UserDetails 
// pour répondre aux specifications de Spring Security qui travaille avec
//UserDetails (Voir la méthode loadUserbyusername de la classe CustomAuthentificationService)
public class UserPrincipal implements UserDetails {

	// Le compte utilisateur (classe persistante à gérer par ORM)
	private UserAccount user;

	@Override
	public String toString() {
		return "MyUserPrincipal [user=" + user + "]";
	}

	public UserPrincipal(UserAccount user) {
		this.user = user;
	}

	public UserAccount getUser() {
		return user;
	}

	public void setUser(UserAccount user) {
		this.user = user;
	}

	/**
	 * 
	 * Cette méthode définie les autorisations de l’utilisateur. Dans notre cas,
	 * nous utilisons la notion de rôle comme un ensemble d’autorisation, ainsi,
	 * nous allons retourner le seul rôle de l’utilisateur sous forme d’une
	 * collection contenant un seul objet de type GrantedAuthority pour respecter
	 * les spécifications de cette méthode.
	 * 
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		ArrayList<GrantedAuthority> arrayAuths = new ArrayList<GrantedAuthority>();

		SimpleGrantedAuthority auth = new SimpleGrantedAuthority(user.getRole().getRoleName());
		arrayAuths.add(auth);
		return arrayAuths;
	}

	// TODO : les méthodes suivantes à adapter si vous changer la conception des
	// classes
	// Sinon vous pouvez les laisser telles quelles
	public String getFirstName() {
		return user.getPerson().getFirstName();
	}

	public String getLastName() {
		return user.getPerson().getLastName();
	}

	public String getEmail() {
		return user.getPerson().getEmail();
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return user.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return user.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return user.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return user.isEnabled();
	}

}