package com.onlinepizza.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinepizza.dao.IPizzaOrderService;
import com.onlinepizza.dto.PizzaOrderDTO;
import com.onlinepizza.exception.ResourceNotFound;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/order")
public class PizzaOrderController {

	@Autowired
	IPizzaOrderService pizzaorderservice;

	// http://localhost:8000/order
	@PostMapping
	public ResponseEntity<PizzaOrderDTO> addPizzaOrder(@Valid @RequestBody PizzaOrderDTO orderdto) {
		PizzaOrderDTO result = pizzaorderservice.bookPizzaOrder(orderdto);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	// http://localhost:8000/order/{id}
	@GetMapping("/{id}")
	public ResponseEntity<PizzaOrderDTO> getPizzaOrderById(@PathVariable("id") Integer pizzaOrderId)
			throws ResourceNotFound {
		PizzaOrderDTO result = pizzaorderservice.viewPizzaOrderById(pizzaOrderId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	// http://localhost:8000/order/allorders
	@GetMapping("/allorders")
	public ResponseEntity<List<PizzaOrderDTO>> getAllPizzaOrders() throws ResourceNotFound {
		List<PizzaOrderDTO> result = pizzaorderservice.viewAllPizzaOrders();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	// http://localhost:8000/order/status/{status}
	@GetMapping("/status/{status}")
	public ResponseEntity<List<PizzaOrderDTO>> getPizzaOrderByStatus(@PathVariable("status") String status)
			throws ResourceNotFound {
		List<PizzaOrderDTO> result = pizzaorderservice.viewPizzaOrderByStatus(status);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	// http://localhost:8000/order/customer/{cusid}
	@GetMapping("/customer/{cusid}")
	public ResponseEntity<List<PizzaOrderDTO>> getPizzaOrderByCustomerId(@PathVariable("cusid") Integer customerId)
			throws ResourceNotFound {
		List<PizzaOrderDTO> result = pizzaorderservice.viewPizzaOrderByCustomerId(customerId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	// http://localhost:8000/order/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePizzaOrder(@PathVariable("id") Integer pizzaId) throws ResourceNotFound {
		String result = pizzaorderservice.cancelPizzaOrder(pizzaId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	// http://localhost:8000/order/bydate/{date}
	@GetMapping("/bydate/{date}")
	public ResponseEntity<List<PizzaOrderDTO>> getPizzaOrderByDate(@PathVariable("date") LocalDate date)
			throws ResourceNotFound {
		List<PizzaOrderDTO> result = pizzaorderservice.viewPizzaOrderByDate(date);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	// http://localhost:8000/order/idstatus/{id}/{status}
	@GetMapping("/idstatus/{id}/{status}")
	public ResponseEntity<List<PizzaOrderDTO>> getPizzaOrderByCustomerIdAndStatus(
			@PathVariable("id") Integer customerId, @PathVariable("status") String status) throws ResourceNotFound {
		List<PizzaOrderDTO> result = pizzaorderservice.viewPizzaOrderByCustomerIdAndStatus(customerId, status);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
