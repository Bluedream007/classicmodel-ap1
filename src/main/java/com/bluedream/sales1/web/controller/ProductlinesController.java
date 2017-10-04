package com.bluedream.sales1.web.controller;

import com.bluedream.sales1.dao.ProductlinesDAO;
import com.bluedream.sales1.dao.ProductsDAO;

import com.bluedream.sales1.domain.Productlines;
import com.bluedream.sales1.domain.Products;

import com.bluedream.sales1.service.ProductlinesService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

/**
 * Spring MVC controller that handles CRUD requests for Productlines entities
 * 
 */

@Controller("ProductlinesController")
public class ProductlinesController {

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
	 * Edit an existing Products entity
	 * 
	 */
	@RequestMapping("/editProductlinesProductses")
	public ModelAndView editProductlinesProductses(@RequestParam String productlines_productLine, @RequestParam String productses_productCode) {
		Products products = productsDAO.findProductsByPrimaryKey(productses_productCode, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("productlines_productLine", productlines_productLine);
		mav.addObject("products", products);
		mav.setViewName("productlines/productses/editProductses.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/productlinesController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Select the Productlines entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteProductlines")
	public ModelAndView confirmDeleteProductlines(@RequestParam String productLineKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("productlines", productlinesDAO.findProductlinesByPrimaryKey(productLineKey));
		mav.setViewName("productlines/deleteProductlines.jsp");

		return mav;
	}

	/**
	 * Delete an existing Productlines entity
	 * 
	 */
	@RequestMapping("/deleteProductlines")
	public String deleteProductlines(@RequestParam String productLineKey) {
		Productlines productlines = productlinesDAO.findProductlinesByPrimaryKey(productLineKey);
		productlinesService.deleteProductlines(productlines);
		return "forward:/indexProductlines";
	}

	/**
	 * View an existing Products entity
	 * 
	 */
	@RequestMapping("/selectProductlinesProductses")
	public ModelAndView selectProductlinesProductses(@RequestParam String productlines_productLine, @RequestParam String productses_productCode) {
		Products products = productsDAO.findProductsByPrimaryKey(productses_productCode, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("productlines_productLine", productlines_productLine);
		mav.addObject("products", products);
		mav.setViewName("productlines/productses/viewProductses.jsp");

		return mav;
	}

	/**
	 * Select an existing Productlines entity
	 * 
	 */
	@RequestMapping("/selectProductlines")
	public ModelAndView selectProductlines(@RequestParam String productLineKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("productlines", productlinesDAO.findProductlinesByPrimaryKey(productLineKey));
		mav.setViewName("productlines/viewProductlines.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Productlines entities
	 * 
	 */
	public String indexProductlines() {
		return "redirect:/indexProductlines";
	}

	/**
	 * Save an existing Products entity
	 * 
	 */
	@RequestMapping("/saveProductlinesProductses")
	public ModelAndView saveProductlinesProductses(@RequestParam String productlines_productLine, @ModelAttribute Products productses) {
		Productlines parent_productlines = productlinesService.saveProductlinesProductses(productlines_productLine, productses);

		ModelAndView mav = new ModelAndView();
		mav.addObject("productlines_productLine", productlines_productLine);
		mav.addObject("productlines", parent_productlines);
		mav.setViewName("productlines/viewProductlines.jsp");

		return mav;
	}

	/**
	 * Create a new Products entity
	 * 
	 */
	@RequestMapping("/newProductlinesProductses")
	public ModelAndView newProductlinesProductses(@RequestParam String productlines_productLine) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("productlines_productLine", productlines_productLine);
		mav.addObject("products", new Products());
		mav.addObject("newFlag", true);
		mav.setViewName("productlines/productses/editProductses.jsp");

		return mav;
	}

	/**
	 * Create a new Productlines entity
	 * 
	 */
	@RequestMapping("/newProductlines")
	public ModelAndView newProductlines() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("productlines", new Productlines());
		mav.addObject("newFlag", true);
		mav.setViewName("productlines/editProductlines.jsp");

		return mav;
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
	 * Show all Productlines entities
	 * 
	 */
	@RequestMapping("/indexProductlines")
	public ModelAndView listProductliness() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("productliness", productlinesService.loadProductliness());

		mav.setViewName("productlines/listProductliness.jsp");

		return mav;
	}

	/**
	 * Select the child Products entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteProductlinesProductses")
	public ModelAndView confirmDeleteProductlinesProductses(@RequestParam String productlines_productLine, @RequestParam String related_productses_productCode) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("products", productsDAO.findProductsByPrimaryKey(related_productses_productCode));
		mav.addObject("productlines_productLine", productlines_productLine);
		mav.setViewName("productlines/productses/deleteProductses.jsp");

		return mav;
	}

	/**
	 * Delete an existing Products entity
	 * 
	 */
	@RequestMapping("/deleteProductlinesProductses")
	public ModelAndView deleteProductlinesProductses(@RequestParam String productlines_productLine, @RequestParam String related_productses_productCode) {
		ModelAndView mav = new ModelAndView();

		Productlines productlines = productlinesService.deleteProductlinesProductses(productlines_productLine, related_productses_productCode);

		mav.addObject("productlines_productLine", productlines_productLine);
		mav.addObject("productlines", productlines);
		mav.setViewName("productlines/viewProductlines.jsp");

		return mav;
	}

	/**
	 * Save an existing Productlines entity
	 * 
	 */
	@RequestMapping("/saveProductlines")
	public String saveProductlines(@ModelAttribute Productlines productlines) {
		productlinesService.saveProductlines(productlines);
		return "forward:/indexProductlines";
	}

	/**
	 * Show all Products entities by Productlines
	 * 
	 */
	@RequestMapping("/listProductlinesProductses")
	public ModelAndView listProductlinesProductses(@RequestParam String productLineKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("productlines", productlinesDAO.findProductlinesByPrimaryKey(productLineKey));
		mav.setViewName("productlines/productses/listProductses.jsp");

		return mav;
	}

	/**
	 * Edit an existing Productlines entity
	 * 
	 */
	@RequestMapping("/editProductlines")
	public ModelAndView editProductlines(@RequestParam String productLineKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("productlines", productlinesDAO.findProductlinesByPrimaryKey(productLineKey));
		mav.setViewName("productlines/editProductlines.jsp");

		return mav;
	}
}