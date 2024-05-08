package com.onlinepizza.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepizza.dto.ToppingsDTO;
import com.onlinepizza.entity.Toppings;
import com.onlinepizza.repository.ToppingsRepository;

@Service
public class IToppingsServiceImpl {
	@Autowired
	ToppingsRepository topres;
	
	
	@Autowired
	ModelMapper modelMapper;
	
	
	
	//Toppings E TO D
			public ToppingsDTO mapTotopDTO(Toppings toppings) {
			  return modelMapper.map(toppings,ToppingsDTO.class);
			}
			
			//Toppings D TO E
			public Toppings mapTotopEn(ToppingsDTO topdto) {
				return modelMapper.map(topdto, Toppings.class);
				
			}
			
	public ToppingsDTO addToppings(ToppingsDTO top)	
	{
		return mapTotopDTO(topres.save(mapTotopEn(top)));
	}

}
