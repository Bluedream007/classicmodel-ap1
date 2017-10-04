package com.bluedream.sales1.dao;

import com.bluedream.sales1.domain.Productlines;

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
 * DAO to manage Productlines entities.
 * 
 */
@Repository("ProductlinesDAO")
@Transactional
public class ProductlinesDAOImpl extends AbstractJpaDao<Productlines> implements
		ProductlinesDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Productlines.class }));

	/**
	 * EntityManager injected by Spring for persistence unit MySQL_ConnecterJ_5_1_36
	 *
	 */
	@PersistenceContext(unitName = "MySQL_ConnecterJ_5_1_36")
	private EntityManager entityManager;

	/**
	 * Instantiates a new ProductlinesDAOImpl
	 *
	 */
	public ProductlinesDAOImpl() {
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
	 * JPQL Query - findProductlinesByProductLineContaining
	 *
	 */
	@Transactional
	public Set<Productlines> findProductlinesByProductLineContaining(String productLine) throws DataAccessException {

		return findProductlinesByProductLineContaining(productLine, -1, -1);
	}

	/**
	 * JPQL Query - findProductlinesByProductLineContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Productlines> findProductlinesByProductLineContaining(String productLine, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProductlinesByProductLineContaining", startResult, maxRows, productLine);
		return new LinkedHashSet<Productlines>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllProductliness
	 *
	 */
	@Transactional
	public Set<Productlines> findAllProductliness() throws DataAccessException {

		return findAllProductliness(-1, -1);
	}

	/**
	 * JPQL Query - findAllProductliness
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Productlines> findAllProductliness(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllProductliness", startResult, maxRows);
		return new LinkedHashSet<Productlines>(query.getResultList());
	}

	/**
	 * JPQL Query - findProductlinesByHtmlDescription
	 *
	 */
	@Transactional
	public Set<Productlines> findProductlinesByHtmlDescription(String htmlDescription) throws DataAccessException {

		return findProductlinesByHtmlDescription(htmlDescription, -1, -1);
	}

	/**
	 * JPQL Query - findProductlinesByHtmlDescription
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Productlines> findProductlinesByHtmlDescription(String htmlDescription, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProductlinesByHtmlDescription", startResult, maxRows, htmlDescription);
		return new LinkedHashSet<Productlines>(query.getResultList());
	}

	/**
	 * JPQL Query - findProductlinesByTextDescription
	 *
	 */
	@Transactional
	public Set<Productlines> findProductlinesByTextDescription(String textDescription) throws DataAccessException {

		return findProductlinesByTextDescription(textDescription, -1, -1);
	}

	/**
	 * JPQL Query - findProductlinesByTextDescription
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Productlines> findProductlinesByTextDescription(String textDescription, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProductlinesByTextDescription", startResult, maxRows, textDescription);
		return new LinkedHashSet<Productlines>(query.getResultList());
	}

	/**
	 * JPQL Query - findProductlinesByTextDescriptionContaining
	 *
	 */
	@Transactional
	public Set<Productlines> findProductlinesByTextDescriptionContaining(String textDescription) throws DataAccessException {

		return findProductlinesByTextDescriptionContaining(textDescription, -1, -1);
	}

	/**
	 * JPQL Query - findProductlinesByTextDescriptionContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Productlines> findProductlinesByTextDescriptionContaining(String textDescription, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProductlinesByTextDescriptionContaining", startResult, maxRows, textDescription);
		return new LinkedHashSet<Productlines>(query.getResultList());
	}

	/**
	 * JPQL Query - findProductlinesByPrimaryKey
	 *
	 */
	@Transactional
	public Productlines findProductlinesByPrimaryKey(String productLine) throws DataAccessException {

		return findProductlinesByPrimaryKey(productLine, -1, -1);
	}

	/**
	 * JPQL Query - findProductlinesByPrimaryKey
	 *
	 */

	@Transactional
	public Productlines findProductlinesByPrimaryKey(String productLine, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findProductlinesByPrimaryKey", startResult, maxRows, productLine);
			return (com.bluedream.sales1.domain.Productlines) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findProductlinesByProductLine
	 *
	 */
	@Transactional
	public Productlines findProductlinesByProductLine(String productLine) throws DataAccessException {

		return findProductlinesByProductLine(productLine, -1, -1);
	}

	/**
	 * JPQL Query - findProductlinesByProductLine
	 *
	 */

	@Transactional
	public Productlines findProductlinesByProductLine(String productLine, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findProductlinesByProductLine", startResult, maxRows, productLine);
			return (com.bluedream.sales1.domain.Productlines) query.getSingleResult();
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
	public boolean canBeMerged(Productlines entity) {
		return true;
	}
}
