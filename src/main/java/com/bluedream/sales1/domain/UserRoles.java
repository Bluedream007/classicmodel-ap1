package com.bluedream.sales1.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Set;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllUserRoless", query = "select myUserRoles from UserRoles myUserRoles"),
		@NamedQuery(name = "findUserRolesByPrimaryKey", query = "select myUserRoles from UserRoles myUserRoles where myUserRoles.userRoleId = ?1") })
@Table(catalog = "classicmodels", name = "user_roles")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "ClassicModels15_AJs1/com/bluedream/sales1/domain", name = "UserRoles")
public class UserRoles implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "user_role_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer userRoleId;
	/**
	 */

	@Column(name = "role", length = 45, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String role;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "username", referencedColumnName = "username", nullable = false) })
	@XmlTransient
	Users users;

	/**
	 */
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	/**
	 */
	public Integer getUserRoleId() {
		return this.userRoleId;
	}

	/**
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 */
	public String getRole() {
		return this.role;
	}

	/**
	 */
	public void setUsers(Users users) {
		this.users = users;
	}

	/**
	 */
	public Users getUsers() {
		return users;
	}

	/**
	 */
	public UserRoles() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(UserRoles that) {
		setUserRoleId(that.getUserRoleId());
		setRole(that.getRole());
		setUsers(that.getUsers());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("userRoleId=[").append(userRoleId).append("] ");
		buffer.append("role=[").append(role).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((userRoleId == null) ? 0 : userRoleId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof UserRoles))
			return false;
		UserRoles equalCheck = (UserRoles) obj;
		if ((userRoleId == null && equalCheck.userRoleId != null) || (userRoleId != null && equalCheck.userRoleId == null))
			return false;
		if (userRoleId != null && !userRoleId.equals(equalCheck.userRoleId))
			return false;
		return true;
	}
}
