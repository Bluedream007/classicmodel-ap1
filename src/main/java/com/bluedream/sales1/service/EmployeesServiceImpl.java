package com.bluedream.sales1.service;

import com.bluedream.sales1.dao.CustomersDAO;
import com.bluedream.sales1.dao.EmployeesDAO;
import com.bluedream.sales1.dao.OfficesDAO;

import com.bluedream.sales1.domain.Customers;
import com.bluedream.sales1.domain.Employees;
import com.bluedream.sales1.domain.Offices;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Employees entities
 * 
 */

@Service("EmployeesService")
@Transactional
public class EmployeesServiceImpl implements EmployeesService {

	/**
	 * DAO injected by Spring that manages Customers entities
	 * 
	 */
	@Autowired
	private CustomersDAO customersDAO;

	/**
	 * DAO injected by Spring that manages Employees entities
	 * 
	 */
	@Autowired
	private EmployeesDAO employeesDAO;

	/**
	 * DAO injected by Spring that manages Offices entities
	 * 
	 */
	@Autowired
	private OfficesDAO officesDAO;

	/**
	 * Instantiates a new EmployeesServiceImpl.
	 *
	 */
	public EmployeesServiceImpl() {
	}

	/**
	 * Save an existing Employees entity
	 * 
	 */
	@Transactional
	public void saveEmployees(Employees employees) {
		Employees existingEmployees = employeesDAO.findEmployeesByPrimaryKey(employees.getEmployeeNumber());

		if (existingEmployees != null) {
			if (existingEmployees != employees) {
				existingEmployees.setEmployeeNumber(employees.getEmployeeNumber());
				existingEmployees.setLastName(employees.getLastName());
				existingEmployees.setFirstName(employees.getFirstName());
				existingEmployees.setExtension(employees.getExtension());
				existingEmployees.setEmail(employees.getEmail());
				existingEmployees.setJobTitle(employees.getJobTitle());
			}
			employees = employeesDAO.store(existingEmployees);
		} else {
			employees = employeesDAO.store(employees);
		}
		employeesDAO.flush();
	}

	/**
	 * Save an existing Employees entity
	 * 
	 */
	@Transactional
	public Employees saveEmployeesEmployees(Integer employeeNumber, Employees related_employees) {
		Employees employees = employeesDAO.findEmployeesByPrimaryKey(employeeNumber, -1, -1);
		Employees existingemployees = employeesDAO.findEmployeesByPrimaryKey(related_employees.getEmployeeNumber());

		// copy into the existing record to preserve existing relationships
		if (existingemployees != null) {
			existingemployees.setEmployeeNumber(related_employees.getEmployeeNumber());
			existingemployees.setLastName(related_employees.getLastName());
			existingemployees.setFirstName(related_employees.getFirstName());
			existingemployees.setExtension(related_employees.getExtension());
			existingemployees.setEmail(related_employees.getEmail());
			existingemployees.setJobTitle(related_employees.getJobTitle());
			related_employees = existingemployees;
		} else {
			related_employees = employeesDAO.store(related_employees);
			employeesDAO.flush();
		}

		employees.setEmployees(related_employees);
		related_employees.getEmployeeses().add(employees);
		employees = employeesDAO.store(employees);
		employeesDAO.flush();

		related_employees = employeesDAO.store(related_employees);
		employeesDAO.flush();

		return employees;
	}

	/**
	 * Delete an existing Employees entity
	 * 
	 */
	@Transactional
	public Employees deleteEmployeesEmployees(Integer employees_employeeNumber, Integer related_employees_employeeNumber) {
		Employees employees = employeesDAO.findEmployeesByPrimaryKey(employees_employeeNumber, -1, -1);
		Employees related_employees = employeesDAO.findEmployeesByPrimaryKey(related_employees_employeeNumber, -1, -1);

		employees.setEmployees(null);
		related_employees.getEmployeeses().remove(employees);
		employees = employeesDAO.store(employees);
		employeesDAO.flush();

		related_employees = employeesDAO.store(related_employees);
		employeesDAO.flush();

		employeesDAO.remove(related_employees);
		employeesDAO.flush();

		return employees;
	}

	/**
	 * Save an existing Offices entity
	 * 
	 */
	@Transactional
	public Employees saveEmployeesOffices(Integer employeeNumber, Offices related_offices) {
		Employees employees = employeesDAO.findEmployeesByPrimaryKey(employeeNumber, -1, -1);
		Offices existingoffices = officesDAO.findOfficesByPrimaryKey(related_offices.getOfficeCode());

		// copy into the existing record to preserve existing relationships
		if (existingoffices != null) {
			existingoffices.setOfficeCode(related_offices.getOfficeCode());
			existingoffices.setCity(related_offices.getCity());
			existingoffices.setPhone(related_offices.getPhone());
			existingoffices.setAddressLine1(related_offices.getAddressLine1());
			existingoffices.setAddressLine2(related_offices.getAddressLine2());
			existingoffices.setState(related_offices.getState());
			existingoffices.setCountry(related_offices.getCountry());
			existingoffices.setPostalCode(related_offices.getPostalCode());
			existingoffices.setTerritory(related_offices.getTerritory());
			related_offices = existingoffices;
		}

		employees.setOffices(related_offices);
		related_offices.getEmployeeses().add(employees);
		employees = employeesDAO.store(employees);
		employeesDAO.flush();

		related_offices = officesDAO.store(related_offices);
		officesDAO.flush();

		return employees;
	}

	/**
	 * Save an existing Employees entity
	 * 
	 */
	@Transactional
	public Employees saveEmployeesEmployeeses(Integer employeeNumber, Employees related_employeeses) {
		Employees employees = employeesDAO.findEmployeesByPrimaryKey(employeeNumber, -1, -1);
		Employees existingemployeeses = employeesDAO.findEmployeesByPrimaryKey(related_employeeses.getEmployeeNumber());

		// copy into the existing record to preserve existing relationships
		if (existingemployeeses != null) {
			existingemployeeses.setEmployeeNumber(related_employeeses.getEmployeeNumber());
			existingemployeeses.setLastName(related_employeeses.getLastName());
			existingemployeeses.setFirstName(related_employeeses.getFirstName());
			existingemployeeses.setExtension(related_employeeses.getExtension());
			existingemployeeses.setEmail(related_employeeses.getEmail());
			existingemployeeses.setJobTitle(related_employeeses.getJobTitle());
			related_employeeses = existingemployeeses;
		} else {
			related_employeeses = employeesDAO.store(related_employeeses);
			employeesDAO.flush();
		}

		employees.setEmployees(related_employeeses);
		related_employeeses.getEmployeeses().add(employees);
		employees = employeesDAO.store(employees);
		employeesDAO.flush();

		related_employeeses = employeesDAO.store(related_employeeses);
		employeesDAO.flush();

		return employees;
	}

	/**
	 * Delete an existing Employees entity
	 * 
	 */
	@Transactional
	public Employees deleteEmployeesEmployeeses(Integer employees_employeeNumber, Integer related_employeeses_employeeNumber) {
		Employees related_employeeses = employeesDAO.findEmployeesByPrimaryKey(related_employeeses_employeeNumber, -1, -1);

		Employees employees = employeesDAO.findEmployeesByPrimaryKey(employees_employeeNumber, -1, -1);

		employees.setEmployees(null);
		related_employeeses.getEmployeeses().remove(employees);

		employeesDAO.remove(related_employeeses);
		employeesDAO.flush();

		return employees;
	}

	/**
	 * Save an existing Customers entity
	 * 
	 */
	@Transactional
	public Employees saveEmployeesCustomerses(Integer employeeNumber, Customers related_customerses) {
		Employees employees = employeesDAO.findEmployeesByPrimaryKey(employeeNumber, -1, -1);
		Customers existingcustomerses = customersDAO.findCustomersByPrimaryKey(related_customerses.getCustomerNumber());

		// copy into the existing record to preserve existing relationships
		if (existingcustomerses != null) {
			existingcustomerses.setCustomerNumber(related_customerses.getCustomerNumber());
			existingcustomerses.setCustomerName(related_customerses.getCustomerName());
			existingcustomerses.setContactLastName(related_customerses.getContactLastName());
			existingcustomerses.setContactFirstName(related_customerses.getContactFirstName());
			existingcustomerses.setPhone(related_customerses.getPhone());
			existingcustomerses.setAddressLine1(related_customerses.getAddressLine1());
			existingcustomerses.setAddressLine2(related_customerses.getAddressLine2());
			existingcustomerses.setCity(related_customerses.getCity());
			existingcustomerses.setState(related_customerses.getState());
			existingcustomerses.setPostalCode(related_customerses.getPostalCode());
			existingcustomerses.setCountry(related_customerses.getCountry());
			existingcustomerses.setCreditLimit(related_customerses.getCreditLimit());
			related_customerses = existingcustomerses;
		} else {
			related_customerses = customersDAO.store(related_customerses);
			customersDAO.flush();
		}

		related_customerses.setEmployees(employees);
		employees.getCustomerses().add(related_customerses);
		related_customerses = customersDAO.store(related_customerses);
		customersDAO.flush();

		employees = employeesDAO.store(employees);
		employeesDAO.flush();

		return employees;
	}

	/**
	 * Return a count of all Employees entity
	 * 
	 */
	@Transactional
	public Integer countEmployeess() {
		return ((Long) employeesDAO.createQuerySingleResult("select count(o) from Employees o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing Employees entity
	 * 
	 */
	@Transactional
	public void deleteEmployees(Employees employees) {
		employeesDAO.remove(employees);
		employeesDAO.flush();
	}

	/**
	 * Return all Employees entity
	 * 
	 */
	@Transactional
	public List<Employees> findAllEmployeess(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Employees>(employeesDAO.findAllEmployeess(startResult, maxRows));
	}

	/**
	 */
	@Transactional
	public Employees findEmployeesByPrimaryKey(Integer employeeNumber) {
		return employeesDAO.findEmployeesByPrimaryKey(employeeNumber);
	}

	/**
	 * Load an existing Employees entity
	 * 
	 */
	@Transactional
	public Set<Employees> loadEmployeess() {
		return employeesDAO.findAllEmployeess();
	}

	/**
	 * Delete an existing Customers entity
	 * 
	 */
	@Transactional
	public Employees deleteEmployeesCustomerses(Integer employees_employeeNumber, Integer related_customerses_customerNumber) {
		Customers related_customerses = customersDAO.findCustomersByPrimaryKey(related_customerses_customerNumber, -1, -1);

		Employees employees = employeesDAO.findEmployeesByPrimaryKey(employees_employeeNumber, -1, -1);

		related_customerses.setEmployees(null);
		employees.getCustomerses().remove(related_customerses);

		customersDAO.remove(related_customerses);
		customersDAO.flush();

		return employees;
	}

	/**
	 * Delete an existing Offices entity
	 * 
	 */
	@Transactional
	public Employees deleteEmployeesOffices(Integer employees_employeeNumber, String related_offices_officeCode) {
		Employees employees = employeesDAO.findEmployeesByPrimaryKey(employees_employeeNumber, -1, -1);
		Offices related_offices = officesDAO.findOfficesByPrimaryKey(related_offices_officeCode, -1, -1);

		employees.setOffices(null);
		related_offices.getEmployeeses().remove(employees);
		employees = employeesDAO.store(employees);
		employeesDAO.flush();

		related_offices = officesDAO.store(related_offices);
		officesDAO.flush();

		officesDAO.remove(related_offices);
		officesDAO.flush();

		return employees;
	}
}
