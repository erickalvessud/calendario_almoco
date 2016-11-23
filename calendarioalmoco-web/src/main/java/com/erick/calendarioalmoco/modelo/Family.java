package com.erick.calendarioalmoco.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
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
public class Family implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "family_id")
	private Long familyId;
	
	@Column(name = "name", length = 255, nullable = false)
	private String name;
	
	@Embedded
	private Address address;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_family_available_weekdays")
	private FamilyAvailableWeekdays familyAvailableWeekdays;
	
	@OneToMany(mappedBy = "family", cascade = {CascadeType.ALL})
	private List<ChurchMember> churchMembers;
	
	@OneToMany(mappedBy = "family", cascade = {CascadeType.ALL})
	private List<Appointment> appointments;
	
	public Family(){
		
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
	public Address getAddress() {
		if (this.address == null) {
			this.address = new Address();
		}
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the familyAvailableWeekdays
	 */
	public FamilyAvailableWeekdays getFamilyAvailableWeekdays() {
		if (this.familyAvailableWeekdays == null) {
			this.familyAvailableWeekdays = new FamilyAvailableWeekdays();
			this.familyAvailableWeekdays.setFamily(this);
		}
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
		if (this.churchMembers == null) {
			this.churchMembers = new ArrayList<>();
		}
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
	public List<Appointment> getAppointments() {
		if (this.appointments == null) {
			this.appointments = new ArrayList<>();
		}
		return appointments;
	}

	/**
	 * @param schedules the schedules to set
	 */
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
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
