/**
 * @author Infosys Ltd.
 */
package com.myRetail.productservice.controller;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;
import org.springframework.web.client.RestTemplate;

import com.myRetail.productservice.exception.ProductServiceException;
import com.myRetail.productservice.model.ProductInfo;
import com.myRetail.productservice.model.SuccessResponse;
import com.myRetail.productservice.service.ProductInfoService;
import com.myRetail.productservice.utils.ServiceTestUtils;


/**
 * @author Infosys Ltd.
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ProductInfoControllerTest {

	@Mock
	private RestTemplate restTemplateMock;
	
	@Autowired
	@InjectMocks
	private ProductInfoController productInfoController;
	
	@Resource
	@Mock
	private ProductInfoService productInfoService;
	
	@Mock
	private BindingResult mockBindingResult;
	
	@Test
	public void testGetProductInfo() throws ProductServiceException{
		ServiceTestUtils serviceTestUtils = new ServiceTestUtils();
		ProductInfo mockResponse = serviceTestUtils.getMockResponseClass("product_info_success.json", ProductInfo.class);
		Mockito.when(productInfoService.fetchProductInfo("16696652"))
				.thenReturn(mockResponse);
		Mockito.when(mockBindingResult.hasErrors()).thenReturn(false);
		ResponseEntity<ProductInfo> respEntity = productInfoController.fetchProductInfo("16696652");
		Assert.assertNotNull(respEntity);
	}
	
	@Test
	public void updateProductInfo() throws ProductServiceException{
		ServiceTestUtils serviceTestUtils = new ServiceTestUtils();
		ProductInfo mockRequest = serviceTestUtils.getMockResponseClass("update_price_request.json", ProductInfo.class);
		String mockResponse = serviceTestUtils.getMockResponseAsString("response_success_status.json");
		Mockito.when(productInfoService.updateProductInfo(mockRequest))
				.thenReturn(mockResponse);
		Mockito.when(mockBindingResult.hasErrors()).thenReturn(false);
		ResponseEntity<SuccessResponse> respEntity = productInfoController.updateProductInfo("16696652", mockRequest, mockBindingResult);
		Assert.assertNotNull(respEntity);
	}

}
