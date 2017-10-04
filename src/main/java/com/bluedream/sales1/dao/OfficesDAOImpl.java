package com.bluedream.sales1.dao;

import com.bluedream.sales1.domain.Offices;

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
 * DAO to manage Offices entities.
 * 
 */
@Repository("OfficesDAO")
@Transactional
public class OfficesDAOImpl extends AbstractJpaDao<Offices> implements
		OfficesDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Offices.class }));

	/**
	 * EntityManager injected by Spring for persistence unit MySQL_ConnecterJ_5_1_36
	 *
	 */
	@PersistenceContext(unitName = "MySQL_ConnecterJ_5_1_36")
	private EntityManager entityManager;

	/**
	 * Instantiates a new OfficesDAOImpl
	 *
	 */
	public OfficesDAOImpl() {
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
	 * JPQL Query - findOfficesByPhoneContaining
	 *
	 */
	@Transactional
	public Set<Offices> findOfficesByPhoneContaining(String phone) throws DataAccessException {

		return findOfficesByPhoneContaining(phone, -1, -1);
	}

	/**
	 * JPQL Query - findOfficesByPhoneContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Offices> findOfficesByPhoneContaining(String phone, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findOfficesByPhoneContaining", startResult, maxRows, phone);
		return new LinkedHashSet<Offices>(query.getResultList());
	}

	/**
	 * JPQL Query - findOfficesByOfficeCode
	 *
	 */
	@Transactional
	public Offices findOfficesByOfficeCode(String officeCode) throws DataAccessException {

		return findOfficesByOfficeCode(officeCode, -1, -1);
	}

	/**
	 * JPQL Query - findOfficesByOfficeCode
	 *
	 */

	@Transactional
	public Offices findOfficesByOfficeCode(String officeCode, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findOfficesByOfficeCode", startResult, maxRows, officeCode);
			return (com.bluedream.sales1.domain.Offices) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findOfficesByCityContaining
	 *
	 */
	@Transactional
	public Set<Offices> findOfficesByCityContaining(String city) throws DataAccessException {

		return findOfficesByCityContaining(city, -1, -1);
	}

	/**
	 * JPQL Query - findOfficesByCityContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Offices> findOfficesByCityContaining(String city, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findOfficesByCityContaining", startResult, maxRows, city);
		return new LinkedHashSet<Offices>(query.getResultList());
	}

	/**
	 * JPQL Query - findOfficesByState
	 *
	 */
	@Transactional
	public Set<Offices> findOfficesByState(String state) throws DataAccessException {

		return findOfficesByState(state, -1, -1);
	}

	/**
	 * JPQL Query - findOfficesByState
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Offices> findOfficesByState(String state, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findOfficesByState", startResult, maxRows, state);
		return new LinkedHashSet<Offices>(query.getResultList());
	}

	/**
	 * JPQL Query - findOfficesByAddressLine2Containing
	 *
	 */
	@Transactional
	public Set<Offices> findOfficesByAddressLine2Containing(String addressLine2) throws DataAccessException {

		return findOfficesByAddressLine2Containing(addressLine2, -1, -1);
	}

	/**
	 * JPQL Query - findOfficesByAddressLine2Containing
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Offices> findOfficesByAddressLine2Containing(String addressLine2, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findOfficesByAddressLine2Containing", startResult, maxRows, addressLine2);
		return new LinkedHashSet<Offices>(query.getResultList());
	}

	/**
	 * JPQL Query - findOfficesByAddressLine2
	 *
	 */
	@Transactional
	public Set<Offices> findOfficesByAddressLine2(String addressLine2) throws DataAccessException {

		return findOfficesByAddressLine2(addressLine2, -1, -1);
	}

	/**
	 * JPQL Query - findOfficesByAddressLine2
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Offices> findOfficesByAddressLine2(String addressLine2, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findOfficesByAddressLine2", startResult, maxRows, addressLine2);
		return new LinkedHashSet<Offices>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllOfficess
	 *
	 */
	@Transactional
	public Set<Offices> findAllOfficess() throws DataAccessException {

		return findAllOfficess(-1, -1);
	}

	/**
	 * JPQL Query - findAllOfficess
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Offices> findAllOfficess(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllOfficess", startResult, maxRows);
		return new LinkedHashSet<Offices>(query.getResultList());
	}

	/**
	 * JPQL Query - findOfficesByPrimaryKey
	 *
	 */
	@Transactional
	public Offices findOfficesByPrimaryKey(String officeCode) throws DataAccessException {

		return findOfficesByPrimaryKey(officeCode, -1, -1);
	}

	/**
	 * JPQL Query - findOfficesByPrimaryKey
	 *
	 */

	@Transactional
	public Offices findOfficesByPrimaryKey(String officeCode, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findOfficesByPrimaryKey", startResult, maxRows, officeCode);
			return (com.bluedream.sales1.domain.Offices) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findOfficesByCity
	 *
	 */
	@Transactional
	public Set<Offices> findOfficesByCity(String city) throws DataAccessException {

		return findOfficesByCity(city, -1, -1);
	}

	/**
	 * JPQL Query - findOfficesByCity
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Offices> findOfficesByCity(String city, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findOfficesByCity", startResult, maxRows, city);
		return new LinkedHashSet<Offices>(query.getResultList());
	}

	/**
	 * JPQL Query - findOfficesByPhone
	 *
	 */
	@Transactional
	public Set<Offices> findOfficesByPhone(String phone) throws DataAccessException {

		return findOfficesByPhone(phone, -1, -1);
	}

	/**
	 * JPQL Query - findOfficesByPhone
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Offices> findOfficesByPhone(String phone, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findOfficesByPhone", startResult, maxRows, phone);
		return new LinkedHashSet<Offices>(query.getResultList());
	}

	/**
	 * JPQL Query - findOfficesByPostalCodeContaining
	 *
	 */
	@Transactional
	public Set<Offices> findOfficesByPostalCodeContaining(String postalCode) throws DataAccessException {

		return findOfficesByPostalCodeContaining(postalCode, -1, -1);
	}

	/**
	 * JPQL Query - findOfficesByPostalCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Offices> findOfficesByPostalCodeContaining(String postalCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findOfficesByPostalCodeContaining", startResult, maxRows, postalCode);
		return new LinkedHashSet<Offices>(query.getResultList());
	}

	/**
	 * JPQL Query - findOfficesByOfficeCodeContaining
	 *
	 */
	@Transactional
	public Set<Offices> findOfficesByOfficeCodeContaining(String officeCode) throws DataAccessException {

		return findOfficesByOfficeCodeContaining(officeCode, -1, -1);
	}

	/**
	 * JPQL Query - findOfficesByOfficeCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Offices> findOfficesByOfficeCodeContaining(String officeCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findOfficesByOfficeCodeContaining", startResult, maxRows, officeCode);
		return new LinkedHashSet<Offices>(query.getResultList());
	}

	/**
	 * JPQL Query - findOfficesByTerritoryContaining
	 *
	 */
	@Transactional
	public Set<Offices> findOfficesByTerritoryContaining(String territory) throws DataAccessException {

		return findOfficesByTerritoryContaining(territory, -1, -1);
	}

	/**
	 * JPQL Query - findOfficesByTerritoryContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Offices> findOfficesByTerritoryContaining(String territory, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findOfficesByTerritoryContaining", startResult, maxRows, territory);
		return new LinkedHashSet<Offices>(query.getResultList());
	}

	/**
	 * JPQL Query - findOfficesByCountry
	 *
	 */
	@Transactional
	public Set<Offices> findOfficesByCountry(String country) throws DataAccessException {

		return findOfficesByCountry(country, -1, -1);
	}

	/**
	 * JPQL Query - findOfficesByCountry
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Offices> findOfficesByCountry(String country, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findOfficesByCountry", startResult, maxRows, country);
		return new LinkedHashSet<Offices>(query.getResultList());
	}

	/**
	 * JPQL Query - findOfficesByStateContaining
	 *
	 */
	@Transactional
	public Set<Offices> findOfficesByStateContaining(String state) throws DataAccessException {

		return findOfficesByStateContaining(state, -1, -1);
	}

	/**
	 * JPQL Query - findOfficesByStateContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Offices> findOfficesByStateContaining(String state, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findOfficesByStateContaining", startResult, maxRows, state);
		return new LinkedHashSet<Offices>(query.getResultList());
	}

	/**
	 * JPQL Query - findOfficesByPostalCode
	 *
	 */
	@Transactional
	public Set<Offices> findOfficesByPostalCode(String postalCode) throws DataAccessException {

		return findOfficesByPostalCode(postalCode, -1, -1);
	}

	/**
	 * JPQL Query - findOfficesByPostalCode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Offices> findOfficesByPostalCode(String postalCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findOfficesByPostalCode", startResult, maxRows, postalCode);
		return new LinkedHashSet<Offices>(query.getResultList());
	}

	/**
	 * JPQL Query - findOfficesByCountryContaining
	 *
	 */
	@Transactional
	public Set<Offices> findOfficesByCountryContaining(String country) throws DataAccessException {

		return findOfficesByCountryContaining(country, -1, -1);
	}

	/**
	 * JPQL Query - findOfficesByCountryContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Offices> findOfficesByCountryContaining(String country, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findOfficesByCountryContaining", startResult, maxRows, country);
		return new LinkedHashSet<Offices>(query.getResultList());
	}

	/**
	 * JPQL Query - findOfficesByAddressLine1Containing
	 *
	 */
	@Transactional
	public Set<Offices> findOfficesByAddressLine1Containing(String addressLine1) throws DataAccessException {

		return findOfficesByAddressLine1Containing(addressLine1, -1, -1);
	}

	/**
	 * JPQL Query - findOfficesByAddressLine1Containing
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Offices> findOfficesByAddressLine1Containing(String addressLine1, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findOfficesByAddressLine1Containing", startResult, maxRows, addressLine1);
		return new LinkedHashSet<Offices>(query.getResultList());
	}

	/**
	 * JPQL Query - findOfficesByTerritory
	 *
	 */
	@Transactional
	public Set<Offices> findOfficesByTerritory(String territory) throws DataAccessException {

		return findOfficesByTerritory(territory, -1, -1);
	}

	/**
	 * JPQL Query - findOfficesByTerritory
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Offices> findOfficesByTerritory(String territory, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findOfficesByTerritory", startResult, maxRows, territory);
		return new LinkedHashSet<Offices>(query.getResultList());
	}

	/**
	 * JPQL Query - findOfficesByAddressLine1
	 *
	 */
	@Transactional
	public Set<Offices> findOfficesByAddressLine1(String addressLine1) throws DataAccessException {

		return findOfficesByAddressLine1(addressLine1, -1, -1);
	}

	/**
	 * JPQL Query - findOfficesByAddressLine1
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Offices> findOfficesByAddressLine1(String addressLine1, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findOfficesByAddressLine1", startResult, maxRows, addressLine1);
		return new LinkedHashSet<Offices>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Offices entity) {
		return true;
	}
}
