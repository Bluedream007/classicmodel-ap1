package com.bluedream.sales1.web.rest;

import com.bluedream.sales1.dao.CustomersDAO;
import com.bluedream.sales1.dao.EmployeesDAO;
import com.bluedream.sales1.dao.OfficesDAO;

import com.bluedream.sales1.domain.Customers;
import com.bluedream.sales1.domain.Employees;
import com.bluedream.sales1.domain.Offices;

import com.bluedream.sales1.service.EmployeesService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Spring Rest controller that handles CRUD requests for Employees entities
 * 
 */

@Controller("EmployeesRestController")
public class EmployeesRestController {

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
	 * Service injected by Spring that provides CRUD operations for Employees entities
	 * 
	 */
	@Autowired
	private EmployeesService employeesService;

	/**
	 * Delete an existing Offices entity
	 * 
	 */
	@RequestMapping(value = "/Employees/{employees_employeeNumber}/offices/{offices_officeCode}", method = RequestMethod.DELETE)
	public void deleteEmployeesOffices(@PathVariable Integer employees_employeeNumber, @PathVariable String related_offices_officeCode) {
		employeesService.deleteEmployeesOffices(employees_employeeNumber, related_offices_officeCode);
	}

	/**
	 * Delete an existing Employees entity
	 * 
	 */
	@RequestMapping(value = "/Employees/{employees_employeeNumber}/employeeses/{employees_employeeNumber}", method = RequestMethod.DELETE)
	public void deleteEmployeesEmployeeses(@PathVariable Integer employees_employeeNumber, @PathVariable Integer related_employeeses_employeeNumber) {
		employeesService.deleteEmployeesEmployeeses(employees_employeeNumber, related_employeeses_employeeNumber);
	}

	/**
	 * Show all Customers entities by Employees
	 * 
	 */
	@RequestMapping(value = "/Employees/{employees_employeeNumber}/customerses", method = RequestMethod.GET)
	public List<Customers> getEmployeesCustomerses(@PathVariable Integer employees_employeeNumber) {
		return new java.util.ArrayList<Customers>(employeesDAO.findEmployeesByPrimaryKey(employees_employeeNumber).getCustomerses());
	}

	/**
	 * Save an existing Employees entity
	 * 
	 */
	@RequestMapping(value = "/Employees/{employees_employeeNumber}/employeeses", method = RequestMethod.PUT)
	public Employees saveEmployeesEmployeeses(@PathVariable Integer employees_employeeNumber, @ModelAttribute Employees employeeses) {
		employeesService.saveEmployeesEmployeeses(employees_employeeNumber, employeeses);
		return employeesDAO.findEmployeesByPrimaryKey(employeeses.getEmployeeNumber());
	}

	/**
	 * Save an existing Employees entity
	 * 
	 */
	@RequestMapping(value = "/Employees", method = RequestMethod.PUT)
	public Employees saveEmployees(@ModelAttribute Employees employees) {
		employeesService.saveEmployees(employees);
		return employeesDAO.findEmployeesByPrimaryKey(employees.getEmployeeNumber());
	}

	/**
	 * View an existing Offices entity
	 * 
	 */
	@RequestMapping(value = "/Employees/{employees_employeeNumber}/offices/{offices_officeCode}", method = RequestMethod.GET)
	public Offices loadEmployeesOffices(@PathVariable Integer employees_employeeNumber, @PathVariable String related_offices_officeCode) {
		Offices offices = officesDAO.findOfficesByPrimaryKey(related_offices_officeCode, -1, -1);

		return offices;
	}

	/**
	 * Create a new Employees entity
	 * 
	 */
	@RequestMapping(value = "/Employees/{employees_employeeNumber}/employeeses", method = RequestMethod.POST)
	public Employees newEmployeesEmployeeses(@PathVariable Integer employees_employeeNumber, @ModelAttribute Employees employees) {
		employeesService.saveEmployeesEmployeeses(employees_employeeNumber, employees);
		return employeesDAO.findEmployeesByPrimaryKey(employees.getEmployeeNumber());
	}

	/**
	 * Get Offices entity by Employees
	 * 
	 */
	@RequestMapping(value = "/Employees/{employees_employeeNumber}/offices", method = RequestMethod.GET)
	public Offices getEmployeesOffices(@PathVariable Integer employees_employeeNumber) {
		return employeesDAO.findEmployeesByPrimaryKey(employees_employeeNumber).getOffices();
	}

	/**
	 * Select an existing Employees entity
	 * 
	 */
	@RequestMapping(value = "/Employees/{employees_employeeNumber}", method = RequestMethod.GET)
	public Employees loadEmployees(@PathVariable Integer employees_employeeNumber) {
		return employeesDAO.findEmployeesByPrimaryKey(employees_employeeNumber);
	}

	/**
	 * Delete an existing Employees entity
	 * 
	 */
	@RequestMapping(value = "/Employees/{employees_employeeNumber}/employees/{employees_employeeNumber}", method = RequestMethod.DELETE)
	public void deleteEmployeesEmployees(@PathVariable Integer employees_employeeNumber, @PathVariable Integer related_employees_employeeNumber) {
		employeesService.deleteEmployeesEmployees(employees_employeeNumber, related_employees_employeeNumber);
	}

	/**
	 * Delete an existing Employees entity
	 * 
	 */
	@RequestMapping(value = "/Employees/{employees_employeeNumber}", method = RequestMethod.DELETE)
	public void deleteEmployees(@PathVariable Integer employees_employeeNumber) {
		Employees employees = employeesDAO.findEmployeesByPrimaryKey(employees_employeeNumber);
		employeesService.deleteEmployees(employees);
	}

	/**
	 * Save an existing Employees entity
	 * 
	 */
	@RequestMapping(value = "/Employees/{employees_employeeNumber}/employees", method = RequestMethod.PUT)
	public Employees saveEmployeesEmployees(@PathVariable Integer employees_employeeNumber, @ModelAttribute Employees employees) {
		employeesService.saveEmployeesEmployees(employees_employeeNumber, employees);
		return employeesDAO.findEmployeesByPrimaryKey(employees.getEmployeeNumber());
	}

	/**
	 * View an existing Employees entity
	 * 
	 */
	@RequestMapping(value = "/Employees/{employees_employeeNumber}/employees/{employees_employeeNumber}", method = RequestMethod.GET)
	public Employees loadEmployeesEmployees(@PathVariable Integer employees_employeeNumber, @PathVariable Integer related_employees_employeeNumber) {
		Employees employees = employeesDAO.findEmployeesByPrimaryKey(related_employees_employeeNumber, -1, -1);

		return employees;
	}

	/**
	 * Create a new Customers entity
	 * 
	 */
	@RequestMapping(value = "/Employees/{employees_employeeNumber}/customerses", method = RequestMethod.POST)
	public Customers newEmployeesCustomerses(@PathVariable Integer employees_employeeNumber, @ModelAttribute Customers customers) {
		employeesService.saveEmployeesCustomerses(employees_employeeNumber, customers);
		return customersDAO.findCustomersByPrimaryKey(customers.getCustomerNumber());
	}

	/**
	 * Save an existing Customers entity
	 * 
	 */
	@RequestMapping(value = "/Employees/{employees_employeeNumber}/customerses", method = RequestMethod.PUT)
	public Customers saveEmployeesCustomerses(@PathVariable Integer employees_employeeNumber, @ModelAttribute Customers customerses) {
		employeesService.saveEmployeesCustomerses(employees_employeeNumber, customerses);
		return customersDAO.findCustomersByPrimaryKey(customerses.getCustomerNumber());
	}

	/**
	 * Delete an existing Customers entity
	 * 
	 */
	@RequestMapping(value = "/Employees/{employees_employeeNumber}/customerses/{customers_customerNumber}", method = RequestMethod.DELETE)
	public void deleteEmployeesCustomerses(@PathVariable Integer employees_employeeNumber, @PathVariable Integer related_customerses_customerNumber) {
		employeesService.deleteEmployeesCustomerses(employees_employeeNumber, related_customerses_customerNumber);
	}

	/**
	 * Get Employees entity by Employees
	 * 
	 */
	@RequestMapping(value = "/Employees/{employees_employeeNumber}/employees", method = RequestMethod.GET)
	public Employees getEmployeesEmployees(@PathVariable Integer employees_employeeNumber) {
		return employeesDAO.findEmployeesByPrimaryKey(employees_employeeNumber).getEmployees();
	}

	/**
	 * Show all Employees entities
	 * 
	 */
	@RequestMapping(value = "/Employees", method = RequestMethod.GET)
	public List<Employees> listEmployeess() {
		return new java.util.ArrayList<Employees>(employeesService.loadEmployeess());
	}

	/**
	 * View an existing Employees entity
	 * 
	 */
	@RequestMapping(value = "/Employees/{employees_employeeNumber}/employeeses/{employees_employeeNumber}", method = RequestMethod.GET)
	public Employees loadEmployeesEmployeeses(@PathVariable Integer employees_employeeNumber, @PathVariable Integer related_employeeses_employeeNumber) {
		Employees employees = employeesDAO.findEmployeesByPrimaryKey(related_employeeses_employeeNumber, -1, -1);

		return employees;
	}

	/**
	 * Save an existing Offices entity
	 * 
	 */
	@RequestMapping(value = "/Employees/{employees_employeeNumber}/offices", method = RequestMethod.PUT)
	public Offices saveEmployeesOffices(@PathVariable Integer employees_employeeNumber, @ModelAttribute Offices offices) {
		employeesService.saveEmployeesOffices(employees_employeeNumber, offices);
		return officesDAO.findOfficesByPrimaryKey(offices.getOfficeCode());
	}

	/**
	 * View an existing Customers entity
	 * 
	 */
	@RequestMapping(value = "/Employees/{employees_employeeNumber}/customerses/{customers_customerNumber}", method = RequestMethod.GET)
	public Customers loadEmployeesCustomerses(@PathVariable Integer employees_employeeNumber, @PathVariable Integer related_customerses_customerNumber) {
		Customers customers = customersDAO.findCustomersByPrimaryKey(related_customerses_customerNumber, -1, -1);

		return customers;
	}

	/**
	 * Create a new Employees entity
	 * 
	 */
	@RequestMapping(value = "/Employees", method = RequestMethod.POST)
	public Employees newEmployees(@ModelAttribute Employees employees) {
		employeesService.saveEmployees(employees);
		return employeesDAO.findEmployeesByPrimaryKey(employees.getEmployeeNumber());
	}

	/**
	 * Show all Employees entities by Employees
	 * 
	 */
	@RequestMapping(value = "/Employees/{employees_employeeNumber}/employeeses", method = RequestMethod.GET)
	public List<Employees> getEmployeesEmployeeses(@PathVariable Integer employees_employeeNumber) {
		return new java.util.ArrayList<Employees>(employeesDAO.findEmployeesByPrimaryKey(employees_employeeNumber).getEmployeeses());
	}

	/**
	 * Register custom, context-specific property editors
	 * 
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder, HttpServletRequest request) { // Register static property editors.
		binder.registerCustomEditor(java.util.Calendar.class, new org.skyway.spring.util.databinding.CustomCalendarEditor());
		binder.registerCustomEditor(byte[].class, new org.springframework.web.multipart.support.ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(false));
		binder.registerCustomEditor(Boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(true));
		binder.registerCustomEditor(java.math.BigDecimal.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(java.math.BigDecimal.class, true));
		binder.registerCustomEditor(Integer.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Integer.class, true));
		binder.registerCustomEditor(java.util.Date.class, new org.skyway.spring.util.databinding.CustomDateEditor());
		binder.registerCustomEditor(String.class, new org.skyway.spring.util.databinding.StringEditor());
		binder.registerCustomEditor(Long.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Long.class, true));
		binder.registerCustomEditor(Double.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Double.class, true));
	}

	/**
	 * Create a new Offices entity
	 * 
	 */
	@RequestMapping(value = "/Employees/{employees_employeeNumber}/offices", method = RequestMethod.POST)
	public Offices newEmployeesOffices(@PathVariable Integer employees_employeeNumber, @ModelAttribute Offices offices) {
		employeesService.saveEmployeesOffices(employees_employeeNumber, offices);
		return officesDAO.findOfficesByPrimaryKey(offices.getOfficeCode());
	}

	/**
	 * Create a new Employees entity
	 * 
	 */
	@RequestMapping(value = "/Employees/{employees_employeeNumber}/employees", method = RequestMethod.POST)
	public Employees newEmployeesEmployees(@PathVariable Integer employees_employeeNumber, @ModelAttribute Employees employees) {
		employeesService.saveEmployeesEmployees(employees_employeeNumber, employees);
		return employeesDAO.findEmployeesByPrimaryKey(employees.getEmployeeNumber());
	}
}