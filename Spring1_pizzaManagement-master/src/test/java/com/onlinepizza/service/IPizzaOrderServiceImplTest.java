package com.onlinepizza.service;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
 
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.onlinepizza.dto.PizzaOrderDTO;
import com.onlinepizza.entity.PizzaOrder;
import com.onlinepizza.exception.ResourceNotFound;
import com.onlinepizza.repository.PizzaOrderRepository;
import com.onlinepizza.util.PizzaStatus;
 
@ExtendWith(MockitoExtension.class)
 class IPizzaOrderServiceImplTest {
 
    @Mock
    private PizzaOrderRepository pizzaOrderRepository;
 
    @Mock
    private IPizzaServiceImpl pizzaService;
 
    @Mock
    private ICustomerServiceImpl customerService;
 
    @Mock
    private ModelMapper modelMapper;
 
    @InjectMocks
    private IPizzaOrderServiceImpl pizzaOrderService;
 
    @Test
    void testBookPizzaOrder() {
       
        PizzaOrderDTO orderDTO = new PizzaOrderDTO();
        PizzaOrder orderEntity = new PizzaOrder();
 
        when(modelMapper.map(any(), eq(PizzaOrder.class))).thenReturn(orderEntity);
        when(modelMapper.map(any(), eq(PizzaOrderDTO.class))).thenReturn(orderDTO);
        when(pizzaOrderRepository.save(any(PizzaOrder.class))).thenReturn(orderEntity);
 
        // When
        PizzaOrderDTO result = pizzaOrderService.bookPizzaOrder(orderDTO);
 
        // Then
        assertNotNull(result);
    }
 
    @Test
    void testCancelPizzaOrder() throws ResourceNotFound {
        
        Integer pizzaOrderId = 1;
        PizzaOrder orderEntity = new PizzaOrder();
 
        when(pizzaOrderRepository.findById(pizzaOrderId)).thenReturn(Optional.of(orderEntity));
        
 
        // When
        String result = pizzaOrderService.cancelPizzaOrder(pizzaOrderId);
 
        // Then
        assertNotNull(result);
    }
 
    @Test
    void testViewPizzaOrderById() throws ResourceNotFound {
       
        Integer pizzaOrderId = 1;
        PizzaOrderDTO orderDTO = new PizzaOrderDTO();
        PizzaOrder orderEntity = new PizzaOrder();
 
        when(pizzaOrderRepository.findById(pizzaOrderId)).thenReturn(Optional.of(orderEntity));
        when(modelMapper.map(any(), eq(PizzaOrderDTO.class))).thenReturn(orderDTO);
 
        // When
        PizzaOrderDTO result = pizzaOrderService.viewPizzaOrderById(pizzaOrderId);
 
        // Then
        assertNotNull(result);
    }
 
    @Test
    void testViewAllPizzaOrders() throws ResourceNotFound {
       
        List<PizzaOrder> orders = new ArrayList<>();
        orders.add(new PizzaOrder());
 
        when(pizzaOrderRepository.findAll()).thenReturn(orders);
        when(modelMapper.map(any(), eq(PizzaOrderDTO.class))).thenReturn(new PizzaOrderDTO());
 
        // When
        List<PizzaOrderDTO> result = pizzaOrderService.viewAllPizzaOrders();
 
        // Then
        assertNotNull(result);
    }
 
    @Test
    void testViewPizzaOrderByDate() {
        
        LocalDate date = LocalDate.now();
        List<PizzaOrder> orders = new ArrayList<>();
        orders.add(new PizzaOrder());
 
        when(pizzaOrderRepository.findByDateTimeOfOrder(date)).thenReturn(orders);
        when(modelMapper.map(any(), eq(PizzaOrderDTO.class))).thenReturn(new PizzaOrderDTO());
 
        // When
        List<PizzaOrderDTO> result = pizzaOrderService.viewPizzaOrderByDate(date);
 
        // Then
        assertNotNull(result);
    }
 
    @Test
    void testViewPizzaOrderByCustomerIdAndStatus() throws ResourceNotFound {
        
        Integer customerId = 1;
        String status = "BOOKED";
        PizzaStatus booked = PizzaStatus.BOOKED;
 
        when(pizzaOrderRepository.findByCustomer_UserIdAndStatus(customerId, booked)).thenReturn(new ArrayList<>());
        when(modelMapper.map(any(), eq(PizzaOrderDTO.class))).thenReturn(new PizzaOrderDTO());
 
        // When
        List<PizzaOrderDTO> result = pizzaOrderService.viewPizzaOrderByCustomerIdAndStatus(customerId, status);
 
        // Then
        assertNotNull(result);
    }
 
}