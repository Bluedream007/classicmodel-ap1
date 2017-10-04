package com.bluedream.sales1.dao;

import com.bluedream.sales1.domain.Customers;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * DAO to manage Customers entities.
 * 
 */
@Repository("CustomersDAO")
@Transactional
public class CustomersDAOImpl extends AbstractJpaDao<Customers> implements
		CustomersDAO {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Customers.class }));

	/**
	 * EntityManager injected by Spring for persistence unit MySQL_ConnecterJ_5_1_36
	 *
	 */
	@PersistenceContext(unitName = "MySQL_ConnecterJ_5_1_36")
	private EntityManager entityManager;

	/**
	 * Instantiates a new CustomersDAOImpl
	 *
	 */
	public CustomersDAOImpl() {
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
	 * JPQL Query - findCustomersByCustomerNameContaining
	 *
	 */
	@Transactional
	public Set<Customers> findCustomersByCustomerNameContaining(String customerName) throws DataAccessException {

		return findCustomersByCustomerNameContaining(customerName, -1, -1);
	}

	/**
	 * JPQL Query - findCustomersByCustomerNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customers> findCustomersByCustomerNameContaining(String customerName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomersByCustomerNameContaining", startResult, maxRows, customerName);
		return new LinkedHashSet<Customers>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomersByPhone
	 *
	 */
	@Transactional
	public Set<Customers> findCustomersByPhone(String phone) throws DataAccessException {

		return findCustomersByPhone(phone, -1, -1);
	}

	/**
	 * JPQL Query - findCustomersByPhone
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customers> findCustomersByPhone(String phone, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomersByPhone", startResult, maxRows, phone);
		return new LinkedHashSet<Customers>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomersByAddressLine1Containing
	 *
	 */
	@Transactional
	public Set<Customers> findCustomersByAddressLine1Containing(String addressLine1) throws DataAccessException {

		return findCustomersByAddressLine1Containing(addressLine1, -1, -1);
	}

	/**
	 * JPQL Query - findCustomersByAddressLine1Containing
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customers> findCustomersByAddressLine1Containing(String addressLine1, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomersByAddressLine1Containing", startResult, maxRows, addressLine1);
		return new LinkedHashSet<Customers>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomersByCityContaining
	 *
	 */
	@Transactional
	public Set<Customers> findCustomersByCityContaining(String city) throws DataAccessException {

		return findCustomersByCityContaining(city, -1, -1);
	}

	/**
	 * JPQL Query - findCustomersByCityContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customers> findCustomersByCityContaining(String city, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomersByCityContaining", startResult, maxRows, city);
		return new LinkedHashSet<Customers>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllCustomerss
	 *
	 */
	@Transactional
	public Set<Customers> findAllCustomerss() throws DataAccessException {

		return findAllCustomerss(-1, -1);
	}

	/**
	 * JPQL Query - findAllCustomerss
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customers> findAllCustomerss(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllCustomerss", startResult, maxRows);
		return new LinkedHashSet<Customers>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomersByContactLastName
	 *
	 */
	@Transactional
	public Set<Customers> findCustomersByContactLastName(String contactLastName) throws DataAccessException {

		return findCustomersByContactLastName(contactLastName, -1, -1);
	}

	/**
	 * JPQL Query - findCustomersByContactLastName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customers> findCustomersByContactLastName(String contactLastName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomersByContactLastName", startResult, maxRows, contactLastName);
		return new LinkedHashSet<Customers>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomersByCountry
	 *
	 */
	@Transactional
	public Set<Customers> findCustomersByCountry(String country) throws DataAccessException {

		return findCustomersByCountry(country, -1, -1);
	}

	/**
	 * JPQL Query - findCustomersByCountry
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customers> findCustomersByCountry(String country, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomersByCountry", startResult, maxRows, country);
		return new LinkedHashSet<Customers>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomersByCustomerNumber
	 *
	 */
	@Transactional
	public Customers findCustomersByCustomerNumber(Integer customerNumber) throws DataAccessException {

		return findCustomersByCustomerNumber(customerNumber, -1, -1);
	}

	/**
	 * JPQL Query - findCustomersByCustomerNumber
	 *
	 */

	@Transactional
	public Customers findCustomersByCustomerNumber(Integer customerNumber, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findCustomersByCustomerNumber", startResult, maxRows, customerNumber);
			return (com.bluedream.sales1.domain.Customers) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findCustomersByContactLastNameContaining
	 *
	 */
	@Transactional
	public Set<Customers> findCustomersByContactLastNameContaining(String contactLastName) throws DataAccessException {

		return findCustomersByContactLastNameContaining(contactLastName, -1, -1);
	}

	/**
	 * JPQL Query - findCustomersByContactLastNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customers> findCustomersByContactLastNameContaining(String contactLastName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomersByContactLastNameContaining", startResult, maxRows, contactLastName);
		return new LinkedHashSet<Customers>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomersByPostalCodeContaining
	 *
	 */
	@Transactional
	public Set<Customers> findCustomersByPostalCodeContaining(String postalCode) throws DataAccessException {

		return findCustomersByPostalCodeContaining(postalCode, -1, -1);
	}

	/**
	 * JPQL Query - findCustomersByPostalCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customers> findCustomersByPostalCodeContaining(String postalCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomersByPostalCodeContaining", startResult, maxRows, postalCode);
		return new LinkedHashSet<Customers>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomersByAddressLine2
	 *
	 */
	@Transactional
	public Set<Customers> findCustomersByAddressLine2(String addressLine2) throws DataAccessException {

		return findCustomersByAddressLine2(addressLine2, -1, -1);
	}

	/**
	 * JPQL Query - findCustomersByAddressLine2
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customers> findCustomersByAddressLine2(String addressLine2, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomersByAddressLine2", startResult, maxRows, addressLine2);
		return new LinkedHashSet<Customers>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomersByAddressLine1
	 *
	 */
	@Transactional
	public Set<Customers> findCustomersByAddressLine1(String addressLine1) throws DataAccessException {

		return findCustomersByAddressLine1(addressLine1, -1, -1);
	}

	/**
	 * JPQL Query - findCustomersByAddressLine1
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customers> findCustomersByAddressLine1(String addressLine1, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomersByAddressLine1", startResult, maxRows, addressLine1);
		return new LinkedHashSet<Customers>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomersByCreditLimit
	 *
	 */
	@Transactional
	public Set<Customers> findCustomersByCreditLimit(java.math.BigDecimal creditLimit) throws DataAccessException {

		return findCustomersByCreditLimit(creditLimit, -1, -1);
	}

	/**
	 * JPQL Query - findCustomersByCreditLimit
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customers> findCustomersByCreditLimit(java.math.BigDecimal creditLimit, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomersByCreditLimit", startResult, maxRows, creditLimit);
		return new LinkedHashSet<Customers>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomersByCountryContaining
	 *
	 */
	@Transactional
	public Set<Customers> findCustomersByCountryContaining(String country) throws DataAccessException {

		return findCustomersByCountryContaining(country, -1, -1);
	}

	/**
	 * JPQL Query - findCustomersByCountryContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customers> findCustomersByCountryContaining(String country, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomersByCountryContaining", startResult, maxRows, country);
		return new LinkedHashSet<Customers>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomersByState
	 *
	 */
	@Transactional
	public Set<Customers> findCustomersByState(String state) throws DataAccessException {

		return findCustomersByState(state, -1, -1);
	}

	/**
	 * JPQL Query - findCustomersByState
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customers> findCustomersByState(String state, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomersByState", startResult, maxRows, state);
		return new LinkedHashSet<Customers>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomersByContactFirstName
	 *
	 */
	@Transactional
	public Set<Customers> findCustomersByContactFirstName(String contactFirstName) throws DataAccessException {

		return findCustomersByContactFirstName(contactFirstName, -1, -1);
	}

	/**
	 * JPQL Query - findCustomersByContactFirstName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customers> findCustomersByContactFirstName(String contactFirstName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomersByContactFirstName", startResult, maxRows, contactFirstName);
		return new LinkedHashSet<Customers>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomersByStateContaining
	 *
	 */
	@Transactional
	public Set<Customers> findCustomersByStateContaining(String state) throws DataAccessException {

		return findCustomersByStateContaining(state, -1, -1);
	}

	/**
	 * JPQL Query - findCustomersByStateContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customers> findCustomersByStateContaining(String state, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomersByStateContaining", startResult, maxRows, state);
		return new LinkedHashSet<Customers>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomersByAddressLine2Containing
	 *
	 */
	@Transactional
	public Set<Customers> findCustomersByAddressLine2Containing(String addressLine2) throws DataAccessException {

		return findCustomersByAddressLine2Containing(addressLine2, -1, -1);
	}

	/**
	 * JPQL Query - findCustomersByAddressLine2Containing
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customers> findCustomersByAddressLine2Containing(String addressLine2, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomersByAddressLine2Containing", startResult, maxRows, addressLine2);
		return new LinkedHashSet<Customers>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomersByCity
	 *
	 */
	@Transactional
	public Set<Customers> findCustomersByCity(String city) throws DataAccessException {

		return findCustomersByCity(city, -1, -1);
	}

	/**
	 * JPQL Query - findCustomersByCity
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customers> findCustomersByCity(String city, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomersByCity", startResult, maxRows, city);
		return new LinkedHashSet<Customers>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomersByPostalCode
	 *
	 */
	@Transactional
	public Set<Customers> findCustomersByPostalCode(String postalCode) throws DataAccessException {

		return findCustomersByPostalCode(postalCode, -1, -1);
	}

	/**
	 * JPQL Query - findCustomersByPostalCode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customers> findCustomersByPostalCode(String postalCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomersByPostalCode", startResult, maxRows, postalCode);
		return new LinkedHashSet<Customers>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomersByContactFirstNameContaining
	 *
	 */
	@Transactional
	public Set<Customers> findCustomersByContactFirstNameContaining(String contactFirstName) throws DataAccessException {

		return findCustomersByContactFirstNameContaining(contactFirstName, -1, -1);
	}

	/**
	 * JPQL Query - findCustomersByContactFirstNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customers> findCustomersByContactFirstNameContaining(String contactFirstName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomersByContactFirstNameContaining", startResult, maxRows, contactFirstName);
		return new LinkedHashSet<Customers>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomersByPhoneContaining
	 *
	 */
	@Transactional
	public Set<Customers> findCustomersByPhoneContaining(String phone) throws DataAccessException {

		return findCustomersByPhoneContaining(phone, -1, -1);
	}

	/**
	 * JPQL Query - findCustomersByPhoneContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customers> findCustomersByPhoneContaining(String phone, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomersByPhoneContaining", startResult, maxRows, phone);
		return new LinkedHashSet<Customers>(query.getResultList());
	}

	/**
	 * JPQL Query - findCustomersByPrimaryKey
	 *
	 */
	@Transactional
	public Customers findCustomersByPrimaryKey(Integer customerNumber) throws DataAccessException {

		// return findCustomersByPrimaryKey(customerNumber, -1, -1);
		// Modify by Charlotte
		return fetchCustomersByPKeyJoin(customerNumber, -1, -1);
	}

	/**
	 * JPQL Query - findCustomersByPrimaryKey
	 *
	 */
	@Transactional
	public Customers findCustomersByPrimaryKey(Integer customerNumber, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findCustomersByPrimaryKey", startResult, maxRows, customerNumber);
			return (com.bluedream.sales1.domain.Customers) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}
	
	/**
	 * JPQL Query - findCustomersByCustomerName
	 *
	 */
	@Transactional
	public Set<Customers> findCustomersByCustomerName(String customerName) throws DataAccessException {

		return findCustomersByCustomerName(customerName, -1, -1);
	}

	/**
	 * JPQL Query - findCustomersByCustomerName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Customers> findCustomersByCustomerName(String customerName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCustomersByCustomerName", startResult, maxRows, customerName);
		return new LinkedHashSet<Customers>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Customers entity) {
		return true;
	}
	
	
	// * MyFunxtion ================================================================================= *
	/**
	 * JPQL Query - fetch Customers By PrimaryKey
	 *
	 */
	@Transactional
	public Customers fetchCustomersByPKeyJoin(Integer customerNumber, int startResult, int maxRows) throws DataAccessException {
		// TODO - Define a Marker for logger
		// logger.debug("", "fetchCustomersByPKeyJoin");
		try {
			// The employees(salesRepEmployeeNumber) is a Lazy fetch so that it have to be selected from list. 
			 String strJoinFetchQry = "select myCustomers, myCustomers.employees from Customers myCustomers " +
		                                                   "inner join fetch myCustomers.employees " +		                                                   
		                                                   "where myCustomers.customerNumber = ?1";
			/* it's same as above sql
			 String strJoinFetchQry = "select oCustomers as oCust, oCustomers.employees as oEmp " +			 
                                      "from Customers oCustomers, Employees E " +
                                      "where  oCustomers.employees.employeeNumber = E.employeeNumber " +
                                      "  and oCustomers.customerNumber = ?1";
                                      */
			 Query query = entityManager.createQuery(strJoinFetchQry);
			 query.setParameter("1", customerNumber);
			 
			 // Customers oCustomers = (Customers) query.getSingleResult();
			 
			 // just for test - TODO move to Log.			 
			 Object[] oQryResult = (Object[]) query.getSingleResult();			 
			 Customers oCustomers = (Customers) (oQryResult[0]);
			 System.out.println("Customers from oQryResult[0]: " + oCustomers.toString());
			 // logger.debug("", "Customers from oQryResult[0]: " + oCustomers.toString());
			 Employees oEmployees = (Employees) (oQryResult[1]);
			 System.out.println("salesRepEmployeeNumber from oQryResult[1]: " + oEmployees.toString());
			 // logger.debug("", "salesRepEmployeeNumber from oQryResult[1]: " + oEmployees.toString());
			  
			 // return (com.bluedream.sales1.domain.Customers) oQryResult;
			 return (oCustomers);
			 
		} catch (NoResultException nre) {
			return null;
		}
	}
	// * MyFunxtion End ================================================================================= *
}
