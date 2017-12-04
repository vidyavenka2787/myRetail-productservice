/**
 * @author Infosys Ltd.
 */
package com.myRetail.productservice.constants;

/**
 * @author Infosys Ltd.
 *
 */
public class ProductServiceConstants {

	public static String SUCCESS = "success";
	//URI param keys
	public static String URI_PARAM_PRODUCT_ID = "product-id";
	
	//GEMFIRE OQL QUERIES
	public static String PRODUCT_PRICE_PKey = "PRD_PRICE_DATA";
	public static String PRODUCT_PRICE_QUERY = "SELECT offerPrice FROM /PRODUCTDATAREGION prdRegion "
			+ "WHERE prdRegion.id='PRD_PRICE_DATA' and partNumber=$1";
	public static String UPDATE_PRICE_QUERY = "UPDATE offerPrice FROM /PRODUCTDATAREGION prdRegion, prdRegion.price priceEntries, priceEntries.offerPrice offerPrice "
			+ "WHERE prdRegion.id='PRD_PRICE_DATA' and priceEntries.partNumber=$1";
}
