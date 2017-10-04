package com.bluedream.sales1.dao;

import com.bluedream.sales1.domain.UserRoles;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage UserRoles entities.
 * 
 */
public interface UserRolesDAO extends JpaDao<UserRoles> {

	/**
	 * JPQL Query - findUserRolesByPrimaryKey
	 *
	 */
	public UserRoles findUserRolesByPrimaryKey(Integer userRoleId) throws DataAccessException;

	/**
	 * JPQL Query - findUserRolesByPrimaryKey
	 *
	 */
	public UserRoles findUserRolesByPrimaryKey(Integer userRoleId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllUserRoless
	 *
	 */
	public Set<UserRoles> findAllUserRoless() throws DataAccessException;

	/**
	 * JPQL Query - findAllUserRoless
	 *
	 */
	public Set<UserRoles> findAllUserRoless(int startResult, int maxRows) throws DataAccessException;

}