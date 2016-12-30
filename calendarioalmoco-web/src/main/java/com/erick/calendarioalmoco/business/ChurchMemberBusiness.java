package com.erick.calendarioalmoco.business;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;

import com.erick.calendarioalmoco.dao.AppointmentDAO;
import com.erick.calendarioalmoco.dao.ChurchMemberDAO;
import com.erick.calendarioalmoco.modelo.ChurchMember;
import com.erick.calendarioalmoco.vo.ChurchMemberVO;

public class ChurchMemberBusiness implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private static Logger logger;
	
	@Inject
	private ChurchMemberDAO churchMemberDAO;
	
	@Inject
	private AppointmentDAO appointmentDAO;

	public List<ChurchMemberVO> getChurchMembersAvailablesByDate(Date dateSelected) {
		List<ChurchMemberVO> churchMembersVO = new ArrayList<>();

		if (this.dayHasAnyAppointment(dateSelected)) {
			return churchMembersVO;
		}

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateSelected);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

		List<ChurchMember> churchMembers = this.churchMemberDAO.findByAvailableWeekDay(dayOfWeek);

		for (ChurchMember churchMember : churchMembers) {
			ChurchMemberVO churchMemberVO = new ChurchMemberVO();
			
			try {
				BeanUtils.copyProperties(churchMemberVO, churchMember);				
				BeanUtils.copyProperties(churchMemberVO.getFamilyVO(), churchMember.getFamily());
				BeanUtils.copyProperties(churchMemberVO.getFamilyVO().getAddressVO(), churchMember.getFamily().getAddress());
				
				churchMembersVO.add(churchMemberVO);
			} catch (IllegalAccessException e) {
				logger.error("", e);
			} catch (InvocationTargetException e) {
				logger.error("", e);
			}
		}

		return churchMembersVO;
	}
	
	private boolean dayHasAnyAppointment(Date dateSelected){
		return this.appointmentDAO.countByDate(dateSelected) > 0;
	}
}














