/**
 * @author Infosys Ltd.
 */
package com.myRetail.productservice.entity;

import java.util.ArrayList;

/**
 * @author Infosys Ltd.
 *
 */

public class ProductPriceData {
	
	private ArrayList<PriceDetails> price;
	/**
	 * @return the price
	 */
	public ArrayList<PriceDetails> getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(ArrayList<PriceDetails> price) {
		this.price = price;
	}
	
}
