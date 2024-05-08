package com.onlinepizza.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.onlinepizza.dto.PizzaTypeDTO;
import com.onlinepizza.entity.PizzaType;
import com.onlinepizza.repository.PizzaTypeRepository;
import com.onlinepizza.service.IPizzaTypeServiceImpl;

@ExtendWith(MockitoExtension.class)
class IPizzaTypeServiceImplTest {

    @Mock
    private PizzaTypeRepository pizzaTypeRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private IPizzaTypeServiceImpl pizzaTypeService;

    @Test
    void testAddPizzaType() {
        // Arrange
        PizzaTypeDTO pizzaTypeDTO = new PizzaTypeDTO();
        PizzaType pizzaTypeEntity = new PizzaType();
        when(modelMapper.map(any(), eq(PizzaType.class))).thenReturn(pizzaTypeEntity);
        when(modelMapper.map(any(), eq(PizzaTypeDTO.class))).thenReturn(pizzaTypeDTO);
        when(pizzaTypeRepository.save(any(PizzaType.class))).thenReturn(new PizzaType());

        // Act
        PizzaTypeDTO result = pizzaTypeService.addPizzaType(pizzaTypeDTO);

        // Assert
        assertNotNull(result);
        // Add assertions based on your business logic and requirements
    }

    @Test
    void testAddPizzaType_SaveFailed() {
        // Arrange
        PizzaTypeDTO pizzaTypeDTO = new PizzaTypeDTO();
        when(modelMapper.map(any(), eq(PizzaType.class))).thenReturn(new PizzaType());
        when(modelMapper.map(any(), eq(PizzaTypeDTO.class))).thenReturn(pizzaTypeDTO);
        when(pizzaTypeRepository.save(any(PizzaType.class))).thenReturn(null); // Simulate save failure

        // Act and Assert
        assertThrows(Exception.class, () -> pizzaTypeService.addPizzaType(pizzaTypeDTO));
    }

    // Add more test cases for other methods based on similar patterns.

}
