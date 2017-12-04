//package com.myRetail.productservice;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.myRetail.productservice.ProductInfoServiceApplication;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ProductInfoServiceApplicationTests {
//
//	private static final Logger log = LoggerFactory.getLogger(ProductInfoServiceApplication.class);
//
//	@Test
//	public final void testMain() {
//		boolean isExceptionThrown = false;
//		try {
//			ProductInfoServiceApplication.main(null);
//		} catch (Exception e) {
//			log.info("Expected error for code coverage", e);
//			isExceptionThrown = true;
//		}
//		Assert.assertEquals(true, isExceptionThrown);
//	}
//
//}
