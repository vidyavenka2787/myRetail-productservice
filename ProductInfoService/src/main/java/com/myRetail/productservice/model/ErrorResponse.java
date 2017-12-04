/**
 * @author Infosys Ltd.
 */
package com.myRetail.productservice.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Infosys Ltd.
 *
 */
public class ErrorResponse {

	@JsonProperty("errors")
	private List<ErrorDetails> errorRsp = new ArrayList<>();

	/**
	 * @return the errorRsp
	 */
	public List<ErrorDetails> getErrorRsp() {
		return errorRsp;
	}

	/**
	 * @param errorRsp the errorRsp to set
	 */
	public void setErrorRsp(List<ErrorDetails> errorRsp) {
		this.errorRsp = errorRsp;
	}
	
	
}
