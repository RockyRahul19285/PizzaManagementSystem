package com.onlinepizza.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ToppingsDTO {
	
	private Integer toppingsId;
	@NotBlank(message="Toppings name should not be empty")
	private String toppingsName;
	@Min(value = 1, message = "Enter the proper number")
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
