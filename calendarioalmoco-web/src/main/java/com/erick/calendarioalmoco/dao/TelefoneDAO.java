package com.erick.calendarioalmoco.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.erick.calendarioalmoco.modelo.Telefone;

public class TelefoneDAO {

	@Inject
	private EntityManager entityManager;
	
	public void salvarTelefone(Telefone telefone){
		this.entityManager.merge(telefone);
	}
}
