/**
 * @author Infosys Ltd.
 */
package com.myRetail.productservice.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Infosys Ltd.
 *
 */
@Component
public class RestClient {

	@Autowired
	RestTemplate restTemplate;

	public <B,T> T invokeExternalService(final HttpMethod method, final B requestBody, 
			final Class<T> responseClassType,final String endPointUrl, 
			final Map<String, String> params){

		HttpEntity<B> requestEntity = new HttpEntity<B>(requestBody);
		ResponseEntity<T> responseEntity = restTemplate.exchange(endPointUrl, method, requestEntity, responseClassType, params);
		return responseEntity.getBody();
	}
}


