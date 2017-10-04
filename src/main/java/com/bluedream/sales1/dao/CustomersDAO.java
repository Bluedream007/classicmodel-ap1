package com.bluedream.sales1.dao;

import com.bluedream.sales1.domain.Customers;

import java.math.BigDecimal;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Customers entities.
 * 
 */
public interface CustomersDAO extends JpaDao<Customers> {

	/**
	 * JPQL Query - findCustomersByCustomerNameContaining
	 *
	 */
	public Set<Customers> findCustomersByCustomerNameContaining(String customerName) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByCustomerNameContaining
	 *
	 */
	public Set<Customers> findCustomersByCustomerNameContaining(String customerName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByPhone
	 *
	 */
	public Set<Customers> findCustomersByPhone(String phone) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByPhone
	 *
	 */
	public Set<Customers> findCustomersByPhone(String phone, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByAddressLine1Containing
	 *
	 */
	public Set<Customers> findCustomersByAddressLine1Containing(String addressLine1) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByAddressLine1Containing
	 *
	 */
	public Set<Customers> findCustomersByAddressLine1Containing(String addressLine1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByCityContaining
	 *
	 */
	public Set<Customers> findCustomersByCityContaining(String city) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByCityContaining
	 *
	 */
	public Set<Customers> findCustomersByCityContaining(String city, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllCustomerss
	 *
	 */
	public Set<Customers> findAllCustomerss() throws DataAccessException;

	/**
	 * JPQL Query - findAllCustomerss
	 *
	 */
	public Set<Customers> findAllCustomerss(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByContactLastName
	 *
	 */
	public Set<Customers> findCustomersByContactLastName(String contactLastName) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByContactLastName
	 *
	 */
	public Set<Customers> findCustomersByContactLastName(String contactLastName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByCountry
	 *
	 */
	public Set<Customers> findCustomersByCountry(String country) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByCountry
	 *
	 */
	public Set<Customers> findCustomersByCountry(String country, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByCustomerNumber
	 *
	 */
	public Customers findCustomersByCustomerNumber(Integer customerNumber) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByCustomerNumber
	 *
	 */
	public Customers findCustomersByCustomerNumber(Integer customerNumber, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByContactLastNameContaining
	 *
	 */
	public Set<Customers> findCustomersByContactLastNameContaining(String contactLastName_1) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByContactLastNameContaining
	 *
	 */
	public Set<Customers> findCustomersByContactLastNameContaining(String contactLastName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByPostalCodeContaining
	 *
	 */
	public Set<Customers> findCustomersByPostalCodeContaining(String postalCode) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByPostalCodeContaining
	 *
	 */
	public Set<Customers> findCustomersByPostalCodeContaining(String postalCode, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByAddressLine2
	 *
	 */
	public Set<Customers> findCustomersByAddressLine2(String addressLine2) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByAddressLine2
	 *
	 */
	public Set<Customers> findCustomersByAddressLine2(String addressLine2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByAddressLine1
	 *
	 */
	public Set<Customers> findCustomersByAddressLine1(String addressLine1_1) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByAddressLine1
	 *
	 */
	public Set<Customers> findCustomersByAddressLine1(String addressLine1_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByCreditLimit
	 *
	 */
	public Set<Customers> findCustomersByCreditLimit(java.math.BigDecimal creditLimit) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByCreditLimit
	 *
	 */
	public Set<Customers> findCustomersByCreditLimit(BigDecimal creditLimit, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByCountryContaining
	 *
	 */
	public Set<Customers> findCustomersByCountryContaining(String country_1) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByCountryContaining
	 *
	 */
	public Set<Customers> findCustomersByCountryContaining(String country_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByState
	 *
	 */
	public Set<Customers> findCustomersByState(String state) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByState
	 *
	 */
	public Set<Customers> findCustomersByState(String state, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByContactFirstName
	 *
	 */
	public Set<Customers> findCustomersByContactFirstName(String contactFirstName) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByContactFirstName
	 *
	 */
	public Set<Customers> findCustomersByContactFirstName(String contactFirstName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByStateContaining
	 *
	 */
	public Set<Customers> findCustomersByStateContaining(String state_1) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByStateContaining
	 *
	 */
	public Set<Customers> findCustomersByStateContaining(String state_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByAddressLine2Containing
	 *
	 */
	public Set<Customers> findCustomersByAddressLine2Containing(String addressLine2_1) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByAddressLine2Containing
	 *
	 */
	public Set<Customers> findCustomersByAddressLine2Containing(String addressLine2_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByCity
	 *
	 */
	public Set<Customers> findCustomersByCity(String city_1) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByCity
	 *
	 */
	public Set<Customers> findCustomersByCity(String city_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByPostalCode
	 *
	 */
	public Set<Customers> findCustomersByPostalCode(String postalCode_1) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByPostalCode
	 *
	 */
	public Set<Customers> findCustomersByPostalCode(String postalCode_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByContactFirstNameContaining
	 *
	 */
	public Set<Customers> findCustomersByContactFirstNameContaining(String contactFirstName_1) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByContactFirstNameContaining
	 *
	 */
	public Set<Customers> findCustomersByContactFirstNameContaining(String contactFirstName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByPhoneContaining
	 *
	 */
	public Set<Customers> findCustomersByPhoneContaining(String phone_1) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByPhoneContaining
	 *
	 */
	public Set<Customers> findCustomersByPhoneContaining(String phone_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByPrimaryKey
	 *
	 */
	public Customers findCustomersByPrimaryKey(Integer customerNumber_1) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByPrimaryKey
	 *
	 */
	public Customers findCustomersByPrimaryKey(Integer customerNumber_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByCustomerName
	 *
	 */
	public Set<Customers> findCustomersByCustomerName(String customerName_1) throws DataAccessException;

	/**
	 * JPQL Query - findCustomersByCustomerName
	 *
	 */
	public Set<Customers> findCustomersByCustomerName(String customerName_1, int startResult, int maxRows) throws DataAccessException;
	
	/**
	 * JPQL Query - fetch Customers By PrimaryKey
	 *
	 */	
	public Customers fetchCustomersByPKeyJoin(Integer customerNumber, int startResult, int maxRows) throws DataAccessException;

}