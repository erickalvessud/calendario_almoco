package com.erick.calendarioalmoco.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;

import com.erick.calendarioalmoco.common.DaysOfTheWeekEnum;
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
		
		StringBuilder sql = new StringBuilder();
		
	    sql.append("SELECT c FROM ChurchMember c ");
		sql.append(" INNER JOIN c.family f ");
		sql.append(" INNER JOIN f.familyAvailableWeekdays fawd");
		sql.append(" WHERE ");
		
		if (Integer.parseInt(DaysOfTheWeekEnum.MONDAY.getId()) == weekDay) {
			sql.append(" fawd.monday = ");
		} else if ((Integer.parseInt(DaysOfTheWeekEnum.TUESDAY.getId()) == weekDay)){
			sql.append(" fawd.tuesday = ");
		} else if ((Integer.parseInt(DaysOfTheWeekEnum.WEDNESDAY.getId()) == weekDay)){
			sql.append(" fawd.wednesday = ");
		} else if ((Integer.parseInt(DaysOfTheWeekEnum.THURSDAY.getId()) == weekDay)){
			sql.append(" fawd.thursday = ");
		} else if ((Integer.parseInt(DaysOfTheWeekEnum.FRIDAY.getId()) == weekDay)){
			sql.append(" fawd.friday = ");
		} else if ((Integer.parseInt(DaysOfTheWeekEnum.SATURDAY.getId()) == weekDay)){
			sql.append(" fawd.saturday = ");
		} else if ((Integer.parseInt(DaysOfTheWeekEnum.SUNDAY.getId()) == weekDay)){
			sql.append(" fawd.sunday = ");
		}
		
		sql.append(" :param ");
		
		TypedQuery<ChurchMember> query = this.entityManager.createQuery(sql.toString(), ChurchMember.class);
		
		query.setParameter("param", 1);
		
		return query.getResultList();
	}
}
