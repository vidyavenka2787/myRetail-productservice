/**
 * @author Infosys Ltd.
 */
package com.myRetail.productservice.service.impl;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Optional;

import org.apache.geode.cache.GemFireCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.gemfire.GemfireTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.myRetail.productservice.constants.ProductServiceConstants;
import com.myRetail.productservice.entity.PriceAuditEntry;
import com.myRetail.productservice.entity.PriceDetails;
import com.myRetail.productservice.entity.PriceInfo;
import com.myRetail.productservice.entity.ProductPriceData;
import com.myRetail.productservice.exception.ProductServiceException;
import com.myRetail.productservice.service.GemFireDataService;

/**
 * @author Infosys Ltd.
 *
 */
@Component
public class GemFireDataServiceImpl implements GemFireDataService{
	
	@Autowired
	GemfireTemplate gemfireTemplate;
	
	@Autowired
	GemFireCache cache;

	/* (non-Javadoc)
	 * @see com.myRetail.productservice.service.GemFireDataService#loadProductPrice(com.myRetail.productservice.entity.ProductPriceData)
	 */
	@Override
	public void loadProductPrice(ProductPriceData prdPriceData) throws ProductServiceException{
		prdPriceData.getPrice().stream().filter(Objects::nonNull).forEach(price -> gemfireTemplate.put(price.getPartNumber(), price));		
	}
	
	@Override
	public PriceInfo getProductPrice(String productId){

		PriceDetails prdPriceDetails = gemfireTemplate.get(productId);
		return Optional.ofNullable(prdPriceDetails).orElse(new PriceDetails()).getOfferPrice();
	}

	@Override
	public String updateProductPrice(String prdId, PriceInfo priceInfo, PriceAuditEntry priceAuditEntry) throws ProductServiceException{

		PriceDetails prdPriceDetails = gemfireTemplate.get(prdId);
		Optional.ofNullable(prdPriceDetails).orElseThrow(() -> new  ProductServiceException(HttpStatus.CONFLICT, "Price data not found for this product", 
				"myRetail.err_3001"));
		prdPriceDetails.setOfferPrice(priceInfo);
		gemfireTemplate.put(prdId, prdPriceDetails);
		priceAuditEntry.setAuditId(prdId+"_AUDIT"); 
		ZonedDateTime zonedTimeStamp = ZonedDateTime.now().withZoneSameInstant(ZoneId.of("America/Los_Angeles"));
		priceAuditEntry.setUpdateDate(String.valueOf(zonedTimeStamp));
		gemfireTemplate.put(priceAuditEntry.getAuditId(), priceAuditEntry);
		return ProductServiceConstants.SUCCESS;
	}
}
