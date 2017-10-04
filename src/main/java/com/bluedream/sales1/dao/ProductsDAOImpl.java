package com.bluedream.sales1.dao;

import com.bluedream.sales1.domain.Products;

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
 * DAO to manage Products entities.
 * 
 */
@Repository("ProductsDAO")
@Transactional
public class ProductsDAOImpl extends AbstractJpaDao<Products> implements
		ProductsDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Products.class }));

	/**
	 * EntityManager injected by Spring for persistence unit MySQL_ConnecterJ_5_1_36
	 *
	 */
	@PersistenceContext(unitName = "MySQL_ConnecterJ_5_1_36")
	private EntityManager entityManager;

	/**
	 * Instantiates a new ProductsDAOImpl
	 *
	 */
	public ProductsDAOImpl() {
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
	 * JPQL Query - findProductsByPrimaryKey
	 *
	 */
	@Transactional
	public Products findProductsByPrimaryKey(String productCode) throws DataAccessException {

		return findProductsByPrimaryKey(productCode, -1, -1);
	}

	/**
	 * JPQL Query - findProductsByPrimaryKey
	 *
	 */

	@Transactional
	public Products findProductsByPrimaryKey(String productCode, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findProductsByPrimaryKey", startResult, maxRows, productCode);
			return (com.bluedream.sales1.domain.Products) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllProductss
	 *
	 */
	@Transactional
	public Set<Products> findAllProductss() throws DataAccessException {

		return findAllProductss(-1, -1);
	}

	/**
	 * JPQL Query - findAllProductss
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Products> findAllProductss(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllProductss", startResult, maxRows);
		return new LinkedHashSet<Products>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Products entity) {
		return true;
	}
}
