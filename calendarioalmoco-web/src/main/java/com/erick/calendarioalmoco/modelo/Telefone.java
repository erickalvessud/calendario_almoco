package com.erick.calendarioalmoco.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dupla_missionaria_telefone")
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long id;

	@Column(name = "codigo_area", length = 2, nullable = false)
	private String codigoArea;

	@Column(name = "numero", length = 9, nullable = false)
	private String numero;

	@Column(name = "tipo_telefone", nullable = false)
	private TipoTelefone tipoTelefone;

	@ManyToOne( optional = false, cascade = CascadeType.PERSIST,
			fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_dupla_missionaria")
	private DuplaMissionaria duplaMissionaria;

	public String getCodigoArea() {
		return codigoArea;
	}

	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public DuplaMissionaria getDuplaMissionaria() {
		return duplaMissionaria;
	}

	public void setDuplaMissionaria(DuplaMissionaria duplaMissionaria) {
		this.duplaMissionaria = duplaMissionaria;
	}
}
