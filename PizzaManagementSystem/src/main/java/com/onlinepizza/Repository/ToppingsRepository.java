package com.onlinepizza.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinepizza.entity.Toppings;

public interface ToppingsRepository extends JpaRepository<Toppings,Integer> {

}
