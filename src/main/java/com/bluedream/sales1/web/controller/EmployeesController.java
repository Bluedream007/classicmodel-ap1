package com.bluedream.sales1.web.controller;

import com.bluedream.sales1.dao.CustomersDAO;
import com.bluedream.sales1.dao.EmployeesDAO;
import com.bluedream.sales1.dao.OfficesDAO;

import com.bluedream.sales1.domain.Customers;
import com.bluedream.sales1.domain.Employees;
import com.bluedream.sales1.domain.Offices;

import com.bluedream.sales1.service.EmployeesService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

/**
 * Spring MVC controller that handles CRUD requests for Employees entities
 * 
 */

@Controller("EmployeesController")
public class EmployeesController {

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
	 * View an existing Employees entity
	 * 
	 */
	@RequestMapping("/selectEmployeesEmployeeses")
	public ModelAndView selectEmployeesEmployeeses(@RequestParam Integer employees_employeeNumber, @RequestParam Integer employeeses_employeeNumber) {
		Employees employees = employeesDAO.findEmployeesByPrimaryKey(employeeses_employeeNumber, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("employees_employeeNumber", employees_employeeNumber);
		mav.addObject("employees", employees);
		mav.setViewName("employees/employeeses/viewEmployeeses.jsp");

		return mav;
	}

	/**
	 * Save an existing Employees entity
	 * 
	 */
	@RequestMapping("/saveEmployees")
	public String saveEmployees(@ModelAttribute Employees employees) {
		employeesService.saveEmployees(employees);
		return "forward:/indexEmployees";
	}

	/**
	 * Delete an existing Employees entity
	 * 
	 */
	@RequestMapping("/deleteEmployeesEmployeeses")
	public ModelAndView deleteEmployeesEmployeeses(@RequestParam Integer employees_employeeNumber, @RequestParam Integer related_employeeses_employeeNumber) {
		ModelAndView mav = new ModelAndView();

		Employees employees = employeesService.deleteEmployeesEmployeeses(employees_employeeNumber, related_employeeses_employeeNumber);

		mav.addObject("employees_employeeNumber", employees_employeeNumber);
		mav.addObject("employees", employees);
		mav.setViewName("employees/viewEmployees.jsp");

		return mav;
	}

	/**
	 * Create a new Employees entity
	 * 
	 */
	@RequestMapping("/newEmployeesEmployees")
	public ModelAndView newEmployeesEmployees(@RequestParam Integer employees_employeeNumber) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("employees_employeeNumber", employees_employeeNumber);
		mav.addObject("employees", new Employees());
		mav.addObject("newFlag", true);
		mav.setViewName("employees/employees/editEmployees.jsp");

		return mav;
	}

	/**
	 * Edit an existing Employees entity
	 * 
	 */
	@RequestMapping("/editEmployeesEmployeeses")
	public ModelAndView editEmployeesEmployeeses(@RequestParam Integer employees_employeeNumber, @RequestParam Integer employeeses_employeeNumber) {
		Employees employees = employeesDAO.findEmployeesByPrimaryKey(employeeses_employeeNumber, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("employees_employeeNumber", employees_employeeNumber);
		mav.addObject("employees", employees);
		mav.setViewName("employees/employeeses/editEmployeeses.jsp");

		return mav;
	}

	/**
	 * Edit an existing Customers entity
	 * 
	 */
	@RequestMapping("/editEmployeesCustomerses")
	public ModelAndView editEmployeesCustomerses(@RequestParam Integer employees_employeeNumber, @RequestParam Integer customerses_customerNumber) {
		Customers customers = customersDAO.findCustomersByPrimaryKey(customerses_customerNumber, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("employees_employeeNumber", employees_employeeNumber);
		mav.addObject("customers", customers);
		mav.setViewName("employees/customerses/editCustomerses.jsp");

		return mav;
	}

	/**
	 * Create a new Employees entity
	 * 
	 */
	@RequestMapping("/newEmployeesEmployeeses")
	public ModelAndView newEmployeesEmployeeses(@RequestParam Integer employees_employeeNumber) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("employees_employeeNumber", employees_employeeNumber);
		mav.addObject("employees", new Employees());
		mav.addObject("newFlag", true);
		mav.setViewName("employees/employeeses/editEmployeeses.jsp");

		return mav;
	}

	/**
	 * Save an existing Customers entity
	 * 
	 */
	@RequestMapping("/saveEmployeesCustomerses")
	public ModelAndView saveEmployeesCustomerses(@RequestParam Integer employees_employeeNumber, @ModelAttribute Customers customerses) {
		Employees parent_employees = employeesService.saveEmployeesCustomerses(employees_employeeNumber, customerses);

		ModelAndView mav = new ModelAndView();
		mav.addObject("employees_employeeNumber", employees_employeeNumber);
		mav.addObject("employees", parent_employees);
		mav.setViewName("employees/viewEmployees.jsp");

		return mav;
	}

	/**
	 * Show all Employees entities by Employees
	 * 
	 */
	@RequestMapping("/listEmployeesEmployees")
	public ModelAndView listEmployeesEmployees(@RequestParam Integer employeeNumberKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("employees", employeesDAO.findEmployeesByPrimaryKey(employeeNumberKey));
		mav.setViewName("employees/employees/listEmployees.jsp");

		return mav;
	}

	/**
	 * Delete an existing Customers entity
	 * 
	 */
	@RequestMapping("/deleteEmployeesCustomerses")
	public ModelAndView deleteEmployeesCustomerses(@RequestParam Integer employees_employeeNumber, @RequestParam Integer related_customerses_customerNumber) {
		ModelAndView mav = new ModelAndView();

		Employees employees = employeesService.deleteEmployeesCustomerses(employees_employeeNumber, related_customerses_customerNumber);

		mav.addObject("employees_employeeNumber", employees_employeeNumber);
		mav.addObject("employees", employees);
		mav.setViewName("employees/viewEmployees.jsp");

		return mav;
	}

	/**
	 * Select the Employees entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteEmployees")
	public ModelAndView confirmDeleteEmployees(@RequestParam Integer employeeNumberKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("employees", employeesDAO.findEmployeesByPrimaryKey(employeeNumberKey));
		mav.setViewName("employees/deleteEmployees.jsp");

		return mav;
	}

	/**
	 * Select the child Offices entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteEmployeesOffices")
	public ModelAndView confirmDeleteEmployeesOffices(@RequestParam Integer employees_employeeNumber, @RequestParam String related_offices_officeCode) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("offices", officesDAO.findOfficesByPrimaryKey(related_offices_officeCode));
		mav.addObject("employees_employeeNumber", employees_employeeNumber);
		mav.setViewName("employees/offices/deleteOffices.jsp");

		return mav;
	}

	/**
	 * Show all Customers entities by Employees
	 * 
	 */
	@RequestMapping("/listEmployeesCustomerses")
	public ModelAndView listEmployeesCustomerses(@RequestParam Integer employeeNumberKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("employees", employeesDAO.findEmployeesByPrimaryKey(employeeNumberKey));
		mav.setViewName("employees/customerses/listCustomerses.jsp");

		return mav;
	}

	/**
	 * Delete an existing Employees entity
	 * 
	 */
	@RequestMapping("/deleteEmployees")
	public String deleteEmployees(@RequestParam Integer employeeNumberKey) {
		Employees employees = employeesDAO.findEmployeesByPrimaryKey(employeeNumberKey);
		employeesService.deleteEmployees(employees);
		return "forward:/indexEmployees";
	}

	/**
	 * Save an existing Employees entity
	 * 
	 */
	@RequestMapping("/saveEmployeesEmployees")
	public ModelAndView saveEmployeesEmployees(@RequestParam Integer employees_employeeNumber, @ModelAttribute Employees employees) {
		Employees parent_employees = employeesService.saveEmployeesEmployees(employees_employeeNumber, employees);

		ModelAndView mav = new ModelAndView();
		mav.addObject("employees_employeeNumber", employees_employeeNumber);
		mav.addObject("employees", parent_employees);
		mav.setViewName("employees/viewEmployees.jsp");

		return mav;
	}

	/**
	 * View an existing Customers entity
	 * 
	 */
	@RequestMapping("/selectEmployeesCustomerses")
	public ModelAndView selectEmployeesCustomerses(@RequestParam Integer employees_employeeNumber, @RequestParam Integer customerses_customerNumber) {
		Customers customers = customersDAO.findCustomersByPrimaryKey(customerses_customerNumber, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("employees_employeeNumber", employees_employeeNumber);
		mav.addObject("customers", customers);
		mav.setViewName("employees/customerses/viewCustomerses.jsp");

		return mav;
	}

	/**
	 * View an existing Employees entity
	 * 
	 */
	@RequestMapping("/selectEmployeesEmployees")
	public ModelAndView selectEmployeesEmployees(@RequestParam Integer employees_employeeNumber) {
		Employees employees = employeesDAO.findEmployeesByPrimaryKey(employees_employeeNumber, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("employees_employeeNumber", employees_employeeNumber);
		mav.addObject("employees", employees);
		mav.setViewName("employees/employees/viewEmployees.jsp");

		return mav;
	}

	/**
	 * Save an existing Offices entity
	 * 
	 */
	@RequestMapping("/saveEmployeesOffices")
	public ModelAndView saveEmployeesOffices(@RequestParam Integer employees_employeeNumber, @ModelAttribute Offices offices) {
		Employees parent_employees = employeesService.saveEmployeesOffices(employees_employeeNumber, offices);

		ModelAndView mav = new ModelAndView();
		mav.addObject("employees_employeeNumber", employees_employeeNumber);
		mav.addObject("employees", parent_employees);
		mav.setViewName("employees/viewEmployees.jsp");

		return mav;
	}

	/**
	 * Edit an existing Employees entity
	 * 
	 */
	@RequestMapping("/editEmployees")
	public ModelAndView editEmployees(@RequestParam Integer employeeNumberKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("employees", employeesDAO.findEmployeesByPrimaryKey(employeeNumberKey));
		mav.setViewName("employees/editEmployees.jsp");

		return mav;
	}

	/**
	 * Delete an existing Offices entity
	 * 
	 */
	@RequestMapping("/deleteEmployeesOffices")
	public ModelAndView deleteEmployeesOffices(@RequestParam Integer employees_employeeNumber, @RequestParam String related_offices_officeCode) {
		ModelAndView mav = new ModelAndView();

		Employees employees = employeesService.deleteEmployeesOffices(employees_employeeNumber, related_offices_officeCode);

		mav.addObject("employees_employeeNumber", employees_employeeNumber);
		mav.addObject("employees", employees);
		mav.setViewName("employees/viewEmployees.jsp");

		return mav;
	}

	/**
	 * Select an existing Employees entity
	 * 
	 */
	@RequestMapping("/selectEmployees")
	public ModelAndView selectEmployees(@RequestParam Integer employeeNumberKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("employees", employeesDAO.findEmployeesByPrimaryKey(employeeNumberKey));
		mav.setViewName("employees/viewEmployees.jsp");

		return mav;
	}

	/**
	 * Create a new Employees entity
	 * 
	 */
	@RequestMapping("/newEmployees")
	public ModelAndView newEmployees() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("employees", new Employees());
		mav.addObject("newFlag", true);
		mav.setViewName("employees/editEmployees.jsp");

		return mav;
	}

	/**
	 * Select the child Customers entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteEmployeesCustomerses")
	public ModelAndView confirmDeleteEmployeesCustomerses(@RequestParam Integer employees_employeeNumber, @RequestParam Integer related_customerses_customerNumber) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("customers", customersDAO.findCustomersByPrimaryKey(related_customerses_customerNumber));
		mav.addObject("employees_employeeNumber", employees_employeeNumber);
		mav.setViewName("employees/customerses/deleteCustomerses.jsp");

		return mav;
	}

	/**
	 * Delete an existing Employees entity
	 * 
	 */
	@RequestMapping("/deleteEmployeesEmployees")
	public ModelAndView deleteEmployeesEmployees(@RequestParam Integer employees_employeeNumber, @RequestParam Integer related_employees_employeeNumber) {
		ModelAndView mav = new ModelAndView();

		Employees employees = employeesService.deleteEmployeesEmployees(employees_employeeNumber, related_employees_employeeNumber);

		mav.addObject("employees_employeeNumber", employees_employeeNumber);
		mav.addObject("employees", employees);
		mav.setViewName("employees/viewEmployees.jsp");

		return mav;
	}

	/**
	 * Show all Offices entities by Employees
	 * 
	 */
	@RequestMapping("/listEmployeesOffices")
	public ModelAndView listEmployeesOffices(@RequestParam Integer employeeNumberKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("employees", employeesDAO.findEmployeesByPrimaryKey(employeeNumberKey));
		mav.setViewName("employees/offices/listOffices.jsp");

		return mav;
	}

	/**
	 * Save an existing Employees entity
	 * 
	 */
	@RequestMapping("/saveEmployeesEmployeeses")
	public ModelAndView saveEmployeesEmployeeses(@RequestParam Integer employees_employeeNumber, @ModelAttribute Employees employeeses) {
		Employees parent_employees = employeesService.saveEmployeesEmployeeses(employees_employeeNumber, employeeses);

		ModelAndView mav = new ModelAndView();
		mav.addObject("employees_employeeNumber", employees_employeeNumber);
		mav.addObject("employees", parent_employees);
		mav.setViewName("employees/viewEmployees.jsp");

		return mav;
	}

	/**
	 * Create a new Offices entity
	 * 
	 */
	@RequestMapping("/newEmployeesOffices")
	public ModelAndView newEmployeesOffices(@RequestParam Integer employees_employeeNumber) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("employees_employeeNumber", employees_employeeNumber);
		mav.addObject("offices", new Offices());
		mav.addObject("newFlag", true);
		mav.setViewName("employees/offices/editOffices.jsp");

		return mav;
	}

	/**
	 * Show all Employees entities
	 * 
	 */
	@RequestMapping("/indexEmployees")
	public ModelAndView listEmployeess() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("employeess", employeesService.loadEmployeess());

		mav.setViewName("employees/listEmployeess.jsp");

		return mav;
	}

	/**
	 * Select the child Employees entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteEmployeesEmployees")
	public ModelAndView confirmDeleteEmployeesEmployees(@RequestParam Integer employees_employeeNumber, @RequestParam Integer related_employees_employeeNumber) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("employees", employeesDAO.findEmployeesByPrimaryKey(related_employees_employeeNumber));
		mav.addObject("employees_employeeNumber", employees_employeeNumber);
		mav.setViewName("employees/employees/deleteEmployees.jsp");

		return mav;
	}

	/**
	 * View an existing Offices entity
	 * 
	 */
	@RequestMapping("/selectEmployeesOffices")
	public ModelAndView selectEmployeesOffices(@RequestParam Integer employees_employeeNumber, @RequestParam String offices_officeCode) {
		Offices offices = officesDAO.findOfficesByPrimaryKey(offices_officeCode, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("employees_employeeNumber", employees_employeeNumber);
		mav.addObject("offices", offices);
		mav.setViewName("employees/offices/viewOffices.jsp");

		return mav;
	}

	/**
	 * Select the child Employees entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteEmployeesEmployeeses")
	public ModelAndView confirmDeleteEmployeesEmployeeses(@RequestParam Integer employees_employeeNumber, @RequestParam Integer related_employeeses_employeeNumber) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("employees", employeesDAO.findEmployeesByPrimaryKey(related_employeeses_employeeNumber));
		mav.addObject("employees_employeeNumber", employees_employeeNumber);
		mav.setViewName("employees/employeeses/deleteEmployeeses.jsp");

		return mav;
	}

	/**
	 * Edit an existing Offices entity
	 * 
	 */
	@RequestMapping("/editEmployeesOffices")
	public ModelAndView editEmployeesOffices(@RequestParam Integer employees_employeeNumber, @RequestParam String offices_officeCode) {
		Offices offices = officesDAO.findOfficesByPrimaryKey(offices_officeCode, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("employees_employeeNumber", employees_employeeNumber);
		mav.addObject("offices", offices);
		mav.setViewName("employees/offices/editOffices.jsp");

		return mav;
	}

	/**
	 * Edit an existing Employees entity
	 * 
	 */
	@RequestMapping("/editEmployeesEmployees")
	public ModelAndView editEmployeesEmployees(@RequestParam Integer employees_employeeNumber) {
		Employees employees = employeesDAO.findEmployeesByPrimaryKey(employees_employeeNumber, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("employees_employeeNumber", employees_employeeNumber);
		mav.addObject("employees", employees);
		mav.setViewName("employees/employees/editEmployees.jsp");

		return mav;
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
	 * Entry point to show all Employees entities
	 * 
	 */
	public String indexEmployees() {
		return "redirect:/indexEmployees";
	}

	/**
	 * Show all Employees entities by Employees
	 * 
	 */
	@RequestMapping("/listEmployeesEmployeeses")
	public ModelAndView listEmployeesEmployeeses(@RequestParam Integer employeeNumberKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("employees", employeesDAO.findEmployeesByPrimaryKey(employeeNumberKey));
		mav.setViewName("employees/employeeses/listEmployeeses.jsp");

		return mav;
	}

	/**
	 * Create a new Customers entity
	 * 
	 */
	@RequestMapping("/newEmployeesCustomerses")
	public ModelAndView newEmployeesCustomerses(@RequestParam Integer employees_employeeNumber) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("employees_employeeNumber", employees_employeeNumber);
		mav.addObject("customers", new Customers());
		mav.addObject("newFlag", true);
		mav.setViewName("employees/customerses/editCustomerses.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/employeesController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}
}