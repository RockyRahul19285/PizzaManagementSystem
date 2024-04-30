package com.onlinepizza.dao;

import java.util.List;

import com.onlinepizza.dto.PizzaDTO;
import com.onlinepizza.dto.PizzaTypeDTO;
import com.onlinepizza.dto.ToppingsDTO;

public interface IPizzaService {
	
	PizzaDTO addPizza(PizzaDTO pizza);

	ToppingsDTO addToppings(ToppingsDTO toppings);

	PizzaTypeDTO addPizzaType(PizzaTypeDTO pizzaType);

	PizzaDTO updatePizza(PizzaDTO pizza,Integer id);

	PizzaDTO viewPizzaById(Integer pizzaId);

	List<PizzaDTO> viewPizzaByPizzaType(String pizzaType);

	List<PizzaDTO> viewPizzaByPizzaSize(String pizzaSize);

	List<PizzaDTO> viewPizzaByPrice(Double minPrice, Double maxPrice);

	List<PizzaDTO> viewAllPizza();

	List<ToppingsDTO> viewToppings();

	ToppingsDTO viewToppingByID(Integer toppingsID);

	PizzaTypeDTO viewPizzaTypeById(Integer pizzaTypeId);

	List<PizzaTypeDTO> viewAllPizzaTypes();

}
