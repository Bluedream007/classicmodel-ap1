package com.bluedream.sales1.dao;

import com.bluedream.sales1.domain.Products;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Products entities.
 * 
 */
public interface ProductsDAO extends JpaDao<Products> {

	/**
	 * JPQL Query - findProductsByPrimaryKey
	 *
	 */
	public Products findProductsByPrimaryKey(String productCode) throws DataAccessException;

	/**
	 * JPQL Query - findProductsByPrimaryKey
	 *
	 */
	public Products findProductsByPrimaryKey(String productCode, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllProductss
	 *
	 */
	public Set<Products> findAllProductss() throws DataAccessException;

	/**
	 * JPQL Query - findAllProductss
	 *
	 */
	public Set<Products> findAllProductss(int startResult, int maxRows) throws DataAccessException;

}