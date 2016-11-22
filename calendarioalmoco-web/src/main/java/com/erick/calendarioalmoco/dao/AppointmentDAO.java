package com.erick.calendarioalmoco.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import com.erick.calendarioalmoco.modelo.Appointment;

public class AppointmentDAO extends GenericDAO<Appointment>{

	@Inject
	public AppointmentDAO(EntityManager entityManager, Logger logger) {
		super(entityManager, logger);
	}

	@Override
	protected Class<Appointment> getEntityClass() {
		return Appointment.class;
	}

}
