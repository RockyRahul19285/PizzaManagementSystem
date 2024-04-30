package com.onlinepizza.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepizza.Repository.PizzaTypeRepository;
import com.onlinepizza.dto.PizzaTypeDTO;
import com.onlinepizza.dto.ToppingsDTO;
import com.onlinepizza.entity.PizzaType;

@Service
public class IPizzaTypeServiceImpl {
	@Autowired
	PizzaTypeRepository piztyperes;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	//PizzaType E TO D
		public PizzaTypeDTO mapTopizzatypeDTO(PizzaType pt) {
		  return modelMapper.map(pt,PizzaTypeDTO.class);
		}
		
		//PizzaType D TO E
		public PizzaType mapTopizzatypeEn(PizzaTypeDTO ptdto) {
			return modelMapper.map(ptdto, PizzaType.class);
			
		}
		
		public PizzaTypeDTO addPizzaType(PizzaTypeDTO ptdto)	
		{
			return mapTopizzatypeDTO(piztyperes.save(mapTopizzatypeEn(ptdto)));
		}

}
