/**
 * @author Infosys Ltd.
 */
package com.myRetail.productservice.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myRetail.productservice.constants.ErrorConstants;
import com.myRetail.productservice.constants.ProductServiceConstants;
import com.myRetail.productservice.entity.PriceAuditEntry;
import com.myRetail.productservice.entity.PriceInfo;
import com.myRetail.productservice.exception.ProductServiceBusinessException;
import com.myRetail.productservice.exception.ProductServiceException;
import com.myRetail.productservice.exception.ProductServiceTimeoutException;
import com.myRetail.productservice.model.ProductDetailsDTO;
import com.myRetail.productservice.model.ProductInfo;
import com.myRetail.productservice.model.ProductPriceDetails;
import com.myRetail.productservice.rest.RestClient;
import com.myRetail.productservice.service.GemFireDataService;
import com.myRetail.productservice.service.ProductInfoService;

/**
 * @author Infosys Ltd.
 *
 */
@Component
public class ProductInfoServiceImpl implements ProductInfoService {

	@Autowired
	RestClient restClient;

	@Value("${myRetail.product-info}")
	String productInfoEndpoint;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	GemFireDataService gemFireDataService;

	/* (non-Javadoc)
	 * @see com.target.productservice.service.ProductInfoService#fetchProductInfo(java.lang.String)
	 */
	@Override
	public ProductInfo fetchProductInfo(String productId) throws ProductServiceException {
		Map<String,String> params = new HashMap<>();
		params.put(ProductServiceConstants.URI_PARAM_PRODUCT_ID, productId);
		ProductDetailsDTO productDetailsResponse = null;
		PriceInfo priceInfo = null;
		try{
			productDetailsResponse =
					restClient.invokeExternalService(HttpMethod.GET, null, ProductDetailsDTO.class, productInfoEndpoint, params);
			priceInfo = gemFireDataService.getProductPrice(productId);
		}catch(HttpClientErrorException httpClientExp){
			throw new ProductServiceBusinessException(ErrorConstants.HTTP_CLIENT_ERROR_CODE,ErrorConstants.HTTP_CLIENT_ERROR_MSG);
		}catch(ResourceAccessException ste){
			throw new ProductServiceTimeoutException(ErrorConstants.TIMEOUT_ERR_CODE, ErrorConstants.TIMEOUT_ERR_MSG);
		}

		ProductInfo prdInfoResponse = new ProductInfo();
		constructProductInfoResponse(prdInfoResponse, productDetailsResponse, priceInfo);

		return prdInfoResponse;
	}


	/* (non-Javadoc)
	 * @see com.target.productservice.service.ProductInfoService#fetchProductInfo(java.lang.String)
	 */
	@Override
	public String updateProductInfo(ProductInfo productInfo) throws ProductServiceException {
		PriceInfo priceInfo = null;
		String status = null;
		PriceAuditEntry priceUpdateAudit = new PriceAuditEntry();
		priceUpdateAudit.setUpdateBy(productInfo.getPriceUpdateAudit().getUpdatedBy());
		priceUpdateAudit.setUpdateReason(productInfo.getPriceUpdateAudit().getUpdateReason());
		try{
			priceInfo = constructPriceDetails(productInfo);
			status = gemFireDataService.updateProductPrice(productInfo.getPartNumber(), priceInfo, priceUpdateAudit);
		}catch(ProductServiceException pse){
			throw pse;
		}catch(Exception e){
			throw new ProductServiceException(HttpStatus.INTERNAL_SERVER_ERROR, ErrorConstants.GENERIC_ERR_MSG, ErrorConstants.GENERIC_ERR_CODE);
		}

		return status;
	}

	public List<PriceAuditEntry> getAuditEntries() throws ProductServiceException{
		return gemFireDataService.getAudit();
	}
	private ProductInfo constructProductInfoResponse(ProductInfo prdInfoResponse, 
			ProductDetailsDTO productDetailsResponse, PriceInfo priceInfo){

		Optional<ProductDetailsDTO> prdDetailsResponseOpt = Optional.ofNullable(productDetailsResponse);
		prdDetailsResponseOpt.ifPresent(prdDetails -> {
			prdInfoResponse.setPartNumber(prdDetails.getProduct().getItem().getPartNumber());
			prdInfoResponse.setTitle(prdDetails.getProduct().getItem().getProductDescriptionDetails().getTitle());
		});

		Optional<PriceInfo> priceInfoOpt = Optional.ofNullable(priceInfo);
		priceInfoOpt.ifPresent(priceInfoDetails -> prdInfoResponse.setProductPriceDetails(
				new ProductPriceDetails(priceInfoDetails.getPrice(),"USD")));
		return prdInfoResponse;
	}

	private PriceInfo constructPriceDetails(ProductInfo prdInfoResponse){

		PriceInfo priceInfo = new PriceInfo();
		Optional<ProductInfo> prdInfoOpt = Optional.ofNullable(prdInfoResponse);
		prdInfoOpt.ifPresent(prdInfo -> {
			priceInfo.setPrice(prdInfo.getProductPriceDetails().getPrice());
			priceInfo.setFormattedPrice("$"+prdInfo.getProductPriceDetails().getPrice());
		});
		return priceInfo;
	}
}
