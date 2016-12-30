package com.erick.calendarioalmoco.business;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;

import com.erick.calendarioalmoco.dao.DoubleMissionaryDAO;
import com.erick.calendarioalmoco.exception.BusinessException;
import com.erick.calendarioalmoco.modelo.DoubleMissionary;
import com.erick.calendarioalmoco.vo.DoubleMissionaryVO;

public class DoubleMissionaryBusiness implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Logger logger;

	@Inject
	private DoubleMissionaryDAO doubleMissionaryDAO;
	
	public List<DoubleMissionaryVO> findAllDoubleMissionary() throws BusinessException {
		List<DoubleMissionaryVO> doubleMissionaryVOs = new ArrayList<>();
		
		List<DoubleMissionary> doubleMissionaries = this.doubleMissionaryDAO.findAll();
		
		for (DoubleMissionary doubleMissionary : doubleMissionaries) {
			
			DoubleMissionaryVO doubleMissionaryVO = new DoubleMissionaryVO();
			
			try {
				BeanUtils.copyProperties(doubleMissionaryVO, doubleMissionary);
				doubleMissionaryVOs.add(doubleMissionaryVO);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return doubleMissionaryVOs;
	}
	
	
}
