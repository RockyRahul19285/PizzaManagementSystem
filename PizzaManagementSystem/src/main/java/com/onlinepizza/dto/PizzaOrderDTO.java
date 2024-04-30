package com.onlinepizza.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.onlinepizza.util.PizzaStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class PizzaOrderDTO {
	
	private Integer bookingOrderId;
	private LocalDateTime dateTimeOfOrder;
	private Integer quantity;
	private Double totalCost;
	private List<PizzaDTO> pizzaList;
	private CustomerDTO customer;
	

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
	public List<PizzaDTO> getPizzaList() {
		return pizzaList;
	}
	public void setPizzaList(List<PizzaDTO> pizzaList) {
		this.pizzaList = pizzaList;
	}
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	public PizzaStatus getStatus() {
		return status;
	}
	public void setStatus(PizzaStatus status) {
		this.status = status;
	}
	
	
	


}
