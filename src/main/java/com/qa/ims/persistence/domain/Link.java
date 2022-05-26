package com.qa.ims.persistence.domain;

public class Link {
	
	//Fields
	private Long orderId;
	private Long customerId;
	
	
	//Constructors
	public Link(Long orderId, Long customerId) {
		this.orderId = orderId;
		this.customerId = customerId;
	}
	
	

	
	public Link(Long customerId) {
		super();
		this.customerId = customerId;
	}




	//Getters and Setters
	public Long getOrderId() {
		return orderId;
	}


	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}


	public Long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	//toString
	@Override
	public String toString() {
		return "Link [orderId=" + orderId + ", customerId=" + customerId + "]";
	}


	//Hash and Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
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
		Link other = (Link) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}
	
	
	
	
	
}
