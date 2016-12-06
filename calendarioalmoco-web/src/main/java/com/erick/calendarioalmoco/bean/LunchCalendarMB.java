package com.erick.calendarioalmoco.bean;

import java.io.Serializable;
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

import com.erick.calendarioalmoco.dao.ChurchMemberDAO;
import com.erick.calendarioalmoco.modelo.ChurchMember;

@Named
@ViewScoped
public class LunchCalendarMB implements Serializable{

	@Inject
	private ChurchMemberDAO churchMemberDAO;
	
	private ScheduleModel eventModel = new DefaultScheduleModel();
	private ScheduleEvent event = new DefaultScheduleEvent();
	
	private List<ChurchMember> churchMembers;
	
	private ChurchMember churchMemberSelected;

	public LunchCalendarMB(){
		this.churchMemberSelected = new ChurchMember();
	}
	
	public void onDateSelect(SelectEvent selectEvent){
		Date dateSelected = (Date)selectEvent.getObject();
		
		this.event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateSelected);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		this.churchMembers = this.churchMemberDAO.findByAvailableWeekDay(dayOfWeek);
	}
	
	public void onRowDblClckSelect(final SelectEvent event) {
		this.churchMemberSelected = (ChurchMember) event.getObject();
		this.addAppointment();
	}
	
	private void addAppointment(){
		
		((DefaultScheduleEvent) this.event).setTitle(churchMemberSelected.getName());
		
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
