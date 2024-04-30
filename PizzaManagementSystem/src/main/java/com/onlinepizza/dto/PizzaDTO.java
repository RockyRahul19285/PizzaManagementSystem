package com.onlinepizza.dto;

import com.onlinepizza.util.PizzaSize;

public class PizzaDTO {
	
	private Integer pizzaId;
	private PizzaTypeDTO pizzaType;
	private String pizzaName;
	private String pizzaDescription;
	private Double pizzaCost;
	private PizzaSize pizzaSize;
	
	
	public Integer getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(Integer pizzaId) {
		this.pizzaId = pizzaId;
	}
	public PizzaTypeDTO getPizzaType() {
		return pizzaType;
	}
	public void setPizzaType(PizzaTypeDTO pizzaType) {
		this.pizzaType = pizzaType;
	}
	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	public String getPizzaDescription() {
		return pizzaDescription;
	}
	public void setPizzaDescription(String pizzaDescription) {
		this.pizzaDescription = pizzaDescription;
	}
	public Double getPizzaCost() {
		return pizzaCost;
	}
	public void setPizzaCost(Double pizzaCost) {
		this.pizzaCost = pizzaCost;
	}
	public PizzaSize getPizzaSize() {
		return pizzaSize;
	}
	public void setPizzaSize(PizzaSize pizzaSize) {
		this.pizzaSize = pizzaSize;
	}
	
	

}
