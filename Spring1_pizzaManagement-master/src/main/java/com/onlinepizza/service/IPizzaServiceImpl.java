package com.onlinepizza.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepizza.dao.IPizzaService;
import com.onlinepizza.dto.PizzaDTO;
import com.onlinepizza.dto.PizzaTypeDTO;
import com.onlinepizza.dto.ToppingsDTO;
import com.onlinepizza.entity.Pizza;
import com.onlinepizza.entity.PizzaType;
import com.onlinepizza.entity.Toppings;
import com.onlinepizza.exception.ResourceNotFound;
import com.onlinepizza.repository.PizzaRepository;
import com.onlinepizza.repository.PizzaTypeRepository;
import com.onlinepizza.repository.ToppingsRepository;
import com.onlinepizza.util.PizzaSize;

@Service
public class IPizzaServiceImpl implements IPizzaService {

	@Autowired
	IPizzaTypeServiceImpl pimpl;

	@Autowired
	IToppingsServiceImpl timpl;

	@Autowired
	PizzaRepository pizzarep;

	@Autowired
	PizzaTypeRepository pizzatyperep;

	@Autowired
	ToppingsRepository toppingsrep;

	@Autowired
	private ModelMapper modelMapper;

	// Pizza Entity TO DTO Converter
	public PizzaDTO mapToDto(Pizza pizza) {
		return modelMapper.map(pizza, PizzaDTO.class);
	}

	// Pizza DTO TO Entity
	public Pizza mapToEntity(PizzaDTO pizza) {
		return modelMapper.map(pizza, Pizza.class);
	}

	// Toppings Entity TO DTO
	public ToppingsDTO mapToTopDTO(Toppings toppings) {
		return modelMapper.map(toppings, ToppingsDTO.class);
	}

	// Toppings DTO TO Entity
	public Toppings mapToTopEn(ToppingsDTO topdto) {
		return modelMapper.map(topdto, Toppings.class);

	}

	// PizzaType Entity TO DTO
	public PizzaTypeDTO mapToPizzaTypeDTO(PizzaType pt) {
		return modelMapper.map(pt, PizzaTypeDTO.class);
	}

	// PizzaType DTO TO Entity
	public PizzaType mapToPizzaTypeEn(PizzaTypeDTO ptdto) {
		return modelMapper.map(ptdto, PizzaType.class);

	}

	@Override
	public PizzaDTO addPizza(PizzaDTO pizza) {
		return mapToDto(pizzarep.save(mapToEntity(pizza)));
	}

	@Override
	public ToppingsDTO addToppings(ToppingsDTO toppings) {
		return mapToTopDTO(toppingsrep.save(mapToTopEn(toppings)));
	}

	@Override
	public PizzaTypeDTO addPizzaType(PizzaTypeDTO pizzaType) {
		return mapToPizzaTypeDTO(pizzatyperep.save(mapToPizzaTypeEn(pizzaType)));
	}

	@Override
	public PizzaDTO updatePizza(PizzaDTO pizzaDTO, Integer pizzaId) throws ResourceNotFound {
		Optional<Pizza> pizza = pizzarep.findById(pizzaId);

		PizzaDTO pizzaDto = new PizzaDTO();
		if (pizza.isPresent()) {
			Pizza updatedPizza = pizza.get();
			modelMapper.map(pizzaDTO, updatedPizza);
			pizzaDto = mapToDto(pizzarep.save(updatedPizza));
		} else {
			throw new ResourceNotFound("Record Not Found");
		}
		return pizzaDto;
	}

	@Override
	public PizzaDTO viewPizzaById(Integer pizzaId) throws ResourceNotFound {
		Optional<Pizza> pizzaById = pizzarep.findById(pizzaId);
		if (pizzaById.isEmpty()) {
			throw new ResourceNotFound("Record Not Found");
		}
		return mapToDto(pizzaById.get());
	}

	@Override
	public List<PizzaDTO> viewPizzaByPizzaType(String pizzaType) throws ResourceNotFound {
		List<PizzaDTO> pizzasdto = new ArrayList<>();
		if (pizzarep.findByPizzaType_PizzaType(pizzaType).isEmpty()) {
			throw new ResourceNotFound("No Records Are Found");
		} else {
			List<Pizza> pizzas = pizzarep.findByPizzaType_PizzaType(pizzaType);
			for (Pizza p : pizzas) {
				pizzasdto.add(mapToDto(p));
			}
		}
		return pizzasdto;
	}

	@Override
	public List<PizzaDTO> viewPizzaByPizzaSize(String pizzaSize) throws ResourceNotFound {
		PizzaSize ps = null;
		if (pizzaSize.equals("MEDIUM")) {
			ps = PizzaSize.MEDIUM;
		} else if (pizzaSize.equals("SMALL")) {
			ps = PizzaSize.SMALL;
		}
		List<PizzaDTO> list = new ArrayList<>();
		if (pizzarep.findPizzaByPizzaSize(ps).isEmpty()) {
			throw new ResourceNotFound("No Records Are Found");
		} else {
			List<Pizza> piz = pizzarep.findPizzaByPizzaSize(ps);
			for (Pizza pc : piz) {
				list.add(mapToDto(pc));
			}
		}
		return list;
	}

	@Override
	public List<PizzaDTO> viewPizzaByPrice(Double minPrice, Double maxPrice) throws ResourceNotFound {
		List<PizzaDTO> lipizdto = new ArrayList<>();
		if (pizzarep.findPizzaByPrice(minPrice, maxPrice).isEmpty()) {
			throw new ResourceNotFound("No Records Are Found");
		} else {
			List<Pizza> lipizza = pizzarep.findPizzaByPrice(minPrice, maxPrice);
			for (Pizza p : lipizza) {
				lipizdto.add(mapToDto(p));
			}
		}
		return lipizdto;
	}

	@Override
	public List<PizzaDTO> viewAllPizza() throws ResourceNotFound {
		List<PizzaDTO> pizzasdto = new ArrayList<>();
		if (pizzarep.findAll().isEmpty()) {
			throw new ResourceNotFound("No Records Are Found");
		} else {
			List<Pizza> pizzaa = pizzarep.findAll();
			for (Pizza pp : pizzaa) {
				pizzasdto.add(mapToDto(pp));
			}
		}
		return pizzasdto;
	}

	@Override
	public List<ToppingsDTO> viewToppings() throws ResourceNotFound {
		List<Toppings> top = toppingsrep.findAll();
		List<ToppingsDTO> topl = new ArrayList<>();
		if (toppingsrep.findAll().isEmpty()) {
			throw new ResourceNotFound("No Toppings in Found");
		} else {

			for (Toppings tt : top) {
				topl.add(mapToTopDTO(tt));
			}
		}
		return topl;
	}

	@Override
	public ToppingsDTO viewToppingByID(Integer toppingsID) throws ResourceNotFound {
		toppingsrep.findById(toppingsID).orElseThrow(() -> new ResourceNotFound("No Topping Is Found"));
		return mapToTopDTO(toppingsrep.findById(toppingsID).get());
	}

	@Override
	public PizzaTypeDTO viewPizzaTypeById(Integer pizzaTypeId) throws ResourceNotFound {
		pizzatyperep.findById(pizzaTypeId).orElseThrow(() -> new ResourceNotFound("No Such Type Of Pizza Is Found"));
		return mapToPizzaTypeDTO(pizzatyperep.findById(pizzaTypeId).get());
	}

	@Override
	public List<PizzaTypeDTO> viewAllPizzaTypes() throws ResourceNotFound {
		List<PizzaType> pizza = pizzatyperep.findAll();
		List<PizzaTypeDTO> ptlist = new ArrayList<>();
		if (pizzatyperep.findAll().isEmpty()) {
			throw new ResourceNotFound("No PizzaTye is Found");
		} else {
			for (PizzaType pty : pizza) {
				ptlist.add(mapToPizzaTypeDTO(pty));
			}
		}
		return ptlist;
	}

}
