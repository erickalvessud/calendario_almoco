package com.erick.calendarioalmoco.business;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.erick.calendarioalmoco.dao.AppointmentDAO;
import com.erick.calendarioalmoco.dao.DoubleMissionaryDAO;
import com.erick.calendarioalmoco.dao.FamilyDAO;
import com.erick.calendarioalmoco.exception.BusinessException;
import com.erick.calendarioalmoco.modelo.DoubleMissionary;
import com.erick.calendarioalmoco.modelo.Family;
import com.erick.calendarioalmoco.modelo.FamilyAvailableWeekdays;
import com.erick.calendarioalmoco.util.jpa.Transactional;
import com.erick.calendarioalmoco.vo.DoubleMissionaryVO;
import com.erick.calendarioalmoco.vo.FamilyVO;
import com.erick.calendarioalmoco.modelo.Appointment;

/**
 * This class manages all business rules for lunch schedule.
 * @author Erick Alves
 */
public class AppointmentBusiness implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AppointmentDAO appointmentDAO;
	
	@Inject
	private FamilyDAO familyDAO;
	
	@Inject
	private DoubleMissionaryDAO doubleMissionaryDAO;

	/**
	 * Save a appointment of lunch. This method returns without do nothing if any
	 * parameters passed to it was null.
	 * 
	 * @param date
	 *            - Date to the lunch.
	 * @param familyVO
	 *            - Family who will offer the lunch.
	 * @param doubleMissionaryVO
	 *            - Double missionary who this lunch is schedule to.
	 * @throws BusinessException
	 *             There are two cases that this method can throws a
	 *             {@link BusinessException}:
	 *             <ul>
	 *             <li>If the day of week for this schedule date is a day that
	 *             was not registered for this family.</li>
	 *             <li>If the schedule date is less than the current date.</li>
	 *             </ul>
	 */
	@Transactional
	public void saveAppointments(Date date, FamilyVO familyVO, DoubleMissionaryVO doubleMissionaryVO)
			throws BusinessException {
		if (date == null || familyVO == null || doubleMissionaryVO == null) {
			return;
		}
		
		Calendar scheduleDate = Calendar.getInstance();
		scheduleDate.setTime(date);

		if (!this.isValidAppointmentDate(scheduleDate)) {
			throw new BusinessException("Desired date for appointment cannot be less than current date");
		}

		int dayOfWeek = scheduleDate.get(Calendar.DAY_OF_WEEK);
		
		Family family = this.familyDAO.findById(familyVO.getFamilyId());
		DoubleMissionary doubleMissionary = this.doubleMissionaryDAO.findById(doubleMissionaryVO.getDoubleMissionaryId());
		
		
		FamilyAvailableWeekdays familyAvailableWeekdays = family.getFamilyAvailableWeekdays();

		if (this.isFamilyAvailableWeekdays(dayOfWeek, familyAvailableWeekdays)) {

			Appointment appointments = new Appointment();
			appointments.setDate(date);
			appointments.setFamily(family);
			appointments.setDoubleMissionary(doubleMissionary);

			family.getAppointments().add(appointments);
			doubleMissionary.getAppointments().add(appointments);

			this.appointmentDAO.save(appointments);
		} else {
			throw new BusinessException("Day of week is not compatible with the day registed for this family");
		}
	}
	
	
	
	/**
	 * Validade if this date is greater than current date.
	 * 
	 * @param appointmentDate
	 *            - Date which desire to validate.
	 * @return true if this date is greater than current date or false
	 *         otherwise.
	 */
	private boolean isValidAppointmentDate(Calendar appointmentDate){
		long desiredDate = appointmentDate.getTimeInMillis();
		long currentDate = Calendar.getInstance().getTimeInMillis();

		return desiredDate > currentDate;
	}
	
	/**
	 * Validate if this day of week has in the list of family available days of
	 * week.
	 * 
	 * @param dayOfWeek
	 *            - Day of week which is desired to schedule the lunch.
	 * @param familyAvailableWeekdays
	 *            - Family available days of week.
	 * @return true if this passed day of week has in the list of family
	 *         available days of week or false otherwise.
	 */
	private boolean isFamilyAvailableWeekdays(int dayOfWeek, 
			FamilyAvailableWeekdays familyAvailableWeekdays) {
		if (familyAvailableWeekdays != null) {
			List<Integer> availableWeekdays = familyAvailableWeekdays
					.getAvailableWeekdays();
			for (Integer availableWeekday : availableWeekdays) {
				if (availableWeekday == dayOfWeek) {
					return true;
				}
			}
		}
		return false;
	}
}
