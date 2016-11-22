package com.erick.calendarioalmoco.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.erick.calendarioalmoco.common.DaysOfTheWeekEnum;
import com.erick.calendarioalmoco.common.RegisterOptionEnum;
import com.erick.calendarioalmoco.modelo.ChurchMember;
import com.erick.calendarioalmoco.modelo.Family;
import com.erick.calendarioalmoco.vo.ChurchMemberVO;
import com.erick.calendarioalmoco.vo.FamilyVO;

@Named
@ViewScoped
public class RegisterUserMB implements Serializable{
	private static final long serialVersionUID = 1L;

	private List<SelectItem> registerOptions;
	
	private List<SelectItem> daysOfTheWeek;
	
	private int registerOptionId;

	private ChurchMemberVO churchMemberVO;
	
	private FamilyVO familyVO;

	public RegisterUserMB(){
		this.churchMemberVO = new ChurchMemberVO();
		this.familyVO = new FamilyVO();
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
