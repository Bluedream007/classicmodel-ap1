package com.bluedream.sales1.dao;

import com.bluedream.sales1.domain.Productlines;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Productlines entities.
 * 
 */
public interface ProductlinesDAO extends JpaDao<Productlines> {

	/**
	 * JPQL Query - findProductlinesByProductLineContaining
	 *
	 */
	public Set<Productlines> findProductlinesByProductLineContaining(String productLine) throws DataAccessException;

	/**
	 * JPQL Query - findProductlinesByProductLineContaining
	 *
	 */
	public Set<Productlines> findProductlinesByProductLineContaining(String productLine, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllProductliness
	 *
	 */
	public Set<Productlines> findAllProductliness() throws DataAccessException;

	/**
	 * JPQL Query - findAllProductliness
	 *
	 */
	public Set<Productlines> findAllProductliness(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProductlinesByHtmlDescription
	 *
	 */
	public Set<Productlines> findProductlinesByHtmlDescription(String htmlDescription) throws DataAccessException;

	/**
	 * JPQL Query - findProductlinesByHtmlDescription
	 *
	 */
	public Set<Productlines> findProductlinesByHtmlDescription(String htmlDescription, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProductlinesByTextDescription
	 *
	 */
	public Set<Productlines> findProductlinesByTextDescription(String textDescription) throws DataAccessException;

	/**
	 * JPQL Query - findProductlinesByTextDescription
	 *
	 */
	public Set<Productlines> findProductlinesByTextDescription(String textDescription, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProductlinesByTextDescriptionContaining
	 *
	 */
	public Set<Productlines> findProductlinesByTextDescriptionContaining(String textDescription_1) throws DataAccessException;

	/**
	 * JPQL Query - findProductlinesByTextDescriptionContaining
	 *
	 */
	public Set<Productlines> findProductlinesByTextDescriptionContaining(String textDescription_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProductlinesByPrimaryKey
	 *
	 */
	public Productlines findProductlinesByPrimaryKey(String productLine_1) throws DataAccessException;

	/**
	 * JPQL Query - findProductlinesByPrimaryKey
	 *
	 */
	public Productlines findProductlinesByPrimaryKey(String productLine_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProductlinesByProductLine
	 *
	 */
	public Productlines findProductlinesByProductLine(String productLine_2) throws DataAccessException;

	/**
	 * JPQL Query - findProductlinesByProductLine
	 *
	 */
	public Productlines findProductlinesByProductLine(String productLine_2, int startResult, int maxRows) throws DataAccessException;

}