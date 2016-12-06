package com.erick.calendarioalmoco.dao;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;

import com.erick.calendarioalmoco.modelo.Appointment;

public class AppointmentDAO extends GenericDAO<Appointment>{
	
	private static final long serialVersionUID = 1L;

	@Inject
	public AppointmentDAO(EntityManager entityManager, Logger logger) {
		super(entityManager, logger);
	}

	@Override
	protected Class<Appointment> getEntityClass() {
		return Appointment.class;
	}

	public List<Appointment> findByDate(Date date){
		TypedQuery<Appointment> query = this.entityManager.createNamedQuery("Appointment.findByDate", Appointment.class);
		query.setParameter("date", date);
		return query.getResultList();
	}
}
