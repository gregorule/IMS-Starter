package com.qa.ims.persistence.domain;

public class Customer {

	//Fields
	private Long id;
	private String firstName;
	private String surname;
	private String email;
	private String phone;

	//Constructors without ID
	public Customer(String firstName, String surname, String email, String phone) {
		this.setFirstName(firstName);
		this.setSurname(surname);
		this.setEmail(email);
		this.setPhone(phone);
	}

	//Constructors with ID
	public Customer(Long id, String firstName, String surname, String email, String phone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
	}


	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	//toString
		@Override
		public String toString() {
			return "Customer ID: " + id + ", First Name: " + firstName + ", Surname: " + surname + ", Email Address: " + email
					+ ", Telephone Number: " + phone;
		}

		//Hashes and Equals
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((email == null) ? 0 : email.hashCode());
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((phone == null) ? 0 : phone.hashCode());
			result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
			Customer other = (Customer) obj;
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			if (firstName == null) {
				if (other.firstName != null)
					return false;
			} else if (!firstName.equals(other.firstName))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (phone == null) {
				if (other.phone != null)
					return false;
			} else if (!phone.equals(other.phone))
				return false;
			if (surname == null) {
				if (other.surname != null)
					return false;
			} else if (!surname.equals(other.surname))
				return false;
			return true;
		}


	
	

	

}
