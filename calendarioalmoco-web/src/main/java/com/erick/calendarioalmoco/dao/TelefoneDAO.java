package com.erick.calendarioalmoco.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.erick.calendarioalmoco.modelo.Phone;

public class TelefoneDAO {

	@Inject
	private EntityManager entityManager;
	
	public void salvarTelefone(Phone telefone){
		this.entityManager.merge(telefone);
	}
}
