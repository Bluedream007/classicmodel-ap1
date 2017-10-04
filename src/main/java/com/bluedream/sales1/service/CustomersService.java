package com.bluedream.sales1.service;

import com.bluedream.sales1.domain.Customers;
import com.bluedream.sales1.domain.Employees;
import com.bluedream.sales1.domain.Orders;
import com.bluedream.sales1.domain.Payments;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Customers entities
 * 
 */
public interface CustomersService {

	/**
	 * Delete an existing Customers entity
	 * 
	 */
	public void deleteCustomers(Customers customers);

	/**
	 * Return a count of all Customers entity
	 * 
	 */
	public Integer countCustomerss();

	/**
	 * Save an existing Orders entity
	 * 
	 */
	public Customers saveCustomersOrderses(Integer customerNumber, Orders related_orderses);

	/**
	 * Return all Customers entity
	 * 
	 */
	public List<Customers> findAllCustomerss(Integer startResult, Integer maxRows);

	/**
	 * Save an existing Employees entity
	 * 
	 */
	public Customers saveCustomersEmployees(Integer customerNumber_1, Employees related_employees);

	/**
	 * Delete an existing Payments entity
	 * 
	 */
	public Customers deleteCustomersPaymentses(Integer customers_customerNumber, Integer related_paymentses_customerNumber, String related_paymentses_checkNumber);

	/**
	 * Save an existing Payments entity
	 * 
	 */
	public Customers saveCustomersPaymentses(Integer customerNumber_2, Payments related_paymentses);

	/**
	 * Delete an existing Orders entity
	 * 
	 */
	public Customers deleteCustomersOrderses(Integer customers_customerNumber_1, Integer related_orderses_orderNumber);

	/**
	 */
	public Customers findCustomersByPrimaryKey(Integer customerNumber_3);

	/**
	 * Save an existing Customers entity
	 * 
	 */
	public void saveCustomers(Customers customers_1);

	/**
	 * Delete an existing Employees entity
	 * 
	 */
	public Customers deleteCustomersEmployees(Integer customers_customerNumber_2, Integer related_employees_employeeNumber);

	/**
	 * Load an existing Customers entity
	 * 
	 */
	public Set<Customers> loadCustomerss();
	
	/**
	 * Fetch Orders By Customers PrimaryKey
	 * 
	 */
	public Set<Orders> fetchOrderByCustPKey(Integer customers_customerNumber);
}