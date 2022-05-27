package com.qa.ims.persistence.domain;

public class Orders {
	
	//Fields
	private Long detailsId;
	private Long orderId;//foreign key
	private Long itemId;//foreign key
	private int quantity;
	private String orderStatus;
	private float cost;
	
	//Constructors without ID
	public Orders(Long orderId, Long itemId, int quantity, String orderStatus) { 
		this.orderId = orderId;
		this.itemId = itemId;
		this.quantity = quantity;
		this.orderStatus = orderStatus;
	}


	//Constructors with ID
	public Orders(Long detailsId, Long orderId, Long itemId, int quantity,	String orderStatus) {
		this.detailsId = detailsId;
		this.orderId = orderId;
		this.itemId = itemId;
		this.quantity = quantity;
		this.orderStatus = orderStatus;
	}
	
	
	//Constructors with cost
	public Orders(Long detailsId, Long orderId, Long itemId, int quantity, String orderStatus, float cost) {
		this.detailsId = detailsId;
		this.orderId = orderId;
		this.itemId = itemId;
		this.quantity = quantity;
		this.orderStatus = orderStatus;
		this.cost = cost;
	}
	
	


	public Orders(Long orderId, Long itemId, int quantity, String orderStatus, float cost) {
		this.orderId = orderId;
		this.itemId = itemId;
		this.quantity = quantity;
		this.orderStatus = orderStatus;
		this.cost = cost;
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

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public float getCost() {
		return cost;
	}
	
	public void setCost(float cost) {
		this.cost = cost;
	}
	

	//toString
	@Override
	public String toString() {
		return "Orders Details Id: " + detailsId + ", Order Id: " + orderId + ", Item Id: " + itemId + ", Quantity: " + quantity + ", Order Status: " + orderStatus + ", Cost: £" + cost;
	}


	//Hash and Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(cost);
		result = prime * result + ((detailsId == null) ? 0 : detailsId.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
		result = prime * result + quantity;
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
		if (Float.floatToIntBits(cost) != Float.floatToIntBits(other.cost))
			return false;
		if (detailsId == null) {
			if (other.detailsId != null)
				return false;
		} else if (!detailsId.equals(other.detailsId))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
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
		if (quantity != other.quantity)
			return false;
		return true;
	}


	
	

	
	
	

	
	
	
	
	
	
	
	
	
	
	

}
