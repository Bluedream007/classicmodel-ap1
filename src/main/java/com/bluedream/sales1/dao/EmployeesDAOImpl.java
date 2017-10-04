package com.bluedream.sales1.dao;

import com.bluedream.sales1.domain.Employees;

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
 * DAO to manage Employees entities.
 * 
 */
@Repository("EmployeesDAO")
@Transactional
public class EmployeesDAOImpl extends AbstractJpaDao<Employees> implements
		EmployeesDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Employees.class }));

	/**
	 * EntityManager injected by Spring for persistence unit MySQL_ConnecterJ_5_1_36
	 *
	 */
	@PersistenceContext(unitName = "MySQL_ConnecterJ_5_1_36")
	private EntityManager entityManager;

	/**
	 * Instantiates a new EmployeesDAOImpl
	 *
	 */
	public EmployeesDAOImpl() {
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
	 * JPQL Query - findEmployeesByEmailContaining
	 *
	 */
	@Transactional
	public Set<Employees> findEmployeesByEmailContaining(String email) throws DataAccessException {

		return findEmployeesByEmailContaining(email, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeesByEmailContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Employees> findEmployeesByEmailContaining(String email, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEmployeesByEmailContaining", startResult, maxRows, email);
		return new LinkedHashSet<Employees>(query.getResultList());
	}

	/**
	 * JPQL Query - findEmployeesByJobTitle
	 *
	 */
	@Transactional
	public Set<Employees> findEmployeesByJobTitle(String jobTitle) throws DataAccessException {

		return findEmployeesByJobTitle(jobTitle, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeesByJobTitle
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Employees> findEmployeesByJobTitle(String jobTitle, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEmployeesByJobTitle", startResult, maxRows, jobTitle);
		return new LinkedHashSet<Employees>(query.getResultList());
	}

	/**
	 * JPQL Query - findEmployeesByLastName
	 *
	 */
	@Transactional
	public Set<Employees> findEmployeesByLastName(String lastName) throws DataAccessException {

		return findEmployeesByLastName(lastName, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeesByLastName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Employees> findEmployeesByLastName(String lastName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEmployeesByLastName", startResult, maxRows, lastName);
		return new LinkedHashSet<Employees>(query.getResultList());
	}

	/**
	 * JPQL Query - findEmployeesByEmployeeNumber
	 *
	 */
	@Transactional
	public Employees findEmployeesByEmployeeNumber(Integer employeeNumber) throws DataAccessException {

		return findEmployeesByEmployeeNumber(employeeNumber, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeesByEmployeeNumber
	 *
	 */

	@Transactional
	public Employees findEmployeesByEmployeeNumber(Integer employeeNumber, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findEmployeesByEmployeeNumber", startResult, maxRows, employeeNumber);
			return (com.bluedream.sales1.domain.Employees) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findEmployeesByPrimaryKey
	 *
	 */
	@Transactional
	public Employees findEmployeesByPrimaryKey(Integer employeeNumber) throws DataAccessException {

		return findEmployeesByPrimaryKey(employeeNumber, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeesByPrimaryKey
	 *
	 */

	@Transactional
	public Employees findEmployeesByPrimaryKey(Integer employeeNumber, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findEmployeesByPrimaryKey", startResult, maxRows, employeeNumber);
			return (com.bluedream.sales1.domain.Employees) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findEmployeesByFirstName
	 *
	 */
	@Transactional
	public Set<Employees> findEmployeesByFirstName(String firstName) throws DataAccessException {

		return findEmployeesByFirstName(firstName, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeesByFirstName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Employees> findEmployeesByFirstName(String firstName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEmployeesByFirstName", startResult, maxRows, firstName);
		return new LinkedHashSet<Employees>(query.getResultList());
	}

	/**
	 * JPQL Query - findEmployeesByJobTitleContaining
	 *
	 */
	@Transactional
	public Set<Employees> findEmployeesByJobTitleContaining(String jobTitle) throws DataAccessException {

		return findEmployeesByJobTitleContaining(jobTitle, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeesByJobTitleContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Employees> findEmployeesByJobTitleContaining(String jobTitle, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEmployeesByJobTitleContaining", startResult, maxRows, jobTitle);
		return new LinkedHashSet<Employees>(query.getResultList());
	}

	/**
	 * JPQL Query - findEmployeesByFirstNameContaining
	 *
	 */
	@Transactional
	public Set<Employees> findEmployeesByFirstNameContaining(String firstName) throws DataAccessException {

		return findEmployeesByFirstNameContaining(firstName, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeesByFirstNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Employees> findEmployeesByFirstNameContaining(String firstName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEmployeesByFirstNameContaining", startResult, maxRows, firstName);
		return new LinkedHashSet<Employees>(query.getResultList());
	}

	/**
	 * JPQL Query - findEmployeesByExtension
	 *
	 */
	@Transactional
	public Set<Employees> findEmployeesByExtension(String extension) throws DataAccessException {

		return findEmployeesByExtension(extension, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeesByExtension
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Employees> findEmployeesByExtension(String extension, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEmployeesByExtension", startResult, maxRows, extension);
		return new LinkedHashSet<Employees>(query.getResultList());
	}

	/**
	 * JPQL Query - findEmployeesByExtensionContaining
	 *
	 */
	@Transactional
	public Set<Employees> findEmployeesByExtensionContaining(String extension) throws DataAccessException {

		return findEmployeesByExtensionContaining(extension, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeesByExtensionContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Employees> findEmployeesByExtensionContaining(String extension, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEmployeesByExtensionContaining", startResult, maxRows, extension);
		return new LinkedHashSet<Employees>(query.getResultList());
	}

	/**
	 * JPQL Query - findEmployeesByEmail
	 *
	 */
	@Transactional
	public Set<Employees> findEmployeesByEmail(String email) throws DataAccessException {

		return findEmployeesByEmail(email, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeesByEmail
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Employees> findEmployeesByEmail(String email, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEmployeesByEmail", startResult, maxRows, email);
		return new LinkedHashSet<Employees>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllEmployeess
	 *
	 */
	@Transactional
	public Set<Employees> findAllEmployeess() throws DataAccessException {

		return findAllEmployeess(-1, -1);
	}

	/**
	 * JPQL Query - findAllEmployeess
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Employees> findAllEmployeess(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllEmployeess", startResult, maxRows);
		return new LinkedHashSet<Employees>(query.getResultList());
	}

	/**
	 * JPQL Query - findEmployeesByLastNameContaining
	 *
	 */
	@Transactional
	public Set<Employees> findEmployeesByLastNameContaining(String lastName) throws DataAccessException {

		return findEmployeesByLastNameContaining(lastName, -1, -1);
	}

	/**
	 * JPQL Query - findEmployeesByLastNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Employees> findEmployeesByLastNameContaining(String lastName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findEmployeesByLastNameContaining", startResult, maxRows, lastName);
		return new LinkedHashSet<Employees>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Employees entity) {
		return true;
	}
}
