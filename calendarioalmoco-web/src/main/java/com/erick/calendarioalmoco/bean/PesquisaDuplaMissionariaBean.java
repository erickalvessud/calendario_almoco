package com.erick.calendarioalmoco.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.erick.calendarioalmoco.business.DuplaMissionariaBusiness;
import com.erick.calendarioalmoco.modelo.DoubleMissionary;

@Named
@ViewScoped
public class PesquisaDuplaMissionariaBean implements Serializable{
	private static final long serialVersionUID = 1L;

	@Inject
	private DuplaMissionariaBusiness duplaMissionariaBusiness;
	
	private List<DoubleMissionary> duplasMissionarias;
	
	private DoubleMissionary duplaMissionariaSelecionada;

	@PostConstruct
	public void init(){
		this.duplasMissionarias = this.duplaMissionariaBusiness.buscarTodasDuplasMissionarias();
	}
	
	public void excluirDuplaMissionaria(){
		this.duplaMissionariaBusiness.excluirDuplaMissionaria(this.duplaMissionariaSelecionada);
		this.duplasMissionarias.remove(this.duplaMissionariaSelecionada);
	}

	public List<DoubleMissionary> getDuplasMissionarias() {
		return duplasMissionarias;
	}
	
	public DoubleMissionary getDuplaMissionariaSelecionada() {
		return duplaMissionariaSelecionada;
	}

	public void setDuplaMissionariaSelecionada(DoubleMissionary duplaMissionariaSelecionada) {
		this.duplaMissionariaSelecionada = duplaMissionariaSelecionada;
	}

}
