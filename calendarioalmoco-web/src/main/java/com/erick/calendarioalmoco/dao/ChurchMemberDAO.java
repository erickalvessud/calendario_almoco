package com.erick.calendarioalmoco.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import com.erick.calendarioalmoco.modelo.ChurchMember;

public class ChurchMemberDAO extends GenericDAO<ChurchMember>{

	@Inject
	public ChurchMemberDAO(EntityManager entityManager, Logger logger) {
		super(entityManager, logger);
	}

	@Override
	protected Class<ChurchMember> getEntityClass() {
		return ChurchMember.class;
	}

	/**
	 * Returns ChurchMembers who has this week day available.
	 * @param weekDay
	 * @return
	 */
	public List<ChurchMember> findByAvailableWeekDay(int weekDay){
		return null;
	}
}
