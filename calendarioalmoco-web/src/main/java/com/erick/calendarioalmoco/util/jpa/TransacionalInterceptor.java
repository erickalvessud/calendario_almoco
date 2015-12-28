package com.erick.calendarioalmoco.util.jpa;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Interceptor
@Transactional
public class TransacionalInterceptor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager entityManager;
	
	@AroundInvoke
	public Object invoke(InvocationContext context) throws Exception {
		
		EntityTransaction transaction = this.entityManager.getTransaction();
		boolean proprio = false;
		
		try{
			if (!transaction.isActive()){
				transaction.begin();
				transaction.rollback();
				
				transaction.begin();
				
				proprio = true;
			}
			return context.proceed();
		} catch (Exception e) {
			if (transaction != null && proprio) {
				transaction.rollback();
			}
			throw e;
		} finally {
			if (transaction != null && transaction.isActive() && proprio){
				transaction.commit();
			}
		}
	}
}
