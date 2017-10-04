package com.bluedream.sales1.web.rest;

import com.bluedream.sales1.dao.UserRolesDAO;
import com.bluedream.sales1.dao.UsersDAO;

import com.bluedream.sales1.domain.UserRoles;
import com.bluedream.sales1.domain.Users;

import com.bluedream.sales1.service.UsersService;

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

/**
 * Spring Rest controller that handles CRUD requests for Users entities
 * 
 */

@Controller("UsersRestController")
public class UsersRestController {

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
	@RequestMapping(value = "/Users/{users_username}/userRoleses", method = RequestMethod.GET)
	public List<UserRoles> getUsersUserRoleses(@PathVariable String users_username) {
		return new java.util.ArrayList<UserRoles>(usersDAO.findUsersByPrimaryKey(users_username).getUserRoleses());
	}

	/**
	 * Save an existing UserRoles entity
	 * 
	 */
	@RequestMapping(value = "/Users/{users_username}/userRoleses", method = RequestMethod.PUT)
	public UserRoles saveUsersUserRoleses(@PathVariable String users_username, @ModelAttribute UserRoles userroleses) {
		usersService.saveUsersUserRoleses(users_username, userroleses);
		return userRolesDAO.findUserRolesByPrimaryKey(userroleses.getUserRoleId());
	}

	/**
	 * Delete an existing Users entity
	 * 
	 */
	@RequestMapping(value = "/Users/{users_username}", method = RequestMethod.DELETE)
	public void deleteUsers(@PathVariable String users_username) {
		Users users = usersDAO.findUsersByPrimaryKey(users_username);
		usersService.deleteUsers(users);
	}

	/**
	 * Select an existing Users entity
	 * 
	 */
	@RequestMapping(value = "/Users/{users_username}", method = RequestMethod.GET)
	public Users loadUsers(@PathVariable String users_username) {
		return usersDAO.findUsersByPrimaryKey(users_username);
	}

	/**
	 * View an existing UserRoles entity
	 * 
	 */
	@RequestMapping(value = "/Users/{users_username}/userRoleses/{userroles_userRoleId}", method = RequestMethod.GET)
	public UserRoles loadUsersUserRoleses(@PathVariable String users_username, @PathVariable Integer related_userroleses_userRoleId) {
		UserRoles userroles = userRolesDAO.findUserRolesByPrimaryKey(related_userroleses_userRoleId, -1, -1);

		return userroles;
	}

	/**
	 * Show all Users entities
	 * 
	 */
	@RequestMapping(value = "/Users", method = RequestMethod.GET)
	public List<Users> listUserss() {
		return new java.util.ArrayList<Users>(usersService.loadUserss());
	}

	/**
	 * Delete an existing UserRoles entity
	 * 
	 */
	@RequestMapping(value = "/Users/{users_username}/userRoleses/{userroles_userRoleId}", method = RequestMethod.DELETE)
	public void deleteUsersUserRoleses(@PathVariable String users_username, @PathVariable Integer related_userroleses_userRoleId) {
		usersService.deleteUsersUserRoleses(users_username, related_userroleses_userRoleId);
	}

	/**
	 * Create a new Users entity
	 * 
	 */
	@RequestMapping(value = "/Users", method = RequestMethod.POST)
	public Users newUsers(@ModelAttribute Users users) {
		usersService.saveUsers(users);
		return usersDAO.findUsersByPrimaryKey(users.getUsername());
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
	 * Create a new UserRoles entity
	 * 
	 */
	@RequestMapping(value = "/Users/{users_username}/userRoleses", method = RequestMethod.POST)
	public UserRoles newUsersUserRoleses(@PathVariable String users_username, @ModelAttribute UserRoles userroles) {
		usersService.saveUsersUserRoleses(users_username, userroles);
		return userRolesDAO.findUserRolesByPrimaryKey(userroles.getUserRoleId());
	}

	/**
	 * Save an existing Users entity
	 * 
	 */
	@RequestMapping(value = "/Users", method = RequestMethod.PUT)
	public Users saveUsers(@ModelAttribute Users users) {
		usersService.saveUsers(users);
		return usersDAO.findUsersByPrimaryKey(users.getUsername());
	}
}