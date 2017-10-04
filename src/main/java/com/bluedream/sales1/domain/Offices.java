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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllOfficess", query = "select myOffices from Offices myOffices"),
		@NamedQuery(name = "findOfficesByAddressLine1", query = "select myOffices from Offices myOffices where myOffices.addressLine1 = ?1"),
		@NamedQuery(name = "findOfficesByAddressLine1Containing", query = "select myOffices from Offices myOffices where myOffices.addressLine1 like ?1"),
		@NamedQuery(name = "findOfficesByAddressLine2", query = "select myOffices from Offices myOffices where myOffices.addressLine2 = ?1"),
		@NamedQuery(name = "findOfficesByAddressLine2Containing", query = "select myOffices from Offices myOffices where myOffices.addressLine2 like ?1"),
		@NamedQuery(name = "findOfficesByCity", query = "select myOffices from Offices myOffices where myOffices.city = ?1"),
		@NamedQuery(name = "findOfficesByCityContaining", query = "select myOffices from Offices myOffices where myOffices.city like ?1"),
		@NamedQuery(name = "findOfficesByCountry", query = "select myOffices from Offices myOffices where myOffices.country = ?1"),
		@NamedQuery(name = "findOfficesByCountryContaining", query = "select myOffices from Offices myOffices where myOffices.country like ?1"),
		@NamedQuery(name = "findOfficesByOfficeCode", query = "select myOffices from Offices myOffices where myOffices.officeCode = ?1"),
		@NamedQuery(name = "findOfficesByOfficeCodeContaining", query = "select myOffices from Offices myOffices where myOffices.officeCode like ?1"),
		@NamedQuery(name = "findOfficesByPhone", query = "select myOffices from Offices myOffices where myOffices.phone = ?1"),
		@NamedQuery(name = "findOfficesByPhoneContaining", query = "select myOffices from Offices myOffices where myOffices.phone like ?1"),
		@NamedQuery(name = "findOfficesByPostalCode", query = "select myOffices from Offices myOffices where myOffices.postalCode = ?1"),
		@NamedQuery(name = "findOfficesByPostalCodeContaining", query = "select myOffices from Offices myOffices where myOffices.postalCode like ?1"),
		@NamedQuery(name = "findOfficesByPrimaryKey", query = "select myOffices from Offices myOffices where myOffices.officeCode = ?1"),
		@NamedQuery(name = "findOfficesByState", query = "select myOffices from Offices myOffices where myOffices.state = ?1"),
		@NamedQuery(name = "findOfficesByStateContaining", query = "select myOffices from Offices myOffices where myOffices.state like ?1"),
		@NamedQuery(name = "findOfficesByTerritory", query = "select myOffices from Offices myOffices where myOffices.territory = ?1"),
		@NamedQuery(name = "findOfficesByTerritoryContaining", query = "select myOffices from Offices myOffices where myOffices.territory like ?1") })
@Table(catalog = "classicmodels", name = "offices")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "ClassicModels15_AJs1/com/bluedream/sales1/domain", name = "Offices")
@XmlRootElement(namespace = "ClassicModels15_AJs1/com/bluedream/sales1/domain")
public class Offices implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "officeCode", length = 10, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	String officeCode;
	/**
	 */

	@Column(name = "city", length = 50, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String city;
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

	@Column(name = "state", length = 50)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String state;
	/**
	 */

	@Column(name = "country", length = 50, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String country;
	/**
	 */

	@Column(name = "postalCode", length = 15, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String postalCode;
	/**
	 */

	@Column(name = "territory", length = 10, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String territory;

	/**
	 */
	@OneToMany(mappedBy = "offices", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.bluedream.sales1.domain.Employees> employeeses;

	/**
	 */
	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	/**
	 */
	public String getOfficeCode() {
		return this.officeCode;
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
	public void setTerritory(String territory) {
		this.territory = territory;
	}

	/**
	 */
	public String getTerritory() {
		return this.territory;
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
	public Offices() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Offices that) {
		setOfficeCode(that.getOfficeCode());
		setCity(that.getCity());
		setPhone(that.getPhone());
		setAddressLine1(that.getAddressLine1());
		setAddressLine2(that.getAddressLine2());
		setState(that.getState());
		setCountry(that.getCountry());
		setPostalCode(that.getPostalCode());
		setTerritory(that.getTerritory());
		setEmployeeses(new java.util.LinkedHashSet<com.bluedream.sales1.domain.Employees>(that.getEmployeeses()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("officeCode=[").append(officeCode).append("] ");
		buffer.append("city=[").append(city).append("] ");
		buffer.append("phone=[").append(phone).append("] ");
		buffer.append("addressLine1=[").append(addressLine1).append("] ");
		buffer.append("addressLine2=[").append(addressLine2).append("] ");
		buffer.append("state=[").append(state).append("] ");
		buffer.append("country=[").append(country).append("] ");
		buffer.append("postalCode=[").append(postalCode).append("] ");
		buffer.append("territory=[").append(territory).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((officeCode == null) ? 0 : officeCode.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Offices))
			return false;
		Offices equalCheck = (Offices) obj;
		if ((officeCode == null && equalCheck.officeCode != null) || (officeCode != null && equalCheck.officeCode == null))
			return false;
		if (officeCode != null && !officeCode.equals(equalCheck.officeCode))
			return false;
		return true;
	}
}
