/**
 * @author Infosys Ltd.
 */
package com.myRetail.productservice.model;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Infosys Ltd.
 *
 */
public class ProductPriceDetails {
	
	@JsonProperty("value")
	//@NotEmpty(message="Missing field price")
	//@Size(max=2,message="Ordinality exceeded the limit, Max. 2 numbers are allowed.")
	private BigDecimal price;
	
	@JsonProperty("currency_code")
	@NotBlank(message="Missing field currency")
	private String currency;
	
	public ProductPriceDetails(BigDecimal price, String currency){
		this.price = price;
		this.currency = currency;
	}
	
	public ProductPriceDetails(){
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
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	

}
