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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllEmployeess", query = "select myEmployees from Employees myEmployees"),
		@NamedQuery(name = "findEmployeesByEmail", query = "select myEmployees from Employees myEmployees where myEmployees.email = ?1"),
		@NamedQuery(name = "findEmployeesByEmailContaining", query = "select myEmployees from Employees myEmployees where myEmployees.email like ?1"),
		@NamedQuery(name = "findEmployeesByEmployeeNumber", query = "select myEmployees from Employees myEmployees where myEmployees.employeeNumber = ?1"),
		@NamedQuery(name = "findEmployeesByExtension", query = "select myEmployees from Employees myEmployees where myEmployees.extension = ?1"),
		@NamedQuery(name = "findEmployeesByExtensionContaining", query = "select myEmployees from Employees myEmployees where myEmployees.extension like ?1"),
		@NamedQuery(name = "findEmployeesByFirstName", query = "select myEmployees from Employees myEmployees where myEmployees.firstName = ?1"),
		@NamedQuery(name = "findEmployeesByFirstNameContaining", query = "select myEmployees from Employees myEmployees where myEmployees.firstName like ?1"),
		@NamedQuery(name = "findEmployeesByJobTitle", query = "select myEmployees from Employees myEmployees where myEmployees.jobTitle = ?1"),
		@NamedQuery(name = "findEmployeesByJobTitleContaining", query = "select myEmployees from Employees myEmployees where myEmployees.jobTitle like ?1"),
		@NamedQuery(name = "findEmployeesByLastName", query = "select myEmployees from Employees myEmployees where myEmployees.lastName = ?1"),
		@NamedQuery(name = "findEmployeesByLastNameContaining", query = "select myEmployees from Employees myEmployees where myEmployees.lastName like ?1"),
		@NamedQuery(name = "findEmployeesByPrimaryKey", query = "select myEmployees from Employees myEmployees where myEmployees.employeeNumber = ?1") })
@Table(catalog = "classicmodels", name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "ClassicModels15_AJs1/com/bluedream/sales1/domain", name = "Employees")
@XmlRootElement(namespace = "ClassicModels15_AJs1/com/bluedream/sales1/domain")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "employeeNumber")
public class Employees implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "employeeNumber", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer employeeNumber;
	/**
	 */

	@Column(name = "lastName", length = 50, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String lastName;
	/**
	 */

	@Column(name = "firstName", length = 50, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String firstName;
	/**
	 */

	@Column(name = "extension", length = 10, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String extension;
	/**
	 */

	@Column(name = "email", length = 100, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String email;
	/**
	 */

	@Column(name = "jobTitle", length = 50, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String jobTitle;

	/**
	 */
	// @ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "officeCode", referencedColumnName = "officeCode", nullable = false) })
	@XmlTransient
	Offices offices;
	/**
	 */
	// @ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "reportsTo", referencedColumnName = "employeeNumber") })
	@XmlTransient
	Employees employees;
	/**
	 */
	@OneToMany(mappedBy = "employees", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.bluedream.sales1.domain.Employees> employeeses;
	/**
	 */
	@OneToMany(mappedBy = "employees", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.bluedream.sales1.domain.Customers> customerses;

	/**
	 */
	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	/**
	 */
	public Integer getEmployeeNumber() {
		return this.employeeNumber;
	}

	/**
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}

	/**
	 */
	public String getExtension() {
		return this.extension;
	}

	/**
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**
	 */
	public String getJobTitle() {
		return this.jobTitle;
	}

	/**
	 */
	public void setOffices(Offices offices) {
		this.offices = offices;
	}

	/**
	 */
	// @JsonIgnore
	public Offices getOffices() {
		return offices;
	}

	/**
	 */
	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	/**
	 */
	public Employees getEmployees() {
		return employees;
	}

	/**
	 */
	public void setEmployeeses(Set<Employees> employeeses) {
		this.employeeses = employeeses;
	}

	/**
	 */
	@JsonIgnore
	public Set<Employees> getEmployeeses() {
		if (employeeses == null) {
			employeeses = new java.util.LinkedHashSet<com.bluedream.sales1.domain.Employees>();
		}
		return employeeses;
	}

	/**
	 */
	@JsonIgnore
	public void setCustomerses(Set<Customers> customerses) {
		this.customerses = customerses;
	}

	/**
	 */
	public Set<Customers> getCustomerses() {
		if (customerses == null) {
			customerses = new java.util.LinkedHashSet<com.bluedream.sales1.domain.Customers>();
		}
		return customerses;
	}

	/**
	 */
	public Employees() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Employees that) {
		setEmployeeNumber(that.getEmployeeNumber());
		setLastName(that.getLastName());
		setFirstName(that.getFirstName());
		setExtension(that.getExtension());
		setEmail(that.getEmail());
		setJobTitle(that.getJobTitle());
		setOffices(that.getOffices());
		setEmployees(that.getEmployees());
		setEmployeeses(new java.util.LinkedHashSet<com.bluedream.sales1.domain.Employees>(that.getEmployeeses()));
		setCustomerses(new java.util.LinkedHashSet<com.bluedream.sales1.domain.Customers>(that.getCustomerses()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("employeeNumber=[").append(employeeNumber).append("] ");
		buffer.append("lastName=[").append(lastName).append("] ");
		buffer.append("firstName=[").append(firstName).append("] ");
		buffer.append("extension=[").append(extension).append("] ");
		buffer.append("email=[").append(email).append("] ");
		buffer.append("jobTitle=[").append(jobTitle).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((employeeNumber == null) ? 0 : employeeNumber.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Employees))
			return false;
		Employees equalCheck = (Employees) obj;
		if ((employeeNumber == null && equalCheck.employeeNumber != null) || (employeeNumber != null && equalCheck.employeeNumber == null))
			return false;
		if (employeeNumber != null && !employeeNumber.equals(equalCheck.employeeNumber))
			return false;
		return true;
	}
}
