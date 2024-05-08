package com.onlinepizza.controller;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import com.onlinepizza.controller.CustomerController;
import com.onlinepizza.dao.ICustomerService;
import com.onlinepizza.dto.CustomerDTO;
import com.onlinepizza.exception.ResourceNotFound;

class CustomerControllerTest {

    @Mock
    private ICustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @Test
    void testRegisterCustomer() {
        // Arrange
        CustomerDTO customerDTO = new CustomerDTO();
        when(customerService.registerCustomer(any(CustomerDTO.class))).thenReturn(customerDTO);

        // Act
        ResponseEntity<CustomerDTO> result = customerController.registerCustomer(customerDTO);

        // Assert
        assertNotNull(result);
        verify(customerService, times(1)).registerCustomer(any(CustomerDTO.class));
    }

    @Test
    void testCustomerById() throws ResourceNotFound {
        // Arrange
        int customerId = 1;
        CustomerDTO customerDTO = new CustomerDTO();
        when(customerService.viewCustomerById(customerId)).thenReturn(customerDTO);

        // Act
        ResponseEntity<CustomerDTO> result = customerController.customerById(customerId);

        // Assert
        assertNotNull(result);
        verify(customerService, times(1)).viewCustomerById(customerId);
    }

    @Test
    void testDeleteCustomerById() throws ResourceNotFound {
        // Arrange
        int customerId = 1;
        when(customerService.deleteCustomerById(customerId)).thenReturn("Deleted Successfully");

        // Act
        ResponseEntity<String> result = customerController.deleteCustomerById(customerId);

        // Assert
        assertEquals("Deleted Successfully",result);
        verify(customerService, times(1)).deleteCustomerById(customerId);
    }

    @Test
    void testUpdateCustomer() throws ResourceNotFound {
        // Arrange
        int customerId = 1;
        CustomerDTO customerDTO = new CustomerDTO();
        when(customerService.updateCustomer(any(CustomerDTO.class), eq(customerId))).thenReturn(customerDTO);

        // Act
        ResponseEntity<CustomerDTO> result = customerController.updateCustomer(customerDTO, customerId);

        // Assert
        assertNotNull(result);
        verify(customerService, times(1)).updateCustomer(any(CustomerDTO.class), eq(customerId));
    }
}
