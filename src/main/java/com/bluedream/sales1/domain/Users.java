package com.bluedream.sales1.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.LinkedHashSet;
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
		@NamedQuery(name = "findAllUserss", query = "select myUsers from Users myUsers"),
		@NamedQuery(name = "findUsersByEnabled", query = "select myUsers from Users myUsers where myUsers.enabled = ?1"),
		@NamedQuery(name = "findUsersByPassword", query = "select myUsers from Users myUsers where myUsers.password = ?1"),
		@NamedQuery(name = "findUsersByPasswordContaining", query = "select myUsers from Users myUsers where myUsers.password like ?1"),
		@NamedQuery(name = "findUsersByPrimaryKey", query = "select myUsers from Users myUsers where myUsers.username = ?1"),
		@NamedQuery(name = "findUsersByUsername", query = "select myUsers from Users myUsers where myUsers.username = ?1"),
		@NamedQuery(name = "findUsersByUsernameContaining", query = "select myUsers from Users myUsers where myUsers.username like ?1") })
@Table(catalog = "classicmodels", name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "ClassicModels15_AJs1/com/bluedream/sales1/domain", name = "Users")
@XmlRootElement(namespace = "ClassicModels15_AJs1/com/bluedream/sales1/domain")
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "username", length = 45, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	String username;
	/**
	 */

	@Column(name = "password", length = 60, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String password;
	/**
	 */

	@Column(name = "enabled", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean enabled;

	/**
	 */
	@OneToMany(mappedBy = "users", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.bluedream.sales1.domain.UserRoles> userRoleses;

	/**
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 */
	public Boolean getEnabled() {
		return this.enabled;
	}

	/**
	 */
	public void setUserRoleses(Set<UserRoles> userRoleses) {
		this.userRoleses = userRoleses;
	}

	/**
	 */
	public Set<UserRoles> getUserRoleses() {
		if (userRoleses == null) {
			userRoleses = new java.util.LinkedHashSet<com.bluedream.sales1.domain.UserRoles>();
		}
		return userRoleses;
	}

	/**
	 */
	public Users() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Users that) {
		setUsername(that.getUsername());
		setPassword(that.getPassword());
		setEnabled(that.getEnabled());
		setUserRoleses(new java.util.LinkedHashSet<com.bluedream.sales1.domain.UserRoles>(that.getUserRoleses()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("username=[").append(username).append("] ");
		buffer.append("password=[").append(password).append("] ");
		buffer.append("enabled=[").append(enabled).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((username == null) ? 0 : username.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Users))
			return false;
		Users equalCheck = (Users) obj;
		if ((username == null && equalCheck.username != null) || (username != null && equalCheck.username == null))
			return false;
		if (username != null && !username.equals(equalCheck.username))
			return false;
		return true;
	}
}
