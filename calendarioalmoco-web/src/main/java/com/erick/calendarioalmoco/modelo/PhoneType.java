package com.erick.calendarioalmoco.modelo;

public enum PhoneType {

	HOME_PHONE (1, "Home Phone"),
	MOBILE_PHONE (2, "Mobile Phone"),
	WORK_PHONE	(3, "Work phone"),
	OTHER_PHONE	(4, "Other phone");
	
	private int type;
	
	private String description;
	
	private PhoneType(int type, String description){
		this.type = type;
		this.description = description;
	}

	public int getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}
}
