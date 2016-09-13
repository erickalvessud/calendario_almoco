package com.erick.calendarioalmoco.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
@DiscriminatorValue(value = "P")
@PrimaryKeyJoinColumn(name = "id_usuario")
public class Pessoa extends Usuario {

	private String endereco;
	
	
}
