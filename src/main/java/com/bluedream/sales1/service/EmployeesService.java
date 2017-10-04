package com.bluedream.sales1.service;

import com.bluedream.sales1.domain.Customers;
import com.bluedream.sales1.domain.Employees;
import com.bluedream.sales1.domain.Offices;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Employees entities
 * 
 */
public interface EmployeesService {

	/**
	 * Save an existing Employees entity
	 * 
	 */
	public void saveEmployees(Employees employees);

	/**
	 * Save an existing Employees entity
	 * 
	 */
	public Employees saveEmployeesEmployees(Integer employeeNumber, Employees related_employees);

	/**
	 * Delete an existing Employees entity
	 * 
	 */
	public Employees deleteEmployeesEmployees(Integer employees_employeeNumber, Integer related_employees_employeeNumber);

	/**
	 * Save an existing Offices entity
	 * 
	 */
	public Employees saveEmployeesOffices(Integer employeeNumber_1, Offices related_offices);

	/**
	 * Save an existing Employees entity
	 * 
	 */
	public Employees saveEmployeesEmployeeses(Integer employeeNumber_2, Employees related_employeeses);

	/**
	 * Delete an existing Employees entity
	 * 
	 */
	public Employees deleteEmployeesEmployeeses(Integer employees_employeeNumber_1, Integer related_employeeses_employeeNumber);

	/**
	 * Save an existing Customers entity
	 * 
	 */
	public Employees saveEmployeesCustomerses(Integer employeeNumber_3, Customers related_customerses);

	/**
	 * Return a count of all Employees entity
	 * 
	 */
	public Integer countEmployeess();

	/**
	 * Delete an existing Employees entity
	 * 
	 */
	public void deleteEmployees(Employees employees_1);

	/**
	 * Return all Employees entity
	 * 
	 */
	public List<Employees> findAllEmployeess(Integer startResult, Integer maxRows);

	/**
	 */
	public Employees findEmployeesByPrimaryKey(Integer employeeNumber_4);

	/**
	 * Load an existing Employees entity
	 * 
	 */
	public Set<Employees> loadEmployeess();

	/**
	 * Delete an existing Customers entity
	 * 
	 */
	public Employees deleteEmployeesCustomerses(Integer employees_employeeNumber_2, Integer related_customerses_customerNumber);

	/**
	 * Delete an existing Offices entity
	 * 
	 */
	public Employees deleteEmployeesOffices(Integer employees_employeeNumber_3, String related_offices_officeCode);
}