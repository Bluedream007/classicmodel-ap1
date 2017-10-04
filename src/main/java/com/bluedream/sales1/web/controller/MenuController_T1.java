package com.bluedream.sales1.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Spring MVC controller that handles Menu requests for function items
 * 
 */

@Controller("MenuController_T1")
public class MenuController_T1 {

	
	/**
	 * Show Menu Test1
	 * 
	 */
	@RequestMapping("/dropdown_menu1")
	public ModelAndView showCustomersList() {
		ModelAndView mav = new ModelAndView();

		// mav.addObject("customerss", customersService.loadCustomerss());

		// mav.setViewName("menu/menu_T1");
		mav.setViewName("menu/dropdown-main-menu_1");

		return mav;
	}
	
	
	
	
}