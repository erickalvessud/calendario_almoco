package com.erick.calendarioalmoco.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
import com.erick.calendarioalmoco.business.DoubleMissionaryBusiness;
import com.erick.calendarioalmoco.dao.DoubleMissionaryDAO;
import com.erick.calendarioalmoco.exception.BusinessException;
import com.erick.calendarioalmoco.modelo.ChurchMember;
import com.erick.calendarioalmoco.modelo.DoubleMissionary;
import com.erick.calendarioalmoco.vo.ChurchMemberVO;
import com.erick.calendarioalmoco.vo.DoubleMissionaryVO;

@Named
@ViewScoped
public class LunchCalendarMB extends BaseMB {
	
	@Inject
	private ChurchMemberBusiness churchMemberBusiness;
	
	@Inject
	private AppointmentBusiness appointmentBusiness;
	
	@Inject
	private DoubleMissionaryBusiness doubleMissionaryBusiness;
	
	private ScheduleModel eventModel = new DefaultScheduleModel();
	private ScheduleEvent event = new DefaultScheduleEvent();
	
	private List<ChurchMemberVO> churchMembersVO;
	
	private ChurchMemberVO churchMemberVOSelected;
	
	List<DoubleMissionaryVO> doubleMissionariesVOs;
	
	private DoubleMissionaryVO doubleMissionaryVOSelected;
	
	public LunchCalendarMB(){
		this.churchMemberVOSelected = new ChurchMemberVO();
		this.doubleMissionaryVOSelected = new DoubleMissionaryVO();
	}
	
	@PostConstruct
	public void init(){
		try {
			this.doubleMissionariesVOs = this.doubleMissionaryBusiness.findAllDoubleMissionary();
		} catch (BusinessException e) {
			this.showMessage(FacesMessage.SEVERITY_ERROR, "", e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void onDateSelect(SelectEvent selectEvent){
		Date dateSelected = (Date)selectEvent.getObject();

		this.event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject(), selectEvent.getObject());

		this.churchMembersVO = this.churchMemberBusiness.getChurchMembersAvailablesByDate(dateSelected);
	}
	
	public void onRowDblClckSelect(final SelectEvent event) throws BusinessException {
		this.churchMemberVOSelected = (ChurchMemberVO) event.getObject();
		this.addAppointment();
	}
	
	private void addAppointment() throws BusinessException{
		
		DefaultScheduleEvent event = (DefaultScheduleEvent) this.event;

		this.appointmentBusiness.saveAppointments((Date)event.getData(), this.churchMemberVOSelected.getFamilyVO(), this.doubleMissionaryVOSelected);
		
		StringBuilder sb = new StringBuilder();  
		sb.append(this.churchMemberVOSelected.getName());
		sb.append("\n");
		sb.append(this.churchMemberVOSelected.getFamilyVO().getAddressVO().getStreet());
		
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
	 * @return the churchMembersVO
	 */
	public List<ChurchMemberVO> getChurchMembersVO() {
		return churchMembersVO;
	}

	/**
	 * @param churchMembersVO the churchMembersVO to set
	 */
	public void setChurchMembersVO(List<ChurchMemberVO> churchMembersVO) {
		this.churchMembersVO = churchMembersVO;
	}
	
	/**
	 * @return the churchMemberVOSelected
	 */
	public ChurchMemberVO getChurchMemberVOSelected() {
		return churchMemberVOSelected;
	}

	/**
	 * @param churchMemberVOSelected the churchMemberVOSelected to set
	 */
	public void setChurchMemberVOSelected(ChurchMemberVO churchMemberVOSelected) {
		this.churchMemberVOSelected = churchMemberVOSelected;
	}

	/**
	 * @return the doubleMissionaryVOSelected
	 */
	public DoubleMissionaryVO getDoubleMissionaryVOSelected() {
		return doubleMissionaryVOSelected;
	}

	/**
	 * @param doubleMissionaryVOSelected the doubleMissionaryVOSelected to set
	 */
	public void setDoubleMissionaryVOSelected(DoubleMissionaryVO doubleMissionaryVOSelected) {
		this.doubleMissionaryVOSelected = doubleMissionaryVOSelected;
	}

	/**
	 * @return the doubleMissionariesVOs
	 */
	public List<DoubleMissionaryVO> getDoubleMissionariesVOs() {
		return doubleMissionariesVOs;
	}

	/**
	 * @param doubleMissionariesVOs the doubleMissionariesVOs to set
	 */
	public void setDoubleMissionariesVOs(List<DoubleMissionaryVO> doubleMissionariesVOs) {
		this.doubleMissionariesVOs = doubleMissionariesVOs;
	}
}
