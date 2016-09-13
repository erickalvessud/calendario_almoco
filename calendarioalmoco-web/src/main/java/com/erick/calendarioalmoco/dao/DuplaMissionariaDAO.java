package com.erick.calendarioalmoco.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.erick.calendarioalmoco.modelo.DuplaMissionaria;
import com.erick.calendarioalmoco.util.jpa.Transactional;

public class DuplaMissionariaDAO {

	@Inject
	private EntityManager entityManager;
	
	public void salvarDuplaMissionaria(DuplaMissionaria duplaMissionaria){
		
		this.entityManager.persist(duplaMissionaria);
	}
	
	public List<DuplaMissionaria> buscarTodasDuplasMissionarias(){
		return this.entityManager.createQuery("FROM DuplaMissionaria", DuplaMissionaria.class).getResultList();
	}
	
	@Transactional
	public void removerDuplaMissionaria(DuplaMissionaria duplaMissionaria){
		duplaMissionaria = this.entityManager.find(DuplaMissionaria.class, duplaMissionaria.getId());
		try {
			this.entityManager.remove(duplaMissionaria);
		} catch (PersistenceException e) {
			System.out.println("Não pode remover a dupla");
		}
	}
}
