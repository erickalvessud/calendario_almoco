package com.erick.calendarioalmoco.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.erick.calendarioalmoco.common.DaysOfTheWeekEnum;
import com.erick.calendarioalmoco.common.RegisterOptionEnum;
import com.erick.calendarioalmoco.dao.ChurchMemberDAO;
import com.erick.calendarioalmoco.modelo.ChurchMember;
import com.erick.calendarioalmoco.modelo.Family;
import com.erick.calendarioalmoco.vo.ChurchMemberVO;
import com.erick.calendarioalmoco.vo.FamilyVO;

@Named
@ViewScoped
public class RegisterUserMB implements Serializable{
	private static final long serialVersionUID = 1L;

	@Inject
	private ChurchMemberDAO churchMemberDAO;
	
	private List<SelectItem> registerOptions;
	
	private List<SelectItem> daysOfTheWeek;
	
	private int registerOptionId;

	private ChurchMemberVO churchMemberVO;
	
	private FamilyVO familyVO;

	public RegisterUserMB(){
		this.churchMemberVO = new ChurchMemberVO();
		this.familyVO = new FamilyVO();
	}
	
	public void doSave(){
		ChurchMember churchMember = new ChurchMember();
		churchMember.setName(this.churchMemberVO.getName());
		churchMember.setEmail(this.churchMemberVO.getEmail());
		churchMember.setPassword(this.churchMemberVO.getPassword());
		churchMember.setPhone(this.churchMemberVO.getPhone());
		churchMember.setPhone2(this.churchMemberVO.getPhone2());
		
		Family family = new Family();
		family.setName(this.familyVO.getName());
		family.getAddress().setStreet(this.familyVO.getAddress().getStreet());
		family.getAddress().setCity(this.familyVO.getAddress().getCity());
		family.getAddress().setState(this.familyVO.getAddress().getState());
		family.getAddress().setZipCode(this.familyVO.getAddress().getZipCode());
		
		churchMember.setFamily(family);
		family.getChurchMembers().add(churchMember);
		
		List<String> familyAvailableWeekdays = this.familyVO.getFamilyAvailableWeekdays();
		
		if (familyAvailableWeekdays.contains(DaysOfTheWeekEnum.SUNDAY.getId())) {
			family.getFamilyAvailableWeekdays().setSunday(1);
		} else {
			family.getFamilyAvailableWeekdays().setSunday(0);
		}
		if (familyAvailableWeekdays.contains(DaysOfTheWeekEnum.MONDAY.getId())) {
			family.getFamilyAvailableWeekdays().setMonday(1);
		} else {
			family.getFamilyAvailableWeekdays().setMonday(0);
		}
		if (familyAvailableWeekdays.contains(DaysOfTheWeekEnum.TUESDAY.getId())) {
			family.getFamilyAvailableWeekdays().setTuesday(1);
		} else {
			family.getFamilyAvailableWeekdays().setTuesday(0);
		}
		if (familyAvailableWeekdays.contains(DaysOfTheWeekEnum.WEDNESDAY.getId())) {
			family.getFamilyAvailableWeekdays().setWednesday(1);
		} else {
			family.getFamilyAvailableWeekdays().setWednesday(0);
		}
		if (familyAvailableWeekdays.contains(DaysOfTheWeekEnum.THURSDAY.getId())) {
			family.getFamilyAvailableWeekdays().setThursday(1);
		} else {
			family.getFamilyAvailableWeekdays().setThursday(0);
		}
		if (familyAvailableWeekdays.contains(DaysOfTheWeekEnum.FRIDAY.getId())) {
			family.getFamilyAvailableWeekdays().setFriday(1);
		} else {
			family.getFamilyAvailableWeekdays().setFriday(0);
		}
		if (familyAvailableWeekdays.contains(DaysOfTheWeekEnum.SATURDAY.getId())) {
			family.getFamilyAvailableWeekdays().setSaturday(1);
		} else {
			family.getFamilyAvailableWeekdays().setSaturday(0);
		}
		
		this.churchMemberDAO.save(churchMember);
		
		this.churchMemberVO = new ChurchMemberVO();
		this.familyVO = new FamilyVO();
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Usuário salvo com sucesso!"));
	}

	public List<SelectItem> getRegisterOptions(){
		if(this.registerOptions == null){
			this.registerOptions = new ArrayList<>();
			for(RegisterOptionEnum r : RegisterOptionEnum.values()){
				this.registerOptions.add(new SelectItem(r.getId(), r.getDescription()));
			}
		}
		return this.registerOptions;
	}
	
	public List<SelectItem> getDaysOfTheWeek(){
		if(this.daysOfTheWeek == null) {
			this.daysOfTheWeek = new ArrayList<>();
			for(DaysOfTheWeekEnum d : DaysOfTheWeekEnum.values()){
				this.daysOfTheWeek.add(new SelectItem(d.getId(), d.getDescription()));
			}
		}
		return this.daysOfTheWeek;
	}
	
	/**
	 * @return the churchMemberVO
	 */
	public ChurchMemberVO getChurchMemberVO() {
		return churchMemberVO;
	}

	/**
	 * @param churchMemberVO the churchMemberVO to set
	 */
	public void setChurchMemberVO(ChurchMemberVO churchMemberVO) {
		this.churchMemberVO = churchMemberVO;
	}

	/**
	 * @return the familyVO
	 */
	public FamilyVO getFamilyVO() {
		return familyVO;
	}

	/**
	 * @param familyVO the familyVO to set
	 */
	public void setFamilyVO(FamilyVO familyVO) {
		this.familyVO = familyVO;
	}
	
	/**
	 * @return the registerOptionId
	 */
	public int getRegisterOptionId() {
		return registerOptionId;
	}

	/**
	 * @param registerOptionId the registerOptionId to set
	 */
	public void setRegisterOptionId(int registerOptionId) {
		this.registerOptionId = registerOptionId;
	}
}
