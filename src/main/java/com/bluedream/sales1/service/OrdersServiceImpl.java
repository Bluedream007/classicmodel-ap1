package com.bluedream.sales1.service;

import com.bluedream.sales1.dao.CustomersDAO;
import com.bluedream.sales1.dao.OrderdetailsDAO;
import com.bluedream.sales1.dao.OrdersDAO;

import com.bluedream.sales1.domain.Customers;
import com.bluedream.sales1.domain.Orderdetails;
import com.bluedream.sales1.domain.Orders;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Orders entities
 * 
 */

@Service("OrdersService")
@Transactional
public class OrdersServiceImpl implements OrdersService {

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
	 * Instantiates a new OrdersServiceImpl.
	 *
	 */
	public OrdersServiceImpl() {
	}

	/**
	 * Return all Orders entity
	 * 
	 */
	@Transactional
	public List<Orders> findAllOrderss(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Orders>(ordersDAO.findAllOrderss(startResult, maxRows));
	}

	/**
	 * Save an existing Orders entity
	 * 
	 */
	@Transactional
	public void saveOrders(Orders orders) {
		Orders existingOrders = ordersDAO.findOrdersByPrimaryKey(orders.getOrderNumber());

		if (existingOrders != null) {
			if (existingOrders != orders) {
				existingOrders.setOrderNumber(orders.getOrderNumber());
				existingOrders.setOrderDate(orders.getOrderDate());
				existingOrders.setRequiredDate(orders.getRequiredDate());
				existingOrders.setShippedDate(orders.getShippedDate());
				existingOrders.setStatus(orders.getStatus());
				existingOrders.setComments(orders.getComments());
			}
			orders = ordersDAO.store(existingOrders);
		} else {
			orders = ordersDAO.store(orders);
		}
		ordersDAO.flush();
	}

	/**
	 * Return a count of all Orders entity
	 * 
	 */
	@Transactional
	public Integer countOrderss() {
		return ((Long) ordersDAO.createQuerySingleResult("select count(o) from Orders o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing Orderdetails entity
	 * 
	 */
	@Transactional
	public Orders saveOrdersOrderdetailses(Integer orderNumber, Orderdetails related_orderdetailses) {
		Orders orders = ordersDAO.findOrdersByPrimaryKey(orderNumber, -1, -1);
		Orderdetails existingorderdetailses = orderdetailsDAO.findOrderdetailsByPrimaryKey(related_orderdetailses.getOrderNumber(), related_orderdetailses.getProductCode());

		// copy into the existing record to preserve existing relationships
		if (existingorderdetailses != null) {
			existingorderdetailses.setOrderNumber(related_orderdetailses.getOrderNumber());
			existingorderdetailses.setProductCode(related_orderdetailses.getProductCode());
			existingorderdetailses.setQuantityOrdered(related_orderdetailses.getQuantityOrdered());
			existingorderdetailses.setPriceEach(related_orderdetailses.getPriceEach());
			existingorderdetailses.setOrderLineNumber(related_orderdetailses.getOrderLineNumber());
			related_orderdetailses = existingorderdetailses;
		}

		related_orderdetailses.setOrders(orders);
		orders.getOrderdetailses().add(related_orderdetailses);
		related_orderdetailses = orderdetailsDAO.store(related_orderdetailses);
		orderdetailsDAO.flush();

		orders = ordersDAO.store(orders);
		ordersDAO.flush();

		return orders;
	}

	/**
	 * Load an existing Orders entity
	 * 
	 */
	@Transactional
	public Set<Orders> loadOrderss() {
		return ordersDAO.findAllOrderss();
	}

	/**
	 * Delete an existing Orders entity
	 * 
	 */
	@Transactional
	public void deleteOrders(Orders orders) {
		ordersDAO.remove(orders);
		ordersDAO.flush();
	}

	/**
	 */
	@Transactional
	public Orders findOrdersByPrimaryKey(Integer orderNumber) {
		return ordersDAO.findOrdersByPrimaryKey(orderNumber);
	}

	/**
	 * Save an existing Customers entity
	 * 
	 */
	@Transactional
	public Orders saveOrdersCustomers(Integer orderNumber, Customers related_customers) {
		Orders orders = ordersDAO.findOrdersByPrimaryKey(orderNumber, -1, -1);
		Customers existingcustomers = customersDAO.findCustomersByPrimaryKey(related_customers.getCustomerNumber());

		// copy into the existing record to preserve existing relationships
		if (existingcustomers != null) {
			existingcustomers.setCustomerNumber(related_customers.getCustomerNumber());
			existingcustomers.setCustomerName(related_customers.getCustomerName());
			existingcustomers.setContactLastName(related_customers.getContactLastName());
			existingcustomers.setContactFirstName(related_customers.getContactFirstName());
			existingcustomers.setPhone(related_customers.getPhone());
			existingcustomers.setAddressLine1(related_customers.getAddressLine1());
			existingcustomers.setAddressLine2(related_customers.getAddressLine2());
			existingcustomers.setCity(related_customers.getCity());
			existingcustomers.setState(related_customers.getState());
			existingcustomers.setPostalCode(related_customers.getPostalCode());
			existingcustomers.setCountry(related_customers.getCountry());
			existingcustomers.setCreditLimit(related_customers.getCreditLimit());
			related_customers = existingcustomers;
		}

		orders.setCustomers(related_customers);
		related_customers.getOrderses().add(orders);
		orders = ordersDAO.store(orders);
		ordersDAO.flush();

		related_customers = customersDAO.store(related_customers);
		customersDAO.flush();

		return orders;
	}

	/**
	 * Delete an existing Orderdetails entity
	 * 
	 */
	@Transactional
	public Orders deleteOrdersOrderdetailses(Integer orders_orderNumber, Integer related_orderdetailses_orderNumber, String related_orderdetailses_productCode) {
		Orderdetails related_orderdetailses = orderdetailsDAO.findOrderdetailsByPrimaryKey(related_orderdetailses_orderNumber, related_orderdetailses_productCode, -1, -1);

		Orders orders = ordersDAO.findOrdersByPrimaryKey(orders_orderNumber, -1, -1);

		related_orderdetailses.setOrders(null);
		orders.getOrderdetailses().remove(related_orderdetailses);

		orderdetailsDAO.remove(related_orderdetailses);
		orderdetailsDAO.flush();

		return orders;
	}

	/**
	 * Delete an existing Customers entity
	 * 
	 */
	@Transactional
	public Orders deleteOrdersCustomers(Integer orders_orderNumber, Integer related_customers_customerNumber) {
		Orders orders = ordersDAO.findOrdersByPrimaryKey(orders_orderNumber, -1, -1);
		Customers related_customers = customersDAO.findCustomersByPrimaryKey(related_customers_customerNumber, -1, -1);

		orders.setCustomers(null);
		related_customers.getOrderses().remove(orders);
		orders = ordersDAO.store(orders);
		ordersDAO.flush();

		related_customers = customersDAO.store(related_customers);
		customersDAO.flush();

		customersDAO.remove(related_customers);
		customersDAO.flush();

		return orders;
	}
	
	// * MyFunxtion ================================================================================= *
	/**
	 * Fetch the list of Order belong to Customer 
	 */
	@Transactional
	public Set<Orders> fetchOrderByCustPKey(Integer customerNumber) {
		return ordersDAO.fetchOrderByCustPKeyJoin(customerNumber, -1, -1);
	}
	
	// * MyFunxtion End ================================================================================= *
}
