package com.erick.calendarioalmoco.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.erick.calendarioalmoco.business.DuplaMissionariaBusiness;
import com.erick.calendarioalmoco.modelo.DuplaMissionaria;

@Named
@ViewScoped
public class PesquisaDuplaMissionariaBean implements Serializable{
	private static final long serialVersionUID = 1L;

	@Inject
	private DuplaMissionariaBusiness duplaMissionariaBusiness;
	
	private List<DuplaMissionaria> duplasMissionarias;
	
	private DuplaMissionaria duplaMissionariaSelecionada;

	@PostConstruct
	public void init(){
		this.duplasMissionarias = this.duplaMissionariaBusiness.buscarTodasDuplasMissionarias();
	}
	
	public void excluirDuplaMissionaria(){
		this.duplaMissionariaBusiness.excluirDuplaMissionaria(this.duplaMissionariaSelecionada);
		this.duplasMissionarias.remove(this.duplaMissionariaSelecionada);
	}

	public List<DuplaMissionaria> getDuplasMissionarias() {
		return duplasMissionarias;
	}
	
	public DuplaMissionaria getDuplaMissionariaSelecionada() {
		return duplaMissionariaSelecionada;
	}

	public void setDuplaMissionariaSelecionada(DuplaMissionaria duplaMissionariaSelecionada) {
		this.duplaMissionariaSelecionada = duplaMissionariaSelecionada;
	}

}
