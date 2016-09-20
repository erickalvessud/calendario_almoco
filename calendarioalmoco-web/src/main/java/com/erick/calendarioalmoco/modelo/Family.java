package com.erick.calendarioalmoco.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "family")
public class Family {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "family_id")
	protected Long familyId;
	
	private String address;
	
	@OneToMany(mappedBy = "family")
	private List<ChurchMember> churchMembers;

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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the churchMembers
	 */
	public List<ChurchMember> getChurchMembers() {
		return churchMembers;
	}

	/**
	 * @param churchMembers the churchMembers to set
	 */
	public void setChurchMembers(List<ChurchMember> churchMembers) {
		this.churchMembers = churchMembers;
	}
}
