package com.bluedream.sales1.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */
@IdClass(com.bluedream.sales1.domain.PaymentsPK.class)
@Entity
@NamedQueries({
		@NamedQuery(name = "findAllPaymentss", query = "select myPayments from Payments myPayments"),
		@NamedQuery(name = "findPaymentsByPrimaryKey", query = "select myPayments from Payments myPayments where myPayments.customerNumber = ?1 and myPayments.checkNumber = ?2") })
@Table(catalog = "classicmodels", name = "payments")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "ClassicModels15_AJs1/com/bluedream/sales1/domain", name = "Payments")
public class Payments implements Serializable {
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

	@Column(name = "checkNumber", length = 50, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	String checkNumber;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "paymentDate", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar paymentDate;
	/**
	 */

	@Column(name = "amount", precision = 22, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal amount;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "customerNumber", referencedColumnName = "customerNumber", nullable = false, insertable = false, updatable = false) })
	@XmlTransient
	Customers customers;

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
	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	/**
	 */
	public String getCheckNumber() {
		return this.checkNumber;
	}

	/**
	 */
	public void setPaymentDate(Calendar paymentDate) {
		this.paymentDate = paymentDate;
	}

	/**
	 */
	public Calendar getPaymentDate() {
		return this.paymentDate;
	}

	/**
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 */
	public BigDecimal getAmount() {
		return this.amount;
	}

	/**
	 */
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	/**
	 */
	public Customers getCustomers() {
		return customers;
	}

	/**
	 */
	public Payments() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Payments that) {
		setCustomerNumber(that.getCustomerNumber());
		setCheckNumber(that.getCheckNumber());
		setPaymentDate(that.getPaymentDate());
		setAmount(that.getAmount());
		setCustomers(that.getCustomers());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("customerNumber=[").append(customerNumber).append("] ");
		buffer.append("checkNumber=[").append(checkNumber).append("] ");
		buffer.append("paymentDate=[").append(paymentDate).append("] ");
		buffer.append("amount=[").append(amount).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((customerNumber == null) ? 0 : customerNumber.hashCode()));
		result = (int) (prime * result + ((checkNumber == null) ? 0 : checkNumber.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Payments))
			return false;
		Payments equalCheck = (Payments) obj;
		if ((customerNumber == null && equalCheck.customerNumber != null) || (customerNumber != null && equalCheck.customerNumber == null))
			return false;
		if (customerNumber != null && !customerNumber.equals(equalCheck.customerNumber))
			return false;
		if ((checkNumber == null && equalCheck.checkNumber != null) || (checkNumber != null && equalCheck.checkNumber == null))
			return false;
		if (checkNumber != null && !checkNumber.equals(equalCheck.checkNumber))
			return false;
		return true;
	}
}
