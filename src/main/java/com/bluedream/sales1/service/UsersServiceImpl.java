package com.bluedream.sales1.service;

import com.bluedream.sales1.dao.UserRolesDAO;
import com.bluedream.sales1.dao.UsersDAO;

import com.bluedream.sales1.domain.UserRoles;
import com.bluedream.sales1.domain.Users;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Users entities
 * 
 */

@Service("UsersService")
@Transactional
public class UsersServiceImpl implements UsersService {

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
	 * Instantiates a new UsersServiceImpl.
	 *
	 */
	public UsersServiceImpl() {
	}

	/**
	 * Delete an existing Users entity
	 * 
	 */
	@Transactional
	public void deleteUsers(Users users) {
		usersDAO.remove(users);
		usersDAO.flush();
	}

	/**
	 * Return a count of all Users entity
	 * 
	 */
	@Transactional
	public Integer countUserss() {
		return ((Long) usersDAO.createQuerySingleResult("select count(o) from Users o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing UserRoles entity
	 * 
	 */
	@Transactional
	public Users saveUsersUserRoleses(String username, UserRoles related_userroleses) {
		Users users = usersDAO.findUsersByPrimaryKey(username, -1, -1);
		UserRoles existinguserRoleses = userRolesDAO.findUserRolesByPrimaryKey(related_userroleses.getUserRoleId());

		// copy into the existing record to preserve existing relationships
		if (existinguserRoleses != null) {
			existinguserRoleses.setUserRoleId(related_userroleses.getUserRoleId());
			existinguserRoleses.setRole(related_userroleses.getRole());
			related_userroleses = existinguserRoleses;
		}

		related_userroleses.setUsers(users);
		users.getUserRoleses().add(related_userroleses);
		related_userroleses = userRolesDAO.store(related_userroleses);
		userRolesDAO.flush();

		users = usersDAO.store(users);
		usersDAO.flush();

		return users;
	}

	/**
	 */
	@Transactional
	public Users findUsersByPrimaryKey(String username) {
		return usersDAO.findUsersByPrimaryKey(username);
	}

	/**
	 * Load an existing Users entity
	 * 
	 */
	@Transactional
	public Set<Users> loadUserss() {
		return usersDAO.findAllUserss();
	}

	/**
	 * Return all Users entity
	 * 
	 */
	@Transactional
	public List<Users> findAllUserss(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Users>(usersDAO.findAllUserss(startResult, maxRows));
	}

	/**
	 * Delete an existing UserRoles entity
	 * 
	 */
	@Transactional
	public Users deleteUsersUserRoleses(String users_username, Integer related_userroleses_userRoleId) {
		UserRoles related_userroleses = userRolesDAO.findUserRolesByPrimaryKey(related_userroleses_userRoleId, -1, -1);

		Users users = usersDAO.findUsersByPrimaryKey(users_username, -1, -1);

		related_userroleses.setUsers(null);
		users.getUserRoleses().remove(related_userroleses);

		userRolesDAO.remove(related_userroleses);
		userRolesDAO.flush();

		return users;
	}

	/**
	 * Save an existing Users entity
	 * 
	 */
	@Transactional
	public void saveUsers(Users users) {
		Users existingUsers = usersDAO.findUsersByPrimaryKey(users.getUsername());

		if (existingUsers != null) {
			if (existingUsers != users) {
				existingUsers.setUsername(users.getUsername());
				existingUsers.setPassword(users.getPassword());
				existingUsers.setEnabled(users.getEnabled());
			}
			users = usersDAO.store(existingUsers);
		} else {
			users = usersDAO.store(users);
		}
		usersDAO.flush();
	}
}
