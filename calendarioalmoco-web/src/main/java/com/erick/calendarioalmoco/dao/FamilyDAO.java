package com.erick.calendarioalmoco.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import com.erick.calendarioalmoco.modelo.Family;

public class FamilyDAO extends GenericDAO<Family> {

	@Inject
	public FamilyDAO(EntityManager entityManager, Logger logger) {
		super(entityManager, logger);
	}

	@Override
	protected Class<Family> getEntityClass() {
		return Family.class;
	}
	
}
