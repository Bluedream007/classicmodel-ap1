package com.bluedream.sales1.dao;

import com.bluedream.sales1.domain.Employees;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Employees entities.
 * 
 */
public interface EmployeesDAO extends JpaDao<Employees> {

	/**
	 * JPQL Query - findEmployeesByEmailContaining
	 *
	 */
	public Set<Employees> findEmployeesByEmailContaining(String email) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeesByEmailContaining
	 *
	 */
	public Set<Employees> findEmployeesByEmailContaining(String email, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeesByJobTitle
	 *
	 */
	public Set<Employees> findEmployeesByJobTitle(String jobTitle) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeesByJobTitle
	 *
	 */
	public Set<Employees> findEmployeesByJobTitle(String jobTitle, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeesByLastName
	 *
	 */
	public Set<Employees> findEmployeesByLastName(String lastName) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeesByLastName
	 *
	 */
	public Set<Employees> findEmployeesByLastName(String lastName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeesByEmployeeNumber
	 *
	 */
	public Employees findEmployeesByEmployeeNumber(Integer employeeNumber) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeesByEmployeeNumber
	 *
	 */
	public Employees findEmployeesByEmployeeNumber(Integer employeeNumber, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeesByPrimaryKey
	 *
	 */
	public Employees findEmployeesByPrimaryKey(Integer employeeNumber_1) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeesByPrimaryKey
	 *
	 */
	public Employees findEmployeesByPrimaryKey(Integer employeeNumber_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeesByFirstName
	 *
	 */
	public Set<Employees> findEmployeesByFirstName(String firstName) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeesByFirstName
	 *
	 */
	public Set<Employees> findEmployeesByFirstName(String firstName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeesByJobTitleContaining
	 *
	 */
	public Set<Employees> findEmployeesByJobTitleContaining(String jobTitle_1) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeesByJobTitleContaining
	 *
	 */
	public Set<Employees> findEmployeesByJobTitleContaining(String jobTitle_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeesByFirstNameContaining
	 *
	 */
	public Set<Employees> findEmployeesByFirstNameContaining(String firstName_1) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeesByFirstNameContaining
	 *
	 */
	public Set<Employees> findEmployeesByFirstNameContaining(String firstName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeesByExtension
	 *
	 */
	public Set<Employees> findEmployeesByExtension(String extension) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeesByExtension
	 *
	 */
	public Set<Employees> findEmployeesByExtension(String extension, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeesByExtensionContaining
	 *
	 */
	public Set<Employees> findEmployeesByExtensionContaining(String extension_1) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeesByExtensionContaining
	 *
	 */
	public Set<Employees> findEmployeesByExtensionContaining(String extension_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeesByEmail
	 *
	 */
	public Set<Employees> findEmployeesByEmail(String email_1) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeesByEmail
	 *
	 */
	public Set<Employees> findEmployeesByEmail(String email_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllEmployeess
	 *
	 */
	public Set<Employees> findAllEmployeess() throws DataAccessException;

	/**
	 * JPQL Query - findAllEmployeess
	 *
	 */
	public Set<Employees> findAllEmployeess(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeesByLastNameContaining
	 *
	 */
	public Set<Employees> findEmployeesByLastNameContaining(String lastName_1) throws DataAccessException;

	/**
	 * JPQL Query - findEmployeesByLastNameContaining
	 *
	 */
	public Set<Employees> findEmployeesByLastNameContaining(String lastName_1, int startResult, int maxRows) throws DataAccessException;

}