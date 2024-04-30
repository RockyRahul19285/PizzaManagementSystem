package com.onlinepizza.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinepizza.dto.PizzaDTO;
import com.onlinepizza.dto.ToppingsDTO;
import com.onlinepizza.entity.Pizza;
import com.onlinepizza.util.PizzaSize;
@Repository
public interface PizzaRepository extends JpaRepository<Pizza,Integer> {
	
	
	public List<Pizza> findByPizzaType_PizzaType(String pizzaType);
	
	public List<Pizza> findPizzaByPizzaSize(PizzaSize pizzaSize);
	
	@Query("select p from Pizza p where p.pizzaCost between :minPrice and :maxPrice")
	public List<Pizza> findPizzaByPrice(Double minPrice, Double maxPrice);
	

}
