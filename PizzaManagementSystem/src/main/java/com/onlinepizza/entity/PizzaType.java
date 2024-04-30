package com.onlinepizza.entity;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

//import com.onlinepizza.entity.*;
@Entity
public class PizzaType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pizzaTypeId;
	// Veg or Non-Veg
	private String pizzaType;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="pizzaToppings",joinColumns = {@JoinColumn(name="pizza_id")},
	inverseJoinColumns = {@JoinColumn(name = "Toppings_id")})
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
