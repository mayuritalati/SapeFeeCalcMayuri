package com.sapient.bean;
/**
 * 
 * @author MayuriJain
 *
 */
public class Pair {
	private String clientId;
	private String securityId;
	private String transactionDate;

	public Pair(String clientId, String securityId, String transactionDate) {
		super();
		this.clientId = clientId;
		this.securityId = securityId;
		this.transactionDate = transactionDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result + ((securityId == null) ? 0 : securityId.hashCode());
		result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
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
		Pair other = (Pair) obj;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
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
		return true;
	}

	@Override
	public String toString() {
		return "Pair [clientId=" + clientId + ", securityId=" + securityId + ", transactionDate=" + transactionDate
				+ "]";
	}

}
