package com.bluedream.sales1.domain;

import java.io.Serializable;
import java.lang.StringBuilder;
import java.math.BigDecimal;
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
		@NamedQuery(name = "findAllCustomerss", query = "select myCustomers from Customers myCustomers"),
		@NamedQuery(name = "findCustomersByAddressLine1", query = "select myCustomers from Customers myCustomers where myCustomers.addressLine1 = ?1"),
		@NamedQuery(name = "findCustomersByAddressLine1Containing", query = "select myCustomers from Customers myCustomers where myCustomers.addressLine1 like ?1"),
		@NamedQuery(name = "findCustomersByAddressLine2", query = "select myCustomers from Customers myCustomers where myCustomers.addressLine2 = ?1"),
		@NamedQuery(name = "findCustomersByAddressLine2Containing", query = "select myCustomers from Customers myCustomers where myCustomers.addressLine2 like ?1"),
		@NamedQuery(name = "findCustomersByCity", query = "select myCustomers from Customers myCustomers where myCustomers.city = ?1"),
		@NamedQuery(name = "findCustomersByCityContaining", query = "select myCustomers from Customers myCustomers where myCustomers.city like ?1"),
		@NamedQuery(name = "findCustomersByContactFirstName", query = "select myCustomers from Customers myCustomers where myCustomers.contactFirstName = ?1"),
		@NamedQuery(name = "findCustomersByContactFirstNameContaining", query = "select myCustomers from Customers myCustomers where myCustomers.contactFirstName like ?1"),
		@NamedQuery(name = "findCustomersByContactLastName", query = "select myCustomers from Customers myCustomers where myCustomers.contactLastName = ?1"),
		@NamedQuery(name = "findCustomersByContactLastNameContaining", query = "select myCustomers from Customers myCustomers where myCustomers.contactLastName like ?1"),
		@NamedQuery(name = "findCustomersByCountry", query = "select myCustomers from Customers myCustomers where myCustomers.country = ?1"),
		@NamedQuery(name = "findCustomersByCountryContaining", query = "select myCustomers from Customers myCustomers where myCustomers.country like ?1"),
		@NamedQuery(name = "findCustomersByCreditLimit", query = "select myCustomers from Customers myCustomers where myCustomers.creditLimit = ?1"),
		@NamedQuery(name = "findCustomersByCustomerName", query = "select myCustomers from Customers myCustomers where myCustomers.customerName = ?1"),
		@NamedQuery(name = "findCustomersByCustomerNameContaining", query = "select myCustomers from Customers myCustomers where myCustomers.customerName like ?1"),
		@NamedQuery(name = "findCustomersByCustomerNumber", query = "select myCustomers from Customers myCustomers where myCustomers.customerNumber = ?1"),
		@NamedQuery(name = "findCustomersByPhone", query = "select myCustomers from Customers myCustomers where myCustomers.phone = ?1"),
		@NamedQuery(name = "findCustomersByPhoneContaining", query = "select myCustomers from Customers myCustomers where myCustomers.phone like ?1"),
		@NamedQuery(name = "findCustomersByPostalCode", query = "select myCustomers from Customers myCustomers where myCustomers.postalCode = ?1"),
		@NamedQuery(name = "findCustomersByPostalCodeContaining", query = "select myCustomers from Customers myCustomers where myCustomers.postalCode like ?1"),
		@NamedQuery(name = "findCustomersByPrimaryKey", query = "select myCustomers from Customers myCustomers where myCustomers.customerNumber = ?1"),
		@NamedQuery(name = "findCustomersByState", query = "select myCustomers from Customers myCustomers where myCustomers.state = ?1"),
		@NamedQuery(name = "findCustomersByStateContaining", query = "select myCustomers from Customers myCustomers where myCustomers.state like ?1") })
@Table(catalog = "classicmodels", name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "ClassicModels15_AJs1/com/bluedream/sales1/domain", name = "Customers")
@XmlRootElement(namespace = "ClassicModels15_AJs1/com/bluedream/sales1/domain")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "customerNumber")
public class Customers implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "customerNumber", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer customerNumber;
	/**
	 */

	@Column(name = "customerName", length = 50, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String customerName;
	/**
	 */

	@Column(name = "contactLastName", length = 50, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String contactLastName;
	/**
	 */

	@Column(name = "contactFirstName", length = 50, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String contactFirstName;
	/**
	 */

	@Column(name = "phone", length = 50, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String phone;
	/**
	 */

	@Column(name = "addressLine1", length = 50, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String addressLine1;
	/**
	 */

	@Column(name = "addressLine2", length = 50)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String addressLine2;
	/**
	 */

	@Column(name = "city", length = 50, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String city;
	/**
	 */

	@Column(name = "state", length = 50)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String state;
	/**
	 */

	@Column(name = "postalCode", length = 15)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String postalCode;
	/**
	 */

	@Column(name = "country", length = 50, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String country;
	/**
	 */

	@Column(name = "creditLimit", precision = 22)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal creditLimit;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	// @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "salesRepEmployeeNumber", referencedColumnName = "employeeNumber") })
	@XmlTransient
	Employees employees;
	/**
	 * TODO - 不適合在 Customers取得Orders關係(會變成雙向參照), 考慮刪除此屬性.     
	 */
	@OneToMany(mappedBy = "customers", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.bluedream.sales1.domain.Orders> orderses;
	/**
	 * TODO - 不適合在 Customers取得Orders關係(會變成雙向參照), 考慮刪除此屬性.
	 */
	@OneToMany(mappedBy = "customers", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.bluedream.sales1.domain.Payments> paymentses;

	/**
	 */
	public void setCustomerNumber(Integer customerNumber) {
		this.customerNumber = customerNumber;
	}

	/**
	 */
	public Integer getCustomerNumber() {
		return this.customerNumber;
	}

	/**
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 */
	public String getCustomerName() {
		return this.customerName;
	}

	/**
	 */
	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	/**
	 */
	public String getContactLastName() {
		return this.contactLastName;
	}

	/**
	 */
	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}

	/**
	 */
	public String getContactFirstName() {
		return this.contactFirstName;
	}

	/**
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 */
	public String getPhone() {
		return this.phone;
	}

	/**
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 */
	public String getAddressLine1() {
		return this.addressLine1;
	}

	/**
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 */
	public String getAddressLine2() {
		return this.addressLine2;
	}

	/**
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 */
	public String getState() {
		return this.state;
	}

	/**
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 */
	public String getPostalCode() {
		return this.postalCode;
	}

	/**
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 */
	public String getCountry() {
		return this.country;
	}

	/**
	 */
	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

	/**
	 */
	public BigDecimal getCreditLimit() {
		return this.creditLimit;
	}

	/**
	 */
	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	/**
	 */
	@JsonIgnore
	public Employees getEmployees() {
		return employees;
	}

	/**
	 */
	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}

	/**
	 */
	@JsonIgnore
	public Set<Orders> getOrderses() {
		if (orderses == null) {
			orderses = new java.util.LinkedHashSet<com.bluedream.sales1.domain.Orders>();
		}
		return orderses;
	}

	/**
	 */
	public void setPaymentses(Set<Payments> paymentses) {
		this.paymentses = paymentses;
	}

	/**
	 */
	@JsonIgnore
	public Set<Payments> getPaymentses() {
		if (paymentses == null) {
			paymentses = new java.util.LinkedHashSet<com.bluedream.sales1.domain.Payments>();
		}
		return paymentses;
	}

	/**
	 */
	public Customers() {
	}
	
	/*	 
	public Customers(Object[] pQryResult) {
		pCust
		
		setCustomerNumber(pCust.getCustomerNumber());
		setCustomerName(pCust.getCustomerName());
		setContactLastName(pCust.getContactLastName());
		setContactFirstName(pCust.getContactFirstName());
		setPhone(pCust.getPhone());
		setAddressLine1(pCust.getAddressLine1());
		setAddressLine2(pCust.getAddressLine2());
		setCity(pCust.getCity());
		setState(pCust.getState());
		setPostalCode(pCust.getPostalCode());
		setCountry(pCust.getCountry());
		setCreditLimit(pCust.getCreditLimit());
	    this.setEmployees(pEmp);		
	}
    */


	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Customers that) {
		setCustomerNumber(that.getCustomerNumber());
		setCustomerName(that.getCustomerName());
		setContactLastName(that.getContactLastName());
		setContactFirstName(that.getContactFirstName());
		setPhone(that.getPhone());
		setAddressLine1(that.getAddressLine1());
		setAddressLine2(that.getAddressLine2());
		setCity(that.getCity());
		setState(that.getState());
		setPostalCode(that.getPostalCode());
		setCountry(that.getCountry());
		setCreditLimit(that.getCreditLimit());
		setEmployees(that.getEmployees());
		setOrderses(new java.util.LinkedHashSet<com.bluedream.sales1.domain.Orders>(that.getOrderses()));
		setPaymentses(new java.util.LinkedHashSet<com.bluedream.sales1.domain.Payments>(that.getPaymentses()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("customerNumber=[").append(customerNumber).append("] ");
		buffer.append("customerName=[").append(customerName).append("] ");
		buffer.append("contactLastName=[").append(contactLastName).append("] ");
		buffer.append("contactFirstName=[").append(contactFirstName).append("] ");
		buffer.append("phone=[").append(phone).append("] ");
		buffer.append("addressLine1=[").append(addressLine1).append("] ");
		buffer.append("addressLine2=[").append(addressLine2).append("] ");
		buffer.append("city=[").append(city).append("] ");
		buffer.append("state=[").append(state).append("] ");
		buffer.append("postalCode=[").append(postalCode).append("] ");
		buffer.append("country=[").append(country).append("] ");
		buffer.append("creditLimit=[").append(creditLimit).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((customerNumber == null) ? 0 : customerNumber.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Customers))
			return false;
		Customers equalCheck = (Customers) obj;
		if ((customerNumber == null && equalCheck.customerNumber != null) || (customerNumber != null && equalCheck.customerNumber == null))
			return false;
		if (customerNumber != null && !customerNumber.equals(equalCheck.customerNumber))
			return false;
		return true;
	}
}
