package com.erick.calendarioalmoco.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erick.calendarioalmoco.dao.ChurchMemberDAO;
import com.erick.calendarioalmoco.exception.BusinessException;
import com.erick.calendarioalmoco.modelo.ChurchMember;
import com.erick.calendarioalmoco.modelo.Family;
import com.erick.calendarioalmoco.modelo.FamilyAvailableWeekdays;
import com.erick.calendarioalmoco.modelo.Phone;
import com.erick.calendarioalmoco.modelo.PhoneType;
import com.erick.calendarioalmoco.modelo.UserType;

/**
 * Servlet implementation class ChurchMemberServlet
 */
@WebServlet("/ChurchMemberServlet")
public class ChurchMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private ChurchMemberDAO churchMemberDAO;
    /**
     * Default constructor. 
     */
    public ChurchMemberServlet() {

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.editChurchMember();
	}
	
	private void addMissionary(){
		
	}
	
	private void removeChurchMember(){
		ChurchMember churchMember;
		try {
			churchMember = this.churchMemberDAO.findById(1l);
			this.churchMemberDAO.remove(churchMember);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void editChurchMember(){
		try {
			ChurchMember churchMember = this.churchMemberDAO.findById(1l);
			Family f = new Family();
			f.setName("Familia Santos");
			f.setAddress("Rua A, 152");
			
			FamilyAvailableWeekdays familyAvailableWeekdays = new FamilyAvailableWeekdays();
			familyAvailableWeekdays.setFamily(f);
			familyAvailableWeekdays.setSunday(1);
			
			f.setFamilyAvailableWeekdays(familyAvailableWeekdays);
			
			churchMember.setFamily(f);
			this.churchMemberDAO.save(churchMember);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void addChurchMember(){
		ChurchMember churchMember = new ChurchMember();
		churchMember.setName("Erick Alves");
		churchMember.setEmail("ealves@gmail.com");
		List<Phone> phoneList = new ArrayList<>();
		Phone p = new Phone();
		p.setAreaCode("11");
		p.setPhoneNumber("985857474");
		p.setPhoneType(PhoneType.MOBILE_PHONE);
		p.setUser(churchMember);
		phoneList.add(p);
		churchMember.setPhones(phoneList);
		churchMember.setUserType(UserType.MISSIONARY);
		try {
			churchMemberDAO.save(churchMember);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
