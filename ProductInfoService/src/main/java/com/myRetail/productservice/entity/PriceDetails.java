/**
 * @author Infosys Ltd.
 */
package com.myRetail.productservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.config.annotation.EnablePdx;

/**
 * @author Infosys Ltd.
 *
 */
@EnablePdx
public class PriceDetails {
	
	private PriceInfo listPrice;
	private PriceInfo offerPrice;
	@Id
	private String partNumber;
	private String mapPriceFlag;
	/**
	 * @return the listPrice
	 */
	public PriceInfo getListPrice() {
		return listPrice;
	}
	/**
	 * @param listPrice the listPrice to set
	 */
	public void setListPrice(PriceInfo listPrice) {
		this.listPrice = listPrice;
	}
	/**
	 * @return the offerPrice
	 */
	public PriceInfo getOfferPrice() {
		return offerPrice;
	}
	/**
	 * @param offerPrice the offerPrice to set
	 */
	public void setOfferPrice(PriceInfo offerPrice) {
		this.offerPrice = offerPrice;
	}
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
	 * @return the mapPriceFlag
	 */
	public String getMapPriceFlag() {
		return mapPriceFlag;
	}
	/**
	 * @param mapPriceFlag the mapPriceFlag to set
	 */
	public void setMapPriceFlag(String mapPriceFlag) {
		this.mapPriceFlag = mapPriceFlag;
	}

}
