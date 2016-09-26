package com.erick.calendarioalmoco.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import com.erick.calendarioalmoco.modelo.DoubleMissionary;

public class DoubleMissionaryDAO extends GenericDAO<DoubleMissionary> {

	@Inject
	public DoubleMissionaryDAO(EntityManager entityManager, Logger logger) {
		super(entityManager, logger);
	}

	@Override
	protected Class<DoubleMissionary> getEntityClass() {
		return DoubleMissionary.class;
	}

}
