package com.bluedream.sales1.dao;

import com.bluedream.sales1.domain.Orderdetails;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Orderdetails entities.
 * 
 */
public interface OrderdetailsDAO extends JpaDao<Orderdetails> {

	/**
	 * JPQL Query - findAllOrderdetailss
	 *
	 */
	public Set<Orderdetails> findAllOrderdetailss() throws DataAccessException;

	/**
	 * JPQL Query - findAllOrderdetailss
	 *
	 */
	public Set<Orderdetails> findAllOrderdetailss(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findOrderdetailsByPrimaryKey
	 *
	 */
	public Orderdetails findOrderdetailsByPrimaryKey(Integer orderNumber, String productCode) throws DataAccessException;

	/**
	 * JPQL Query - findOrderdetailsByPrimaryKey
	 *
	 */
	public Orderdetails findOrderdetailsByPrimaryKey(Integer orderNumber, String productCode, int startResult, int maxRows) throws DataAccessException;

}