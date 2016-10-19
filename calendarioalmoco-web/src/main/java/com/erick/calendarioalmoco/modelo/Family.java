package com.erick.calendarioalmoco.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "family")
public class Family {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "family_id")
	private Long familyId;
	
	@Column(name = "name", length = 255, nullable = false)
	private String name;
	
	private String address;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_family_available_weekdays")
	private FamilyAvailableWeekdays familyAvailableWeekdays;
	
	@OneToMany(mappedBy = "family", cascade = {CascadeType.ALL})
	private List<ChurchMember> churchMembers;
	
	@OneToMany(mappedBy = "family", cascade = {CascadeType.ALL})
	private List<Schedule> schedules;

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
	 * @return the familyAvailableWeekdays
	 */
	public FamilyAvailableWeekdays getFamilyAvailableWeekdays() {
		return familyAvailableWeekdays;
	}

	/**
	 * @param familyAvailableWeekdays the familyAvailableWeekdays to set
	 */
	public void setFamilyAvailableWeekdays(FamilyAvailableWeekdays familyAvailableWeekdays) {
		this.familyAvailableWeekdays = familyAvailableWeekdays;
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

	/**
	 * @return the schedules
	 */
	public List<Schedule> getSchedules() {
		if (this.schedules == null) {
			this.schedules = new ArrayList<>();
		}
		return schedules;
	}

	/**
	 * @param schedules the schedules to set
	 */
	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((familyId == null) ? 0 : familyId.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Family other = (Family) obj;
		if (familyId == null) {
			if (other.familyId != null)
				return false;
		} else if (!familyId.equals(other.familyId))
			return false;
		return true;
	}
}
