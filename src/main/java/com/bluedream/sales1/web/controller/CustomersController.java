package com.bluedream.sales1.web.controller;

import com.bluedream.sales1.dao.CustomersDAO;
import com.bluedream.sales1.dao.EmployeesDAO;
import com.bluedream.sales1.dao.OrdersDAO;
import com.bluedream.sales1.dao.PaymentsDAO;

import com.bluedream.sales1.domain.Customers;
import com.bluedream.sales1.domain.Employees;
import com.bluedream.sales1.domain.Orders;
import com.bluedream.sales1.domain.Payments;

import com.bluedream.sales1.service.CustomersService;

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
 * Spring MVC controller that handles CRUD requests for Customers entities
 * 
 */

@Controller("CustomersController")
public class CustomersController {

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
	 * DAO injected by Spring that manages Orders entities
	 * 
	 */
	@Autowired
	private OrdersDAO ordersDAO;

	/**
	 * DAO injected by Spring that manages Payments entities
	 * 
	 */
	@Autowired
	private PaymentsDAO paymentsDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Customers entities
	 * 
	 */
	@Autowired
	private CustomersService customersService;

	/**
	 * View an existing Employees entity
	 * 
	 */
	@RequestMapping("/selectCustomersEmployees")
	public ModelAndView selectCustomersEmployees(@RequestParam Integer customers_customerNumber, @RequestParam Integer employees_employeeNumber) {
		Employees employees = employeesDAO.findEmployeesByPrimaryKey(employees_employeeNumber, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("customers_customerNumber", customers_customerNumber);
		mav.addObject("employees", employees);
		mav.setViewName("customers/employees/viewEmployees.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/customersController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Show all Customers entities
	 * 
	 */
	@RequestMapping("/indexCustomers")
	public ModelAndView listCustomerss() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("customerss", customersService.loadCustomerss());

		mav.setViewName("customers/listCustomerss.jsp");

		return mav;
	}

	/**
	 * View an existing Payments entity
	 * 
	 */
	@RequestMapping("/selectCustomersPaymentses")
	public ModelAndView selectCustomersPaymentses(@RequestParam Integer customers_customerNumber, @RequestParam Integer paymentses_customerNumber, @RequestParam String paymentses_checkNumber) {
		Payments payments = paymentsDAO.findPaymentsByPrimaryKey(paymentses_customerNumber, paymentses_checkNumber, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("customers_customerNumber", customers_customerNumber);
		mav.addObject("payments", payments);
		mav.setViewName("customers/paymentses/viewPaymentses.jsp");

		return mav;
	}

	/**
	 * Delete an existing Customers entity
	 * 
	 */
	@RequestMapping("/deleteCustomers")
	public String deleteCustomers(@RequestParam Integer customerNumberKey) {
		Customers customers = customersDAO.findCustomersByPrimaryKey(customerNumberKey);
		customersService.deleteCustomers(customers);
		return "forward:/indexCustomers";
	}

	/**
	 * Delete an existing Payments entity
	 * 
	 */
	@RequestMapping("/deleteCustomersPaymentses")
	public ModelAndView deleteCustomersPaymentses(@RequestParam Integer customers_customerNumber, @RequestParam Integer related_paymentses_customerNumber, @RequestParam String related_paymentses_checkNumber) {
		ModelAndView mav = new ModelAndView();

		Customers customers = customersService.deleteCustomersPaymentses(customers_customerNumber, related_paymentses_customerNumber, related_paymentses_checkNumber);

		mav.addObject("customers_customerNumber", customers_customerNumber);
		mav.addObject("customers", customers);
		mav.setViewName("customers/viewCustomers.jsp");

		return mav;
	}

	/**
	 * Select the child Payments entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteCustomersPaymentses")
	public ModelAndView confirmDeleteCustomersPaymentses(@RequestParam Integer customers_customerNumber, @RequestParam Integer related_paymentses_customerNumber, @RequestParam String related_paymentses_checkNumber) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("payments", paymentsDAO.findPaymentsByPrimaryKey(related_paymentses_customerNumber, related_paymentses_checkNumber));
		mav.addObject("customers_customerNumber", customers_customerNumber);
		mav.setViewName("customers/paymentses/deletePaymentses.jsp");

		return mav;
	}

	/**
	 * Save an existing Employees entity
	 * 
	 */
	@RequestMapping("/saveCustomersEmployees")
	public ModelAndView saveCustomersEmployees(@RequestParam Integer customers_customerNumber, @ModelAttribute Employees employees) {
		Customers parent_customers = customersService.saveCustomersEmployees(customers_customerNumber, employees);

		ModelAndView mav = new ModelAndView();
		mav.addObject("customers_customerNumber", customers_customerNumber);
		mav.addObject("customers", parent_customers);
		mav.setViewName("customers/viewCustomers.jsp");

		return mav;
	}

	/**
	 * Edit an existing Employees entity
	 * 
	 */
	@RequestMapping("/editCustomersEmployees")
	public ModelAndView editCustomersEmployees(@RequestParam Integer customers_customerNumber, @RequestParam Integer employees_employeeNumber) {
		Employees employees = employeesDAO.findEmployeesByPrimaryKey(employees_employeeNumber, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("customers_customerNumber", customers_customerNumber);
		mav.addObject("employees", employees);
		mav.setViewName("customers/employees/editEmployees.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Customers entities
	 * 
	 */
	public String indexCustomers() {
		return "redirect:/indexCustomers";
	}

	/**
	 * Edit an existing Payments entity
	 * 
	 */
	@RequestMapping("/editCustomersPaymentses")
	public ModelAndView editCustomersPaymentses(@RequestParam Integer customers_customerNumber, @RequestParam Integer paymentses_customerNumber, @RequestParam String paymentses_checkNumber) {
		Payments payments = paymentsDAO.findPaymentsByPrimaryKey(paymentses_customerNumber, paymentses_checkNumber, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("customers_customerNumber", customers_customerNumber);
		mav.addObject("payments", payments);
		mav.setViewName("customers/paymentses/editPaymentses.jsp");

		return mav;
	}

	/**
	 * Select the Customers entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteCustomers")
	public ModelAndView confirmDeleteCustomers(@RequestParam Integer customerNumberKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("customers", customersDAO.findCustomersByPrimaryKey(customerNumberKey));
		mav.setViewName("customers/deleteCustomers.jsp");

		return mav;
	}

	/**
	 * Save an existing Payments entity
	 * 
	 */
	@RequestMapping("/saveCustomersPaymentses")
	public ModelAndView saveCustomersPaymentses(@RequestParam Integer customers_customerNumber, @ModelAttribute Payments paymentses) {
		Customers parent_customers = customersService.saveCustomersPaymentses(customers_customerNumber, paymentses);

		ModelAndView mav = new ModelAndView();
		mav.addObject("customers_customerNumber", customers_customerNumber);
		mav.addObject("customers", parent_customers);
		mav.setViewName("customers/viewCustomers.jsp");

		return mav;
	}

	/**
	 * Edit an existing Orders entity
	 * 
	 */
	@RequestMapping("/editCustomersOrderses")
	public ModelAndView editCustomersOrderses(@RequestParam Integer customers_customerNumber, @RequestParam Integer orderses_orderNumber) {
		Orders orders = ordersDAO.findOrdersByPrimaryKey(orderses_orderNumber, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("customers_customerNumber", customers_customerNumber);
		mav.addObject("orders", orders);
		mav.setViewName("customers/orderses/editOrderses.jsp");

		return mav;
	}

	/**
	 * Show all Orders entities by Customers
	 * 
	 */
	@RequestMapping("/listCustomersOrderses")
	public ModelAndView listCustomersOrderses(@RequestParam Integer customerNumberKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("customers", customersDAO.findCustomersByPrimaryKey(customerNumberKey));
		mav.setViewName("customers/orderses/listOrderses.jsp");

		return mav;
	}

	/**
	 * Save an existing Orders entity
	 * 
	 */
	@RequestMapping("/saveCustomersOrderses")
	public ModelAndView saveCustomersOrderses(@RequestParam Integer customers_customerNumber, @ModelAttribute Orders orderses) {
		Customers parent_customers = customersService.saveCustomersOrderses(customers_customerNumber, orderses);

		ModelAndView mav = new ModelAndView();
		mav.addObject("customers_customerNumber", customers_customerNumber);
		mav.addObject("customers", parent_customers);
		mav.setViewName("customers/viewCustomers.jsp");

		return mav;
	}

	/**
	 * Create a new Customers entity
	 * 
	 */
	@RequestMapping("/newCustomers")
	public ModelAndView newCustomers() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("customers", new Customers());
		mav.addObject("newFlag", true);
		mav.setViewName("customers/editCustomers.jsp");

		return mav;
	}

	/**
	 * Delete an existing Orders entity
	 * 
	 */
	@RequestMapping("/deleteCustomersOrderses")
	public ModelAndView deleteCustomersOrderses(@RequestParam Integer customers_customerNumber, @RequestParam Integer related_orderses_orderNumber) {
		ModelAndView mav = new ModelAndView();

		Customers customers = customersService.deleteCustomersOrderses(customers_customerNumber, related_orderses_orderNumber);

		mav.addObject("customers_customerNumber", customers_customerNumber);
		mav.addObject("customers", customers);
		mav.setViewName("customers/viewCustomers.jsp");

		return mav;
	}

	/**
	 * Show all Employees entities by Customers
	 * 
	 */
	@RequestMapping("/listCustomersEmployees")
	public ModelAndView listCustomersEmployees(@RequestParam Integer customerNumberKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("customers", customersDAO.findCustomersByPrimaryKey(customerNumberKey));
		mav.setViewName("customers/employees/listEmployees.jsp");

		return mav;
	}

	/**
	 * Save an existing Customers entity
	 * 
	 */
	@RequestMapping("/saveCustomers")
	public String saveCustomers(@ModelAttribute Customers customers) {
		customersService.saveCustomers(customers);
		return "forward:/indexCustomers";
	}

	/**
	 * Select the child Orders entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteCustomersOrderses")
	public ModelAndView confirmDeleteCustomersOrderses(@RequestParam Integer customers_customerNumber, @RequestParam Integer related_orderses_orderNumber) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("orders", ordersDAO.findOrdersByPrimaryKey(related_orderses_orderNumber));
		mav.addObject("customers_customerNumber", customers_customerNumber);
		mav.setViewName("customers/orderses/deleteOrderses.jsp");

		return mav;
	}

	/**
	 * Delete an existing Employees entity
	 * 
	 */
	@RequestMapping("/deleteCustomersEmployees")
	public ModelAndView deleteCustomersEmployees(@RequestParam Integer customers_customerNumber, @RequestParam Integer related_employees_employeeNumber) {
		ModelAndView mav = new ModelAndView();

		Customers customers = customersService.deleteCustomersEmployees(customers_customerNumber, related_employees_employeeNumber);

		mav.addObject("customers_customerNumber", customers_customerNumber);
		mav.addObject("customers", customers);
		mav.setViewName("customers/viewCustomers.jsp");

		return mav;
	}

	/**
	 * Create a new Payments entity
	 * 
	 */
	@RequestMapping("/newCustomersPaymentses")
	public ModelAndView newCustomersPaymentses(@RequestParam Integer customers_customerNumber) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("customers_customerNumber", customers_customerNumber);
		mav.addObject("payments", new Payments());
		mav.addObject("newFlag", true);
		mav.setViewName("customers/paymentses/editPaymentses.jsp");

		return mav;
	}

	/**
	 * Select an existing Customers entity
	 * 
	 */
	@RequestMapping("/selectCustomers")
	public ModelAndView selectCustomers(@RequestParam Integer customerNumberKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("customers", customersDAO.findCustomersByPrimaryKey(customerNumberKey));
		mav.setViewName("customers/viewCustomers.jsp");

		return mav;
	}

	/**
	 * Select the child Employees entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteCustomersEmployees")
	public ModelAndView confirmDeleteCustomersEmployees(@RequestParam Integer customers_customerNumber, @RequestParam Integer related_employees_employeeNumber) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("employees", employeesDAO.findEmployeesByPrimaryKey(related_employees_employeeNumber));
		mav.addObject("customers_customerNumber", customers_customerNumber);
		mav.setViewName("customers/employees/deleteEmployees.jsp");

		return mav;
	}

	/**
	 * Edit an existing Customers entity
	 * 
	 */
	@RequestMapping("/editCustomers")
	public ModelAndView editCustomers(@RequestParam Integer customerNumberKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("customers", customersDAO.findCustomersByPrimaryKey(customerNumberKey));
		mav.setViewName("customers/editCustomers.jsp");

		return mav;
	}

	/**
	 * View an existing Orders entity
	 * 
	 */
	@RequestMapping("/selectCustomersOrderses")
	public ModelAndView selectCustomersOrderses(@RequestParam Integer customers_customerNumber, @RequestParam Integer orderses_orderNumber) {
		Orders orders = ordersDAO.findOrdersByPrimaryKey(orderses_orderNumber, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("customers_customerNumber", customers_customerNumber);
		mav.addObject("orders", orders);
		mav.setViewName("customers/orderses/viewOrderses.jsp");

		return mav;
	}

	/**
	 * Create a new Orders entity
	 * 
	 */
	@RequestMapping("/newCustomersOrderses")
	public ModelAndView newCustomersOrderses(@RequestParam Integer customers_customerNumber) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("customers_customerNumber", customers_customerNumber);
		mav.addObject("orders", new Orders());
		mav.addObject("newFlag", true);
		mav.setViewName("customers/orderses/editOrderses.jsp");

		return mav;
	}

	/**
	 * Create a new Employees entity
	 * 
	 */
	@RequestMapping("/newCustomersEmployees")
	public ModelAndView newCustomersEmployees(@RequestParam Integer customers_customerNumber) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("customers_customerNumber", customers_customerNumber);
		mav.addObject("employees", new Employees());
		mav.addObject("newFlag", true);
		mav.setViewName("customers/employees/editEmployees.jsp");

		return mav;
	}

	/**
	 * Show all Payments entities by Customers
	 * 
	 */
	@RequestMapping("/listCustomersPaymentses")
	public ModelAndView listCustomersPaymentses(@RequestParam Integer customerNumberKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("customers", customersDAO.findCustomersByPrimaryKey(customerNumberKey));
		mav.setViewName("customers/paymentses/listPaymentses.jsp");

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
}