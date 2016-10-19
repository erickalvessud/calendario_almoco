package com.erick.calendarioalmoco.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.slf4j.Logger;

import com.erick.calendarioalmoco.exception.BusinessException;
import com.erick.calendarioalmoco.util.jpa.Transactional;

/**
 * Abstract class which return a DAO with gereric methods for all its DAOs
 * subclasses.
 * 
 * @param <E>
 *            Entity to be handled by this DAO.
 * @author Erick Alves
 * @since 21-09-2016
 */
public abstract class GenericDAO<E> {
	
	protected EntityManager entityManager;
	
	protected Logger logger;
	
	/**
	 * Constructor.
	 * This class has the dependencies of {@link EntityManager} and {@link Logger}.
	 * @param entityManager
	 * @param logger
	 */
	public GenericDAO(EntityManager entityManager, Logger logger){
		this.entityManager = entityManager;
		this.logger = logger;
	}

	/**
	 * Find out for a entity by its identifier.
	 * @param id
	 *      - Identifier of an Entity.
	 * @return
	 *      - A list of a entity which this identifier belongs to.
	 */
	public E findById(Object id) {
		return this.entityManager.find(this.getEntityClass(), id) ;
	}
	
	/**
	 * Save a entity in the database.
	 * @param entity
	 *      - Entity to persistent.
	 */
	@Transactional
	public E save(E entity) {
		return this.entityManager.merge(entity);
	}
	
	/**
	 * Delete a entity from the database.
	 * @param entity
	 *      - Entity to remove.
	 */
	@Transactional
	public void remove(E entity){
		entity = this.entityManager.merge(entity);
		this.entityManager.remove(entity);
		this.entityManager.flush();
	}
	
	/**
	 * Metodo realiza uma busca por todos os registros para essa entidade
	 * retornando uma lista de objetos conforme persistidos no banco de dados.
	 * This method return a list of entities or a empty list if there are not
	 * any register in the database.
	 * 
	 * @return - List of entities.
	 * @throws BusinessException
	 *             If a exception occurs while the process.
	 */
	public List<E> findAll() throws BusinessException {
		try {
			this.logger.info("listando todos os registros para a entidade: ", this.getClass().getSimpleName());
			String jpql = "FROM " + this.getEntityClass().getSimpleName();
			return this.entityManager.createQuery(jpql, this.getEntityClass()).getResultList();
		} catch (Exception e){
			this.logger.error(e.getMessage(), e);
			throw new BusinessException("Falha ao tentar listar dados");
		}
	}
	
	/**
	 * Return an object type {@link Class} of a entity for this DAO.
	 * 
	 * @return - Entity type.
	 */
	protected abstract Class<E> getEntityClass();
}