package com.erick.calendarioalmoco.modelo;

public enum TipoTelefone {

	TELEFONE_RESIDENCIA (1, "Telefone Residencial"),
	TELEFONE_MOVEL		(2, "Telefone Movel"),
	TELEFONE_COMERCIAL	(3, "Telefone Comercial"),
	TELEFONE_OUTRO		(4, "Telefone Outro");
	
	private int tipo;
	
	private String descricao;
	
	private TipoTelefone(int tipo, String descricao){
		this.tipo = tipo;
		this.descricao = descricao;
	}

	public int getTipo() {
		return tipo;
	}

	public String getDescricao() {
		return descricao;
	}
}
