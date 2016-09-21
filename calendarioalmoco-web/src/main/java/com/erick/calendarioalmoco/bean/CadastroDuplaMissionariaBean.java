package com.erick.calendarioalmoco.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
/**
 * Conflito entre anota��es JSF e CDI
 * Fonte: Livro CDI Integre as depend�ncias e contextos do seu c�digo Java 
 * cap�tulo 8.2 - Rela��o entre CDI e JSF
 */
//import javax.faces.bean.ViewScoped; //nao funciona
import javax.faces.view.ViewScoped; //funcinou!
import javax.inject.Inject;
import javax.inject.Named;

import com.erick.calendarioalmoco.business.DuplaMissionariaBusiness;
import com.erick.calendarioalmoco.modelo.DoubleMissionary;
import com.erick.calendarioalmoco.modelo.Phone;
import com.erick.calendarioalmoco.modelo.PhoneType;

@Named
@ViewScoped
public class CadastroDuplaMissionariaBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private DoubleMissionary duplaMissionaria;

	@Inject
	private DuplaMissionariaBusiness duplaMissionariaBusiness;
	
	@PostConstruct
	public void init(){
		this.duplaMissionaria = new DoubleMissionary();
	}
	
	public void salvar(){
		this.duplaMissionariaBusiness.salvarDuplaMissionaria(this.duplaMissionaria);
		this.limpar();
	}
	
	public void adicionarTelefone(){
//		Phone telefone = new Phone();
//		telefone.setUsuario(this.duplaMissionaria);
//		this.duplaMissionaria.getTelefones().add(telefone);
	}
	
	public void limpar(){
		this.duplaMissionaria = new DoubleMissionary();
	}
	
	public DoubleMissionary getDuplaMissionaria() {
		return duplaMissionaria;
	}
	public void setDuplaMissionaria(DoubleMissionary duplaMissionaria) {
		this.duplaMissionaria = duplaMissionaria;
	}
	
	public PhoneType[] getTipoTelefone() {
		return PhoneType.values();
	}
}
