package com.bluedream.sales1.web.controller;

import com.bluedream.sales1.dao.UserRolesDAO;
import com.bluedream.sales1.dao.UsersDAO;

import com.bluedream.sales1.domain.UserRoles;
import com.bluedream.sales1.domain.Users;

import com.bluedream.sales1.service.UsersService;

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
 * Spring MVC controller that handles CRUD requests for Users entities
 * 
 */

@Controller("UsersController")
public class UsersController {

	/**
	 * DAO injected by Spring that manages UserRoles entities
	 * 
	 */
	@Autowired
	private UserRolesDAO userRolesDAO;

	/**
	 * DAO injected by Spring that manages Users entities
	 * 
	 */
	@Autowired
	private UsersDAO usersDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Users entities
	 * 
	 */
	@Autowired
	private UsersService usersService;

	/**
	 * Show all UserRoles entities by Users
	 * 
	 */
	@RequestMapping("/listUsersUserRoleses")
	public ModelAndView listUsersUserRoleses(@RequestParam String usernameKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("users", usersDAO.findUsersByPrimaryKey(usernameKey));
		mav.setViewName("users/userroleses/listUserRoleses.jsp");

		return mav;
	}

	/**
	 * Select an existing Users entity
	 * 
	 */
	@RequestMapping("/selectUsers")
	public ModelAndView selectUsers(@RequestParam String usernameKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("users", usersDAO.findUsersByPrimaryKey(usernameKey));
		mav.setViewName("users/viewUsers.jsp");

		return mav;
	}

	/**
	 * Save an existing Users entity
	 * 
	 */
	@RequestMapping("/saveUsers")
	public String saveUsers(@ModelAttribute Users users) {
		usersService.saveUsers(users);
		return "forward:/indexUsers";
	}

	/**
	 * View an existing UserRoles entity
	 * 
	 */
	@RequestMapping("/selectUsersUserRoleses")
	public ModelAndView selectUsersUserRoleses(@RequestParam String users_username, @RequestParam Integer userroleses_userRoleId) {
		UserRoles userroles = userRolesDAO.findUserRolesByPrimaryKey(userroleses_userRoleId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("users_username", users_username);
		mav.addObject("userroles", userroles);
		mav.setViewName("users/userroleses/viewUserRoleses.jsp");

		return mav;
	}

	/**
	 * Save an existing UserRoles entity
	 * 
	 */
	@RequestMapping("/saveUsersUserRoleses")
	public ModelAndView saveUsersUserRoleses(@RequestParam String users_username, @ModelAttribute UserRoles userroleses) {
		Users parent_users = usersService.saveUsersUserRoleses(users_username, userroleses);

		ModelAndView mav = new ModelAndView();
		mav.addObject("users_username", users_username);
		mav.addObject("users", parent_users);
		mav.setViewName("users/viewUsers.jsp");

		return mav;
	}

	/**
	 * Create a new UserRoles entity
	 * 
	 */
	@RequestMapping("/newUsersUserRoleses")
	public ModelAndView newUsersUserRoleses(@RequestParam String users_username) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("users_username", users_username);
		mav.addObject("userroles", new UserRoles());
		mav.addObject("newFlag", true);
		mav.setViewName("users/userroleses/editUserRoleses.jsp");

		return mav;
	}

	/**
	 * Select the Users entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteUsers")
	public ModelAndView confirmDeleteUsers(@RequestParam String usernameKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("users", usersDAO.findUsersByPrimaryKey(usernameKey));
		mav.setViewName("users/deleteUsers.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Users entities
	 * 
	 */
	public String indexUsers() {
		return "redirect:/indexUsers";
	}

	/**
	 * Edit an existing Users entity
	 * 
	 */
	@RequestMapping("/editUsers")
	public ModelAndView editUsers(@RequestParam String usernameKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("users", usersDAO.findUsersByPrimaryKey(usernameKey));
		mav.setViewName("users/editUsers.jsp");

		return mav;
	}

	/**
	 * Create a new Users entity
	 * 
	 */
	@RequestMapping("/newUsers")
	public ModelAndView newUsers() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("users", new Users());
		mav.addObject("newFlag", true);
		mav.setViewName("users/editUsers.jsp");

		return mav;
	}

	/**
	 * Show all Users entities
	 * 
	 */
	@RequestMapping("/indexUsers")
	public ModelAndView listUserss() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("userss", usersService.loadUserss());

		mav.setViewName("users/listUserss.jsp");

		return mav;
	}

	/**
	 * Edit an existing UserRoles entity
	 * 
	 */
	@RequestMapping("/editUsersUserRoleses")
	public ModelAndView editUsersUserRoleses(@RequestParam String users_username, @RequestParam Integer userroleses_userRoleId) {
		UserRoles userroles = userRolesDAO.findUserRolesByPrimaryKey(userroleses_userRoleId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("users_username", users_username);
		mav.addObject("userroles", userroles);
		mav.setViewName("users/userroleses/editUserRoleses.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/usersController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Delete an existing Users entity
	 * 
	 */
	@RequestMapping("/deleteUsers")
	public String deleteUsers(@RequestParam String usernameKey) {
		Users users = usersDAO.findUsersByPrimaryKey(usernameKey);
		usersService.deleteUsers(users);
		return "forward:/indexUsers";
	}

	/**
	 * Select the child UserRoles entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteUsersUserRoleses")
	public ModelAndView confirmDeleteUsersUserRoleses(@RequestParam String users_username, @RequestParam Integer related_userroleses_userRoleId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("userroles", userRolesDAO.findUserRolesByPrimaryKey(related_userroleses_userRoleId));
		mav.addObject("users_username", users_username);
		mav.setViewName("users/userroleses/deleteUserRoleses.jsp");

		return mav;
	}

	/**
	 * Delete an existing UserRoles entity
	 * 
	 */
	@RequestMapping("/deleteUsersUserRoleses")
	public ModelAndView deleteUsersUserRoleses(@RequestParam String users_username, @RequestParam Integer related_userroleses_userRoleId) {
		ModelAndView mav = new ModelAndView();

		Users users = usersService.deleteUsersUserRoleses(users_username, related_userroleses_userRoleId);

		mav.addObject("users_username", users_username);
		mav.addObject("users", users);
		mav.setViewName("users/viewUsers.jsp");

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
}