package com.bluedream.sales1.web.controller;

import com.bluedream.sales1.dao.EmployeesDAO;
import com.bluedream.sales1.dao.OfficesDAO;

import com.bluedream.sales1.domain.Employees;
import com.bluedream.sales1.domain.Offices;

import com.bluedream.sales1.service.OfficesService;

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
 * Spring MVC controller that handles CRUD requests for Offices entities
 * 
 */

@Controller("OfficesController")
public class OfficesController {

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
	 * Edit an existing Employees entity
	 * 
	 */
	@RequestMapping("/editOfficesEmployeeses")
	public ModelAndView editOfficesEmployeeses(@RequestParam String offices_officeCode, @RequestParam Integer employeeses_employeeNumber) {
		Employees employees = employeesDAO.findEmployeesByPrimaryKey(employeeses_employeeNumber, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("offices_officeCode", offices_officeCode);
		mav.addObject("employees", employees);
		mav.setViewName("offices/employeeses/editEmployeeses.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Offices entities
	 * 
	 */
	public String indexOffices() {
		return "redirect:/indexOffices";
	}

	/**
	 * Select an existing Offices entity
	 * 
	 */
	@RequestMapping("/selectOffices")
	public ModelAndView selectOffices(@RequestParam String officeCodeKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("offices", officesDAO.findOfficesByPrimaryKey(officeCodeKey));
		mav.setViewName("offices/viewOffices.jsp");

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
	 * Select the child Employees entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteOfficesEmployeeses")
	public ModelAndView confirmDeleteOfficesEmployeeses(@RequestParam String offices_officeCode, @RequestParam Integer related_employeeses_employeeNumber) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("employees", employeesDAO.findEmployeesByPrimaryKey(related_employeeses_employeeNumber));
		mav.addObject("offices_officeCode", offices_officeCode);
		mav.setViewName("offices/employeeses/deleteEmployeeses.jsp");

		return mav;
	}

	/**
	 * Edit an existing Offices entity
	 * 
	 */
	@RequestMapping("/editOffices")
	public ModelAndView editOffices(@RequestParam String officeCodeKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("offices", officesDAO.findOfficesByPrimaryKey(officeCodeKey));
		mav.setViewName("offices/editOffices.jsp");

		return mav;
	}

	/**
	 * Create a new Offices entity
	 * 
	 */
	@RequestMapping("/newOffices")
	public ModelAndView newOffices() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("offices", new Offices());
		mav.addObject("newFlag", true);
		mav.setViewName("offices/editOffices.jsp");

		return mav;
	}

	/**
	 * View an existing Employees entity
	 * 
	 */
	@RequestMapping("/selectOfficesEmployeeses")
	public ModelAndView selectOfficesEmployeeses(@RequestParam String offices_officeCode, @RequestParam Integer employeeses_employeeNumber) {
		Employees employees = employeesDAO.findEmployeesByPrimaryKey(employeeses_employeeNumber, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("offices_officeCode", offices_officeCode);
		mav.addObject("employees", employees);
		mav.setViewName("offices/employeeses/viewEmployeeses.jsp");

		return mav;
	}

	/**
	 * Show all Employees entities by Offices
	 * 
	 */
	@RequestMapping("/listOfficesEmployeeses")
	public ModelAndView listOfficesEmployeeses(@RequestParam String officeCodeKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("offices", officesDAO.findOfficesByPrimaryKey(officeCodeKey));
		mav.setViewName("offices/employeeses/listEmployeeses.jsp");

		return mav;
	}

	/**
	 * Save an existing Employees entity
	 * 
	 */
	@RequestMapping("/saveOfficesEmployeeses")
	public ModelAndView saveOfficesEmployeeses(@RequestParam String offices_officeCode, @ModelAttribute Employees employeeses) {
		Offices parent_offices = officesService.saveOfficesEmployeeses(offices_officeCode, employeeses);

		ModelAndView mav = new ModelAndView();
		mav.addObject("offices_officeCode", offices_officeCode);
		mav.addObject("offices", parent_offices);
		mav.setViewName("offices/viewOffices.jsp");

		return mav;
	}

	/**
	 * Delete an existing Offices entity
	 * 
	 */
	@RequestMapping("/deleteOffices")
	public String deleteOffices(@RequestParam String officeCodeKey) {
		Offices offices = officesDAO.findOfficesByPrimaryKey(officeCodeKey);
		officesService.deleteOffices(offices);
		return "forward:/indexOffices";
	}

	/**
	 * Save an existing Offices entity
	 * 
	 */
	@RequestMapping("/saveOffices")
	public String saveOffices(@ModelAttribute Offices offices) {
		officesService.saveOffices(offices);
		return "forward:/indexOffices";
	}

	/**
	 */
	@RequestMapping("/officesController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Delete an existing Employees entity
	 * 
	 */
	@RequestMapping("/deleteOfficesEmployeeses")
	public ModelAndView deleteOfficesEmployeeses(@RequestParam String offices_officeCode, @RequestParam Integer related_employeeses_employeeNumber) {
		ModelAndView mav = new ModelAndView();

		Offices offices = officesService.deleteOfficesEmployeeses(offices_officeCode, related_employeeses_employeeNumber);

		mav.addObject("offices_officeCode", offices_officeCode);
		mav.addObject("offices", offices);
		mav.setViewName("offices/viewOffices.jsp");

		return mav;
	}

	/**
	 * Create a new Employees entity
	 * 
	 */
	@RequestMapping("/newOfficesEmployeeses")
	public ModelAndView newOfficesEmployeeses(@RequestParam String offices_officeCode) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("offices_officeCode", offices_officeCode);
		mav.addObject("employees", new Employees());
		mav.addObject("newFlag", true);
		mav.setViewName("offices/employeeses/editEmployeeses.jsp");

		return mav;
	}

	/**
	 * Select the Offices entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteOffices")
	public ModelAndView confirmDeleteOffices(@RequestParam String officeCodeKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("offices", officesDAO.findOfficesByPrimaryKey(officeCodeKey));
		mav.setViewName("offices/deleteOffices.jsp");

		return mav;
	}

	/**
	 * Show all Offices entities
	 * 
	 */
	@RequestMapping("/indexOffices")
	public ModelAndView listOfficess() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("officess", officesService.loadOfficess());

		mav.setViewName("offices/listOfficess.jsp");

		return mav;
	}
}