package com.onlinepizza.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;


@Entity
public class PizzaType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pizzaTypeId;
	// Veg or Non-Veg
	private String pizzaType;
	
	@ManyToMany
	@JoinTable(name="pizzaToppings",joinColumns = @JoinColumn(name="pizzaTypeId",referencedColumnName = "pizzaTypeId"),
	inverseJoinColumns = @JoinColumn(name = "toppings_id",referencedColumnName = "toppingsId"))
	private List<Toppings> toppings;
	
	
	
	
	
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
	public List<Toppings> getToppings() {
		return toppings;
	}
	public void setToppings(List<Toppings> toppings) {
		this.toppings = toppings;
	}

}
