package com.bluedream.sales1.domain;

import java.io.Serializable;

import javax.persistence.Id;

import javax.persistence.*;

/**
 */
public class PaymentsPK implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */
	public PaymentsPK() {
	}

	/**
	 */

	@Column(name = "customerNumber", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	public Integer customerNumber;
	/**
	 */

	@Column(name = "checkNumber", length = 50, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	public String checkNumber;

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
		if (!(obj instanceof PaymentsPK))
			return false;
		PaymentsPK equalCheck = (PaymentsPK) obj;
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("PaymentsPK");
		sb.append(" customerNumber: ").append(getCustomerNumber());
		sb.append(" checkNumber: ").append(getCheckNumber());
		return sb.toString();
	}
}
