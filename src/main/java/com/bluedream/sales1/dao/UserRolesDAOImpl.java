package com.bluedream.sales1.dao;

import com.bluedream.sales1.domain.UserRoles;

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
 * DAO to manage UserRoles entities.
 * 
 */
@Repository("UserRolesDAO")
@Transactional
public class UserRolesDAOImpl extends AbstractJpaDao<UserRoles> implements
		UserRolesDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { UserRoles.class }));

	/**
	 * EntityManager injected by Spring for persistence unit MySQL_ConnecterJ_5_1_36
	 *
	 */
	@PersistenceContext(unitName = "MySQL_ConnecterJ_5_1_36")
	private EntityManager entityManager;

	/**
	 * Instantiates a new UserRolesDAOImpl
	 *
	 */
	public UserRolesDAOImpl() {
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
	 * JPQL Query - findUserRolesByPrimaryKey
	 *
	 */
	@Transactional
	public UserRoles findUserRolesByPrimaryKey(Integer userRoleId) throws DataAccessException {

		return findUserRolesByPrimaryKey(userRoleId, -1, -1);
	}

	/**
	 * JPQL Query - findUserRolesByPrimaryKey
	 *
	 */

	@Transactional
	public UserRoles findUserRolesByPrimaryKey(Integer userRoleId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findUserRolesByPrimaryKey", startResult, maxRows, userRoleId);
			return (com.bluedream.sales1.domain.UserRoles) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllUserRoless
	 *
	 */
	@Transactional
	public Set<UserRoles> findAllUserRoless() throws DataAccessException {

		return findAllUserRoless(-1, -1);
	}

	/**
	 * JPQL Query - findAllUserRoless
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UserRoles> findAllUserRoless(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllUserRoless", startResult, maxRows);
		return new LinkedHashSet<UserRoles>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(UserRoles entity) {
		return true;
	}
}
