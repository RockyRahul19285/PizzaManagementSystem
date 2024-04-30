package com.onlinepizza.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepizza.Repository.PizzaOrderRepository;
import com.onlinepizza.dao.IPizzaOrderService;
import com.onlinepizza.dto.PizzaDTO;
import com.onlinepizza.dto.PizzaOrderDTO;
import com.onlinepizza.entity.PizzaOrder;
import com.onlinepizza.util.PizzaStatus;

@Service
public class IPizzaOrderServiceImpl implements IPizzaOrderService{
	
	@Autowired
	IPizzaServiceImpl pimpl;
	
	@Autowired
	ICustomerServiceImpl cimpl;
	
	@Autowired
	PizzaOrderRepository pizzaorderrep;
	
	
	@Autowired
	ModelMapper modelMapper;
	
	//E TO DTo
	public PizzaOrderDTO mapTOdto(PizzaOrder pizzaorder) {
		return modelMapper.map(pizzaorder, PizzaOrderDTO.class);
	}
	
	//D TO E
	public PizzaOrder mapTOentity(PizzaOrderDTO orderdto) {
		return modelMapper.map(orderdto, PizzaOrder.class);
	}

	@Override
	public PizzaOrderDTO bookPizzaOrder(PizzaOrderDTO order) {
	
//		cimpl.registerCustomer(order.getCustomer());
//	    System.out.println(order.getCustomer().getCustomerName());
//	    List<PizzaDTO> pizzaList = order.getPizzaList();
//	    for(PizzaDTO pdt:pizzaList)
//	    {
//	    	pimpl.addPizza(pdt);
//	    }
	    
	    
		return mapTOdto(pizzaorderrep.save(mapTOentity(order)));
	}

	@Override
	public PizzaOrderDTO updatepizzaOrder(PizzaOrderDTO pizzaOrder) {
	PizzaOrder pizup=pizzaorderrep.findById(mapTOentity(pizzaOrder).getBookingOrderId()).get();
	return mapTOdto(pizzaorderrep.save(pizup));
	}

	@Override
	public PizzaOrderDTO cancelPizzaOrder(Integer pizzaId) {
		PizzaOrder findById = pizzaorderrep.findById(pizzaId).get();
		pizzaorderrep.deleteById(findById.getBookingOrderId());
		
		return mapTOdto(findById);
	}

	@Override
	public PizzaOrderDTO viewPizzaOrderById(Integer pizzaOrderId) {
		
		return  mapTOdto(pizzaorderrep.findById(pizzaOrderId).get());
	}

	@Override
	public List<PizzaOrderDTO> viewAllPizzaOrders() {
		List<PizzaOrderDTO> pizzaorderdto=new ArrayList<>();
		List<PizzaOrder> pizzaorder =pizzaorderrep.findAll();
		
		for(PizzaOrder po:pizzaorder) {
			pizzaorderdto.add(mapTOdto(po));
		}
		return pizzaorderdto;
	}

	@Override
	public List<PizzaOrderDTO> viewPizzaOrderByStartAndEndDate(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PizzaOrderDTO> viewPizzaOrderByDate(LocalDate date) {
		List<PizzaOrder> pizdate=pizzaorderrep.findByDateTimeOfOrder(date);
		List<PizzaOrderDTO> pizdto=new ArrayList<>();
		for(PizzaOrder po:pizdate)
		{
			pizdto.add(mapTOdto(po));
		}
		
		return pizdto;
	}

	@Override
	public List<PizzaOrderDTO> viewPizzaOrderByCustomerId(Integer customerId) {
		List<PizzaOrder> listpr=pizzaorderrep.findByCustomer_UserId(customerId);
		List<PizzaOrderDTO> listprd=new ArrayList<>();
		for(PizzaOrder prr:listpr)
		{
			listprd.add(mapTOdto(prr));
		}
		return listprd;
	}

	@Override
	public List<PizzaOrderDTO> viewPizzaOrderByStatus(String status) {
		PizzaStatus booked = PizzaStatus.BOOKED;
		if(status.equals("DELIVERED"))
		{
			booked=PizzaStatus.DELIVERED;
		}
		else if(status.equals("CANCELLED"))
		{
			booked=PizzaStatus.CANCELLED;
		}
		List<PizzaOrder> listpo = pizzaorderrep.findByStatus(booked);
		List<PizzaOrderDTO> listpod=new ArrayList<>();
		for(PizzaOrder po:listpo)
		{
			listpod.add(mapTOdto(po));
		}
		return listpod;
	}

	@Override
	public List<PizzaOrderDTO> viewPizzaOrderByCustomerIdAndStatus(Integer customerId, String status) {
		PizzaStatus booked = PizzaStatus.BOOKED;
		if(status.equals("DELIVERED"))
		{
			booked=PizzaStatus.DELIVERED;
		}
		else if(status.equals("CANCELLED"))
		{
			booked=PizzaStatus.CANCELLED;
		}
		List<PizzaOrder> pizordcs=pizzaorderrep.findByCustomer_UserIdAndStatus(customerId,booked );
		List<PizzaOrderDTO> pizordto=new ArrayList<>();
		for(PizzaOrder poo:pizordcs)
		{
			pizordto.add(mapTOdto(poo));
		}
		return pizordto;
	}

}
