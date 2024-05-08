package com.onlinepizza.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepizza.dao.IPizzaOrderService;
import com.onlinepizza.dto.PizzaOrderDTO;
import com.onlinepizza.entity.PizzaOrder;
import com.onlinepizza.exception.ResourceNotFound;
import com.onlinepizza.repository.PizzaOrderRepository;
import com.onlinepizza.util.PizzaStatus;

@Service
public class IPizzaOrderServiceImpl implements IPizzaOrderService{
	
	@Autowired
	IPizzaServiceImpl pizzaserviceimpl;
	
	@Autowired
	ICustomerServiceImpl customerserviceimpl;
	
	@Autowired
	PizzaOrderRepository pizzaorderrepo;
	
	
	@Autowired
	ModelMapper modelMapper;
	
	//Entity TO DTO converter
	public PizzaOrderDTO mapToDto(PizzaOrder pizzaorder) {
		return modelMapper.map(pizzaorder, PizzaOrderDTO.class);
	}
	
	//D TO E
	public PizzaOrder mapToEntity(PizzaOrderDTO orderdto) {
		return modelMapper.map(orderdto, PizzaOrder.class);
	}

	@Override
	public PizzaOrderDTO bookPizzaOrder(PizzaOrderDTO order) {
	    
	    
		return mapToDto(pizzaorderrepo.save(mapToEntity(order)));
	}

    @Override
	public String cancelPizzaOrder(Integer pizzaId)throws ResourceNotFound {
		PizzaOrder findById = pizzaorderrepo.findById(pizzaId).get();
		if(findById==null)
		{
			throw new ResourceNotFound("Record Not Found");
		}
		pizzaorderrepo.deleteById(findById.getBookingOrderId());
		
		return "Order Cancelled Successfully";
	}

	@Override
	public PizzaOrderDTO viewPizzaOrderById(Integer pizzaOrderId) throws ResourceNotFound {
		Optional<PizzaOrder> orderById = pizzaorderrepo.findById(pizzaOrderId);
		if(orderById.isEmpty())
		{
			throw new ResourceNotFound("No Record Found");
		}
		
		return  mapToDto(orderById.get());
	}

	@Override
	public List<PizzaOrderDTO> viewAllPizzaOrders() throws ResourceNotFound {
		List<PizzaOrderDTO> pizzaorderdto=new ArrayList<>();
		List<PizzaOrder> pizzaorder =pizzaorderrepo.findAll();
		
		for(PizzaOrder po:pizzaorder) {
			pizzaorderdto.add(mapToDto(po));
		}
		if(pizzaorder.isEmpty())
		{
			throw new ResourceNotFound("Orders Not Found");
		}
		return pizzaorderdto;
	}

	@Override
	public List<PizzaOrderDTO> viewPizzaOrderByStartAndEndDate(LocalDate startDate, LocalDate endDate) {
		return null;
	}

	@Override
	public List<PizzaOrderDTO> viewPizzaOrderByDate(LocalDate date) {
		List<PizzaOrder> pizdate=pizzaorderrepo.findByDateTimeOfOrder(date);
		List<PizzaOrderDTO> pizdto=new ArrayList<>();
		for(PizzaOrder po:pizdate)
		{
			pizdto.add(mapToDto(po));
		}
		
		return pizdto;
	}

	@Override
	public List<PizzaOrderDTO> viewPizzaOrderByCustomerId(Integer customerId) throws ResourceNotFound {
		List<PizzaOrder> listpr=pizzaorderrepo.findByCustomer_UserId(customerId);
		List<PizzaOrderDTO> listprd=new ArrayList<>();
		for(PizzaOrder prr:listpr)
		{
			listprd.add(mapToDto(prr));
		}
		if(listprd.isEmpty())
		{
			throw new ResourceNotFound("No Record Found");
		}
		return listprd;
	}

	@Override
	public List<PizzaOrderDTO> viewPizzaOrderByStatus(String status)throws ResourceNotFound {
		PizzaStatus booked = null;
		if(status.equals("DELIVERED"))
		{
			booked=PizzaStatus.DELIVERED;
		}
		else if(status.equals("CANCELLED"))
		{
			booked=PizzaStatus.CANCELLED;
		}
		if(pizzaorderrepo.findByStatus(booked).isEmpty())
		{
			throw new ResourceNotFound("No Records are Found");
		}
		List<PizzaOrder> listpo = pizzaorderrepo.findByStatus(booked);
		List<PizzaOrderDTO> listpod=new ArrayList<>();
		for(PizzaOrder po:listpo)
		{
			listpod.add(mapToDto(po));
		}
		return listpod;
	}

	@Override
	public List<PizzaOrderDTO> viewPizzaOrderByCustomerIdAndStatus(Integer customerId, String status)throws ResourceNotFound {
		PizzaStatus booked = null;
		if(status.equals("DELIVERED"))
		{
			booked=PizzaStatus.DELIVERED;
		}
		else if(status.equals("CANCELLED"))
		{
			booked=PizzaStatus.CANCELLED;
		}
		if(pizzaorderrepo.findByCustomer_UserIdAndStatus(customerId, booked).isEmpty())
		{
			 throw new ResourceNotFound("No Record Found");
		}
		List<PizzaOrder> pizordcs=pizzaorderrepo.findByCustomer_UserIdAndStatus(customerId,booked );
		List<PizzaOrderDTO> pizordto=new ArrayList<>();
		for(PizzaOrder poo:pizordcs)
		{
			pizordto.add(mapToDto(poo));
		}
		return pizordto;
	}

}
