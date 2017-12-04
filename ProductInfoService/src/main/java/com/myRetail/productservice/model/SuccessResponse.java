/**
 * @author Infosys Ltd.
 */
package com.myRetail.productservice.model;

/**
 * @author Infosys Ltd.
 *
 */
public class SuccessResponse {

	private String status;
	
	public SuccessResponse(String status){
		this.status = status;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
