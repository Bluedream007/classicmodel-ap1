package com.bluedream.sales1.dao;

import com.bluedream.sales1.domain.Users;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Users entities.
 * 
 */
public interface UsersDAO extends JpaDao<Users> {

	/**
	 * JPQL Query - findUsersByPrimaryKey
	 *
	 */
	public Users findUsersByPrimaryKey(String username) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByPrimaryKey
	 *
	 */
	public Users findUsersByPrimaryKey(String username, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByEnabled
	 *
	 */
	public Set<Users> findUsersByEnabled(Boolean enabled) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByEnabled
	 *
	 */
	public Set<Users> findUsersByEnabled(Boolean enabled, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllUserss
	 *
	 */
	public Set<Users> findAllUserss() throws DataAccessException;

	/**
	 * JPQL Query - findAllUserss
	 *
	 */
	public Set<Users> findAllUserss(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByPasswordContaining
	 *
	 */
	public Set<Users> findUsersByPasswordContaining(String password) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByPasswordContaining
	 *
	 */
	public Set<Users> findUsersByPasswordContaining(String password, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByPassword
	 *
	 */
	public Set<Users> findUsersByPassword(String password_1) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByPassword
	 *
	 */
	public Set<Users> findUsersByPassword(String password_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByUsernameContaining
	 *
	 */
	public Set<Users> findUsersByUsernameContaining(String username_1) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByUsernameContaining
	 *
	 */
	public Set<Users> findUsersByUsernameContaining(String username_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByUsername
	 *
	 */
	public Users findUsersByUsername(String username_2) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByUsername
	 *
	 */
	public Users findUsersByUsername(String username_2, int startResult, int maxRows) throws DataAccessException;

}