package com.erick.calendarioalmoco.modelo;

public enum UserType {

	CHURCH_MEMBER("ChurchMember"),
	MISSIONARY("Missionary");
	
	private String value;

	private UserType(String value){
		this.value = value;
	}
	
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
