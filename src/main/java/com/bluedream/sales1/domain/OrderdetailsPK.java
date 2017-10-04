package com.bluedream.sales1.domain;

import java.io.Serializable;

import javax.persistence.Id;

import javax.persistence.*;

/**
 */
public class OrderdetailsPK implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */
	public OrderdetailsPK() {
	}

	/**
	 */

	@Column(name = "orderNumber", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	public Integer orderNumber;
	/**
	 */

	@Column(name = "productCode", length = 15, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	public String productCode;

	/**
	 */
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 */
	public Integer getOrderNumber() {
		return this.orderNumber;
	}

	/**
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 */
	public String getProductCode() {
		return this.productCode;
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode()));
		result = (int) (prime * result + ((productCode == null) ? 0 : productCode.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof OrderdetailsPK))
			return false;
		OrderdetailsPK equalCheck = (OrderdetailsPK) obj;
		if ((orderNumber == null && equalCheck.orderNumber != null) || (orderNumber != null && equalCheck.orderNumber == null))
			return false;
		if (orderNumber != null && !orderNumber.equals(equalCheck.orderNumber))
			return false;
		if ((productCode == null && equalCheck.productCode != null) || (productCode != null && equalCheck.productCode == null))
			return false;
		if (productCode != null && !productCode.equals(equalCheck.productCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("OrderdetailsPK");
		sb.append(" orderNumber: ").append(getOrderNumber());
		sb.append(" productCode: ").append(getProductCode());
		return sb.toString();
	}
}
