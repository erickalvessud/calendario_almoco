package com.erick.calendarioalmoco.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	private Long id;
	
	private String nome;
	
	private String email;
	
	private List<Telefone> telefone;
}
