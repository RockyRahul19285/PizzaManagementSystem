package com.onlinepizza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinepizza.dao.IPizzaService;
import com.onlinepizza.dto.PizzaDTO;
import com.onlinepizza.dto.PizzaTypeDTO;
import com.onlinepizza.dto.ToppingsDTO;
import com.onlinepizza.exception.ResourceNotFound;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pizza")
public class PizzaController {

	@Autowired
	private IPizzaService pizzaservice;

	// http://localhost:8000/pizza
	@PostMapping
	public ResponseEntity<PizzaDTO> postPizza(@Valid @RequestBody PizzaDTO pizza) throws ResourceNotFound {
		PizzaDTO pizzadto = pizzaservice.addPizza(pizza);
		return new ResponseEntity<>(pizzadto, HttpStatus.OK);
	}

	// http://localhost:8000/pizza/addtoppings
	@PostMapping("/addtoppings")
	public ResponseEntity<ToppingsDTO> postToppings(@Valid @RequestBody ToppingsDTO top) throws ResourceNotFound {
		ToppingsDTO toppingsdto = pizzaservice.addToppings(top);
		return new ResponseEntity<>(toppingsdto, HttpStatus.OK);
	}

	// http://localhost:8000/pizza/pizzatype
	@PostMapping("/pizzatype")
	public ResponseEntity<PizzaTypeDTO> postPizzatype(@Valid @RequestBody PizzaTypeDTO ptdto) throws ResourceNotFound {
		PizzaTypeDTO pizzatypedto = pizzaservice.addPizzaType(ptdto);
		return new ResponseEntity<>(pizzatypedto, HttpStatus.OK);
	}

	// http://localhost:8000/pizza/{id}
	@GetMapping("/{id}")
	public ResponseEntity<PizzaDTO> getbyId(@PathVariable("id") Integer pizzaId) throws ResourceNotFound {
		PizzaDTO pizzaDTO = pizzaservice.viewPizzaById(pizzaId);
		return new ResponseEntity<>(pizzaDTO, HttpStatus.OK);
	}

	// http://localhost:8000/pizza/toppings/{id}
	@GetMapping("/toppings/{id}")
	public ResponseEntity<ToppingsDTO> getToppingByID(@PathVariable("id") Integer toppingsID) throws ResourceNotFound {
		ToppingsDTO toppingsDTO = pizzaservice.viewToppingByID(toppingsID);
		return new ResponseEntity<>(toppingsDTO, HttpStatus.OK);
	}

	// http://localhost:8000/pizza/pizzatype/{id}
	@GetMapping("/pizzatype/{id}")
	public ResponseEntity<PizzaTypeDTO> getPizzaTypeById(@PathVariable("id") Integer pizzaTypeId)
			throws ResourceNotFound {
		PizzaTypeDTO pizzaTypeDTO = pizzaservice.viewPizzaTypeById(pizzaTypeId);
		return new ResponseEntity<>(pizzaTypeDTO, HttpStatus.OK);
	}

	// http://localhost:8000/pizza/{id}
	@PutMapping("/{id}")
	public ResponseEntity<PizzaDTO> putPizza(@Valid @RequestBody PizzaDTO pizzaDTO, @PathVariable("id") Integer pizzaId)
			throws ResourceNotFound {
		PizzaDTO updatedPizzaDTO = pizzaservice.updatePizza(pizzaDTO, pizzaId);
		return new ResponseEntity<>(updatedPizzaDTO, HttpStatus.OK);
	}

	// http://localhost:8000/pizza/pizzatype/type/{str}
	@GetMapping("/pizzatype/type/{str}")
	public ResponseEntity<List<PizzaDTO>> getPizzaByPizzaType(@PathVariable("str") String pizzaType)
			throws ResourceNotFound {
		List<PizzaDTO> pizzaList = pizzaservice.viewPizzaByPizzaType(pizzaType);
		return new ResponseEntity<>(pizzaList, HttpStatus.OK);
	}

	// http://localhost:8000/pizza/allpizza
	@GetMapping("/allpizza")
	public ResponseEntity<List<PizzaDTO>> getAllPizza() throws ResourceNotFound {
		List<PizzaDTO> pizzaList = pizzaservice.viewAllPizza();
		return new ResponseEntity<>(pizzaList, HttpStatus.OK);
	}

	// http://localhost:8000/pizza/pizzasize/{size}
	@GetMapping("/pizzasize/{size}")
	public ResponseEntity<List<PizzaDTO>> getPizzaByPizzaSize(@PathVariable("size") String pizzaSize)
			throws ResourceNotFound {
		List<PizzaDTO> pizzaList = pizzaservice.viewPizzaByPizzaSize(pizzaSize);
		return new ResponseEntity<>(pizzaList, HttpStatus.OK);
	}

	// http://localhost:8000/pizza/toppings
	@GetMapping("/toppings")
	public ResponseEntity<List<ToppingsDTO>> getToppings() throws ResourceNotFound {
		List<ToppingsDTO> toppingsList = pizzaservice.viewToppings();
		return new ResponseEntity<>(toppingsList, HttpStatus.OK);
	}

	// http://localhost:8000/pizza/pizzatype
	@GetMapping("/pizzatype")
	public ResponseEntity<List<PizzaTypeDTO>> viewAllPizzaTypes() throws ResourceNotFound {
		List<PizzaTypeDTO> pizzaTypeList = pizzaservice.viewAllPizzaTypes();
		return new ResponseEntity<>(pizzaTypeList, HttpStatus.OK);
	}

	// http://localhost:8000/pizza/pizzabyprice/{min}/{max}
	@GetMapping("pizzabyprice/{min}/{max}")
	public ResponseEntity<List<PizzaDTO>> getPizzaByPrice(@PathVariable("min") Double minPrice,
			@PathVariable("max") Double maxPrice) throws ResourceNotFound {
		List<PizzaDTO> pizzaList = pizzaservice.viewPizzaByPrice(minPrice, maxPrice);
		return new ResponseEntity<>(pizzaList, HttpStatus.OK);
	}
}
