package com.erick.calendarioalmoco.modelo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "schedule")
public class Schedule{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "schedule_id")
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "family_id", referencedColumnName = "family_id", nullable = false)
	private Family family;
	
	@ManyToOne
	@JoinColumn(name = "double_missionary_id", referencedColumnName = "double_missionary_id", nullable = false)
	private DoubleMissionary doubleMissionary;

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
	public Family getFamily() {
		return family;
	}

	/**
	 * @param family the family to set
	 */
	public void setFamily(Family family) {
		this.family = family;
	}

	/**
	 * @return the doubleMissionary
	 */
	public DoubleMissionary getDoubleMissionary() {
		return doubleMissionary;
	}

	/**
	 * @param doubleMissionary the doubleMissionary to set
	 */
	public void setDoubleMissionary(DoubleMissionary doubleMissionary) {
		this.doubleMissionary = doubleMissionary;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Schedule other = (Schedule) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
