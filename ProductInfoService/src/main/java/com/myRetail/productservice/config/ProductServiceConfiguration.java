/**
 * @author Infosys Ltd.
 */
package com.myRetail.productservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author Infosys Ltd.
 *
 */
@Configuration
public class ProductServiceConfiguration {


	@Value("${myRetail.read-timeout}")
	int readTimeout;
	
	@Value("${myRetail.connection-timeout}")
	int connectionTimeout;
	/**
	 * Rest template.
	 *
	 * @return the rest template
	 */
	@Bean
	@Primary
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		SimpleClientHttpRequestFactory rf =
			    (SimpleClientHttpRequestFactory) restTemplate.getRequestFactory();
			rf.setReadTimeout(readTimeout);
			rf.setConnectTimeout(connectionTimeout);
		return restTemplate;
	}
}
