/**
 * @author Infosys Ltd.
 */
package com.myRetail.productservice.model;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Infosys Ltd.
 *
 */
public class PriceUpdateAudit {
	
	@JsonProperty
	@NotBlank(message="Missing updateBy")
	private String updatedBy;
	
	@JsonProperty
	@NotBlank(message="Missing update reason")
	private String updateReason;

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the updateReason
	 */
	public String getUpdateReason() {
		return updateReason;
	}

	/**
	 * @param updateReason the updateReason to set
	 */
	public void setUpdateReason(String updateReason) {
		this.updateReason = updateReason;
	}
	
	

}
