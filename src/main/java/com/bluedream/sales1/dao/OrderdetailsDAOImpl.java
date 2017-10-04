package com.bluedream.sales1.dao;

import com.bluedream.sales1.domain.Orderdetails;

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
 * DAO to manage Orderdetails entities.
 * 
 */
@Repository("OrderdetailsDAO")
@Transactional
public class OrderdetailsDAOImpl extends AbstractJpaDao<Orderdetails> implements
		OrderdetailsDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Orderdetails.class }));

	/**
	 * EntityManager injected by Spring for persistence unit MySQL_ConnecterJ_5_1_36
	 *
	 */
	@PersistenceContext(unitName = "MySQL_ConnecterJ_5_1_36")
	private EntityManager entityManager;

	/**
	 * Instantiates a new OrderdetailsDAOImpl
	 *
	 */
	public OrderdetailsDAOImpl() {
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
	 * JPQL Query - findAllOrderdetailss
	 *
	 */
	@Transactional
	public Set<Orderdetails> findAllOrderdetailss() throws DataAccessException {

		return findAllOrderdetailss(-1, -1);
	}

	/**
	 * JPQL Query - findAllOrderdetailss
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Orderdetails> findAllOrderdetailss(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllOrderdetailss", startResult, maxRows);
		return new LinkedHashSet<Orderdetails>(query.getResultList());
	}

	/**
	 * JPQL Query - findOrderdetailsByPrimaryKey
	 *
	 */
	@Transactional
	public Orderdetails findOrderdetailsByPrimaryKey(Integer orderNumber, String productCode) throws DataAccessException {

		return findOrderdetailsByPrimaryKey(orderNumber, productCode, -1, -1);
	}

	/**
	 * JPQL Query - findOrderdetailsByPrimaryKey
	 *
	 */

	@Transactional
	public Orderdetails findOrderdetailsByPrimaryKey(Integer orderNumber, String productCode, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findOrderdetailsByPrimaryKey", startResult, maxRows, orderNumber, productCode);
			return (com.bluedream.sales1.domain.Orderdetails) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Orderdetails entity) {
		return true;
	}
}
