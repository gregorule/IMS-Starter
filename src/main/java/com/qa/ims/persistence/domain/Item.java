package com.qa.ims.persistence.domain;

public class Item {
	
	//Fields
	private Long itemId;
	private String itemName;
	private float price;
	private int stock;
	
	//Constructors without ID
	public Item(String itemName, float price, int stock) {
		this.itemName = itemName;
		this.price = price;
		this.stock = stock;
	}

	///Constructors with ID
	public Item(Long itemId, String itemName, float price, int stock) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.stock = stock;
	}

	//Getters and Setters
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	//toString
	@Override
	public String toString() {
		return "Item ID: " + itemId + ", Item Name: " + itemName + ", Price: " + price
				+ ", stock: " + stock;
	}

	//Hash and Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + stock;
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
		Item other = (Item) obj;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (stock != other.stock)
			return false;
		return true;
	}
	
	
	
	
	
	

}
