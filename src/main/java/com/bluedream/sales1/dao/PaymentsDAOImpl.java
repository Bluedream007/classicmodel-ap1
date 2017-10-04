package com.bluedream.sales1.dao;

import com.bluedream.sales1.domain.Payments;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.skyway.spring.util.dao.AbstractJpaDao;

import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

/**
 * DAO to manage Payments entities.
 * 
 */
@Repository("PaymentsDAO")
@Transactional
public class PaymentsDAOImpl extends AbstractJpaDao<Payments> implements
		PaymentsDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Payments.class }));

	/**
	 * EntityManager injected by Spring for persistence unit MySQL_ConnecterJ_5_1_36
	 *
	 */
	@PersistenceContext(unitName = "MySQL_ConnecterJ_5_1_36")
	private EntityManager entityManager;

	/**
	 * Instantiates a new PaymentsDAOImpl
	 *
	 */
	public PaymentsDAOImpl() {
		super();
	}

	/**
	 * Get the entity manager that manages persistence unit 
	 *
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Returns the set of entity classes managed by this DAO.
	 *
	 */
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	/**
	 * JPQL Query - findPaymentsByPrimaryKey
	 *
	 */
	@Transactional
	public Payments findPaymentsByPrimaryKey(Integer customerNumber, String checkNumber) throws DataAccessException {

		return findPaymentsByPrimaryKey(customerNumber, checkNumber, -1, -1);
	}

	/**
	 * JPQL Query - findPaymentsByPrimaryKey
	 *
	 */

	@Transactional
	public Payments findPaymentsByPrimaryKey(Integer customerNumber, String checkNumber, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findPaymentsByPrimaryKey", startResult, maxRows, customerNumber, checkNumber);
			return (com.bluedream.sales1.domain.Payments) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllPaymentss
	 *
	 */
	@Transactional
	public Set<Payments> findAllPaymentss() throws DataAccessException {

		return findAllPaymentss(-1, -1);
	}

	/**
	 * JPQL Query - findAllPaymentss
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Payments> findAllPaymentss(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllPaymentss", startResult, maxRows);
		return new LinkedHashSet<Payments>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Payments entity) {
		return true;
	}
}
