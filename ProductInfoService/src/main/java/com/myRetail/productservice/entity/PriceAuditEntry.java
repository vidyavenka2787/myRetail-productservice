/**
 * @author Infosys Ltd.
 */
package com.myRetail.productservice.entity;

import org.springframework.data.annotation.Id;

/**
 * @author Infosys Ltd.
 *
 */
public class PriceAuditEntry {
	
	@Id
	private String auditId;
	private String updateBy;
	private String updateReason;
	private String updateDate;
	
	
	/**
	 * @return the auditId
	 */
	public String getAuditId() {
		return auditId;
	}
	/**
	 * @param auditId the auditId to set
	 */
	public void setAuditId(String auditId) {
		this.auditId = auditId;
	}
	/**
	 * @return the updateBy
	 */
	public String getUpdateBy() {
		return updateBy;
	}
	/**
	 * @param updateBy the updateBy to set
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
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
	/**
	 * @return the updateDate
	 */
	public String getUpdateDate() {
		return updateDate;
	}
	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	
	

}
