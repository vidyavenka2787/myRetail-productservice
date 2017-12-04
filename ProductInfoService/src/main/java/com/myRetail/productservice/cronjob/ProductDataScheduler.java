/**
 * @author Infosys Ltd.
 */
package com.myRetail.productservice.cronjob;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myRetail.productservice.entity.ProductPriceData;
import com.myRetail.productservice.exception.ProductServiceException;
import com.myRetail.productservice.service.GemFireDataService;

/**
 * @author Infosys Ltd.
 *
 */
@Component
public class ProductDataScheduler {

	private static final Logger log = LoggerFactory.getLogger(ProductDataScheduler.class);

	@Autowired
	GemFireDataService gemFireDataService;
	
	@Autowired
	ObjectMapper objectMapper;

	@PostConstruct
	public void onStartup() {
		loadProductPrice();
	}

	@Scheduled(cron="${scheduler.product-price.cron}", zone="PST")
	public void loadProductPrice(){
		log.info("Starting job to populate price data");
		try {
			gemFireDataService.loadProductPrice(getProductPriceLoad());
		} catch (ProductServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Finished job to populate price data");
	}
	
	/* (non-Javadoc)
	 * @see com.target.productservice.service.ProductInfoService#getProductPriceLoad()
	 */
	public ProductPriceData getProductPriceLoad() throws ProductServiceException {
		JSONParser jsonParser = new JSONParser();
		JSONObject productDataJson = null;
		ProductPriceData prdPriceData = null;
		try {
			File jsonDataFile = new File(getClass().getClassLoader().getResource("data/ProductDataLoad.json").getFile());
			productDataJson = (JSONObject) 
					jsonParser.parse(new FileReader(jsonDataFile));
			prdPriceData = objectMapper.readValue(productDataJson.toJSONString(), ProductPriceData.class);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return prdPriceData;
	}
}
