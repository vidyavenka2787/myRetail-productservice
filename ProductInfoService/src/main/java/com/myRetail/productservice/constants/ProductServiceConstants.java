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
    public static String AUDIT_QUERY = "SELECT * FROM /PRODUCTDATAREGION region WHERE region.auditId like '%AUDIT'";
}
