package com.bluedream.sales1.dao;

import com.bluedream.sales1.domain.Offices;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Offices entities.
 * 
 */
public interface OfficesDAO extends JpaDao<Offices> {

	/**
	 * JPQL Query - findOfficesByPhoneContaining
	 *
	 */
	public Set<Offices> findOfficesByPhoneContaining(String phone) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByPhoneContaining
	 *
	 */
	public Set<Offices> findOfficesByPhoneContaining(String phone, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByOfficeCode
	 *
	 */
	public Offices findOfficesByOfficeCode(String officeCode) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByOfficeCode
	 *
	 */
	public Offices findOfficesByOfficeCode(String officeCode, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByCityContaining
	 *
	 */
	public Set<Offices> findOfficesByCityContaining(String city) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByCityContaining
	 *
	 */
	public Set<Offices> findOfficesByCityContaining(String city, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByState
	 *
	 */
	public Set<Offices> findOfficesByState(String state) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByState
	 *
	 */
	public Set<Offices> findOfficesByState(String state, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByAddressLine2Containing
	 *
	 */
	public Set<Offices> findOfficesByAddressLine2Containing(String addressLine2) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByAddressLine2Containing
	 *
	 */
	public Set<Offices> findOfficesByAddressLine2Containing(String addressLine2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByAddressLine2
	 *
	 */
	public Set<Offices> findOfficesByAddressLine2(String addressLine2_1) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByAddressLine2
	 *
	 */
	public Set<Offices> findOfficesByAddressLine2(String addressLine2_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllOfficess
	 *
	 */
	public Set<Offices> findAllOfficess() throws DataAccessException;

	/**
	 * JPQL Query - findAllOfficess
	 *
	 */
	public Set<Offices> findAllOfficess(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByPrimaryKey
	 *
	 */
	public Offices findOfficesByPrimaryKey(String officeCode_1) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByPrimaryKey
	 *
	 */
	public Offices findOfficesByPrimaryKey(String officeCode_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByCity
	 *
	 */
	public Set<Offices> findOfficesByCity(String city_1) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByCity
	 *
	 */
	public Set<Offices> findOfficesByCity(String city_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByPhone
	 *
	 */
	public Set<Offices> findOfficesByPhone(String phone_1) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByPhone
	 *
	 */
	public Set<Offices> findOfficesByPhone(String phone_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByPostalCodeContaining
	 *
	 */
	public Set<Offices> findOfficesByPostalCodeContaining(String postalCode) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByPostalCodeContaining
	 *
	 */
	public Set<Offices> findOfficesByPostalCodeContaining(String postalCode, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByOfficeCodeContaining
	 *
	 */
	public Set<Offices> findOfficesByOfficeCodeContaining(String officeCode_2) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByOfficeCodeContaining
	 *
	 */
	public Set<Offices> findOfficesByOfficeCodeContaining(String officeCode_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByTerritoryContaining
	 *
	 */
	public Set<Offices> findOfficesByTerritoryContaining(String territory) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByTerritoryContaining
	 *
	 */
	public Set<Offices> findOfficesByTerritoryContaining(String territory, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByCountry
	 *
	 */
	public Set<Offices> findOfficesByCountry(String country) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByCountry
	 *
	 */
	public Set<Offices> findOfficesByCountry(String country, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByStateContaining
	 *
	 */
	public Set<Offices> findOfficesByStateContaining(String state_1) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByStateContaining
	 *
	 */
	public Set<Offices> findOfficesByStateContaining(String state_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByPostalCode
	 *
	 */
	public Set<Offices> findOfficesByPostalCode(String postalCode_1) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByPostalCode
	 *
	 */
	public Set<Offices> findOfficesByPostalCode(String postalCode_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByCountryContaining
	 *
	 */
	public Set<Offices> findOfficesByCountryContaining(String country_1) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByCountryContaining
	 *
	 */
	public Set<Offices> findOfficesByCountryContaining(String country_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByAddressLine1Containing
	 *
	 */
	public Set<Offices> findOfficesByAddressLine1Containing(String addressLine1) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByAddressLine1Containing
	 *
	 */
	public Set<Offices> findOfficesByAddressLine1Containing(String addressLine1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByTerritory
	 *
	 */
	public Set<Offices> findOfficesByTerritory(String territory_1) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByTerritory
	 *
	 */
	public Set<Offices> findOfficesByTerritory(String territory_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByAddressLine1
	 *
	 */
	public Set<Offices> findOfficesByAddressLine1(String addressLine1_1) throws DataAccessException;

	/**
	 * JPQL Query - findOfficesByAddressLine1
	 *
	 */
	public Set<Offices> findOfficesByAddressLine1(String addressLine1_1, int startResult, int maxRows) throws DataAccessException;

}