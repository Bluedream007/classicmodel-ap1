package com.bluedream.sales1.service;

import com.bluedream.sales1.domain.UserRoles;
import com.bluedream.sales1.domain.Users;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Users entities
 * 
 */
public interface UsersService {

	/**
	 * Delete an existing Users entity
	 * 
	 */
	public void deleteUsers(Users users);

	/**
	 * Return a count of all Users entity
	 * 
	 */
	public Integer countUserss();

	/**
	 * Save an existing UserRoles entity
	 * 
	 */
	public Users saveUsersUserRoleses(String username, UserRoles related_userroleses);

	/**
	 */
	public Users findUsersByPrimaryKey(String username_1);

	/**
	 * Load an existing Users entity
	 * 
	 */
	public Set<Users> loadUserss();

	/**
	 * Return all Users entity
	 * 
	 */
	public List<Users> findAllUserss(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing UserRoles entity
	 * 
	 */
	public Users deleteUsersUserRoleses(String users_username, Integer related_userroleses_userRoleId);

	/**
	 * Save an existing Users entity
	 * 
	 */
	public void saveUsers(Users users_1);
}