package com.onlinepizza.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.onlinepizza.util.PizzaStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;

@Entity
public class PizzaOrder {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingOrderId;
	
	@CreationTimestamp
	private LocalDateTime dateTimeOfOrder;
	
	@PrePersist
	private void onCreate() {
		this.dateTimeOfOrder = LocalDateTime.now();
	}
	
	
	private Integer quantity;
	private Double totalCost;
	
	@OneToMany(cascade = CascadeType.ALL,targetEntity = Pizza.class)
	@JoinColumn(name="bookingOrderId", referencedColumnName = "bookingOrderId") 
	private List<Pizza> pizzaList;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	private PizzaStatus status;

	public Integer getBookingOrderId() {
		return bookingOrderId;
	}
	public void setBookingOrderId(Integer bookingOrderId) {
		this.bookingOrderId = bookingOrderId;
	}
	public LocalDateTime getDateTimeOfOrder() {
		return dateTimeOfOrder;
	}
	public void setDateTimeOfOrder(LocalDateTime dateTimeOfOrder) {
		this.dateTimeOfOrder = dateTimeOfOrder;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	public List<Pizza> getPizzaList() {
		return pizzaList;
	}
	public void setPizzaList(List<Pizza> pizzaList) {
		this.pizzaList = pizzaList;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public PizzaStatus getStatus() {
		return status;
	}
	public void setStatus(PizzaStatus status) {
		this.status = status;
	}
	
	
	
	
	
	

}
