package com.bluedream.sales1.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.math.BigDecimal;

import java.util.Set;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 */
@IdClass(com.bluedream.sales1.domain.OrderdetailsPK.class)
@Entity
@NamedQueries({
		@NamedQuery(name = "findAllOrderdetailss", query = "select myOrderdetails from Orderdetails myOrderdetails"),
		@NamedQuery(name = "findOrderdetailsByPrimaryKey", query = "select myOrderdetails from Orderdetails myOrderdetails where myOrderdetails.orderNumber = ?1 and myOrderdetails.productCode = ?2") })
@Table(catalog = "classicmodels", name = "orderdetails")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "ClassicModels15_AJs1/com/bluedream/sales1/domain", name = "Orderdetails")
public class Orderdetails implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "orderNumber", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer orderNumber;
	/**
	 */

	@Column(name = "productCode", length = 15, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	String productCode;
	/**
	 */

	@Column(name = "quantityOrdered", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer quantityOrdered;
	/**
	 */

	@Column(name = "priceEach", precision = 22, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal priceEach;
	/**
	 */

	@Column(name = "orderLineNumber", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer orderLineNumber;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	// @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "orderNumber", referencedColumnName = "orderNumber", nullable = false, insertable = false, updatable = false) })
	@XmlTransient
	Orders orders;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	// @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "productCode", referencedColumnName = "productCode", nullable = false, insertable = false, updatable = false) })
	@XmlTransient
	Products products;

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
	public void setQuantityOrdered(Integer quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	/**
	 */
	public Integer getQuantityOrdered() {
		return this.quantityOrdered;
	}

	/**
	 */
	public void setPriceEach(BigDecimal priceEach) {
		this.priceEach = priceEach;
	}

	/**
	 */
	public BigDecimal getPriceEach() {
		return this.priceEach;
	}

	/**
	 */
	public void setOrderLineNumber(Integer orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}

	/**
	 */
	public Integer getOrderLineNumber() {
		return this.orderLineNumber;
	}

	/**
	 */
	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	/**
	 */
	@JsonIgnore
	public Orders getOrders() {
		return orders;
	}

	/**
	 */
	public void setProducts(Products products) {
		this.products = products;
	}

	/**
	 */
	@JsonIgnore
	public Products getProducts() {
		return products;
	}

	/**
	 */
	public Orderdetails() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Orderdetails that) {
		setOrderNumber(that.getOrderNumber());
		setProductCode(that.getProductCode());
		setQuantityOrdered(that.getQuantityOrdered());
		setPriceEach(that.getPriceEach());
		setOrderLineNumber(that.getOrderLineNumber());
		setOrders(that.getOrders());
		setProducts(that.getProducts());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("orderNumber=[").append(orderNumber).append("] ");
		buffer.append("productCode=[").append(productCode).append("] ");
		buffer.append("quantityOrdered=[").append(quantityOrdered).append("] ");
		buffer.append("priceEach=[").append(priceEach).append("] ");
		buffer.append("orderLineNumber=[").append(orderLineNumber).append("] ");

		return buffer.toString();
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
		if (!(obj instanceof Orderdetails))
			return false;
		Orderdetails equalCheck = (Orderdetails) obj;
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
}
