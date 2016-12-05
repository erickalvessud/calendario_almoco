package com.erick.calendarioalmoco.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;

import com.erick.calendarioalmoco.modelo.User;

public class UserDAO extends GenericDAO<User> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	public UserDAO(EntityManager entityManager, Logger logger) {
		super(entityManager, logger);

	}

	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}

	public User findUserByEmailAndPwd(String email, String pwd){
		try {
			TypedQuery<User> query = this.entityManager.createNamedQuery("User.findByEmailAndPwd", User.class);
			query.setParameter("email", email);
			query.setParameter("pwd", pwd);
			return query.getSingleResult();
		} catch(NoResultException e){
			return null;
		}
	}
}
