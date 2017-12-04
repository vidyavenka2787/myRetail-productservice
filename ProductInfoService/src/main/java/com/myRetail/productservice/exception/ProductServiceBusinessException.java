/**
 * @author Infosys Ltd.
 */
package com.myRetail.productservice.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Infosys Ltd.
 *
 */
public class ProductServiceBusinessException extends ProductServiceException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	private HttpStatus status = HttpStatus.CONFLICT;
	private String msg;
	private String code;
	
	public ProductServiceBusinessException(String code, String msg){
		this.msg = msg;
		this.code = code;
	}
	/**
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
