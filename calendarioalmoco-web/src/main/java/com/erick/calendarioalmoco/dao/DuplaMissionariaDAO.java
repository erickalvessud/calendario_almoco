package com.erick.calendarioalmoco.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.erick.calendarioalmoco.modelo.DoubleMissionary;
import com.erick.calendarioalmoco.util.jpa.Transactional;

public class DuplaMissionariaDAO {

	@Inject
	private EntityManager entityManager;
	
	public void salvarDuplaMissionaria(DoubleMissionary duplaMissionaria){
		
		this.entityManager.persist(duplaMissionaria);
	}
	
	public List<DoubleMissionary> buscarTodasDuplasMissionarias(){
		return this.entityManager.createQuery("FROM DuplaMissionaria", DoubleMissionary.class).getResultList();
	}
	
	@Transactional
	public void removerDuplaMissionaria(DoubleMissionary duplaMissionaria){
		duplaMissionaria = this.entityManager.find(DoubleMissionary.class, duplaMissionaria.getDoubleMissionaryId());
		try {
			this.entityManager.remove(duplaMissionaria);
		} catch (PersistenceException e) {
			System.out.println("Não pode remover a dupla");
		}
	}
}
