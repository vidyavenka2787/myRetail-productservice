/**
 * @author Infosys Ltd.
 */
package com.myRetail.productservice.entity;

import java.math.BigDecimal;

/**
 * @author Infosys Ltd.
 *
 */
public class PriceInfo {
	
	private String minPrice;
	private String maxPrice;
	private BigDecimal price;
	private String formattedPrice;
	private String priceType;
	private String saveDollar;
	private String savePercent;
	/**
	 * @return the minPrice
	 */
	public String getMinPrice() {
		return minPrice;
	}
	/**
	 * @param minPrice the minPrice to set
	 */
	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}
	/**
	 * @return the maxPrice
	 */
	public String getMaxPrice() {
		return maxPrice;
	}
	/**
	 * @param maxPrice the maxPrice to set
	 */
	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}
	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * @return the formattedPrice
	 */
	public String getFormattedPrice() {
		return formattedPrice;
	}
	/**
	 * @param formattedPrice the formattedPrice to set
	 */
	public void setFormattedPrice(String formattedPrice) {
		this.formattedPrice = formattedPrice;
	}
	/**
	 * @return the priceType
	 */
	public String getPriceType() {
		return priceType;
	}
	/**
	 * @param priceType the priceType to set
	 */
	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}
	/**
	 * @return the saveDollar
	 */
	public String getSaveDollar() {
		return saveDollar;
	}
	/**
	 * @param saveDollar the saveDollar to set
	 */
	public void setSaveDollar(String saveDollar) {
		this.saveDollar = saveDollar;
	}
	/**
	 * @return the savePercent
	 */
	public String getSavePercent() {
		return savePercent;
	}
	/**
	 * @param savePercent the savePercent to set
	 */
	public void setSavePercent(String savePercent) {
		this.savePercent = savePercent;
	}
	
}
