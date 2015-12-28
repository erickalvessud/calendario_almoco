package com.erick.calendarioalmoco.business;

import java.io.Serializable;

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
}
