/**
 * @author Infosys Ltd.
 */
package com.myRetail.productservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Infosys Ltd.
 *
 */
public class ProductDetailsDTO {

	@JsonProperty("product")
	private ProductResponse product;
	public static class ProductResponse {

		@JsonProperty("item")
		private ItemDetailsDTO item;

		/**
		 * @return the item
		 */
		public ItemDetailsDTO getItem() {
			return item;
		}

		/**
		 * @param item the item to set
		 */
		public void setItem(ItemDetailsDTO item) {
			this.item = item;
		}
	}
	/**
	 * @return the product
	 */
	public ProductResponse getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(ProductResponse product) {
		this.product = product;
	}
	
	

}
