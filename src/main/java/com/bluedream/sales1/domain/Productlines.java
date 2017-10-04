package com.bluedream.sales1.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllProductliness", query = "select myProductlines from Productlines myProductlines"),
		@NamedQuery(name = "findProductlinesByHtmlDescription", query = "select myProductlines from Productlines myProductlines where myProductlines.htmlDescription = ?1"),
		@NamedQuery(name = "findProductlinesByPrimaryKey", query = "select myProductlines from Productlines myProductlines where myProductlines.productLine = ?1"),
		@NamedQuery(name = "findProductlinesByProductLine", query = "select myProductlines from Productlines myProductlines where myProductlines.productLine = ?1"),
		@NamedQuery(name = "findProductlinesByProductLineContaining", query = "select myProductlines from Productlines myProductlines where myProductlines.productLine like ?1"),
		@NamedQuery(name = "findProductlinesByTextDescription", query = "select myProductlines from Productlines myProductlines where myProductlines.textDescription = ?1"),
		@NamedQuery(name = "findProductlinesByTextDescriptionContaining", query = "select myProductlines from Productlines myProductlines where myProductlines.textDescription like ?1") })
@Table(catalog = "classicmodels", name = "productlines")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "ClassicModels15_AJs1/com/bluedream/sales1/domain", name = "Productlines")
@XmlRootElement(namespace = "ClassicModels15_AJs1/com/bluedream/sales1/domain")
public class Productlines implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "productLine", length = 50, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	String productLine;
	/**
	 */

	@Column(name = "textDescription", length = 4000)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String textDescription;
	/**
	 */

	@Column(name = "htmlDescription", columnDefinition = "MEDIUMTEXT")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	String htmlDescription;
	/**
	 */

	@Column(name = "image", columnDefinition = "BLOB")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	byte[] image;

	/**
	 */
	//  TODO - change to LAZY, by HQL 
	// @OneToMany(mappedBy = "productlines", cascade = { CascadeType.REMOVE }, fetch = FetchType.EAGER)
	@OneToMany(mappedBy = "productlines", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.bluedream.sales1.domain.Products> productses;

	/**
	 */
	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	/**
	 */
	public String getProductLine() {
		return this.productLine;
	}

	/**
	 */
	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}

	/**
	 */
	public String getTextDescription() {
		return this.textDescription;
	}

	/**
	 */
	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}

	/**
	 */
	public String getHtmlDescription() {
		return this.htmlDescription;
	}

	/**
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}

	/**
	 */
	public byte[] getImage() {
		return this.image;
	}

	/**
	 */
	public void setProductses(Set<Products> productses) {
		this.productses = productses;
	}

	/**
	 */
	//@JsonIgnore
	public Set<Products> getProductses() {
		if (productses == null) {
			productses = new java.util.LinkedHashSet<com.bluedream.sales1.domain.Products>();
		}
		return productses;
	}

	/**
	 */
	public Productlines() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Productlines that) {
		setProductLine(that.getProductLine());
		setTextDescription(that.getTextDescription());
		setHtmlDescription(that.getHtmlDescription());
		setImage(that.getImage());
		setProductses(new java.util.LinkedHashSet<com.bluedream.sales1.domain.Products>(that.getProductses()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("productLine=[").append(productLine).append("] ");
		buffer.append("textDescription=[").append(textDescription).append("] ");
		buffer.append("htmlDescription=[").append(htmlDescription).append("] ");
		buffer.append("image=[").append(image).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((productLine == null) ? 0 : productLine.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Productlines))
			return false;
		Productlines equalCheck = (Productlines) obj;
		if ((productLine == null && equalCheck.productLine != null) || (productLine != null && equalCheck.productLine == null))
			return false;
		if (productLine != null && !productLine.equals(equalCheck.productLine))
			return false;
		return true;
	}
}
