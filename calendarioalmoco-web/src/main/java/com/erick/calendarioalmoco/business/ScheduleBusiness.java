package com.erick.calendarioalmoco.business;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import com.erick.calendarioalmoco.dao.ScheduleDAO;
import com.erick.calendarioalmoco.exception.BusinessException;
import com.erick.calendarioalmoco.modelo.DoubleMissionary;
import com.erick.calendarioalmoco.modelo.Family;
import com.erick.calendarioalmoco.modelo.FamilyAvailableWeekdays;
import com.erick.calendarioalmoco.modelo.Schedule;

public class ScheduleBusiness implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	public ScheduleDAO scheduleDAO;

	public void saveSchedule(Calendar calendar, 
			Family family, DoubleMissionary doubleMissionary) throws BusinessException{
		if (calendar == null || family == null || doubleMissionary == null) {
			return;
		}
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		FamilyAvailableWeekdays familyAvailableWeekdays = family.getFamilyAvailableWeekdays();
		List<Integer> availableWeekdays = familyAvailableWeekdays.getAvailableWeekdays();
		
		boolean isFamilyAvailableWeekdays = false;
		
		for (Integer availableWeekday : availableWeekdays) {
			if (availableWeekday == dayOfWeek) {
				isFamilyAvailableWeekdays = true;
			}
		}
		
		if (isFamilyAvailableWeekdays) {
			Schedule schedule = new Schedule();
			schedule.setDate(calendar.getTime());
			schedule.setFamily(family);
			schedule.setDoubleMissionary(doubleMissionary);
			
			family.getSchedules().add(schedule);
			doubleMissionary.getSchedules().add(schedule);
			
			this.scheduleDAO.save(schedule);
		} else {
			throw new BusinessException("Day of week is not compatible with the day registed for this family");
		}
	}
}
