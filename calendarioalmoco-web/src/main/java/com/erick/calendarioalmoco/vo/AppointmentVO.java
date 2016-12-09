package com.erick.calendarioalmoco.vo;

import java.util.Date;

public class AppointmentVO {
	private Long id;
	private Date date;
	private FamilyVO family;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the family
	 */
	public FamilyVO getFamily() {
		return family;
	}
	/**
	 * @param family the family to set
	 */
	public void setFamily(FamilyVO family) {
		this.family = family;
	}
}
