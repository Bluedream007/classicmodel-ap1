package com.bluedream.sales1.web.controller;

import com.bluedream.sales1.dao.CustomersDAO;
import com.bluedream.sales1.dao.OrderdetailsDAO;
import com.bluedream.sales1.dao.OrdersDAO;

import com.bluedream.sales1.domain.Customers;
import com.bluedream.sales1.domain.Orderdetails;
import com.bluedream.sales1.domain.Orders;

import com.bluedream.sales1.service.OrdersService;

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
 * Spring MVC controller that handles CRUD requests for Orders entities
 * 
 */

@Controller("OrdersController")
public class OrdersController {

	/**
	 * DAO injected by Spring that manages Customers entities
	 * 
	 */
	@Autowired
	private CustomersDAO customersDAO;

	/**
	 * DAO injected by Spring that manages Orderdetails entities
	 * 
	 */
	@Autowired
	private OrderdetailsDAO orderdetailsDAO;

	/**
	 * DAO injected by Spring that manages Orders entities
	 * 
	 */
	@Autowired
	private OrdersDAO ordersDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Orders entities
	 * 
	 */
	@Autowired
	private OrdersService ordersService;

	/**
	 * Select the child Orderdetails entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteOrdersOrderdetailses")
	public ModelAndView confirmDeleteOrdersOrderdetailses(@RequestParam Integer orders_orderNumber, @RequestParam Integer related_orderdetailses_orderNumber, @RequestParam String related_orderdetailses_productCode) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("orderdetails", orderdetailsDAO.findOrderdetailsByPrimaryKey(related_orderdetailses_orderNumber, related_orderdetailses_productCode));
		mav.addObject("orders_orderNumber", orders_orderNumber);
		mav.setViewName("orders/orderdetailses/deleteOrderdetailses.jsp");

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
	 * Select the Orders entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteOrders")
	public ModelAndView confirmDeleteOrders(@RequestParam Integer orderNumberKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("orders", ordersDAO.findOrdersByPrimaryKey(orderNumberKey));
		mav.setViewName("orders/deleteOrders.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/ordersController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Edit an existing Customers entity
	 * 
	 */
	@RequestMapping("/editOrdersCustomers")
	public ModelAndView editOrdersCustomers(@RequestParam Integer orders_orderNumber, @RequestParam Integer customers_customerNumber) {
		Customers customers = customersDAO.findCustomersByPrimaryKey(customers_customerNumber, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("orders_orderNumber", orders_orderNumber);
		mav.addObject("customers", customers);
		mav.setViewName("orders/customers/editCustomers.jsp");

		return mav;
	}

	/**
	 * Show all Orders entities
	 * 
	 */
	@RequestMapping("/indexOrders")
	public ModelAndView listOrderss() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("orderss", ordersService.loadOrderss());

		mav.setViewName("orders/listOrderss.jsp");

		return mav;
	}

	/**
	 * Delete an existing Customers entity
	 * 
	 */
	@RequestMapping("/deleteOrdersCustomers")
	public ModelAndView deleteOrdersCustomers(@RequestParam Integer orders_orderNumber, @RequestParam Integer related_customers_customerNumber) {
		ModelAndView mav = new ModelAndView();

		Orders orders = ordersService.deleteOrdersCustomers(orders_orderNumber, related_customers_customerNumber);

		mav.addObject("orders_orderNumber", orders_orderNumber);
		mav.addObject("orders", orders);
		mav.setViewName("orders/viewOrders.jsp");

		return mav;
	}

	/**
	 * Create a new Orders entity
	 * 
	 */
	@RequestMapping("/newOrders")
	public ModelAndView newOrders() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("orders", new Orders());
		mav.addObject("newFlag", true);
		mav.setViewName("orders/editOrders.jsp");

		return mav;
	}

	/**
	 * Save an existing Customers entity
	 * 
	 */
	@RequestMapping("/saveOrdersCustomers")
	public ModelAndView saveOrdersCustomers(@RequestParam Integer orders_orderNumber, @ModelAttribute Customers customers) {
		Orders parent_orders = ordersService.saveOrdersCustomers(orders_orderNumber, customers);

		ModelAndView mav = new ModelAndView();
		mav.addObject("orders_orderNumber", orders_orderNumber);
		mav.addObject("orders", parent_orders);
		mav.setViewName("orders/viewOrders.jsp");

		return mav;
	}

	/**
	 * View an existing Customers entity
	 * 
	 */
	@RequestMapping("/selectOrdersCustomers")
	public ModelAndView selectOrdersCustomers(@RequestParam Integer orders_orderNumber, @RequestParam Integer customers_customerNumber) {
		Customers customers = customersDAO.findCustomersByPrimaryKey(customers_customerNumber, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("orders_orderNumber", orders_orderNumber);
		mav.addObject("customers", customers);
		mav.setViewName("orders/customers/viewCustomers.jsp");

		return mav;
	}

	/**
	 * Edit an existing Orders entity
	 * 
	 */
	@RequestMapping("/editOrders")
	public ModelAndView editOrders(@RequestParam Integer orderNumberKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("orders", ordersDAO.findOrdersByPrimaryKey(orderNumberKey));
		mav.setViewName("orders/editOrders.jsp");

		return mav;
	}

	/**
	 * Show all Customers entities by Orders
	 * 
	 */
	@RequestMapping("/listOrdersCustomers")
	public ModelAndView listOrdersCustomers(@RequestParam Integer orderNumberKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("orders", ordersDAO.findOrdersByPrimaryKey(orderNumberKey));
		mav.setViewName("orders/customers/listCustomers.jsp");

		return mav;
	}

	/**
	 * Select the child Customers entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteOrdersCustomers")
	public ModelAndView confirmDeleteOrdersCustomers(@RequestParam Integer orders_orderNumber, @RequestParam Integer related_customers_customerNumber) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("customers", customersDAO.findCustomersByPrimaryKey(related_customers_customerNumber));
		mav.addObject("orders_orderNumber", orders_orderNumber);
		mav.setViewName("orders/customers/deleteCustomers.jsp");

		return mav;
	}

	/**
	 * Select an existing Orders entity
	 * 
	 */
	@RequestMapping("/selectOrders")
	public ModelAndView selectOrders(@RequestParam Integer orderNumberKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("orders", ordersDAO.findOrdersByPrimaryKey(orderNumberKey));
		mav.setViewName("orders/viewOrders.jsp");

		return mav;
	}

	/**
	 * Save an existing Orders entity
	 * 
	 */
	@RequestMapping("/saveOrders")
	public String saveOrders(@ModelAttribute Orders orders) {
		ordersService.saveOrders(orders);
		return "forward:/indexOrders";
	}

	/**
	 * Show all Orderdetails entities by Orders
	 * 
	 */
	@RequestMapping("/listOrdersOrderdetailses")
	public ModelAndView listOrdersOrderdetailses(@RequestParam Integer orderNumberKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("orders", ordersDAO.findOrdersByPrimaryKey(orderNumberKey));
		mav.setViewName("orders/orderdetailses/listOrderdetailses.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Orders entities
	 * 
	 */
	public String indexOrders() {
		return "redirect:/indexOrders";
	}

	/**
	 * Edit an existing Orderdetails entity
	 * 
	 */
	@RequestMapping("/editOrdersOrderdetailses")
	public ModelAndView editOrdersOrderdetailses(@RequestParam Integer orders_orderNumber, @RequestParam Integer orderdetailses_orderNumber, @RequestParam String orderdetailses_productCode) {
		Orderdetails orderdetails = orderdetailsDAO.findOrderdetailsByPrimaryKey(orderdetailses_orderNumber, orderdetailses_productCode, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("orders_orderNumber", orders_orderNumber);
		mav.addObject("orderdetails", orderdetails);
		mav.setViewName("orders/orderdetailses/editOrderdetailses.jsp");

		return mav;
	}

	/**
	 * Delete an existing Orderdetails entity
	 * 
	 */
	@RequestMapping("/deleteOrdersOrderdetailses")
	public ModelAndView deleteOrdersOrderdetailses(@RequestParam Integer orders_orderNumber, @RequestParam Integer related_orderdetailses_orderNumber, @RequestParam String related_orderdetailses_productCode) {
		ModelAndView mav = new ModelAndView();

		Orders orders = ordersService.deleteOrdersOrderdetailses(orders_orderNumber, related_orderdetailses_orderNumber, related_orderdetailses_productCode);

		mav.addObject("orders_orderNumber", orders_orderNumber);
		mav.addObject("orders", orders);
		mav.setViewName("orders/viewOrders.jsp");

		return mav;
	}

	/**
	 * Save an existing Orderdetails entity
	 * 
	 */
	@RequestMapping("/saveOrdersOrderdetailses")
	public ModelAndView saveOrdersOrderdetailses(@RequestParam Integer orders_orderNumber, @ModelAttribute Orderdetails orderdetailses) {
		Orders parent_orders = ordersService.saveOrdersOrderdetailses(orders_orderNumber, orderdetailses);

		ModelAndView mav = new ModelAndView();
		mav.addObject("orders_orderNumber", orders_orderNumber);
		mav.addObject("orders", parent_orders);
		mav.setViewName("orders/viewOrders.jsp");

		return mav;
	}

	/**
	 * Create a new Orderdetails entity
	 * 
	 */
	@RequestMapping("/newOrdersOrderdetailses")
	public ModelAndView newOrdersOrderdetailses(@RequestParam Integer orders_orderNumber) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("orders_orderNumber", orders_orderNumber);
		mav.addObject("orderdetails", new Orderdetails());
		mav.addObject("newFlag", true);
		mav.setViewName("orders/orderdetailses/editOrderdetailses.jsp");

		return mav;
	}

	/**
	 * Create a new Customers entity
	 * 
	 */
	@RequestMapping("/newOrdersCustomers")
	public ModelAndView newOrdersCustomers(@RequestParam Integer orders_orderNumber) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("orders_orderNumber", orders_orderNumber);
		mav.addObject("customers", new Customers());
		mav.addObject("newFlag", true);
		mav.setViewName("orders/customers/editCustomers.jsp");

		return mav;
	}

	/**
	 * View an existing Orderdetails entity
	 * 
	 */
	@RequestMapping("/selectOrdersOrderdetailses")
	public ModelAndView selectOrdersOrderdetailses(@RequestParam Integer orders_orderNumber, @RequestParam Integer orderdetailses_orderNumber, @RequestParam String orderdetailses_productCode) {
		Orderdetails orderdetails = orderdetailsDAO.findOrderdetailsByPrimaryKey(orderdetailses_orderNumber, orderdetailses_productCode, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("orders_orderNumber", orders_orderNumber);
		mav.addObject("orderdetails", orderdetails);
		mav.setViewName("orders/orderdetailses/viewOrderdetailses.jsp");

		return mav;
	}

	/**
	 * Delete an existing Orders entity
	 * 
	 */
	@RequestMapping("/deleteOrders")
	public String deleteOrders(@RequestParam Integer orderNumberKey) {
		Orders orders = ordersDAO.findOrdersByPrimaryKey(orderNumberKey);
		ordersService.deleteOrders(orders);
		return "forward:/indexOrders";
	}
}