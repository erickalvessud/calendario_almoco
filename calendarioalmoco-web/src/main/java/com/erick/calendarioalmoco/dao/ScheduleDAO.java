package com.erick.calendarioalmoco.dao;

import javax.persistence.EntityManager;

import org.slf4j.Logger;

import com.erick.calendarioalmoco.modelo.Schedule;

public class ScheduleDAO extends GenericDAO<Schedule>{

	public ScheduleDAO(EntityManager entityManager, Logger logger) {
		super(entityManager, logger);
	}

	@Override
	protected Class<Schedule> getEntityClass() {
		return Schedule.class;
	}

}
