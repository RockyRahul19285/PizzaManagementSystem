package com.onlinepizza.dao;

import java.time.LocalDate;
import java.util.List;

import com.onlinepizza.dto.PizzaOrderDTO;
import com.onlinepizza.exception.ResourceNotFound;

public interface IPizzaOrderService {
	
	PizzaOrderDTO bookPizzaOrder(PizzaOrderDTO order);

	String cancelPizzaOrder(Integer pizzaId)throws ResourceNotFound;

	PizzaOrderDTO viewPizzaOrderById(Integer pizzaOrderId) throws ResourceNotFound;
	
	List<PizzaOrderDTO> viewAllPizzaOrders() throws ResourceNotFound;
	
	List<PizzaOrderDTO> viewPizzaOrderByStartAndEndDate(LocalDate startDate, LocalDate endDate)throws ResourceNotFound;

	List<PizzaOrderDTO> viewPizzaOrderByDate(LocalDate date)throws ResourceNotFound;
	
	List<PizzaOrderDTO> viewPizzaOrderByCustomerId(Integer customerId) throws ResourceNotFound;
	
	List<PizzaOrderDTO> viewPizzaOrderByStatus(String status)throws ResourceNotFound;
	
	List<PizzaOrderDTO> viewPizzaOrderByCustomerIdAndStatus(Integer customerId, String status)throws ResourceNotFound;


}
