package com.ensah.core.web.models;

//Classe model utilisé dans la partie web
// pour recevoir les données de la vue 
//utilisée pour créer les comptes
//C'est une classe non persistante

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class AccountModel {
	
	private String username;
	
	private String password;
	
	private Long roleId;
	
	private Long personId;
	
	


	public AccountModel(Long personId) {
		this.personId = personId;
	}

	
	public AccountModel(Long roleId, Long personId) {
		this.roleId = roleId;
		this.personId = personId;
	}



	
	
	
}
