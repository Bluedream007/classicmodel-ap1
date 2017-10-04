package com.bluedream.sales1.web.rest;

import com.bluedream.sales1.dao.CustomersDAO;
import com.bluedream.sales1.dao.EmployeesDAO;
import com.bluedream.sales1.dao.OrdersDAO;
import com.bluedream.sales1.dao.PaymentsDAO;
import com.bluedream.sales1.domain.Customers;
import com.bluedream.sales1.domain.Employees;
import com.bluedream.sales1.domain.Orders;
import com.bluedream.sales1.domain.Payments;
import com.bluedream.sales1.service.CustomersService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
 * Spring Rest controller that handles CRUD requests for Customers entities
 * 
 */

@Controller("CustomersRestController")
public class CustomersRestController {

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
	 * Delete an existing Orders entity
	 * 
	 */
	@RequestMapping(value = "/Customers/{customers_customerNumber}/orderses/{orders_orderNumber}", method = RequestMethod.DELETE)
	public void deleteCustomersOrderses(@PathVariable Integer customers_customerNumber, @PathVariable Integer related_orderses_orderNumber) {
		customersService.deleteCustomersOrderses(customers_customerNumber, related_orderses_orderNumber);
	}

	/**
	 * Save an existing Orders entity
	 * 
	 */
	@RequestMapping(value = "/Customers/{customers_customerNumber}/orderses", method = RequestMethod.PUT)
	public Orders saveCustomersOrderses(@PathVariable Integer customers_customerNumber, @ModelAttribute Orders orderses) {
		customersService.saveCustomersOrderses(customers_customerNumber, orderses);
		return ordersDAO.findOrdersByPrimaryKey(orderses.getOrderNumber());
	}

	/**
	 * View an existing Employees entity
	 * 
	 */
	@RequestMapping(value = "/Customers/{customers_customerNumber}/employees/{employees_employeeNumber}", method = RequestMethod.GET)
	public Employees loadCustomersEmployees(@PathVariable Integer customers_customerNumber, @PathVariable Integer related_employees_employeeNumber) {
		Employees employees = employeesDAO.findEmployeesByPrimaryKey(related_employees_employeeNumber, -1, -1);

		return employees;
	}

	/**
	 * View an existing Payments entity
	 * 
	 */
	@RequestMapping(value = "/Customers/{customers_customerNumber}/paymentses/{payments_customerNumber}/{payments_checkNumber}", method = RequestMethod.GET)
	public Payments loadCustomersPaymentses(@PathVariable Integer customers_customerNumber, @PathVariable Integer related_paymentses_customerNumber, @PathVariable String related_paymentses_checkNumber) {
		Payments payments = paymentsDAO.findPaymentsByPrimaryKey(related_paymentses_customerNumber, related_paymentses_checkNumber, -1, -1);

		return payments;
	}

	/**
	 * Create a new Orders entity
	 * 
	 */
	@RequestMapping(value = "/Customers/{customers_customerNumber}/orderses", method = RequestMethod.POST)
	public Orders newCustomersOrderses(@PathVariable Integer customers_customerNumber, @ModelAttribute Orders orders) {
		customersService.saveCustomersOrderses(customers_customerNumber, orders);
		return ordersDAO.findOrdersByPrimaryKey(orders.getOrderNumber());
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
	 * Create a new Customers entity
	 * 
	 */
	@RequestMapping(value = "/Customers", method = RequestMethod.POST)
	public Customers newCustomers(@ModelAttribute Customers customers) {
		customersService.saveCustomers(customers);
		return customersDAO.findCustomersByPrimaryKey(customers.getCustomerNumber());
	}

	/**
	 * Delete an existing Employees entity
	 * 
	 */
	@RequestMapping(value = "/Customers/{customers_customerNumber}/employees/{employees_employeeNumber}", method = RequestMethod.DELETE)
	public void deleteCustomersEmployees(@PathVariable Integer customers_customerNumber, @PathVariable Integer related_employees_employeeNumber) {
		customersService.deleteCustomersEmployees(customers_customerNumber, related_employees_employeeNumber);
	}

	/**
	 * Delete an existing Payments entity
	 * 
	 */
	@RequestMapping(value = "/Customers/{customers_customerNumber}/paymentses/{payments_customerNumber}/{payments_checkNumber}", method = RequestMethod.DELETE)
	public void deleteCustomersPaymentses(@PathVariable Integer customers_customerNumber, @PathVariable Integer related_paymentses_customerNumber, @PathVariable String related_paymentses_checkNumber) {
		customersService.deleteCustomersPaymentses(customers_customerNumber, related_paymentses_customerNumber, related_paymentses_checkNumber);
	}

	/**
	 * View an existing Orders entity
	 * 
	 */
	@RequestMapping(value = "/Customers/{customers_customerNumber}/orderses/{orders_orderNumber}", method = RequestMethod.GET)
	public Orders loadCustomersOrderses(@PathVariable Integer customers_customerNumber, @PathVariable Integer related_orderses_orderNumber) {
		Orders orders = ordersDAO.findOrdersByPrimaryKey(related_orderses_orderNumber, -1, -1);

		return orders;
	}

	/**
	 * Show all Customers entities
	 * 
	 */
	@RequestMapping(value = "/Customers", method = RequestMethod.GET)
	@ResponseBody
	public List<Customers> listCustomerss() {
		return new java.util.ArrayList<Customers>(customersService.loadCustomerss());
	}
	
	/**
	 * Show all Customers entities
	 * 
	 */
	@RequestMapping(value = "/CustomersJson", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Customers> listCustomerssJson() {
		return new java.util.ArrayList<Customers>(customersService.loadCustomerss());
	}

	/**
	 * Show all Orders entities by Customers
	 * 
	 */
	@RequestMapping(value = "/Customers/{customers_customerNumber}/orderses", method = RequestMethod.GET)
	@ResponseBody
	public List<Orders> getCustomersOrderses(@PathVariable Integer customers_customerNumber) {
		// return new java.util.ArrayList<Orders>(customersDAO.findCustomersByPrimaryKey(customers_customerNumber).getOrderses());
		// Modify by Charlotte
		return new java.util.ArrayList<Orders>(customersService.fetchOrderByCustPKey(customers_customerNumber));
	}
	
	/**
	 * Show all Orders entities by Customers
	 * 
	 */
	@RequestMapping(value = "/CustomersJson/{customers_customerNumber}/orderses", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Orders> getCustomersOrdersesJson(@PathVariable Integer customers_customerNumber) {
		// return new java.util.ArrayList<Orders>(customersDAO.findCustomersByPrimaryKey(customers_customerNumber).getOrderses());
		// Modify by Charlotte
		return new java.util.ArrayList<Orders>(customersService.fetchOrderByCustPKey(customers_customerNumber));
	}

	/**
	 * Create a new Employees entity
	 * 
	 */
	@RequestMapping(value = "/Customers/{customers_customerNumber}/employees", method = RequestMethod.POST)
	public Employees newCustomersEmployees(@PathVariable Integer customers_customerNumber, @ModelAttribute Employees employees) {
		customersService.saveCustomersEmployees(customers_customerNumber, employees);
		return employeesDAO.findEmployeesByPrimaryKey(employees.getEmployeeNumber());
	}

	/**
	 * Create a new Payments entity
	 * 
	 */
	@RequestMapping(value = "/Customers/{customers_customerNumber}/paymentses", method = RequestMethod.POST)
	public Payments newCustomersPaymentses(@PathVariable Integer customers_customerNumber, @ModelAttribute Payments payments) {
		customersService.saveCustomersPaymentses(customers_customerNumber, payments);
		return paymentsDAO.findPaymentsByPrimaryKey(payments.getCustomerNumber(), payments.getCheckNumber());
	}

	/**
	 * Get Employees entity by Customers
	 * 
	 */
	@RequestMapping(value = "/Customers/{customers_customerNumber}/employees", method = RequestMethod.GET)
	@ResponseBody
	public Employees getCustomersEmployees(@PathVariable Integer customers_customerNumber) {
		return customersDAO.findCustomersByPrimaryKey(customers_customerNumber).getEmployees();
	}
	
	/**
	 * Get Employees entity by Customers
	 * 
	 */
	@RequestMapping(value = "/CustomersJson/{customers_customerNumber}/employees", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public Employees getCustomersEmployeesJson(@PathVariable Integer customers_customerNumber) {
		return customersDAO.findCustomersByPrimaryKey(customers_customerNumber).getEmployees();
	}

	/**
	 * Select an existing Customers entity - ok(JSon)
	 * 
	 */
	// @RequestMapping(value = "/Customers/{customers_customerNumber}", method = RequestMethod.GET) // XML format
	@RequestMapping(value = "/CustomersJson/{customers_customerNumber}", method = RequestMethod.GET, produces="application/json") // JSon format
	@ResponseBody
	public Customers loadCustomersJson(@PathVariable Integer customers_customerNumber) {
	// public String loadCustomers(@PathVariable Integer customers_customerNumber) {	
		Customers oCustomers = null;
		String strJsonData = "";		
		// return customersDAO.findCustomersByPrimaryKey(customers_customerNumber);		
		try {
			oCustomers = customersDAO.findCustomersByPrimaryKey(customers_customerNumber);
			
			// TODO - Change print out to Log data. 
			strJsonData = new ObjectMapper().writeValueAsString(oCustomers);
			System.out.println("Customers json: " + strJsonData);
		} catch (JsonProcessingException JsonE) {
			System.out.println("Error: " + JsonE.getMessage());
			
		}		
		
		return oCustomers;
		// return strJsonData;		
	}
	
	// @RequestMapping(value = "/Customers/{customers_customerNumber}", method = RequestMethod.GET) // XML format
	@RequestMapping(value = "/CustomersXml/{customers_customerNumber}", method = RequestMethod.GET, produces="application/xml") // XML format
	@ResponseBody
	public Customers loadCustomersXml(@PathVariable Integer customers_customerNumber) {
	// public String loadCustomers(@PathVariable Integer customers_customerNumber) {	
		Customers oCustomers = null;
		String strJsonData = "";		
		// return customersDAO.findCustomersByPrimaryKey(customers_customerNumber);		
		try {
			oCustomers = customersDAO.findCustomersByPrimaryKey(customers_customerNumber);
			
			strJsonData = new ObjectMapper().writeValueAsString(oCustomers);
			System.out.println("Customers json: " + strJsonData);
		} catch (JsonProcessingException JsonE) {
			System.out.println("Error: " + JsonE.getMessage());
			
		}		
		
		return oCustomers;
		// return strJsonData;		
	}
	
	/**
	 * Select an existing Customers entity
	 * 1. Generate a Customers by JSon format of List. (test ok) 
	 * 
	 * TODO - 增加 exception handle
	 * a.當 oCustomers2 查詢結果為 null時, oCustomers.copy(oCustomers2); 會有錯誤
	 */
	@RequestMapping(value = "/CustomersListJson/{customers_customerNumber}", method = RequestMethod.GET, produces="application/json")	
	@ResponseBody
	public List<Customers> loadCustomersListJson(@PathVariable String customers_customerNumber) {
		Integer intcustomerNumber = new Integer(customers_customerNumber);
		List<Customers> oCustList = new java.util.ArrayList<Customers>();
		// return customersDAO.findCustomersByPrimaryKey(intcustomerNumber);
		// Customers oCustomers = new Customers();
		Customers oCustomers2 = new Customers();
		oCustomers2 = customersService.findCustomersByPrimaryKey(intcustomerNumber);
		// oCustomers.copy(customersService.findCustomersByPrimaryKey(intcustomerNumber));
		//oCustomers.copy(oCustomers2);
		
		//String strRet = oCustomers.toString() + " Employees: " + oCustomers.getEmployees(); 
		// return strRet;
		// 使用 Customers 傳回的值為 XML 格式, 且需有@XmlElement定義
		//return oCustomers;
		
		// 使用 List 傳回的值為 json 格式
		oCustList.add(oCustomers2);
		/* Json formate - Example Data: 
		 * [{"customerNumber":103,"customerName":"Atelier graphique","contactLastName":"Schmitt","contactFirstName":"Carine ","phone":"40.32.2555","addressLine1":"54, rue Royale","addressLine2":null,"city":"Nantes","state":null,"postalCode":"44000","country":"France","creditLimit":21000,"employees":{"employeeNumber":1370,"lastName":"Hernandez","firstName":"Gerard","extension":"x2028","email":"ghernande@classicmodelcars.com","jobTitle":"Sales Rep","offices":{"officeCode":"4","city":"Paris","phone":"+33 14 723 4404","addressLine1":"43 Rue Jouffroy D'abbans","addressLine2":null,"state":null,"country":"France","postalCode":"75017","territory":"EMEA"}}}]
		 */
		
		return oCustList;
	}
	
	@RequestMapping(value = "/CustomersListXml/{customers_customerNumber}", method = RequestMethod.GET, produces="application/xml")	
	@ResponseBody
	public List<Customers> loadCustomersListXml(@PathVariable String customers_customerNumber) {
		Integer intcustomerNumber = new Integer(customers_customerNumber);
		List<Customers> oCustList = new java.util.ArrayList<Customers>();
		// return customersDAO.findCustomersByPrimaryKey(intcustomerNumber);
		// Customers oCustomers = new Customers();
		Customers oCustomers2 = new Customers();
		oCustomers2 = customersService.findCustomersByPrimaryKey(intcustomerNumber);		
		
		// 使用 List 傳回的值為 json 格式
		oCustList.add(oCustomers2);
		/* Json formate - Example Data: 
		 * [{"customerNumber":103,"customerName":"Atelier graphique","contactLastName":"Schmitt","contactFirstName":"Carine ","phone":"40.32.2555","addressLine1":"54, rue Royale","addressLine2":null,"city":"Nantes","state":null,"postalCode":"44000","country":"France","creditLimit":21000,"employees":{"employeeNumber":1370,"lastName":"Hernandez","firstName":"Gerard","extension":"x2028","email":"ghernande@classicmodelcars.com","jobTitle":"Sales Rep","offices":{"officeCode":"4","city":"Paris","phone":"+33 14 723 4404","addressLine1":"43 Rue Jouffroy D'abbans","addressLine2":null,"state":null,"country":"France","postalCode":"75017","territory":"EMEA"}}}]
		 */
		
		return oCustList;
	}

	/**
	 * Delete an existing Customers entity
	 * 
	 */
	@RequestMapping(value = "/Customers/{customers_customerNumber}", method = RequestMethod.DELETE)
	public void deleteCustomers(@PathVariable Integer customers_customerNumber) {
		Customers customers = customersDAO.findCustomersByPrimaryKey(customers_customerNumber);
		customersService.deleteCustomers(customers);
	}

	/**
	 * Save an existing Payments entity
	 * 
	 */
	@RequestMapping(value = "/Customers/{customers_customerNumber}/paymentses", method = RequestMethod.PUT)
	public Payments saveCustomersPaymentses(@PathVariable Integer customers_customerNumber, @ModelAttribute Payments paymentses) {
		customersService.saveCustomersPaymentses(customers_customerNumber, paymentses);
		return paymentsDAO.findPaymentsByPrimaryKey(paymentses.getCustomerNumber(), paymentses.getCheckNumber());
	}

	/**
	 * Save an existing Employees entity
	 * 
	 */
	@RequestMapping(value = "/Customers/{customers_customerNumber}/employees", method = RequestMethod.PUT)
	public Employees saveCustomersEmployees(@PathVariable Integer customers_customerNumber, @ModelAttribute Employees employees) {
		customersService.saveCustomersEmployees(customers_customerNumber, employees);
		return employeesDAO.findEmployeesByPrimaryKey(employees.getEmployeeNumber());
	}

	/**
	 * Save an existing Customers entity
	 * 
	 */
	@RequestMapping(value = "/Customers", method = RequestMethod.PUT)
	public Customers saveCustomers(@ModelAttribute Customers customers) {
		customersService.saveCustomers(customers);
		return customersDAO.findCustomersByPrimaryKey(customers.getCustomerNumber());
	}

	/**
	 * Show all Payments entities by Customers
	 * 
	 */
	@RequestMapping(value = "/Customers/{customers_customerNumber}/paymentses", method = RequestMethod.GET)
	public List<Payments> getCustomersPaymentses(@PathVariable Integer customers_customerNumber) {
		return new java.util.ArrayList<Payments>(customersDAO.findCustomersByPrimaryKey(customers_customerNumber).getPaymentses());
	}
}