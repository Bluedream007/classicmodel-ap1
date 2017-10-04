package com.bluedream.sales1.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllOrderss", query = "select myOrders from Orders myOrders"),
		@NamedQuery(name = "findOrdersByComments", query = "select myOrders from Orders myOrders where myOrders.comments = ?1"),
		@NamedQuery(name = "findOrdersByOrderDate", query = "select myOrders from Orders myOrders where myOrders.orderDate = ?1"),
		@NamedQuery(name = "findOrdersByOrderDateAfter", query = "select myOrders from Orders myOrders where myOrders.orderDate > ?1"),
		@NamedQuery(name = "findOrdersByOrderDateBefore", query = "select myOrders from Orders myOrders where myOrders.orderDate < ?1"),
		@NamedQuery(name = "findOrdersByOrderNumber", query = "select myOrders from Orders myOrders where myOrders.orderNumber = ?1"),
		@NamedQuery(name = "findOrdersByPrimaryKey", query = "select myOrders from Orders myOrders where myOrders.orderNumber = ?1"),
		@NamedQuery(name = "findOrdersByRequiredDate", query = "select myOrders from Orders myOrders where myOrders.requiredDate = ?1"),
		@NamedQuery(name = "findOrdersByRequiredDateAfter", query = "select myOrders from Orders myOrders where myOrders.requiredDate > ?1"),
		@NamedQuery(name = "findOrdersByRequiredDateBefore", query = "select myOrders from Orders myOrders where myOrders.requiredDate < ?1"),
		@NamedQuery(name = "findOrdersByShippedDate", query = "select myOrders from Orders myOrders where myOrders.shippedDate = ?1"),
		@NamedQuery(name = "findOrdersByShippedDateAfter", query = "select myOrders from Orders myOrders where myOrders.shippedDate > ?1"),
		@NamedQuery(name = "findOrdersByShippedDateBefore", query = "select myOrders from Orders myOrders where myOrders.shippedDate < ?1"),
		@NamedQuery(name = "findOrdersByStatus", query = "select myOrders from Orders myOrders where myOrders.status = ?1"),
		@NamedQuery(name = "findOrdersByStatusContaining", query = "select myOrders from Orders myOrders where myOrders.status like ?1") })
@Table(catalog = "classicmodels", name = "orders")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "ClassicModels15_AJs1/com/bluedream/sales1/domain", name = "Orders")
@XmlRootElement(namespace = "ClassicModels15_AJs1/com/bluedream/sales1/domain")
public class Orders implements Serializable {
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
	@Temporal(TemporalType.DATE)
	@Column(name = "orderDate", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar orderDate;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "requiredDate", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar requiredDate;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "shippedDate")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar shippedDate;
	/**
	 */

	@Column(name = "status", length = 15, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String status;
	/**
	 */

	@Column(name = "comments", columnDefinition = "TEXT")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	String comments;

	/**	 
	 */
	// @ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "customerNumber", referencedColumnName = "customerNumber", nullable = false) })
	@XmlTransient
	Customers customers;
	/**
	 */
	@OneToMany(mappedBy = "orders", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.bluedream.sales1.domain.Orderdetails> orderdetailses;

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
	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 */
	public Calendar getOrderDate() {
		return this.orderDate;
	}

	/**
	 */
	public void setRequiredDate(Calendar requiredDate) {
		this.requiredDate = requiredDate;
	}

	/**
	 */
	public Calendar getRequiredDate() {
		return this.requiredDate;
	}

	/**
	 */
	public void setShippedDate(Calendar shippedDate) {
		this.shippedDate = shippedDate;
	}

	/**
	 */
	public Calendar getShippedDate() {
		return this.shippedDate;
	}

	/**
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 */
	public String getComments() {
		return this.comments;
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
	public void setOrderdetailses(Set<Orderdetails> orderdetailses) {
		this.orderdetailses = orderdetailses;
	}

	/**
	 */
	@JsonIgnore
	public Set<Orderdetails> getOrderdetailses() {
		if (orderdetailses == null) {
			orderdetailses = new java.util.LinkedHashSet<com.bluedream.sales1.domain.Orderdetails>();
		}
		return orderdetailses;
	}

	/**
	 */
	public Orders() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Orders that) {
		setOrderNumber(that.getOrderNumber());
		setOrderDate(that.getOrderDate());
		setRequiredDate(that.getRequiredDate());
		setShippedDate(that.getShippedDate());
		setStatus(that.getStatus());
		setComments(that.getComments());
		setCustomers(that.getCustomers());
		setOrderdetailses(new java.util.LinkedHashSet<com.bluedream.sales1.domain.Orderdetails>(that.getOrderdetailses()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("orderNumber=[").append(orderNumber).append("] ");
		buffer.append("orderDate=[").append(orderDate).append("] ");
		buffer.append("requiredDate=[").append(requiredDate).append("] ");
		buffer.append("shippedDate=[").append(shippedDate).append("] ");
		buffer.append("status=[").append(status).append("] ");
		buffer.append("comments=[").append(comments).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Orders))
			return false;
		Orders equalCheck = (Orders) obj;
		if ((orderNumber == null && equalCheck.orderNumber != null) || (orderNumber != null && equalCheck.orderNumber == null))
			return false;
		if (orderNumber != null && !orderNumber.equals(equalCheck.orderNumber))
			return false;
		return true;
	}
}
