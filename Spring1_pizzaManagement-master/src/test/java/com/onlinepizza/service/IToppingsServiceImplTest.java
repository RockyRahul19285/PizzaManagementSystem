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

import com.onlinepizza.dto.ToppingsDTO;
import com.onlinepizza.entity.Toppings;
import com.onlinepizza.repository.ToppingsRepository;
import com.onlinepizza.service.IToppingsServiceImpl;

@ExtendWith(MockitoExtension.class)
class IToppingsServiceImplTest {

    @Mock
    private ToppingsRepository toppingsRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private IToppingsServiceImpl toppingsService;

    @Test
    void testAddToppings() {
        // Arrange
        ToppingsDTO toppingsDTO = new ToppingsDTO();
        toppingsDTO.setToppingsName("Cheese");
        Toppings toppingsEntity = new Toppings();
        toppingsEntity.setToppingsName("Cheese");

        when(modelMapper.map(any(), eq(Toppings.class))).thenReturn(toppingsEntity);
        when(modelMapper.map(any(), eq(ToppingsDTO.class))).thenReturn(toppingsDTO);
        when(toppingsRepository.save(any(Toppings.class))).thenReturn(new Toppings());

        // Act
        ToppingsDTO result = toppingsService.addToppings(toppingsDTO);

        // Assert
        assertNotNull(result);
        assertEquals("Cheese", result.getToppingsName());
    }

    @Test
    void testMapTotopDTO() {
        // Arrange
        Toppings toppingsEntity = new Toppings();
        toppingsEntity.setToppingsName("Pepperoni");

        when(modelMapper.map(any(), eq(ToppingsDTO.class))).thenReturn(new ToppingsDTO());

        // Act
        ToppingsDTO result = toppingsService.mapTotopDTO(toppingsEntity);

        // Assert
        assertNotNull(result);
        assertEquals("Pepperoni", result.getToppingsName());
    }

    @Test
    void testMapTotopEn() {
        // Arrange
        ToppingsDTO toppingsDTO = new ToppingsDTO();
        toppingsDTO.setToppingsName("Mushrooms");

        when(modelMapper.map(any(), eq(Toppings.class))).thenReturn(new Toppings());

        // Act
        Toppings result = toppingsService.mapTotopEn(toppingsDTO);

        // Assert
        assertNotNull(result);
        assertEquals("Mushrooms", result.getToppingsName());
    }

    // Add more test cases as needed for different scenarios and edge cases
}
