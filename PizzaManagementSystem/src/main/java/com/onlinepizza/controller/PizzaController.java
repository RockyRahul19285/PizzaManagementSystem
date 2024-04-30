package com.onlinepizza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinepizza.Repository.PizzaTypeRepository;
import com.onlinepizza.Repository.ToppingsRepository;
import com.onlinepizza.dao.IPizzaService;
import com.onlinepizza.dto.PizzaDTO;
import com.onlinepizza.dto.PizzaTypeDTO;
import com.onlinepizza.dto.ToppingsDTO;
import com.onlinepizza.entity.Pizza;
import com.onlinepizza.entity.PizzaType;
import com.onlinepizza.entity.Toppings;


@RestController
@RequestMapping("/pizza")
public class PizzaController {
	
	
	@Autowired
	private IPizzaService pizzaservice;
	@Autowired
	private PizzaTypeRepository ptr;
	@Autowired
	private ToppingsRepository tr;
	
	
	@PostMapping("/piz")
	public PizzaDTO postPizza(@RequestBody PizzaDTO pizza){
//		System.out.println("hello");
//		System.out.println(pizza.getPizzaName());
		
		PizzaDTO pizzadto = pizzaservice.addPizza(pizza);
		return pizzadto;
		
	}
	
	@PostMapping("/top")
	public ToppingsDTO postToppings(@RequestBody ToppingsDTO top) {
		
		ToppingsDTO toppingsdto=pizzaservice.addToppings(top);
		return toppingsdto;
	}
	
	@PostMapping("/type")
	public PizzaTypeDTO postPizzatype(@RequestBody   PizzaTypeDTO ptdto) {
		PizzaTypeDTO pizzatypedto = pizzaservice.addPizzaType(ptdto);
		return pizzatypedto;
	}
	
	
	@GetMapping("/{id}")
	public PizzaDTO getbyId(@PathVariable("id")  Integer pizzaId) {
		
		return pizzaservice.viewPizzaById(pizzaId);
		
	}
	
	
	
	
	@GetMapping("/top/{id}")
	public ToppingsDTO getToppingByID(@PathVariable("id") Integer toppingsID) {
		
		return pizzaservice.viewToppingByID(toppingsID);
		
	}
	
	
	@GetMapping("/type/get/{id}")
	public PizzaTypeDTO getPizzaTypeById(@PathVariable("id")    Integer pizzaTypeId) {
		return pizzaservice.viewPizzaTypeById(pizzaTypeId);
	}
	
	
	
	
	@PutMapping("/put/{id}")
	public PizzaDTO putPizza(@RequestBody PizzaDTO pizzaDTO,@PathVariable("id") Integer pizzaId)
	{
		System.out.println("dj");
	return pizzaservice.updatePizza(pizzaDTO, pizzaId)	;
	}
	
	@GetMapping("/type/{str}")
	public List<PizzaDTO> getPizzaByPizzaType(@PathVariable("str") String pizzaType)
	{
		return pizzaservice.viewPizzaByPizzaType(pizzaType);
	}
	
	@GetMapping("/get")
	public List<PizzaDTO> getAllPizza()
	{
		return pizzaservice.viewAllPizza();
	}
	
	
	@GetMapping("/get/size/{size}")
	public List<PizzaDTO> getPizzaByPizzaSize(@PathVariable("size") String pizzaSize)
	{
		return pizzaservice.viewPizzaByPizzaSize(pizzaSize);
	}
	
	@GetMapping("/get/top")
	public List<ToppingsDTO> getToppings(){
		return pizzaservice.viewToppings();
	}
	
	@GetMapping("/get/pizzatype")
	public List<PizzaTypeDTO> viewAllPizzaTypes()
	{
		return pizzaservice.viewAllPizzaTypes();
	}
	
	@GetMapping("/get/{min}/{max}")
	public List<PizzaDTO> getPizzaByPrice(@PathVariable("min") Double minPrice,@PathVariable("max") Double maxPrice)
	{
		return pizzaservice.viewPizzaByPrice(minPrice, maxPrice);
	}
	

}
