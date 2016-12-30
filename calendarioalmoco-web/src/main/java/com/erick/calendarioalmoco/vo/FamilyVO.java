package com.erick.calendarioalmoco.vo;

import java.util.ArrayList;
import java.util.List;

public class FamilyVO {
	
	private Long familyId;
	
	private String name;
	
	private AddressVO addressVO;

	private List<String> familyAvailableWeekdaysList;
	
	public FamilyVO() {
		this.addressVO = new AddressVO();
		this.familyAvailableWeekdaysList = new ArrayList<>();
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
	public AddressVO getAddressVO() {
		return addressVO;
	}

	/**
	 * @param addressVO the address to set
	 */
	public void setAddressVO(AddressVO addressVO) {
		this.addressVO = addressVO;
	}

	/**
	 * @return the familyAvailableWeekdaysList
	 */
	public List<String> getFamilyAvailableWeekdaysList() {
		return familyAvailableWeekdaysList;
	}

	/**
	 * @param familyAvailableWeekdaysList the familyAvailableWeekdaysList to set
	 */
	public void setFamilyAvailableWeekdaysList(List<String> familyAvailableWeekdaysList) {
		this.familyAvailableWeekdaysList = familyAvailableWeekdaysList;
	}
}
