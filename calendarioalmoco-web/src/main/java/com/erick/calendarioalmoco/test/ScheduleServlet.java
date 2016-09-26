package com.erick.calendarioalmoco.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erick.calendarioalmoco.business.ScheduleBusiness;
import com.erick.calendarioalmoco.dao.DoubleMissionaryDAO;
import com.erick.calendarioalmoco.dao.FamilyDAO;
import com.erick.calendarioalmoco.exception.BusinessException;
import com.erick.calendarioalmoco.modelo.ChurchMember;
import com.erick.calendarioalmoco.modelo.DoubleMissionary;
import com.erick.calendarioalmoco.modelo.Family;
import com.erick.calendarioalmoco.modelo.FamilyAvailableWeekdays;
import com.erick.calendarioalmoco.modelo.Missionary;

/**
 * Servlet implementation class ScheduleServlet
 */
@WebServlet("/ScheduleServlet")
public class ScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@Inject
	private FamilyDAO familyDAO;
	
	@Inject
	private DoubleMissionaryDAO doubleMissionaryDAO;
	
	@Inject
	private ScheduleBusiness scheduleBusiness;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		saveSchedule();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void saveSchedule(){
		Family family = new Family();
		family.setName("Silva's family");
		family.setAddress("R. A, 25");
		
		List<ChurchMember> churchMembers = new ArrayList<>();
		ChurchMember member1 = new ChurchMember();
		ChurchMember member2 = new ChurchMember();
		
		member1.setName("Joao");
		member1.setEmail("j@g.com");
		member1.setFamily(family);

		member2.setName("Maria");
		member2.setEmail("m@g.com");
		member2.setFamily(family);
		
		churchMembers.add(member1);
		churchMembers.add(member2);
		
		family.setChurchMembers(churchMembers);
		
		FamilyAvailableWeekdays familyAvailableWeekdays = new FamilyAvailableWeekdays();
		familyAvailableWeekdays.setSunday(1);
		familyAvailableWeekdays.setMonday(1);
		
		family.setFamilyAvailableWeekdays(familyAvailableWeekdays);
		
		try {
			familyDAO.save(family);
		} catch (BusinessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		DoubleMissionary doubleMissionary = new DoubleMissionary();
		
		List<Missionary> missionaries = new ArrayList<>();
		Missionary missionary1 = new Missionary();
		Missionary missionary2 = new Missionary();
		
		missionary1.setName("Elder X");
		missionary1.setEmail("x@g.com");
		
		missionary2.setName("Elder Z");
		missionary2.setEmail("z@g.com");
		
		missionaries.add(missionary1);
		missionaries.add(missionary2);
		
		doubleMissionary.setMissionaries(missionaries);
		
		try {
			doubleMissionaryDAO.save(doubleMissionary);
		} catch (BusinessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			this.scheduleBusiness.saveSchedule(Calendar.getInstance(), family, doubleMissionary);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
