package com.bluedream.sales1.web.rest;

import com.bluedream.sales1.dao.ProductlinesDAO;
import com.bluedream.sales1.dao.ProductsDAO;

import com.bluedream.sales1.domain.Productlines;
import com.bluedream.sales1.domain.Products;

import com.bluedream.sales1.service.ProductlinesService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Spring Rest controller that handles CRUD requests for Productlines entities
 * 
 */

@Controller("ProductlinesRestController")
public class ProductlinesRestController {

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
	 * Service injected by Spring that provides CRUD operations for Productlines entities
	 * 
	 */
	@Autowired
	private ProductlinesService productlinesService;

	/**
	 * Create a new Productlines entity
	 * 
	 */
	@RequestMapping(value = "/Productlines", method = RequestMethod.POST)
	public Productlines newProductlines(@ModelAttribute Productlines productlines) {
		productlinesService.saveProductlines(productlines);
		return productlinesDAO.findProductlinesByPrimaryKey(productlines.getProductLine());
	}

	/**
	 * Save an existing Productlines entity
	 * 
	 */
	@RequestMapping(value = "/Productlines", method = RequestMethod.PUT)
	public Productlines saveProductlines(@ModelAttribute Productlines productlines) {
		productlinesService.saveProductlines(productlines);
		return productlinesDAO.findProductlinesByPrimaryKey(productlines.getProductLine());
	}

	/**
	 * Register custom, context-specific property editors
	 * 
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder, HttpServletRequest request) { // Register static property editors.
		binder.registerCustomEditor(java.util.Calendar.class, new org.skyway.spring.util.databinding.CustomCalendarEditor());
		binder.registerCustomEditor(byte[].class, new org.springframework.web.multipart.support.ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(false));
		binder.registerCustomEditor(Boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(true));
		binder.registerCustomEditor(java.math.BigDecimal.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(java.math.BigDecimal.class, true));
		binder.registerCustomEditor(Integer.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Integer.class, true));
		binder.registerCustomEditor(java.util.Date.class, new org.skyway.spring.util.databinding.CustomDateEditor());
		binder.registerCustomEditor(String.class, new org.skyway.spring.util.databinding.StringEditor());
		binder.registerCustomEditor(Long.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Long.class, true));
		binder.registerCustomEditor(Double.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Double.class, true));
	}

	/**
	 * Create a new Products entity
	 * 
	 */
	@RequestMapping(value = "/Productlines/{productlines_productLine}/productses", method = RequestMethod.POST)
	public Products newProductlinesProductses(@PathVariable String productlines_productLine, @ModelAttribute Products products) {
		productlinesService.saveProductlinesProductses(productlines_productLine, products);
		return productsDAO.findProductsByPrimaryKey(products.getProductCode());
	}

	/**
	 * Show all Productlines entities
	 * 
	 */
	@RequestMapping(value = "/Productlines", method = RequestMethod.GET)
	public List<Productlines> listProductliness() {
		return new java.util.ArrayList<Productlines>(productlinesService.loadProductliness());
	}
	
	/**
	 * Show all Productlines entities (Json - ok)
	 * Modify by Charlotte 
	 */
	@RequestMapping(value = "/ProductlinesJson", method = RequestMethod.GET, produces="application/json")
	@ResponseBody	
	public List<Productlines> listProductlinessJson() {
		return new java.util.ArrayList<Productlines>(productlinesService.loadProductliness());
	}

	/**
	 * View an existing Products entity
	 * 
	 */
	@RequestMapping(value = "/Productlines/{productlines_productLine}/productses/{products_productCode}", method = RequestMethod.GET)
	public Products loadProductlinesProductses(@PathVariable String productlines_productLine, @PathVariable String related_productses_productCode) {
		Products products = productsDAO.findProductsByPrimaryKey(related_productses_productCode, -1, -1);

		return products;
	}

	/**
	 * Delete an existing Products entity
	 * 
	 */
	@RequestMapping(value = "/Productlines/{productlines_productLine}/productses/{products_productCode}", method = RequestMethod.DELETE)
	public void deleteProductlinesProductses(@PathVariable String productlines_productLine, @PathVariable String related_productses_productCode) {
		productlinesService.deleteProductlinesProductses(productlines_productLine, related_productses_productCode);
	}

	/**
	 * Delete an existing Productlines entity
	 * 
	 */
	@RequestMapping(value = "/Productlines/{productlines_productLine}", method = RequestMethod.DELETE)
	public void deleteProductlines(@PathVariable String productlines_productLine) {
		Productlines productlines = productlinesDAO.findProductlinesByPrimaryKey(productlines_productLine);
		productlinesService.deleteProductlines(productlines);
	}

	/**
	 * Show all Products entities by Productlines
	 * 
	 */
	@RequestMapping(value = "/Productlines/{productlines_productLine}/productses", method = RequestMethod.GET)
	public List<Products> getProductlinesProductses(@PathVariable String productlines_productLine) {
		return new java.util.ArrayList<Products>(productlinesDAO.findProductlinesByPrimaryKey(productlines_productLine).getProductses());
	}
	
	/**
	 * Show all Products entities by Productlines (Json - error)
	 * Modify by Charlotte	 * 
	 */
	@RequestMapping(value = "/ProductlinesJson/{productlines_productLine}/productses", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Products> getProductlinesProductsesJson(@PathVariable String productlines_productLine) {
		return new java.util.ArrayList<Products>(productlinesDAO.findProductlinesByPrimaryKey(productlines_productLine).getProductses());
	}

	/**
	 * Save an existing Products entity
	 * 
	 */
	@RequestMapping(value = "/Productlines/{productlines_productLine}/productses", method = RequestMethod.PUT)
	public Products saveProductlinesProductses(@PathVariable String productlines_productLine, @ModelAttribute Products productses) {
		productlinesService.saveProductlinesProductses(productlines_productLine, productses);
		return productsDAO.findProductsByPrimaryKey(productses.getProductCode());
	}

	/**
	 * Select an existing Productlines entity
	 * 
	 */
	@RequestMapping(value = "/Productlines/{productlines_productLine}", method = RequestMethod.GET)
	public Productlines loadProductlines(@PathVariable String productlines_productLine) {
		return productlinesDAO.findProductlinesByPrimaryKey(productlines_productLine);
	}
}