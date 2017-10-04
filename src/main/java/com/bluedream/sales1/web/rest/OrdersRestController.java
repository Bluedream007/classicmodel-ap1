package com.bluedream.sales1.web.rest;

import com.bluedream.sales1.dao.CustomersDAO;
import com.bluedream.sales1.dao.OrderdetailsDAO;
import com.bluedream.sales1.dao.OrdersDAO;

import com.bluedream.sales1.domain.Customers;
import com.bluedream.sales1.domain.Orderdetails;
import com.bluedream.sales1.domain.Orders;

import com.bluedream.sales1.service.OrdersService;

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
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Spring Rest controller that handles CRUD requests for Orders entities
 * 
 */

@Controller("OrdersRestController")
public class OrdersRestController {

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
	 * View an existing Orderdetails entity
	 * 
	 */
	@RequestMapping(value = "/Orders/{orders_orderNumber}/orderdetailses/{orderdetails_orderNumber}/{orderdetails_productCode}", method = RequestMethod.GET)
	public Orderdetails loadOrdersOrderdetailses(@PathVariable Integer orders_orderNumber, @PathVariable Integer related_orderdetailses_orderNumber, @PathVariable String related_orderdetailses_productCode) {
		Orderdetails orderdetails = orderdetailsDAO.findOrderdetailsByPrimaryKey(related_orderdetailses_orderNumber, related_orderdetailses_productCode, -1, -1);

		return orderdetails;
	}

	/**
	 * Delete an existing Customers entity
	 * 
	 */
	@RequestMapping(value = "/Orders/{orders_orderNumber}/customers/{customers_customerNumber}", method = RequestMethod.DELETE)
	public void deleteOrdersCustomers(@PathVariable Integer orders_orderNumber, @PathVariable Integer related_customers_customerNumber) {
		ordersService.deleteOrdersCustomers(orders_orderNumber, related_customers_customerNumber);
	}

	/**
	 * Save an existing Orders entity
	 * 
	 */
	@RequestMapping(value = "/Orders", method = RequestMethod.PUT)
	public Orders saveOrders(@ModelAttribute Orders orders) {
		ordersService.saveOrders(orders);
		return ordersDAO.findOrdersByPrimaryKey(orders.getOrderNumber());
	}

	/**
	 * Get Customers entity by Orders
	 * 
	 */
	@RequestMapping(value = "/Orders/{orders_orderNumber}/customers", method = RequestMethod.GET)
	public Customers getOrdersCustomers(@PathVariable Integer orders_orderNumber) {
		return ordersDAO.findOrdersByPrimaryKey(orders_orderNumber).getCustomers();
	}

	/**
	 * Save an existing Orderdetails entity
	 * 
	 */
	@RequestMapping(value = "/Orders/{orders_orderNumber}/orderdetailses", method = RequestMethod.PUT)
	public Orderdetails saveOrdersOrderdetailses(@PathVariable Integer orders_orderNumber, @ModelAttribute Orderdetails orderdetailses) {
		ordersService.saveOrdersOrderdetailses(orders_orderNumber, orderdetailses);
		return orderdetailsDAO.findOrderdetailsByPrimaryKey(orderdetailses.getOrderNumber(), orderdetailses.getProductCode());
	}

	/**
	 * Select an existing Orders entity
	 * 
	 */
	@RequestMapping(value = "/Orders/{orders_orderNumber}", method = RequestMethod.GET)
	public Orders loadOrders(@PathVariable Integer orders_orderNumber) {
		return ordersDAO.findOrdersByPrimaryKey(orders_orderNumber);
	}
	
	@RequestMapping(value = "/OrdersJson/{orders_orderNumber}", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public Orders loadOrdersJson(@PathVariable Integer orders_orderNumber) {
		return ordersDAO.findOrdersByPrimaryKey(orders_orderNumber);
	}	

	/**
	 * Save an existing Customers entity
	 * 
	 */
	@RequestMapping(value = "/Orders/{orders_orderNumber}/customers", method = RequestMethod.PUT)
	public Customers saveOrdersCustomers(@PathVariable Integer orders_orderNumber, @ModelAttribute Customers customers) {
		ordersService.saveOrdersCustomers(orders_orderNumber, customers);
		return customersDAO.findCustomersByPrimaryKey(customers.getCustomerNumber());
	}

	/**
	 * Create a new Orderdetails entity
	 * 
	 */
	@RequestMapping(value = "/Orders/{orders_orderNumber}/orderdetailses", method = RequestMethod.POST)
	public Orderdetails newOrdersOrderdetailses(@PathVariable Integer orders_orderNumber, @ModelAttribute Orderdetails orderdetails) {
		ordersService.saveOrdersOrderdetailses(orders_orderNumber, orderdetails);
		return orderdetailsDAO.findOrderdetailsByPrimaryKey(orderdetails.getOrderNumber(), orderdetails.getProductCode());
	}

	/**
	 * View an existing Customers entity
	 * 
	 */
	@RequestMapping(value = "/Orders/{orders_orderNumber}/customers/{customers_customerNumber}", method = RequestMethod.GET)
	public Customers loadOrdersCustomers(@PathVariable Integer orders_orderNumber, @PathVariable Integer related_customers_customerNumber) {
		Customers customers = customersDAO.findCustomersByPrimaryKey(related_customers_customerNumber, -1, -1);

		return customers;
	}

	/**
	 * Create a new Orders entity
	 * 
	 */
	@RequestMapping(value = "/Orders", method = RequestMethod.POST)
	public Orders newOrders(@ModelAttribute Orders orders) {
		ordersService.saveOrders(orders);
		return ordersDAO.findOrdersByPrimaryKey(orders.getOrderNumber());
	}

	/**
	 * Show all Orderdetails entities by Orders
	 * 
	 */
	// @RequestMapping(value = "/Orders/{orders_orderNumber}/orderdetailses", method = RequestMethod.GET)
	@RequestMapping(value = "/OrdersJson/{orders_orderNumber}/orderdetailses", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Orderdetails> getOrdersOrderdetailses(@PathVariable Integer orders_orderNumber) {
		// return new java.util.ArrayList<Orderdetails>(ordersDAO.findOrdersByPrimaryKey(orders_orderNumber).getOrderdetailses());
		// Modify by Charlotte
		return new java.util.ArrayList<Orderdetails>(ordersDAO.fetchOrdetailsByPKeyJoin(orders_orderNumber, -1, -1));
	}

	/**
	 * Create a new Customers entity
	 * 
	 */
	@RequestMapping(value = "/Orders/{orders_orderNumber}/customers", method = RequestMethod.POST)
	public Customers newOrdersCustomers(@PathVariable Integer orders_orderNumber, @ModelAttribute Customers customers) {
		ordersService.saveOrdersCustomers(orders_orderNumber, customers);
		return customersDAO.findCustomersByPrimaryKey(customers.getCustomerNumber());
	}

	/**
	 * Delete an existing Orders entity
	 * 
	 */
	@RequestMapping(value = "/Orders/{orders_orderNumber}", method = RequestMethod.DELETE)
	public void deleteOrders(@PathVariable Integer orders_orderNumber) {
		Orders orders = ordersDAO.findOrdersByPrimaryKey(orders_orderNumber);
		ordersService.deleteOrders(orders);
	}

	/**
	 * Delete an existing Orderdetails entity
	 * 
	 */
	@RequestMapping(value = "/Orders/{orders_orderNumber}/orderdetailses/{orderdetails_orderNumber}/{orderdetails_productCode}", method = RequestMethod.DELETE)
	public void deleteOrdersOrderdetailses(@PathVariable Integer orders_orderNumber, @PathVariable Integer related_orderdetailses_orderNumber, @PathVariable String related_orderdetailses_productCode) {
		ordersService.deleteOrdersOrderdetailses(orders_orderNumber, related_orderdetailses_orderNumber, related_orderdetailses_productCode);
	}

	/**
	 * Show all Orders entities
	 * 
	 */
	@RequestMapping(value = "/Orders", method = RequestMethod.GET)
	@ResponseBody
	public List<Orders> listOrderss() {
		return new java.util.ArrayList<Orders>(ordersService.loadOrderss());
	}
	
	/**
	 * Show the list of Orders entities belong to Customers
	 * Note:
	 *    1.{customers_customerNumber} is too long so it cause http 400 erro.
	 *     
	 */
	
	// @RequestMapping(value = "/Orders/{customers_customerNumber}/orderses", method = RequestMethod.GET)
	@RequestMapping(value = "/OrdersJson/{customerNumber}/orderslist", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Orders> listOrdersByCustomer(@PathVariable Integer customerNumber) {		
		// Modify by Charlotte		
		return new java.util.ArrayList<Orders>(ordersService.fetchOrderByCustPKey(customerNumber));		
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