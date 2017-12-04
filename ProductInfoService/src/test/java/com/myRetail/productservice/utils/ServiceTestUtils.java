package com.myRetail.productservice.utils;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ServiceTestUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceTestUtils.class);

	public <T> T getMockResponseClass(final String fileName, final Class<T> actualClass) {

		T returnClass = null;
		try {
			String jsonStringMockResponse = new String(
					Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource(fileName).toURI())));
			returnClass = getObjectMapper().readValue(jsonStringMockResponse, actualClass);

		} catch (Exception e) {
			LOGGER.error("error on mock generation", e);
		}
		return returnClass;
	}

	private ObjectMapper getObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false);
		return objectMapper;
	}

	public String getMockResponseAsString(final String fileName) {
		String jsonStringMockResponse = null;
		try {
			jsonStringMockResponse = new String(
					Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource(fileName).toURI())));

		} catch (Exception e) {
			LOGGER.error("error on mock generation", e);
		}
		return jsonStringMockResponse;
	}
}
