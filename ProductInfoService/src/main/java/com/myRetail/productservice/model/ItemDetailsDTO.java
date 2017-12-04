/**
 * @author Infosys Ltd.
 */
package com.myRetail.productservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Infosys Ltd.
 *
 */
public class ItemDetailsDTO {
	
	@JsonProperty("tcin")
	private String partNumber;
	
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
	 * @return the productDescriptionDetails
	 */
	public ProductDescriptionDetails getProductDescriptionDetails() {
		return productDescriptionDetails;
	}

	/**
	 * @param productDescriptionDetails the productDescriptionDetails to set
	 */
	public void setProductDescriptionDetails(ProductDescriptionDetails productDescriptionDetails) {
		this.productDescriptionDetails = productDescriptionDetails;
	}

	@JsonProperty("product_description")
	private ProductDescriptionDetails productDescriptionDetails;

	public static class ProductDescriptionDetails {
		
		private String title;
		private String general_description;
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
		 * @return the general_description
		 */
		public String getGeneral_description() {
			return general_description;
		}
		/**
		 * @param general_description the general_description to set
		 */
		public void setGeneral_description(String general_description) {
			this.general_description = general_description;
		}
		
		

	}
}
