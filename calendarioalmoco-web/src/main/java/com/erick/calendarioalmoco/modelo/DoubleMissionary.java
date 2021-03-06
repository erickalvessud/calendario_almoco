package com.erick.calendarioalmoco.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "double_missionary")
public class DoubleMissionary implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "double_missionary_id")
	private Long doubleMissionaryId;
	
	@OneToMany(mappedBy = "doubleMissionary", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Missionary> missionaries;
	
	@OneToMany(mappedBy = "doubleMissionary")
	private List<Appointment> appointments;

	public DoubleMissionary(){
		super();
	}
	
	/**
	 * @return the doubleMissionaryId
	 */
	public Long getDoubleMissionaryId() {
		return doubleMissionaryId;
	}

	/**
	 * @param doubleMissionaryId the doubleMissionaryId to set
	 */
	public void setDoubleMissionaryId(Long doubleMissionaryId) {
		this.doubleMissionaryId = doubleMissionaryId;
	}

	/**
	 * @return the missionaries
	 */
	public List<Missionary> getMissionaries() {
		return missionaries;
	}

	/**
	 * @param missionaries the missionaries to set
	 */
	public void setMissionaries(List<Missionary> missionaries) {
		this.missionaries = missionaries;
	}
	
	
	/**
	 * @return the schedules
	 */
	public List<Appointment> getAppointments() {
		if (this.appointments == null){
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
}
