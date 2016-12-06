package com.erick.calendarioalmoco.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import com.erick.calendarioalmoco.business.AppointmentBusiness;
import com.erick.calendarioalmoco.business.ChurchMemberBusiness;
import com.erick.calendarioalmoco.dao.DoubleMissionaryDAO;
import com.erick.calendarioalmoco.exception.BusinessException;
import com.erick.calendarioalmoco.modelo.ChurchMember;
import com.erick.calendarioalmoco.modelo.DoubleMissionary;

@Named
@ViewScoped
public class LunchCalendarMB implements Serializable{
	
	@Inject
	private ChurchMemberBusiness churchMemberBusiness;
	
	@Inject
	private AppointmentBusiness appointmentBusiness;
	
	private ScheduleModel eventModel = new DefaultScheduleModel();
	private ScheduleEvent event = new DefaultScheduleEvent();
	
	private List<ChurchMember> churchMembers;
	
	private ChurchMember churchMemberSelected;

	public LunchCalendarMB(){
		this.churchMemberSelected = new ChurchMember();
	}
	
	public void onDateSelect(SelectEvent selectEvent){
		Date dateSelected = (Date)selectEvent.getObject();
		
		this.event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject(), selectEvent.getObject());
		
		this.churchMembers = this.churchMemberBusiness.getChurchMembersAvailablesByDate(dateSelected);
	}
	
	public void onRowDblClckSelect(final SelectEvent event) throws BusinessException {
		this.churchMemberSelected = (ChurchMember) event.getObject();
		this.addAppointment();
	}
	
	@Inject
	private DoubleMissionaryDAO doubleMissionaryDAO;
	
	private void addAppointment() throws BusinessException{
		
		DefaultScheduleEvent event = (DefaultScheduleEvent) this.event;
		
		// teste ate construir o cadastro de duplas missionarias
		List<DoubleMissionary> doubleMissionaries = doubleMissionaryDAO.findAll();
		
		this.appointmentBusiness.saveAppointments((Date)event.getData(), this.churchMemberSelected.getFamily(), doubleMissionaries.get(0));
		
		StringBuilder sb = new StringBuilder();  
		sb.append(this.churchMemberSelected.getName());
		sb.append("\n");
		sb.append(this.churchMemberSelected.getFamily().getAddress().getStreet());
		
		event.setTitle(sb.toString());
		
        if(this.event.getId() == null){
            this.eventModel.addEvent(this.event);
        }else{
        	this.eventModel.updateEvent(this.event);
		}
        this.event = new DefaultScheduleEvent();
	}
	
	/**
	 * @return the eventModel
	 */
	public ScheduleModel getEventModel() {
		return eventModel;
	}

	/**
	 * @param eventModel the eventModel to set
	 */
	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	/**
	 * @return the churchMembers
	 */
	public List<ChurchMember> getChurchMembers() {
		return churchMembers;
	}
	/**
	 * @param churchMembers the churchMembers to set
	 */
	public void setChurchMembers(List<ChurchMember> churchMembers) {
		this.churchMembers = churchMembers;
	}
	
	/**
	 * @return the churchMemberSelected
	 */
	public ChurchMember getChurchMemberSelected() {
		return churchMemberSelected;
	}

	/**
	 * @param churchMemberSelected the churchMemberSelected to set
	 */
	public void setChurchMemberSelected(ChurchMember churchMemberSelected) {
		this.churchMemberSelected = churchMemberSelected;
	}
}
