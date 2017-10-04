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

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllProductss", query = "select myProducts from Products myProducts"),
		@NamedQuery(name = "findProductsByPrimaryKey", query = "select myProducts from Products myProducts where myProducts.productCode = ?1") })
@Table(catalog = "classicmodels", name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "ClassicModels15_AJs1/com/bluedream/sales1/domain", name = "Products")
@XmlRootElement(namespace = "ClassicModels15_AJs1/com/bluedream/sales1/domain")
public class Products implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "productCode", length = 15, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	String productCode;
	/**
	 */

	@Column(name = "productName", length = 70, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String productName;
	/**
	 */

	@Column(name = "productScale", length = 10, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String productScale;
	/**
	 */

	@Column(name = "productVendor", length = 50, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String productVendor;
	/**
	 */

	@Column(name = "productDescription", nullable = false, columnDefinition = "TEXT")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	String productDescription;
	/**
	 */

	@Column(name = "quantityInStock", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer quantityInStock;
	/**
	 */

	@Column(name = "buyPrice", precision = 22, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal buyPrice;
	/**
	 */

	@Column(name = "MSRP", precision = 22, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal msrp;

	/**
	 */
	// @ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "productLine", referencedColumnName = "productLine", nullable = false) })
	@XmlTransient
	Productlines productlines;
	/**
	 */
	@OneToMany(mappedBy = "products", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.bluedream.sales1.domain.Orderdetails> orderdetailses;

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
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 */
	public String getProductName() {
		return this.productName;
	}

	/**
	 */
	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}

	/**
	 */
	public String getProductScale() {
		return this.productScale;
	}

	/**
	 */
	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}

	/**
	 */
	public String getProductVendor() {
		return this.productVendor;
	}

	/**
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	/**
	 */
	public String getProductDescription() {
		return this.productDescription;
	}

	/**
	 */
	public void setQuantityInStock(Integer quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	/**
	 */
	public Integer getQuantityInStock() {
		return this.quantityInStock;
	}

	/**
	 */
	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}

	/**
	 */
	public BigDecimal getBuyPrice() {
		return this.buyPrice;
	}

	/**
	 */
	public void setMsrp(BigDecimal msrp) {
		this.msrp = msrp;
	}

	/**
	 */
	public BigDecimal getMsrp() {
		return this.msrp;
	}

	/**
	 */
	public void setProductlines(Productlines productlines) {
		this.productlines = productlines;
	}

	/**
	 */
	public Productlines getProductlines() {
		return productlines;
	}

	/**
	 */
	public void setOrderdetailses(Set<Orderdetails> orderdetailses) {
		this.orderdetailses = orderdetailses;
	}

	/**
	 */
	public Set<Orderdetails> getOrderdetailses() {
		if (orderdetailses == null) {
			orderdetailses = new java.util.LinkedHashSet<com.bluedream.sales1.domain.Orderdetails>();
		}
		return orderdetailses;
	}

	/**
	 */
	public Products() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Products that) {
		setProductCode(that.getProductCode());
		setProductName(that.getProductName());
		setProductScale(that.getProductScale());
		setProductVendor(that.getProductVendor());
		setProductDescription(that.getProductDescription());
		setQuantityInStock(that.getQuantityInStock());
		setBuyPrice(that.getBuyPrice());
		setMsrp(that.getMsrp());
		setProductlines(that.getProductlines());
		setOrderdetailses(new java.util.LinkedHashSet<com.bluedream.sales1.domain.Orderdetails>(that.getOrderdetailses()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("productCode=[").append(productCode).append("] ");
		buffer.append("productName=[").append(productName).append("] ");
		buffer.append("productScale=[").append(productScale).append("] ");
		buffer.append("productVendor=[").append(productVendor).append("] ");
		buffer.append("productDescription=[").append(productDescription).append("] ");
		buffer.append("quantityInStock=[").append(quantityInStock).append("] ");
		buffer.append("buyPrice=[").append(buyPrice).append("] ");
		buffer.append("msrp=[").append(msrp).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((productCode == null) ? 0 : productCode.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Products))
			return false;
		Products equalCheck = (Products) obj;
		if ((productCode == null && equalCheck.productCode != null) || (productCode != null && equalCheck.productCode == null))
			return false;
		if (productCode != null && !productCode.equals(equalCheck.productCode))
			return false;
		return true;
	}
}
