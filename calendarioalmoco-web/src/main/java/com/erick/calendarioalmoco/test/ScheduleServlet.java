package com.erick.calendarioalmoco.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
		try {
			saveSchedule();
		} catch (BusinessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void saveSchedule() throws BusinessException{
		Family family = new Family();
		family.setName("Santos's family");
		family.setAddress("R. Costa Filho, 25");
		
		List<ChurchMember> churchMembers = new ArrayList<>();
		ChurchMember member1 = new ChurchMember();
		ChurchMember member2 = new ChurchMember();
		
		member1.setName("Mario");
		member1.setEmail("mario@g.com");
		member1.setFamily(family);

		member2.setName("Regina");
		member2.setEmail("regina@g.com");
		member2.setFamily(family);
		
		churchMembers.add(member1);
		churchMembers.add(member2);
		
		family.setChurchMembers(churchMembers);
		
		FamilyAvailableWeekdays familyAvailableWeekdays = new FamilyAvailableWeekdays();
		familyAvailableWeekdays.setSunday(1);
		familyAvailableWeekdays.setMonday(1);
		
		family.setFamilyAvailableWeekdays(familyAvailableWeekdays);
		
		
		this.familyDAO.save(family);
		
		
		List<Family> families = this.familyDAO.findAll();
		
		
		DoubleMissionary doubleMissionary = new DoubleMissionary();
		
		List<Missionary> missionaries = new ArrayList<>();
		Missionary missionary1 = new Missionary();
		Missionary missionary2 = new Missionary();
		
		missionary1.setName("Elder Lucas");
		missionary1.setEmail("lucas@g.com");
		missionary1.setDoubleMissionary(doubleMissionary);
		
		missionary2.setName("Elder Erick");
		missionary2.setEmail("erick@g.com");
		missionary2.setDoubleMissionary(doubleMissionary);
		
		missionaries.add(missionary1);
		missionaries.add(missionary2);
		
		doubleMissionary.setMissionaries(missionaries);
		
		doubleMissionaryDAO.save(doubleMissionary);
		
		List<DoubleMissionary> doubleMissionaries = doubleMissionaryDAO.findAll();
	
	
		Calendar desiredDate = Calendar.getInstance();
		desiredDate.set(2016, 11, 5);
		this.scheduleBusiness.saveSchedule(desiredDate, families.get(0), doubleMissionaries.get(0));

	}
}
