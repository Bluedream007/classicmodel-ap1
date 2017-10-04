package com.bluedream.sales1.web.rest;

import com.bluedream.sales1.dao.EmployeesDAO;
import com.bluedream.sales1.dao.OfficesDAO;

import com.bluedream.sales1.domain.Employees;
import com.bluedream.sales1.domain.Offices;

import com.bluedream.sales1.service.OfficesService;

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
 * Spring Rest controller that handles CRUD requests for Offices entities
 * 
 */

@Controller("OfficesRestController")
public class OfficesRestController {

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
	 * Service injected by Spring that provides CRUD operations for Offices entities
	 * 
	 */
	@Autowired
	private OfficesService officesService;

	/**
	 * Show all Offices entities
	 * 
	 */
	@RequestMapping(value = "/Offices", method = RequestMethod.GET)
	public List<Offices> listOfficess() {
		return new java.util.ArrayList<Offices>(officesService.loadOfficess());
	}

	/**
	 * Delete an existing Offices entity
	 * 
	 */
	@RequestMapping(value = "/Offices/{offices_officeCode}", method = RequestMethod.DELETE)
	public void deleteOffices(@PathVariable String offices_officeCode) {
		Offices offices = officesDAO.findOfficesByPrimaryKey(offices_officeCode);
		officesService.deleteOffices(offices);
	}

	/**
	 * Delete an existing Employees entity
	 * 
	 */
	@RequestMapping(value = "/Offices/{offices_officeCode}/employeeses/{employees_employeeNumber}", method = RequestMethod.DELETE)
	public void deleteOfficesEmployeeses(@PathVariable String offices_officeCode, @PathVariable Integer related_employeeses_employeeNumber) {
		officesService.deleteOfficesEmployeeses(offices_officeCode, related_employeeses_employeeNumber);
	}

	/**
	 * Save an existing Offices entity
	 * 
	 */
	@RequestMapping(value = "/Offices", method = RequestMethod.PUT)
	public Offices saveOffices(@ModelAttribute Offices offices) {
		officesService.saveOffices(offices);
		return officesDAO.findOfficesByPrimaryKey(offices.getOfficeCode());
	}

	/**
	 * Show all Employees entities by Offices
	 * 
	 */
	@RequestMapping(value = "/Offices/{offices_officeCode}/employeeses", method = RequestMethod.GET)
	public List<Employees> getOfficesEmployeeses(@PathVariable String offices_officeCode) {
		return new java.util.ArrayList<Employees>(officesDAO.findOfficesByPrimaryKey(offices_officeCode).getEmployeeses());
	}

	/**
	 * Create a new Offices entity
	 * 
	 */
	@RequestMapping(value = "/Offices", method = RequestMethod.POST)
	public Offices newOffices(@ModelAttribute Offices offices) {
		officesService.saveOffices(offices);
		return officesDAO.findOfficesByPrimaryKey(offices.getOfficeCode());
	}

	/**
	 * Create a new Employees entity
	 * 
	 */
	@RequestMapping(value = "/Offices/{offices_officeCode}/employeeses", method = RequestMethod.POST)
	public Employees newOfficesEmployeeses(@PathVariable String offices_officeCode, @ModelAttribute Employees employees) {
		officesService.saveOfficesEmployeeses(offices_officeCode, employees);
		return employeesDAO.findEmployeesByPrimaryKey(employees.getEmployeeNumber());
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
	 * View an existing Employees entity
	 * 
	 */
	@RequestMapping(value = "/Offices/{offices_officeCode}/employeeses/{employees_employeeNumber}", method = RequestMethod.GET)
	public Employees loadOfficesEmployeeses(@PathVariable String offices_officeCode, @PathVariable Integer related_employeeses_employeeNumber) {
		Employees employees = employeesDAO.findEmployeesByPrimaryKey(related_employeeses_employeeNumber, -1, -1);

		return employees;
	}

	/**
	 * Select an existing Offices entity
	 * 
	 */
	@RequestMapping(value = "/Offices/{offices_officeCode}", method = RequestMethod.GET)
	public Offices loadOffices(@PathVariable String offices_officeCode) {
		return officesDAO.findOfficesByPrimaryKey(offices_officeCode);
	}

	/**
	 * Save an existing Employees entity
	 * 
	 */
	@RequestMapping(value = "/Offices/{offices_officeCode}/employeeses", method = RequestMethod.PUT)
	public Employees saveOfficesEmployeeses(@PathVariable String offices_officeCode, @ModelAttribute Employees employeeses) {
		officesService.saveOfficesEmployeeses(offices_officeCode, employeeses);
		return employeesDAO.findEmployeesByPrimaryKey(employeeses.getEmployeeNumber());
	}
}