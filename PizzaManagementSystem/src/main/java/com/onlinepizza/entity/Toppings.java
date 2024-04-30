package com.onlinepizza.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Toppings {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer toppingsId;
	private String toppingsName;
	private Double price;
	
	
	
	
	
	
	
	public Integer getToppingsId() {
		return toppingsId;
	}
	public void setToppingsId(Integer toppingsId) {
		this.toppingsId = toppingsId;
	}
	public String getToppingsName() {
		return toppingsName;
	}
	public void setToppingsName(String toppingsName) {
		this.toppingsName = toppingsName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}


	
	
	


}
