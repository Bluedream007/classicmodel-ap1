package com.bluedream.sales1.service;

import com.bluedream.sales1.domain.Productlines;
import com.bluedream.sales1.domain.Products;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Productlines entities
 * 
 */
public interface ProductlinesService {

	/**
	 * Return a count of all Productlines entity
	 * 
	 */
	public Integer countProductliness();

	/**
	 * Load an existing Productlines entity
	 * 
	 */
	public Set<Productlines> loadProductliness();

	/**
	 */
	public Productlines findProductlinesByPrimaryKey(String productLine);

	/**
	 * Save an existing Products entity
	 * 
	 */
	public Productlines saveProductlinesProductses(String productLine_1, Products related_productses);

	/**
	 * Delete an existing Productlines entity
	 * 
	 */
	public void deleteProductlines(Productlines productlines);

	/**
	 * Return all Productlines entity
	 * 
	 */
	public List<Productlines> findAllProductliness(Integer startResult, Integer maxRows);

	/**
	 * Save an existing Productlines entity
	 * 
	 */
	public void saveProductlines(Productlines productlines_1);

	/**
	 * Delete an existing Products entity
	 * 
	 */
	public Productlines deleteProductlinesProductses(String productlines_productLine, String related_productses_productCode);
}