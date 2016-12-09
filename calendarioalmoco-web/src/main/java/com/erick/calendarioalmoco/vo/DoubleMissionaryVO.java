package com.erick.calendarioalmoco.vo;

import java.util.List;

public class DoubleMissionaryVO {

	private Long doubleMissionaryId;
	
	private List<MissionaryVO> missionaries;
	
	private List<AppointmentVO> appointments;

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
	public List<MissionaryVO> getMissionaries() {
		return missionaries;
	}

	/**
	 * @param missionaries the missionaries to set
	 */
	public void setMissionaries(List<MissionaryVO> missionaries) {
		this.missionaries = missionaries;
	}

	/**
	 * @return the appointments
	 */
	public List<AppointmentVO> getAppointments() {
		return appointments;
	}

	/**
	 * @param appointments the appointments to set
	 */
	public void setAppointments(List<AppointmentVO> appointments) {
		this.appointments = appointments;
	}
}
