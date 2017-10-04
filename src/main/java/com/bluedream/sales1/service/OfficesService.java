package com.bluedream.sales1.service;

import com.bluedream.sales1.domain.Employees;
import com.bluedream.sales1.domain.Offices;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Offices entities
 * 
 */
public interface OfficesService {

	/**
	 * Return a count of all Offices entity
	 * 
	 */
	public Integer countOfficess();

	/**
	 * Return all Offices entity
	 * 
	 */
	public List<Offices> findAllOfficess(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing Offices entity
	 * 
	 */
	public void deleteOffices(Offices offices);

	/**
	 * Save an existing Offices entity
	 * 
	 */
	public void saveOffices(Offices offices_1);

	/**
	 * Load an existing Offices entity
	 * 
	 */
	public Set<Offices> loadOfficess();

	/**
	 */
	public Offices findOfficesByPrimaryKey(String officeCode);

	/**
	 * Delete an existing Employees entity
	 * 
	 */
	public Offices deleteOfficesEmployeeses(String offices_officeCode, Integer related_employeeses_employeeNumber);

	/**
	 * Save an existing Employees entity
	 * 
	 */
	public Offices saveOfficesEmployeeses(String officeCode_1, Employees related_employeeses);
}