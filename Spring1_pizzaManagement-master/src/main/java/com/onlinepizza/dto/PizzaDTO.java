package com.onlinepizza.dto;

import com.onlinepizza.util.PizzaSize;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class PizzaDTO {
	
	private Integer pizzaId;
	private PizzaTypeDTO pizzaType;
	@NotBlank(message="Name should not be empty")
	private String pizzaName;
	@NotBlank(message="Description should not be empty")
	private String pizzaDescription;
	
	
	@Min(value = 1, message = "Enter the proper number")
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
