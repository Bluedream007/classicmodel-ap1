package com.bluedream.sales1.service;

import com.bluedream.sales1.domain.Customers;
import com.bluedream.sales1.domain.Orderdetails;
import com.bluedream.sales1.domain.Orders;

import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Orders entities
 * 
 */
public interface OrdersService {

	/**
	 * Return all Orders entity
	 * 
	 */
	public List<Orders> findAllOrderss(Integer startResult, Integer maxRows);

	/**
	 * Save an existing Orders entity
	 * 
	 */
	public void saveOrders(Orders orders);

	/**
	 * Return a count of all Orders entity
	 * 
	 */
	public Integer countOrderss();

	/**
	 * Save an existing Orderdetails entity
	 * 
	 */
	public Orders saveOrdersOrderdetailses(Integer orderNumber, Orderdetails related_orderdetailses);

	/**
	 * Load an existing Orders entity
	 * 
	 */
	public Set<Orders> loadOrderss();

	/**
	 * Delete an existing Orders entity
	 * 
	 */
	public void deleteOrders(Orders orders_1);

	/**
	 */
	public Orders findOrdersByPrimaryKey(Integer orderNumber_1);

	/**
	 * Save an existing Customers entity
	 * 
	 */
	public Orders saveOrdersCustomers(Integer orderNumber_2, Customers related_customers);

	/**
	 * Delete an existing Orderdetails entity
	 * 
	 */
	public Orders deleteOrdersOrderdetailses(Integer orders_orderNumber, Integer related_orderdetailses_orderNumber, String related_orderdetailses_productCode);

	/**
	 * Delete an existing Customers entity
	 * 
	 */
	public Orders deleteOrdersCustomers(Integer orders_orderNumber_1, Integer related_customers_customerNumber);
	
	/**
	 * Fetch the list of Order belong to Customer 
	 */	
	public Set<Orders> fetchOrderByCustPKey(Integer customerNumber);
}