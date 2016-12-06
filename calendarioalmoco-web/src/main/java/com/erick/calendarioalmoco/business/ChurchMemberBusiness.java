package com.erick.calendarioalmoco.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.erick.calendarioalmoco.dao.AppointmentDAO;
import com.erick.calendarioalmoco.dao.ChurchMemberDAO;
import com.erick.calendarioalmoco.modelo.Appointment;
import com.erick.calendarioalmoco.modelo.ChurchMember;

public class ChurchMemberBusiness implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ChurchMemberDAO churchMemberDAO;
	
	@Inject
	private AppointmentDAO appointmentDAO;

	public List<ChurchMember> getChurchMembersAvailablesByDate(Date dateSelected) {
		List<ChurchMember> churchMembers = new ArrayList<>();
		
		List<Appointment> appointments = this.appointmentDAO.findByDate(dateSelected);
		
		if (!appointments.isEmpty()) {
			return churchMembers;
		}
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateSelected);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		return this.churchMemberDAO.findByAvailableWeekDay(dayOfWeek);
	}
}
