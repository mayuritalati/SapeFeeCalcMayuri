package com.sapient.bean;
import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 
 * @author MayuriJain
 *
 */
public class TranscationRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -950935171457263537L;

	private String externalTransactionId;
	private String clientId;
	private String securityId;
	private String transactionType;
	private String transactionDate;
	private String marketValue;
	private String priorityFlag;
	private BigDecimal processingFee;
	public String getExternalTransactionId() {
		return externalTransactionId;
	}
	public void setExternalTransactionId(String externalTransactionId) {
		this.externalTransactionId = externalTransactionId;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getSecurityId() {
		return securityId;
	}
	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(String marketValue) {
		this.marketValue = marketValue;
	}
	public String getPriorityFlag() {
		return priorityFlag;
	}
	public void setPriorityFlag(String priorityFlag) {
		this.priorityFlag = priorityFlag;
	}
	public BigDecimal getProcessingFee() {
		return processingFee;
	}
	public void setProcessingFee(BigDecimal processingFee) {
		this.processingFee = processingFee;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result + ((externalTransactionId == null) ? 0 : externalTransactionId.hashCode());
		result = prime * result + ((marketValue == null) ? 0 : marketValue.hashCode());
		result = prime * result + ((priorityFlag == null) ? 0 : priorityFlag.hashCode());
		result = prime * result + ((securityId == null) ? 0 : securityId.hashCode());
		result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
		result = prime * result + ((transactionType == null) ? 0 : transactionType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TranscationRecord other = (TranscationRecord) obj;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		if (externalTransactionId == null) {
			if (other.externalTransactionId != null)
				return false;
		} else if (!externalTransactionId.equals(other.externalTransactionId))
			return false;
		if (marketValue == null) {
			if (other.marketValue != null)
				return false;
		} else if (!marketValue.equals(other.marketValue))
			return false;
		if (priorityFlag == null) {
			if (other.priorityFlag != null)
				return false;
		} else if (!priorityFlag.equals(other.priorityFlag))
			return false;
		if (securityId == null) {
			if (other.securityId != null)
				return false;
		} else if (!securityId.equals(other.securityId))
			return false;
		if (transactionDate == null) {
			if (other.transactionDate != null)
				return false;
		} else if (!transactionDate.equals(other.transactionDate))
			return false;
		if (transactionType == null) {
			if (other.transactionType != null)
				return false;
		} else if (!transactionType.equals(other.transactionType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TranscationRecord [externalTransactionId=" + externalTransactionId + ", clientId=" + clientId
				+ ", securityId=" + securityId + ", transactionType=" + transactionType + ", transactionDate="
				+ transactionDate + ", marketValue=" + marketValue + ", priorityFlag=" + priorityFlag + "]";
	}

	
}
