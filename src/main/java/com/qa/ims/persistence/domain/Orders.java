package com.qa.ims.persistence.domain;

public class Orders {
	
	//Fields
	private Long detailsId;
	private Long orderId;//foreign key
	private Long customerId;//foreign key
	private String orderDescription;
	private String orderStatus;
	
	//Constructors without ID
	public Orders(Long orderId, Long customerId, String orderDescription, String orderStatus) { 
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderDescription = orderDescription;
		this.orderStatus = orderStatus;
	}


	//Constructors with ID
	public Orders(Long detailsId, Long orderId, Long customerId, String orderDescription,
			String orderStatus) {
		this.detailsId = detailsId;
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderDescription = orderDescription;
		this.orderStatus = orderStatus;
	}


	//Getters and Setters
	public Long getDetailsId() {
		return detailsId;
	}

	public void setDetailsId(Long detailsId) {
		this.detailsId = detailsId;
	}

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

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	//toString
	@Override
	public String toString() {
		return "Orders Details Id: " + detailsId + ", Order Id: " + orderId + ", Customer Id: " + customerId + ", Order Description: " + orderDescription + ", Order Status: " + orderStatus;
	}

	//Hash and Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((detailsId == null) ? 0 : detailsId.hashCode());
		result = prime * result + ((orderDescription == null) ? 0 : orderDescription.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
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
		Orders other = (Orders) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (detailsId == null) {
			if (other.detailsId != null)
				return false;
		} else if (!detailsId.equals(other.detailsId))
			return false;
		if (orderDescription == null) {
			if (other.orderDescription != null)
				return false;
		} else if (!orderDescription.equals(other.orderDescription))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderStatus == null) {
			if (other.orderStatus != null)
				return false;
		} else if (!orderStatus.equals(other.orderStatus))
			return false;
		return true;
	}


	
	
	
	
	
	
	
	
	
	
	

}
