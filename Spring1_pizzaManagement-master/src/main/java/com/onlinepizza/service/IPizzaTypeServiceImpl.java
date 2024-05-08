package com.onlinepizza.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepizza.dto.PizzaTypeDTO;
import com.onlinepizza.entity.PizzaType;
import com.onlinepizza.repository.PizzaTypeRepository;



@Service
public class IPizzaTypeServiceImpl {
	@Autowired
	PizzaTypeRepository piztyperes;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	//PizzaType Entity TO DTO converter
		public PizzaTypeDTO mapToPizzaTypeDTO(PizzaType pt) {
		  return modelMapper.map(pt,PizzaTypeDTO.class);
		}
		
		//PizzaType DTO TO Entity
		public PizzaType mapToPizzaTypeEn(PizzaTypeDTO ptdto) {
			return modelMapper.map(ptdto, PizzaType.class);
			
		}
		
		public PizzaTypeDTO addPizzaType(PizzaTypeDTO ptdto)	
		{
			return mapToPizzaTypeDTO(piztyperes.save(mapToPizzaTypeEn(ptdto)));
		}

}
