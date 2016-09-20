package com.erick.calendarioalmoco.modelo;

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
@Table(name = "user_phone")
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "phone_id")
	private Long phoneId;

	@Column(name = "area_code", length = 2, nullable = false)
	private String areaCode;

	@Column(name = "phone_number", length = 9, nullable = false)
	private String phoneNumber;

	@Column(name = "phone_type", nullable = false)
	private PhoneType phoneType;

	@ManyToOne( optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	/**
	 * @return the phoneId
	 */
	public Long getPhoneId() {
		return phoneId;
	}

	/**
	 * @param phoneId the phoneId to set
	 */
	public void setPhoneId(Long phoneId) {
		this.phoneId = phoneId;
	}

	/**
	 * @return the areaCode
	 */
	public String getAreaCode() {
		return areaCode;
	}

	/**
	 * @param areaCode the areaCode to set
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the phoneType
	 */
	public PhoneType getPhoneType() {
		return phoneType;
	}

	/**
	 * @param phoneType the phoneType to set
	 */
	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
