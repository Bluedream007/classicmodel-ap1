package com.bluedream.sales1.dao;

import com.bluedream.sales1.domain.Payments;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Payments entities.
 * 
 */
public interface PaymentsDAO extends JpaDao<Payments> {

	/**
	 * JPQL Query - findPaymentsByPrimaryKey
	 *
	 */
	public Payments findPaymentsByPrimaryKey(Integer customerNumber, String checkNumber) throws DataAccessException;

	/**
	 * JPQL Query - findPaymentsByPrimaryKey
	 *
	 */
	public Payments findPaymentsByPrimaryKey(Integer customerNumber, String checkNumber, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllPaymentss
	 *
	 */
	public Set<Payments> findAllPaymentss() throws DataAccessException;

	/**
	 * JPQL Query - findAllPaymentss
	 *
	 */
	public Set<Payments> findAllPaymentss(int startResult, int maxRows) throws DataAccessException;

}