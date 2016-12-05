package com.erick.calendarioalmoco.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

@Named
@ViewScoped
public class LunchCalendarMB implements Serializable{

	private ScheduleModel eventModel = new DefaultScheduleModel();

	
	public void onDateSelect(SelectEvent selectEvent){
		Date dateSelected = (Date)selectEvent.getObject();
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(dateSelected);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println("Dia da semana: "+dayOfWeek);
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


}
