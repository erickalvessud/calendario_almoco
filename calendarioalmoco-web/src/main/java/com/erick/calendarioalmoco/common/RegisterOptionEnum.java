package com.erick.calendarioalmoco.common;

public enum RegisterOptionEnum {

	NEW_FAMILY(1, "Cadastrar Família"),
	NEW_DOUBLE_MISSIONARY(2, "Cadastrar Dupla Missionária");
	
	private int id;
	private String description;

	private RegisterOptionEnum(int id, String description){
		this.id = id;
		this.description = description;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
}
