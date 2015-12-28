package com.erick.calendarioalmoco.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
/**
 * Conflito entre anotações JSF e CDI
 * Fonte: Livro CDI Integre as dependências e contextos do seu código Java 
 * capítulo 8.2 - Relação entre CDI e JSF
 */
//import javax.faces.bean.ViewScoped; //nao funciona
import javax.faces.view.ViewScoped; //funcinou!
import javax.inject.Inject;
import javax.inject.Named;

import com.erick.calendarioalmoco.business.DuplaMissionariaBusiness;
import com.erick.calendarioalmoco.modelo.DuplaMissionaria;
import com.erick.calendarioalmoco.modelo.Telefone;
import com.erick.calendarioalmoco.modelo.TipoTelefone;

@Named
@ViewScoped
public class CadastroDuplaMissionariaBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private DuplaMissionaria duplaMissionaria;

	@Inject
	private DuplaMissionariaBusiness duplaMissionariaBusiness;
	
	@PostConstruct
	public void init(){
		this.duplaMissionaria = new DuplaMissionaria();
	}
	
	public void salvar(){
		this.duplaMissionariaBusiness.salvarDuplaMissionaria(this.duplaMissionaria);
		this.limpar();
	}
	
	public void adicionarTelefone(){
		Telefone telefone = new Telefone();
		telefone.setDuplaMissionaria(this.duplaMissionaria);
		this.duplaMissionaria.getTelefones().add(telefone);
	}
	
	public void limpar(){
		this.duplaMissionaria = new DuplaMissionaria();
	}
	
	public DuplaMissionaria getDuplaMissionaria() {
		return duplaMissionaria;
	}
	public void setDuplaMissionaria(DuplaMissionaria duplaMissionaria) {
		this.duplaMissionaria = duplaMissionaria;
	}
	
	public TipoTelefone[] getTipoTelefone() {
		return TipoTelefone.values();
	}
}
