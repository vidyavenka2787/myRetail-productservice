/**
 * @author Infosys Ltd.
 */
package com.myRetail.productservice.service;

import java.util.List;

import com.myRetail.productservice.entity.PriceAuditEntry;
import com.myRetail.productservice.exception.ProductServiceException;
import com.myRetail.productservice.model.ProductInfo;

/**
 * @author Infosys Ltd.
 *
 */
public interface ProductInfoService {
	
	public ProductInfo fetchProductInfo(String productId) throws ProductServiceException;
	public String updateProductInfo(ProductInfo productInfo) throws ProductServiceException;
	public List<PriceAuditEntry> getAuditEntries() throws ProductServiceException;

}
