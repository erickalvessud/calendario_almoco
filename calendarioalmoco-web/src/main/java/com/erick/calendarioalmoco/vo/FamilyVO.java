package com.erick.calendarioalmoco.vo;

import java.util.ArrayList;
import java.util.List;

public class FamilyVO {
	
	private Long familyId;
	
	private String name;
	
	private AddressVO address;

	private List<Integer> familyAvailableWeekdays;
	
	public FamilyVO() {
		this.address = new AddressVO();
		this.familyAvailableWeekdays = new ArrayList<>();
	}

	/**
	 * @return the familyId
	 */
	public Long getFamilyId() {
		return familyId;
	}

	/**
	 * @param familyId the familyId to set
	 */
	public void setFamilyId(Long familyId) {
		this.familyId = familyId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public AddressVO getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(AddressVO address) {
		this.address = address;
	}

	/**
	 * @return the familyAvailableWeekdays
	 */
	public List<Integer> getFamilyAvailableWeekdays() {
		return familyAvailableWeekdays;
	}

	/**
	 * @param familyAvailableWeekdays the familyAvailableWeekdays to set
	 */
	public void setFamilyAvailableWeekdays(List<Integer> familyAvailableWeekdays) {
		this.familyAvailableWeekdays = familyAvailableWeekdays;
	}
}
