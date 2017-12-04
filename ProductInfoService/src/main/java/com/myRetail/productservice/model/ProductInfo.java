/**
 * @author Infosys Ltd.
 */
package com.myRetail.productservice.model;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Infosys Ltd.
 *
 */
public class ProductInfo {
	
	@JsonProperty("id")
	@NotBlank(message="Missing part number")
	private String partNumber;
	
	@JsonProperty("name")
	private String title;
	
	@JsonProperty("current_price")
	//@Valid
	private ProductPriceDetails productPriceDetails;
	
	@JsonProperty("auditInfo")
	@Valid
	private PriceUpdateAudit priceUpdateAudit;
	
	/**
	 * @return the partNumber
	 */
	public String getPartNumber() {
		return partNumber;
	}
	/**
	 * @param partNumber the partNumber to set
	 */
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the productPriceDetails
	 */
	public ProductPriceDetails getProductPriceDetails() {
		return productPriceDetails;
	}
	/**
	 * @param productPriceDetails the productPriceDetails to set
	 */
	public void setProductPriceDetails(ProductPriceDetails productPriceDetails) {
		this.productPriceDetails = productPriceDetails;
	}
	/**
	 * @return the priceUpdateAudit
	 */
	public PriceUpdateAudit getPriceUpdateAudit() {
		return priceUpdateAudit;
	}
	/**
	 * @param priceUpdateAudit the priceUpdateAudit to set
	 */
	public void setPriceUpdateAudit(PriceUpdateAudit priceUpdateAudit) {
		this.priceUpdateAudit = priceUpdateAudit;
	}
	

}
