package com.fastwheel.fastwheelbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GeneratorType;

@Entity
public class Address {
	
	int cartid;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int addressid;
	@Column(nullable=false)
	@NotBlank(message = "Name is mandatory")
	String name;
	@Column(nullable=false)
	@NotBlank(message = "Address line is mandatory")
	String addline1;
	@Column(nullable=false)
	@NotBlank(message = "Address line is mandatory")
	String addline2;
	@Column(nullable=false)
	@NotBlank(message = "Address line is mandatory")
    String city;
	@Column(nullable=false)
	@NotBlank(message = "Address line is mandatory")
    String state;
	@Column(nullable=false)
	@NotBlank(message = "Address line is mandatory")
    String pincode;
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddline1() {
		return addline1;
	}
	public void setAddline1(String addline1) {
		this.addline1 = addline1;
	}
	public String getAddline2() {
		return addline2;
	}
	public void setAddline2(String addline2) {
		this.addline2 = addline2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
    
    
	
	
	

}
