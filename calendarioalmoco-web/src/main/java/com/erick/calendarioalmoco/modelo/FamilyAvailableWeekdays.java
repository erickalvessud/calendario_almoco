package com.erick.calendarioalmoco.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "family_available_weekdays")
public class FamilyAvailableWeekdays {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_family_available_weekdays")
	private long idFamilyAvailableWeekdays;
	
	@Column(name = "sunday", length = 1, nullable = true)
	private int sunday;
	
	@Column(name = "monday", length = 1, nullable = true)
	private int monday;
	
	@Column(name = "tuesday", length = 1, nullable = true)
	private int tuesday;
	
	@Column(name = "wednesday", length = 1, nullable = true)
	private int wednesday;
	
	@Column(name = "thursday", length = 1, nullable = true)
	private int thursday;
	
	@Column(name = "friday", length = 1, nullable = true)
	private int friday;
	
	@Column(name = "saturday", length = 1, nullable = true)
	private int saturday;
	
	@OneToOne(mappedBy = "familyAvailableWeekdays")
	private Family family;
	
	public List<Integer> getAvailableWeekdays(){
		List<Integer> availableWeekdays = new ArrayList<>();
		
		if (this.sunday == 1) {
			availableWeekdays.add(1);
		}
		if (this.monday == 1) {
			availableWeekdays.add(2);
		}
		if (this.tuesday == 1) {
			availableWeekdays.add(3);
		}
		if (this.wednesday == 1) {
			availableWeekdays.add(4);
		}
		if (this.thursday == 1) {
			availableWeekdays.add(5);
		}
		if (this.friday == 1) {
			availableWeekdays.add(6);
		}
		if (this.saturday == 1) {
			availableWeekdays.add(7);
		}
		return availableWeekdays;
	}

	/**
	 * @return the idFamilyAvailableWeekdays
	 */
	public long getIdFamilyAvailableWeekdays() {
		return idFamilyAvailableWeekdays;
	}

	/**
	 * @param idFamilyAvailableWeekdays the idFamilyAvailableWeekdays to set
	 */
	public void setIdFamilyAvailableWeekdays(long idFamilyAvailableWeekdays) {
		this.idFamilyAvailableWeekdays = idFamilyAvailableWeekdays;
	}

	/**
	 * @return the sunday
	 */
	public int getSunday() {
		return sunday;
	}

	/**
	 * @param sunday the sunday to set
	 */
	public void setSunday(int sunday) {
		this.sunday = sunday;
	}

	/**
	 * @return the monday
	 */
	public int getMonday() {
		return monday;
	}

	/**
	 * @param monday the monday to set
	 */
	public void setMonday(int monday) {
		this.monday = monday;
	}

	/**
	 * @return the tuesday
	 */
	public int getTuesday() {
		return tuesday;
	}

	/**
	 * @param tuesday the tuesday to set
	 */
	public void setTuesday(int tuesday) {
		this.tuesday = tuesday;
	}

	/**
	 * @return the wednesday
	 */
	public int getWednesday() {
		return wednesday;
	}

	/**
	 * @param wednesday the wednesday to set
	 */
	public void setWednesday(int wednesday) {
		this.wednesday = wednesday;
	}

	/**
	 * @return the thursday
	 */
	public int getThursday() {
		return thursday;
	}

	/**
	 * @param thursday the thursday to set
	 */
	public void setThursday(int thursday) {
		this.thursday = thursday;
	}

	/**
	 * @return the friday
	 */
	public int getFriday() {
		return friday;
	}

	/**
	 * @param friday the friday to set
	 */
	public void setFriday(int friday) {
		this.friday = friday;
	}

	/**
	 * @return the saturday
	 */
	public int getSaturday() {
		return saturday;
	}

	/**
	 * @param saturday the saturday to set
	 */
	public void setSaturday(int saturday) {
		this.saturday = saturday;
	}

	/**
	 * @return the family
	 */
	public Family getFamily() {
		return family;
	}

	/**
	 * @param family the family to set
	 */
	public void setFamily(Family family) {
		this.family = family;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idFamilyAvailableWeekdays ^ (idFamilyAvailableWeekdays >>> 32));
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
		FamilyAvailableWeekdays other = (FamilyAvailableWeekdays) obj;
		if (idFamilyAvailableWeekdays != other.idFamilyAvailableWeekdays)
			return false;
		return true;
	}
}
