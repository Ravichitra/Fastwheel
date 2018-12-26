package com.fastwheel.fastwheelbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.multipart.MultipartFile;


@Entity

public class Product {

	@Column(nullable=false)
	private String product_Name;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int product_id;

	
	@Column(nullable=false, columnDefinition = "text")
	private String productDesc;

	@Column(nullable=false)
	private int quantity;

	@Column(nullable=false)
	private int price;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private MyCategory category;
	
    @Transient	
	MultipartFile pimage;
	
	public MultipartFile getPimage() {
		return pimage;
	}

	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_Name() {
		return product_Name;
	}

	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}

	
	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public MyCategory getCategory() {
		return category;
	}

	public void setCategory(MyCategory category) {
		this.category = category;
	}
}
