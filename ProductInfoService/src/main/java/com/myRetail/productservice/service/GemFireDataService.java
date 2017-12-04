/**
 * @author Infosys Ltd.
 */
package com.myRetail.productservice.service;

import org.springframework.stereotype.Component;

import com.myRetail.productservice.entity.PriceAuditEntry;
import com.myRetail.productservice.entity.PriceInfo;
import com.myRetail.productservice.entity.ProductPriceData;
import com.myRetail.productservice.exception.ProductServiceException;

/**
 * @author Infosys Ltd.
 *
 */
@Component
public interface GemFireDataService {
	
	public void loadProductPrice(ProductPriceData prdPriceData) 
			throws ProductServiceException;
	public PriceInfo getProductPrice(String productId) 
			throws ProductServiceException;
	public String updateProductPrice(String prdId, PriceInfo priceInfo, PriceAuditEntry priceAuditEntry) 
			throws ProductServiceException;
	

}
