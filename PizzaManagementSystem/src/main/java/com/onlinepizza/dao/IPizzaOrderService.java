package com.onlinepizza.dao;

import java.time.LocalDate;
import java.util.List;

import com.onlinepizza.dto.PizzaOrderDTO;

public interface IPizzaOrderService {
	
	PizzaOrderDTO bookPizzaOrder(PizzaOrderDTO order);

	PizzaOrderDTO updatepizzaOrder(PizzaOrderDTO pizzaOrder);

	PizzaOrderDTO cancelPizzaOrder(Integer pizzaId);

	PizzaOrderDTO viewPizzaOrderById(Integer pizzaOrderId);
	
	List<PizzaOrderDTO> viewAllPizzaOrders();
	
	List<PizzaOrderDTO> viewPizzaOrderByStartAndEndDate(LocalDate startDate, LocalDate endDate);

	List<PizzaOrderDTO> viewPizzaOrderByDate(LocalDate date);
	
	List<PizzaOrderDTO> viewPizzaOrderByCustomerId(Integer customerId);
	
	List<PizzaOrderDTO> viewPizzaOrderByStatus(String status);
	
	List<PizzaOrderDTO> viewPizzaOrderByCustomerIdAndStatus(Integer customerId, String status);


}
