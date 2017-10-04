package com.bluedream.sales1.service;

import com.bluedream.sales1.dao.CustomersDAO;
import com.bluedream.sales1.dao.EmployeesDAO;
import com.bluedream.sales1.dao.OrdersDAO;
import com.bluedream.sales1.dao.PaymentsDAO;

import com.bluedream.sales1.domain.Customers;
import com.bluedream.sales1.domain.Employees;
import com.bluedream.sales1.domain.Orders;
import com.bluedream.sales1.domain.Payments;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Customers entities
 * 
 */

@Service("CustomersService")
@Transactional
public class CustomersServiceImpl implements CustomersService {

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
	 * Instantiates a new CustomersServiceImpl.
	 *
	 */
	public CustomersServiceImpl() {
	}

	/**
	 * Delete an existing Customers entity
	 * 
	 */
	@Transactional
	public void deleteCustomers(Customers customers) {
		customersDAO.remove(customers);
		customersDAO.flush();
	}

	/**
	 * Return a count of all Customers entity
	 * 
	 */
	@Transactional
	public Integer countCustomerss() {
		return ((Long) customersDAO.createQuerySingleResult("select count(o) from Customers o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing Orders entity
	 * 
	 */
	@Transactional
	public Customers saveCustomersOrderses(Integer customerNumber, Orders related_orderses) {
		Customers customers = customersDAO.findCustomersByPrimaryKey(customerNumber, -1, -1);
		Orders existingorderses = ordersDAO.findOrdersByPrimaryKey(related_orderses.getOrderNumber());

		// copy into the existing record to preserve existing relationships
		if (existingorderses != null) {
			existingorderses.setOrderNumber(related_orderses.getOrderNumber());
			existingorderses.setOrderDate(related_orderses.getOrderDate());
			existingorderses.setRequiredDate(related_orderses.getRequiredDate());
			existingorderses.setShippedDate(related_orderses.getShippedDate());
			existingorderses.setStatus(related_orderses.getStatus());
			existingorderses.setComments(related_orderses.getComments());
			related_orderses = existingorderses;
		}

		related_orderses.setCustomers(customers);
		customers.getOrderses().add(related_orderses);
		related_orderses = ordersDAO.store(related_orderses);
		ordersDAO.flush();

		customers = customersDAO.store(customers);
		customersDAO.flush();

		return customers;
	}

	/**
	 * Return all Customers entity
	 * 
	 */
	@Transactional
	public List<Customers> findAllCustomerss(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Customers>(customersDAO.findAllCustomerss(startResult, maxRows));
	}

	/**
	 * Save an existing Employees entity
	 * 
	 */
	@Transactional
	public Customers saveCustomersEmployees(Integer customerNumber, Employees related_employees) {
		Customers customers = customersDAO.findCustomersByPrimaryKey(customerNumber, -1, -1);
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

		customers.setEmployees(related_employees);
		related_employees.getCustomerses().add(customers);
		customers = customersDAO.store(customers);
		customersDAO.flush();

		related_employees = employeesDAO.store(related_employees);
		employeesDAO.flush();

		return customers;
	}

	/**
	 * Delete an existing Payments entity
	 * 
	 */
	@Transactional
	public Customers deleteCustomersPaymentses(Integer customers_customerNumber, Integer related_paymentses_customerNumber, String related_paymentses_checkNumber) {
		Payments related_paymentses = paymentsDAO.findPaymentsByPrimaryKey(related_paymentses_customerNumber, related_paymentses_checkNumber, -1, -1);

		Customers customers = customersDAO.findCustomersByPrimaryKey(customers_customerNumber, -1, -1);

		related_paymentses.setCustomers(null);
		customers.getPaymentses().remove(related_paymentses);

		paymentsDAO.remove(related_paymentses);
		paymentsDAO.flush();

		return customers;
	}

	/**
	 * Save an existing Payments entity
	 * 
	 */
	@Transactional
	public Customers saveCustomersPaymentses(Integer customerNumber, Payments related_paymentses) {
		Customers customers = customersDAO.findCustomersByPrimaryKey(customerNumber, -1, -1);
		Payments existingpaymentses = paymentsDAO.findPaymentsByPrimaryKey(related_paymentses.getCustomerNumber(), related_paymentses.getCheckNumber());

		// copy into the existing record to preserve existing relationships
		if (existingpaymentses != null) {
			existingpaymentses.setCustomerNumber(related_paymentses.getCustomerNumber());
			existingpaymentses.setCheckNumber(related_paymentses.getCheckNumber());
			existingpaymentses.setPaymentDate(related_paymentses.getPaymentDate());
			existingpaymentses.setAmount(related_paymentses.getAmount());
			related_paymentses = existingpaymentses;
		}

		related_paymentses.setCustomers(customers);
		customers.getPaymentses().add(related_paymentses);
		related_paymentses = paymentsDAO.store(related_paymentses);
		paymentsDAO.flush();

		customers = customersDAO.store(customers);
		customersDAO.flush();

		return customers;
	}

	/**
	 * Delete an existing Orders entity
	 * 
	 */
	@Transactional
	public Customers deleteCustomersOrderses(Integer customers_customerNumber, Integer related_orderses_orderNumber) {
		Orders related_orderses = ordersDAO.findOrdersByPrimaryKey(related_orderses_orderNumber, -1, -1);

		Customers customers = customersDAO.findCustomersByPrimaryKey(customers_customerNumber, -1, -1);

		related_orderses.setCustomers(null);
		customers.getOrderses().remove(related_orderses);

		ordersDAO.remove(related_orderses);
		ordersDAO.flush();

		return customers;
	}

	/**
	 */
	@Transactional
	public Customers findCustomersByPrimaryKey(Integer customerNumber) {
		return customersDAO.findCustomersByPrimaryKey(customerNumber);
	}

	/**
	 * Save an existing Customers entity
	 * 
	 */
	@Transactional
	public void saveCustomers(Customers customers) {
		Customers existingCustomers = customersDAO.findCustomersByPrimaryKey(customers.getCustomerNumber());

		if (existingCustomers != null) {
			if (existingCustomers != customers) {
				existingCustomers.setCustomerNumber(customers.getCustomerNumber());
				existingCustomers.setCustomerName(customers.getCustomerName());
				existingCustomers.setContactLastName(customers.getContactLastName());
				existingCustomers.setContactFirstName(customers.getContactFirstName());
				existingCustomers.setPhone(customers.getPhone());
				existingCustomers.setAddressLine1(customers.getAddressLine1());
				existingCustomers.setAddressLine2(customers.getAddressLine2());
				existingCustomers.setCity(customers.getCity());
				existingCustomers.setState(customers.getState());
				existingCustomers.setPostalCode(customers.getPostalCode());
				existingCustomers.setCountry(customers.getCountry());
				existingCustomers.setCreditLimit(customers.getCreditLimit());
			}
			customers = customersDAO.store(existingCustomers);
		} else {
			customers = customersDAO.store(customers);
		}
		customersDAO.flush();
	}

	/**
	 * Delete an existing Employees entity
	 * 
	 */
	@Transactional
	public Customers deleteCustomersEmployees(Integer customers_customerNumber, Integer related_employees_employeeNumber) {
		Customers customers = customersDAO.findCustomersByPrimaryKey(customers_customerNumber, -1, -1);
		Employees related_employees = employeesDAO.findEmployeesByPrimaryKey(related_employees_employeeNumber, -1, -1);

		customers.setEmployees(null);
		related_employees.getCustomerses().remove(customers);
		customers = customersDAO.store(customers);
		customersDAO.flush();

		related_employees = employeesDAO.store(related_employees);
		employeesDAO.flush();

		employeesDAO.remove(related_employees);
		employeesDAO.flush();

		return customers;
	}

	/**
	 * Load an existing Customers entity
	 * 
	 */
	@Transactional
	public Set<Customers> loadCustomerss() {
		return customersDAO.findAllCustomerss();
	}
	
	/**
	 * Fetch Orders By Customers PrimaryKey
	 * 
	 */
	@Transactional
	public Set<Orders> fetchOrderByCustPKey(Integer customers_customerNumber) {
		return ordersDAO.fetchOrderByCustPKeyJoin(customers_customerNumber, -1, -1);
	}
}
