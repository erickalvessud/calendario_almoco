package com.erick.calendarioalmoco.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "missionary_duo")
public class DoubleMissionary implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "double_missionary_id")
	private Long doubleMissionaryId;
	
	@OneToMany(mappedBy = "doubleMissionary")
	private List<Missionary> missionaries;
	
	@OneToMany(mappedBy = "doubleMissionary")
	private List<Schedule> schedules;

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
	public List<Schedule> getSchedules() {
		if (this.schedules == null){
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
}
