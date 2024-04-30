package com.onlinepizza.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinepizza.dto.PizzaOrderDTO;
import com.onlinepizza.entity.PizzaOrder;
import com.onlinepizza.util.PizzaStatus;

@Repository
public interface PizzaOrderRepository extends JpaRepository<PizzaOrder,Integer>{

	//public List<PizzaOrder> findPizzaOrderByDate(LocalDate date);
	
	public List<PizzaOrder> findByStatus(PizzaStatus status);
	
	public List<PizzaOrder> findByCustomer_UserId(Integer customerId);
	
	public List<PizzaOrder> findByDateTimeOfOrder(LocalDate date);
	
	
	public List<PizzaOrder> findByCustomer_UserIdAndStatus(Integer customerId, PizzaStatus status);
}
