/**
 * @author Infosys Ltd.
 */
package com.myRetail.productservice.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myRetail.productservice.constants.ErrorConstants;
import com.myRetail.productservice.exception.ProductServiceException;
import com.myRetail.productservice.model.ErrorDetails;
import com.myRetail.productservice.model.ErrorResponse;
import com.myRetail.productservice.model.ProductInfo;
import com.myRetail.productservice.model.SuccessResponse;
import com.myRetail.productservice.service.ProductInfoService;

/**
 * @author Infosys Ltd.
 *
 */
@Controller
public class ProductInfoController {

	@Autowired
	ProductInfoService productInfoService;

	@RequestMapping(path="/products/{product-id}", method=RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ProductInfo> fetchProductInfo(@PathVariable(required=true, name="product-id") String productId) 
			throws ProductServiceException{
		ProductInfo productDetailsResponse = productInfoService.fetchProductInfo(productId);
		return new ResponseEntity<ProductInfo>(productDetailsResponse, HttpStatus.OK);
	}

	@RequestMapping(path="/products/{product-id}", method=RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<SuccessResponse> updateProductInfo(@PathVariable(required=true, name="product-id") String productId,
			@RequestBody @Valid ProductInfo productInfo, BindingResult bindingResult) 
					throws ProductServiceException{
		if(bindingResult.hasErrors()){
			List<ErrorDetails> errorRspList = new ArrayList<ErrorDetails>();
			bindingResult.getAllErrors().forEach(objError -> {
				ErrorDetails errorRsp = new ErrorDetails();
				errorRsp.setCode(ErrorConstants.MISSING_FIELD_CODE);
				errorRsp.setMessage(objError.getDefaultMessage());
				errorRspList.add(errorRsp);	
			});
			throw new ProductServiceException(HttpStatus.BAD_REQUEST, errorRspList);
		}
		String status = productInfoService.updateProductInfo(productInfo);
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(status), HttpStatus.OK);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(final Exception e){

		List<ErrorDetails> errorDetailsList = null;
		ErrorResponse errorRsp = new ErrorResponse();
		ProductServiceException prdServiceException = null;
		if(e instanceof ProductServiceException){
			prdServiceException = (ProductServiceException) e;
			if(CollectionUtils.isNotEmpty(prdServiceException.getErrorResponseList())) {
				errorDetailsList = prdServiceException.getErrorResponseList();
				errorRsp.setErrorRsp(errorDetailsList);
			}else{
				errorDetailsList = new ArrayList<>();
				ErrorDetails errorDetails = new ErrorDetails();
				errorDetails.setCode(prdServiceException.getCode());
				errorDetails.setMessage(prdServiceException.getMsg());
				errorDetailsList.add(errorDetails);
			}			
		}else{
			errorDetailsList = new ArrayList<>();
			ErrorDetails errorDetails = new ErrorDetails();
			errorDetails.setCode(ErrorConstants.GENERIC_ERR_CODE);
			errorDetails.setMessage(ErrorConstants.GENERIC_ERR_MSG);
			errorDetailsList.add(errorDetails);
		}
		errorRsp.setErrorRsp(errorDetailsList);	
		return new ResponseEntity<ErrorResponse>(errorRsp, prdServiceException != null ? prdServiceException.getStatus() : HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
