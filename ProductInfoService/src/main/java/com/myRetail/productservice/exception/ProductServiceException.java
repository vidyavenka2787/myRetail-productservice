/**
 * @author Infosys Ltd.
 */
package com.myRetail.productservice.exception;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.myRetail.productservice.model.ErrorDetails;

/**
 * @author Infosys Ltd.
 *
 */
public class ProductServiceException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
	private String msg;
	private String code;
	private List<ErrorDetails> errorResponseList;

	public ProductServiceException(HttpStatus status, String msg, String code){
		this.status = status;
		this.msg = msg;
		this.code = code;
	}
	
	public ProductServiceException(HttpStatus status, List<ErrorDetails> errorResponseList){
		this.status = status;
		this.errorResponseList = errorResponseList;
	}
	
	public ProductServiceException(){
		this.code = null;
		this.msg = null;
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

	/**
	 * @return the errorResponseList
	 */
	public List<ErrorDetails> getErrorResponseList() {
		return errorResponseList;
	}

	/**
	 * @param errorResponseList the errorResponseList to set
	 */
	public void setErrorResponseList(List<ErrorDetails> errorResponseList) {
		this.errorResponseList = errorResponseList;
	}

	

	
}
