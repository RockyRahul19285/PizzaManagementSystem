package com.onlinepizza.dao;

import java.util.List;

import com.onlinepizza.dto.PizzaDTO;
import com.onlinepizza.dto.PizzaTypeDTO;
import com.onlinepizza.dto.ToppingsDTO;
import com.onlinepizza.exception.ResourceNotFound;

public interface IPizzaService {
	
	PizzaDTO addPizza(PizzaDTO pizza)throws ResourceNotFound;

	ToppingsDTO addToppings(ToppingsDTO toppings)throws ResourceNotFound;

	PizzaTypeDTO addPizzaType(PizzaTypeDTO pizzaType)throws ResourceNotFound;

	PizzaDTO updatePizza(PizzaDTO pizza,Integer id)throws ResourceNotFound;

	PizzaDTO viewPizzaById(Integer pizzaId)throws ResourceNotFound;

	List<PizzaDTO> viewPizzaByPizzaType(String pizzaType)throws ResourceNotFound;

	List<PizzaDTO> viewPizzaByPizzaSize(String pizzaSize)throws ResourceNotFound;

	List<PizzaDTO> viewPizzaByPrice(Double minPrice, Double maxPrice)throws ResourceNotFound;

	List<PizzaDTO> viewAllPizza()throws ResourceNotFound;

	List<ToppingsDTO> viewToppings()throws ResourceNotFound;

	ToppingsDTO viewToppingByID(Integer toppingsID)throws ResourceNotFound;

	PizzaTypeDTO viewPizzaTypeById(Integer pizzaTypeId)throws ResourceNotFound;

	List<PizzaTypeDTO> viewAllPizzaTypes()throws ResourceNotFound;

}
