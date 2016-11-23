package com.erick.calendarioalmoco.common;

public enum DaysOfTheWeekEnum {

	SUNDAY("1", "Dom"), 
	MONDAY("2", "Seg"), 
	TUESDAY("3", "Ter"), 
	WEDNESDAY("4", "Qua"), 
	THURSDAY("5", "Qui"), 
	FRIDAY("6", "Sex"), 
	SATURDAY("7", "Sab");
	
	private String id;
	private String description;
	
	private DaysOfTheWeekEnum(String id, String description){
		this.id = id;
		this.description = description;
	}	
	
	/**
	 * @return the id
	 */

	public String getId() {
		return id;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
}
