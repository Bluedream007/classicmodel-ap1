package com.bluedream.sales1.service;

import com.bluedream.sales1.dao.ProductlinesDAO;
import com.bluedream.sales1.dao.ProductsDAO;

import com.bluedream.sales1.domain.Productlines;
import com.bluedream.sales1.domain.Products;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Productlines entities
 * 
 */

@Service("ProductlinesService")
@Transactional
public class ProductlinesServiceImpl implements ProductlinesService {

	/**
	 * DAO injected by Spring that manages Productlines entities
	 * 
	 */
	@Autowired
	private ProductlinesDAO productlinesDAO;

	/**
	 * DAO injected by Spring that manages Products entities
	 * 
	 */
	@Autowired
	private ProductsDAO productsDAO;

	/**
	 * Instantiates a new ProductlinesServiceImpl.
	 *
	 */
	public ProductlinesServiceImpl() {
	}

	/**
	 * Return a count of all Productlines entity
	 * 
	 */
	@Transactional
	public Integer countProductliness() {
		return ((Long) productlinesDAO.createQuerySingleResult("select count(o) from Productlines o").getSingleResult()).intValue();
	}

	/**
	 * Load an existing Productlines entity
	 * 
	 */
	@Transactional
	public Set<Productlines> loadProductliness() {
		return productlinesDAO.findAllProductliness();
	}

	/**
	 */
	@Transactional
	public Productlines findProductlinesByPrimaryKey(String productLine) {
		return productlinesDAO.findProductlinesByPrimaryKey(productLine);
	}

	/**
	 * Save an existing Products entity
	 * 
	 */
	@Transactional
	public Productlines saveProductlinesProductses(String productLine, Products related_productses) {
		Productlines productlines = productlinesDAO.findProductlinesByPrimaryKey(productLine, -1, -1);
		Products existingproductses = productsDAO.findProductsByPrimaryKey(related_productses.getProductCode());

		// copy into the existing record to preserve existing relationships
		if (existingproductses != null) {
			existingproductses.setProductCode(related_productses.getProductCode());
			existingproductses.setProductName(related_productses.getProductName());
			existingproductses.setProductScale(related_productses.getProductScale());
			existingproductses.setProductVendor(related_productses.getProductVendor());
			existingproductses.setProductDescription(related_productses.getProductDescription());
			existingproductses.setQuantityInStock(related_productses.getQuantityInStock());
			existingproductses.setBuyPrice(related_productses.getBuyPrice());
			existingproductses.setMsrp(related_productses.getMsrp());
			related_productses = existingproductses;
		}

		related_productses.setProductlines(productlines);
		productlines.getProductses().add(related_productses);
		related_productses = productsDAO.store(related_productses);
		productsDAO.flush();

		productlines = productlinesDAO.store(productlines);
		productlinesDAO.flush();

		return productlines;
	}

	/**
	 * Delete an existing Productlines entity
	 * 
	 */
	@Transactional
	public void deleteProductlines(Productlines productlines) {
		productlinesDAO.remove(productlines);
		productlinesDAO.flush();
	}

	/**
	 * Return all Productlines entity
	 * 
	 */
	@Transactional
	public List<Productlines> findAllProductliness(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Productlines>(productlinesDAO.findAllProductliness(startResult, maxRows));
	}

	/**
	 * Save an existing Productlines entity
	 * 
	 */
	@Transactional
	public void saveProductlines(Productlines productlines) {
		Productlines existingProductlines = productlinesDAO.findProductlinesByPrimaryKey(productlines.getProductLine());

		if (existingProductlines != null) {
			if (existingProductlines != productlines) {
				existingProductlines.setProductLine(productlines.getProductLine());
				existingProductlines.setTextDescription(productlines.getTextDescription());
				existingProductlines.setHtmlDescription(productlines.getHtmlDescription());
				existingProductlines.setImage(productlines.getImage());
			}
			productlines = productlinesDAO.store(existingProductlines);
		} else {
			productlines = productlinesDAO.store(productlines);
		}
		productlinesDAO.flush();
	}

	/**
	 * Delete an existing Products entity
	 * 
	 */
	@Transactional
	public Productlines deleteProductlinesProductses(String productlines_productLine, String related_productses_productCode) {
		Products related_productses = productsDAO.findProductsByPrimaryKey(related_productses_productCode, -1, -1);

		Productlines productlines = productlinesDAO.findProductlinesByPrimaryKey(productlines_productLine, -1, -1);

		related_productses.setProductlines(null);
		productlines.getProductses().remove(related_productses);

		productsDAO.remove(related_productses);
		productsDAO.flush();

		return productlines;
	}
}
