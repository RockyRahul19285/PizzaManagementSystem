package com.onlinepizza.dto;

import java.util.List;

public class PizzaTypeDTO {
	
	private Integer pizzaTypeId;
	// Veg or Non-Veg
	private String pizzaType;
	private List<ToppingsDTO> toppings;
	
	
	public Integer getPizzaTypeId() {
		return pizzaTypeId;
	}
	public void setPizzaTypeId(Integer pizzaTypeId) {
		this.pizzaTypeId = pizzaTypeId;
	}
	public String getPizzaType() {
		return pizzaType;
	}
	public void setPizzaType(String pizzaType) {
		this.pizzaType = pizzaType;
	}
	public List<ToppingsDTO> getToppings() {
		return toppings;
	}
	public void setToppings(List<ToppingsDTO> toppings) {
		this.toppings = toppings;
	}
	
	

}
