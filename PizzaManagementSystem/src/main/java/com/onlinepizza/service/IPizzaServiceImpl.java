package com.onlinepizza.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepizza.Repository.PizzaRepository;
import com.onlinepizza.Repository.PizzaTypeRepository;
import com.onlinepizza.Repository.ToppingsRepository;

import com.onlinepizza.dao.IPizzaService;
import com.onlinepizza.dto.PizzaDTO;
import com.onlinepizza.dto.PizzaTypeDTO;
import com.onlinepizza.dto.ToppingsDTO;
import com.onlinepizza.entity.Pizza;
import com.onlinepizza.entity.PizzaType;
import com.onlinepizza.entity.Toppings;
import com.onlinepizza.util.PizzaSize;

@Service
public class IPizzaServiceImpl implements IPizzaService{

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
	
	//Pizza E TO D
	public PizzaDTO mapToDto(Pizza pizza)
	{
		return modelMapper.map(pizza, PizzaDTO.class);
	}
	
	//Pizza D TO E
	public Pizza mapToEntity(PizzaDTO pizza)
	{
		return modelMapper.map(pizza, Pizza.class);
	}
	
	
	//Toppings E TO D
		public ToppingsDTO mapTotopDTO(Toppings toppings) {
		  return modelMapper.map(toppings,ToppingsDTO.class);
		}
		
		//Toppings D TO E
		public Toppings mapTotopEn(ToppingsDTO topdto) {
			return modelMapper.map(topdto, Toppings.class);
			
		}
		
		
	//PizzaType E TO D
	public PizzaTypeDTO mapTopizzatypeDTO(PizzaType pt) {
	  return modelMapper.map(pt,PizzaTypeDTO.class);
	}
	
	//PizzaType D TO E
	public PizzaType mapTopizzatypeEn(PizzaTypeDTO ptdto) {
		return modelMapper.map(ptdto, PizzaType.class);
		
	}
	
	
	
	@Override
	public PizzaDTO addPizza(PizzaDTO pizza) {
		pimpl.addPizzaType(pizza.getPizzaType());
		List<ToppingsDTO> toppings = pizza.getPizzaType().getToppings();
		for(ToppingsDTO tt:toppings)
		{
			timpl.addToppings(tt);
		}
		return mapToDto(pizzarep.save(mapToEntity(pizza)));
	}

	@Override
	public ToppingsDTO addToppings(ToppingsDTO toppings) {
		   return mapTotopDTO(toppingsrep.save(mapTotopEn(toppings)));
	}

	@Override
	public PizzaTypeDTO addPizzaType(PizzaTypeDTO pizzaType) {
		   return mapTopizzatypeDTO(pizzatyperep.save(mapTopizzatypeEn(pizzaType)));
	}

	@Override
	public PizzaDTO updatePizza(PizzaDTO pizzaDTO,Integer pizzaId) {
			Pizza pizza=pizzarep.findById(pizzaId).get();
			if(pizza!=null) {
				pizzarep.save(mapToEntity(pizzaDTO));
			}
		return mapToDto(pizzarep.save(mapToEntity(pizzaDTO)));
	}

	@Override
	public PizzaDTO viewPizzaById(Integer pizzaId) {
		
		return mapToDto(pizzarep.findById(pizzaId).get());
	}

	@Override
	public List<PizzaDTO> viewPizzaByPizzaType(String pizzaType) {
		List<PizzaDTO> pizzasdto=new ArrayList<>();
        List<Pizza> pizzas=pizzarep.findByPizzaType_PizzaType(pizzaType);
        for(Pizza p:pizzas)
        {
        	pizzasdto.add(mapToDto(p));
        }
		return pizzasdto;
	}
	

	@Override
	public List<PizzaDTO> viewPizzaByPizzaSize(String pizzaSize) {
		PizzaSize ps=PizzaSize.LARGE;
		if(pizzaSize.equals("MEDIUM")) 
		{
			ps=PizzaSize.MEDIUM;
		}
		else if(pizzaSize.equals("SMALL"))
		{
			ps=PizzaSize.SMALL;
		}
		List<PizzaDTO> list=new ArrayList<>();
		List<Pizza> piz=pizzarep.findPizzaByPizzaSize(ps);
		for(Pizza pc:piz)
		{
			list.add(mapToDto(pc));
		}
		return list;
	}

	@Override
	public List<PizzaDTO> viewPizzaByPrice(Double minPrice, Double maxPrice) {
		List<Pizza> lipizza=pizzarep.findPizzaByPrice(minPrice, maxPrice);
		List<PizzaDTO> lipizdto=new ArrayList<>();
		for(Pizza p:lipizza)
		{
			lipizdto.add(mapToDto(p));
		}
		return lipizdto;
	}

	@Override
	public List<PizzaDTO> viewAllPizza() {
		List<PizzaDTO> pizzasdto=new ArrayList<>();
		List<Pizza> pizzaa =pizzarep.findAll();
		for(Pizza pp:pizzaa)
		{
			pizzasdto.add(mapToDto(pp));
		}
		
		return pizzasdto;
	}

	@Override
	public List<ToppingsDTO> viewToppings() {
		List<Toppings> top=toppingsrep.findAll();
		List<ToppingsDTO> topl= new ArrayList<>();
		for(Toppings tt:top)
		{
			topl.add(mapTotopDTO(tt));
		}
		return topl;
	}

	@Override
	public ToppingsDTO viewToppingByID(Integer toppingsID) {
		
		return mapTotopDTO(toppingsrep.findById(toppingsID).get());
	}

	@Override
	public PizzaTypeDTO viewPizzaTypeById(Integer pizzaTypeId) {
		
		return mapTopizzatypeDTO(pizzatyperep.findById(pizzaTypeId).get());
	}

	@Override
	public List<PizzaTypeDTO> viewAllPizzaTypes() {
		List<PizzaType> pizza=pizzatyperep.findAll();
		List<PizzaTypeDTO> ptlist=new ArrayList<>();
		for(PizzaType pty:pizza)
		{
			ptlist.add(mapTopizzatypeDTO(pty));
		}
		return ptlist;
	}

}
