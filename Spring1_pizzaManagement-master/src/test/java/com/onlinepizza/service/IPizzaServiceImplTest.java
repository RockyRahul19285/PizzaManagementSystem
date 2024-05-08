package com.onlinepizza.service;
 
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.onlinepizza.dto.PizzaDTO;
import com.onlinepizza.dto.PizzaTypeDTO;
import com.onlinepizza.dto.ToppingsDTO;
import com.onlinepizza.entity.Pizza;
import com.onlinepizza.entity.PizzaType;
import com.onlinepizza.entity.Toppings;
import com.onlinepizza.exception.ResourceNotFound;
import com.onlinepizza.repository.PizzaRepository;
import com.onlinepizza.repository.PizzaTypeRepository;
import com.onlinepizza.repository.ToppingsRepository;
import com.onlinepizza.util.PizzaSize;
 
@ExtendWith(MockitoExtension.class)
class IPizzaServiceImplTest {
 
    @Mock
    private PizzaRepository pizzaRepository;
 
    @Mock
    private PizzaTypeRepository pizzaTypeRepository;
 
    @Mock
    private ToppingsRepository toppingsRepository;
 
    @Mock
    private ModelMapper modelMapper;
 
    @InjectMocks
    private IPizzaServiceImpl pizzaService;
 
    @Test
    void testAddPizza() {
        
        PizzaDTO pizzaDTO = new PizzaDTO();
        Pizza pizzaEntity = new Pizza();
 
        when(modelMapper.map(any(), eq(Pizza.class))).thenReturn(pizzaEntity);
        when(modelMapper.map(any(), eq(PizzaDTO.class))).thenReturn(pizzaDTO);
        when(pizzaRepository.save(any(Pizza.class))).thenReturn(pizzaEntity);
 
        // When
        PizzaDTO result = pizzaService.addPizza(pizzaDTO);
 
        // Then
        assertNotNull(result);
        
    }
 
    @Test
    void testAddToppings() {
        
        ToppingsDTO toppingsDTO = new ToppingsDTO();
        Toppings toppingsEntity = new Toppings();
 
        when(modelMapper.map(any(), eq(Toppings.class))).thenReturn(toppingsEntity);
        when(modelMapper.map(any(), eq(ToppingsDTO.class))).thenReturn(toppingsDTO);
        when(toppingsRepository.save(any(Toppings.class))).thenReturn(toppingsEntity);
 
        // When
        ToppingsDTO result = pizzaService.addToppings(toppingsDTO);
 
        // Then
        assertNotNull(result);
        
    }
 
    @Test
    void testAddPizzaType() {
        
        PizzaTypeDTO pizzaTypeDTO = new PizzaTypeDTO();
        PizzaType pizzaTypeEntity = new PizzaType();
 
        when(modelMapper.map(any(), eq(PizzaType.class))).thenReturn(pizzaTypeEntity);
        when(modelMapper.map(any(), eq(PizzaTypeDTO.class))).thenReturn(pizzaTypeDTO);
        when(pizzaTypeRepository.save(any(PizzaType.class))).thenReturn(pizzaTypeEntity);
 
        // When
        PizzaTypeDTO result = pizzaService.addPizzaType(pizzaTypeDTO);
 
        // Then
        assertNotNull(result);
        
    }
 
   
 
    @Test
    void testViewPizzaById() throws ResourceNotFound {
       
        Integer pizzaId = 1;
        PizzaDTO pizzaDTO = new PizzaDTO();
        Pizza pizzaEntity = new Pizza();
 
        when(pizzaRepository.findById(pizzaId)).thenReturn(Optional.of(pizzaEntity));
        when(modelMapper.map(any(), eq(PizzaDTO.class))).thenReturn(pizzaDTO);
 
        // When
        PizzaDTO result = pizzaService.viewPizzaById(pizzaId);
 
        // Then
        assertNotNull(result);
        
    }
 
    @Test
    void testViewPizzaByPizzaType() throws ResourceNotFound {
        
        String pizzaType = "Vegetarian";
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new Pizza());
 
        when(pizzaRepository.findByPizzaType_PizzaType(pizzaType)).thenReturn(pizzas);
        when(modelMapper.map(any(), eq(PizzaDTO.class))).thenReturn(new PizzaDTO());
 
        // When
        List<PizzaDTO> result = pizzaService.viewPizzaByPizzaType(pizzaType);
 
        // Then
        assertNotNull(result);
        
    }
 
    @Test
    void testViewPizzaByPizzaSize() throws ResourceNotFound {
        
        String pizzaSize = "LARGE";
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new Pizza());
 
        when(pizzaRepository.findPizzaByPizzaSize(any(PizzaSize.class))).thenReturn(pizzas);
        when(modelMapper.map(any(), eq(PizzaDTO.class))).thenReturn(new PizzaDTO());
 
        // When
        List<PizzaDTO> result = pizzaService.viewPizzaByPizzaSize(pizzaSize);
 
        // Then
        assertNotNull(result);
        
    }
 
    @Test
    void testViewPizzaByPrice() throws ResourceNotFound {
        
        Double minPrice = 10.0;
        Double maxPrice = 20.0;
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new Pizza());
 
        when(pizzaRepository.findPizzaByPrice(minPrice, maxPrice)).thenReturn(pizzas);
        when(modelMapper.map(any(), eq(PizzaDTO.class))).thenReturn(new PizzaDTO());
 
        // When
        List<PizzaDTO> result = pizzaService.viewPizzaByPrice(minPrice, maxPrice);
 
        // Then
        assertNotNull(result);
        
    }
 
    @Test
    void testViewAllPizza() throws ResourceNotFound {
        
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new Pizza());
 
        when(pizzaRepository.findAll()).thenReturn(pizzas);
        when(modelMapper.map(any(), eq(PizzaDTO.class))).thenReturn(new PizzaDTO());
 
        // When
        List<PizzaDTO> result = pizzaService.viewAllPizza();
 
        // Then
        assertNotNull(result);
       
    }
 
    @Test
    void testViewToppings() throws ResourceNotFound {
        
        List<Toppings> toppings = new ArrayList<>();
        toppings.add(new Toppings());
 
        when(toppingsRepository.findAll()).thenReturn(toppings);
        when(modelMapper.map(any(), eq(ToppingsDTO.class))).thenReturn(new ToppingsDTO());
 
        // When
        List<ToppingsDTO> result = pizzaService.viewToppings();
 
        // Then
        assertNotNull(result);
        
    }
 
    @Test
    void testViewToppingByID() throws ResourceNotFound {
        
        Integer toppingsID = 1;
        Toppings toppings = new Toppings();
 
        when(toppingsRepository.findById(toppingsID)).thenReturn(Optional.of(toppings));
        when(modelMapper.map(any(), eq(ToppingsDTO.class))).thenReturn(new ToppingsDTO());
 
        // When
        ToppingsDTO result = pizzaService.viewToppingByID(toppingsID);
 
        // Then
        assertNotNull(result);
        
    }
 
    @Test
    void testViewPizzaTypeById() throws ResourceNotFound {
        
        Integer pizzaTypeId = 1;
        PizzaType pizzaType = new PizzaType();
 
        when(pizzaTypeRepository.findById(pizzaTypeId)).thenReturn(Optional.of(pizzaType));
        when(modelMapper.map(any(), eq(PizzaTypeDTO.class))).thenReturn(new PizzaTypeDTO());
 
        // When
        PizzaTypeDTO result = pizzaService.viewPizzaTypeById(pizzaTypeId);
 
        // Then
        assertNotNull(result);
        
    }
 
    @Test
    void testViewAllPizzaTypes() throws ResourceNotFound {
        
        List<PizzaType> pizzaTypes = new ArrayList<>();
        pizzaTypes.add(new PizzaType());
 
        when(pizzaTypeRepository.findAll()).thenReturn(pizzaTypes);
        when(modelMapper.map(any(), eq(PizzaTypeDTO.class))).thenReturn(new PizzaTypeDTO());
 
        // When
        List<PizzaTypeDTO> result = pizzaService.viewAllPizzaTypes();
 
        // Then
        assertNotNull(result);
        
    }
 
    
 
}