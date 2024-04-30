package com.onlinepizza.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinepizza.dao.IPizzaOrderService;
import com.onlinepizza.dto.PizzaOrderDTO;

@RestController
@RequestMapping("/order")
public class PizzaOrderController {
	
	@Autowired
	IPizzaOrderService pizzaorderservice;
	
	@PostMapping("/add")
	public PizzaOrderDTO addPizzaOrder(@RequestBody PizzaOrderDTO orderdto)
	{
		return pizzaorderservice.bookPizzaOrder(orderdto);
	}
	
	
	@GetMapping("/get/id/{id}")
	public PizzaOrderDTO getPizzaOrderById(@PathVariable("id") Integer pizzaOrderId) 
	{
		return pizzaorderservice.viewPizzaOrderById(pizzaOrderId);
		
	}
	
	@GetMapping("/get/all")
	public List<PizzaOrderDTO> getAllPizzaOrders()
	{
		return pizzaorderservice.viewAllPizzaOrders();
	}
	
//	@GetMapping("/get/date")
//	public List<PizzaOrderDTO> viewPizzaOrderByDate(LocalDate date){
//		return pizzaorderservice.viewPizzaOrderByDate(date);
//		
//	}
	
	@GetMapping("/get/status/{status}")
	public List<PizzaOrderDTO> getPizzaOrderByStatus(@PathVariable("status")  String status)
	{
		
		return pizzaorderservice.viewPizzaOrderByStatus(status);
	}
	
	@GetMapping("/get/{cusid}")
	public List<PizzaOrderDTO> getPizzaOrderByCustomerId(Integer customerId)
	{
		return pizzaorderservice.viewPizzaOrderByCustomerId(customerId);
	}
	
	@DeleteMapping("/del/{id}")
	public PizzaOrderDTO deletePizzaOrder(@PathVariable("id") Integer pizzaId)
	{
	  return pizzaorderservice.cancelPizzaOrder(pizzaId);	
	}
	
	@GetMapping("/get/date/{date}")
	public List<PizzaOrderDTO> getPizzaOrderByDate(LocalDate date)
	{
		return pizzaorderservice.viewPizzaOrderByDate(date);
	}
	
	@GetMapping("/get/idstatus/{id}/{status}")
	public List<PizzaOrderDTO> getPizzaOrderByCustomerIdAndStatus(@PathVariable("id") Integer customerId,@PathVariable("status") String status){
		return pizzaorderservice.viewPizzaOrderByCustomerIdAndStatus(customerId, status);
	}
	
	@PutMapping("/put")
	public PizzaOrderDTO putpizzaOrder(@RequestBody  PizzaOrderDTO pizzaOrder)
	{
	return pizzaorderservice.updatepizzaOrder(pizzaOrder);	
	}
	
	
	
	

}
