package com.erick.calendarioalmoco.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.erick.calendarioalmoco.dao.DuplaMissionariaDAO;
import com.erick.calendarioalmoco.modelo.DuplaMissionaria;
import com.erick.calendarioalmoco.util.jpa.Transactional;

public class DuplaMissionariaBusiness implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	public DuplaMissionariaDAO duplaMissionariaDAO;
	
	@Transactional
	public void salvarDuplaMissionaria(DuplaMissionaria duplaMissionaria){
		this.duplaMissionariaDAO.salvarDuplaMissionaria(duplaMissionaria);
	}
	
	public List<DuplaMissionaria> buscarTodasDuplasMissionarias(){
		return this.duplaMissionariaDAO.buscarTodasDuplasMissionarias();
	}
	
	@Transactional
	public void excluirDuplaMissionaria(DuplaMissionaria duplaMissionaria){
		this.duplaMissionariaDAO.removerDuplaMissionaria(duplaMissionaria);
	}
}
