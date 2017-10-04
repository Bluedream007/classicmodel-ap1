package com.bluedream.sales1.dao;

import com.bluedream.sales1.domain.Orderdetails;
import com.bluedream.sales1.domain.Orders;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

/**
 * DAO to manage Orders entities.
 * 
 */
public interface OrdersDAO extends JpaDao<Orders> {

	/**
	 * JPQL Query - findOrdersByShippedDate
	 *
	 */
	public Set<Orders> findOrdersByShippedDate(java.util.Calendar shippedDate) throws DataAccessException;

	/**
	 * JPQL Query - findOrdersByShippedDate
	 *
	 */
	public Set<Orders> findOrdersByShippedDate(Calendar shippedDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOrdersByStatusContaining
	 *
	 */
	public Set<Orders> findOrdersByStatusContaining(String status) throws DataAccessException;

	/**
	 * JPQL Query - findOrdersByStatusContaining
	 *
	 */
	public Set<Orders> findOrdersByStatusContaining(String status, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOrdersByPrimaryKey
	 *
	 */
	public Orders findOrdersByPrimaryKey(Integer orderNumber) throws DataAccessException;

	/**
	 * JPQL Query - findOrdersByPrimaryKey
	 *
	 */
	public Orders findOrdersByPrimaryKey(Integer orderNumber, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOrdersByOrderDateAfter
	 *
	 */
	public Set<Orders> findOrdersByOrderDateAfter(java.util.Calendar orderDate) throws DataAccessException;

	/**
	 * JPQL Query - findOrdersByOrderDateAfter
	 *
	 */
	public Set<Orders> findOrdersByOrderDateAfter(Calendar orderDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOrdersByShippedDateBefore
	 *
	 */
	public Set<Orders> findOrdersByShippedDateBefore(java.util.Calendar shippedDate_1) throws DataAccessException;

	/**
	 * JPQL Query - findOrdersByShippedDateBefore
	 *
	 */
	public Set<Orders> findOrdersByShippedDateBefore(Calendar shippedDate_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOrdersByComments
	 *
	 */
	public Set<Orders> findOrdersByComments(String comments) throws DataAccessException;

	/**
	 * JPQL Query - findOrdersByComments
	 *
	 */
	public Set<Orders> findOrdersByComments(String comments, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOrdersByShippedDateAfter
	 *
	 */
	public Set<Orders> findOrdersByShippedDateAfter(java.util.Calendar shippedDate_2) throws DataAccessException;

	/**
	 * JPQL Query - findOrdersByShippedDateAfter
	 *
	 */
	public Set<Orders> findOrdersByShippedDateAfter(Calendar shippedDate_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllOrderss
	 *
	 */
	public Set<Orders> findAllOrderss() throws DataAccessException;

	/**
	 * JPQL Query - findAllOrderss
	 *
	 */
	public Set<Orders> findAllOrderss(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOrdersByStatus
	 *
	 */
	public Set<Orders> findOrdersByStatus(String status_1) throws DataAccessException;

	/**
	 * JPQL Query - findOrdersByStatus
	 *
	 */
	public Set<Orders> findOrdersByStatus(String status_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOrdersByOrderDateBefore
	 *
	 */
	public Set<Orders> findOrdersByOrderDateBefore(java.util.Calendar orderDate_1) throws DataAccessException;

	/**
	 * JPQL Query - findOrdersByOrderDateBefore
	 *
	 */
	public Set<Orders> findOrdersByOrderDateBefore(Calendar orderDate_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOrdersByRequiredDate
	 *
	 */
	public Set<Orders> findOrdersByRequiredDate(java.util.Calendar requiredDate) throws DataAccessException;

	/**
	 * JPQL Query - findOrdersByRequiredDate
	 *
	 */
	public Set<Orders> findOrdersByRequiredDate(Calendar requiredDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOrdersByOrderNumber
	 *
	 */
	public Orders findOrdersByOrderNumber(Integer orderNumber_1) throws DataAccessException;

	/**
	 * JPQL Query - findOrdersByOrderNumber
	 *
	 */
	public Orders findOrdersByOrderNumber(Integer orderNumber_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOrdersByOrderDate
	 *
	 */
	public Set<Orders> findOrdersByOrderDate(java.util.Calendar orderDate_2) throws DataAccessException;

	/**
	 * JPQL Query - findOrdersByOrderDate
	 *
	 */
	public Set<Orders> findOrdersByOrderDate(Calendar orderDate_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOrdersByRequiredDateAfter
	 *
	 */
	public Set<Orders> findOrdersByRequiredDateAfter(java.util.Calendar requiredDate_1) throws DataAccessException;

	/**
	 * JPQL Query - findOrdersByRequiredDateAfter
	 *
	 */
	public Set<Orders> findOrdersByRequiredDateAfter(Calendar requiredDate_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOrdersByRequiredDateBefore
	 *
	 */
	public Set<Orders> findOrdersByRequiredDateBefore(java.util.Calendar requiredDate_2) throws DataAccessException;

	/**
	 * JPQL Query - findOrdersByRequiredDateBefore
	 *
	 */
	public Set<Orders> findOrdersByRequiredDateBefore(Calendar requiredDate_2, int startResult, int maxRows) throws DataAccessException;
	
	/**
	 * JPQL Query - fetch OrdersDetails By Orders PrimaryKey
	 *
	 */	
	public Set<Orderdetails> fetchOrdetailsByPKeyJoin(Integer orderNumber, int startResult, int maxRows) throws DataAccessException;
	
	/**
	 * JPQL Query - fetch Orders By Customers PrimaryKey
	 *
	 */
	public Set<Orders> fetchOrderByCustPKeyJoin(Integer customerNumber, int startResult, int maxRows) throws DataAccessException;
	
	

}