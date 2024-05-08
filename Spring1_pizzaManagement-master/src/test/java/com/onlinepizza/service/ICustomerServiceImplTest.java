package com.onlinepizza.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.onlinepizza.dao.ICustomerService;
import com.onlinepizza.dto.CustomerDTO;
import com.onlinepizza.entity.Customer;
import com.onlinepizza.exception.ResourceNotFound;
import com.onlinepizza.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
class ICustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private ICustomerServiceImpl customerService;

    @Test
    void testRegisterCustomer() {
        // Arrange
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setUserName("TestCustomer");
        when(customerRepository.save(any(Customer.class))).thenReturn(new Customer());

        // Act
        CustomerDTO result = customerService.registerCustomer(customerDTO);

        // Assert
        assertNotNull(result);
        assertEquals("TestCustomer", result.getUserName());
    }

    @Test
    void testUpdateCustomer_Success() throws ResourceNotFound {
        // Arrange
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setUserName("UpdatedCustomer");
        when(customerRepository.findById(anyInt())).thenReturn(Optional.of(new Customer()));

        // Act
        CustomerDTO result = customerService.updateCustomer(customerDTO, 1);

        // Assert
        assertNotNull(result);
        assertEquals("UpdatedCustomer", result.getUserName());
    }

    @Test
    void testUpdateCustomer_ResourceNotFound() {
        // Arrange
        CustomerDTO customerDTO = new CustomerDTO();
        when(customerRepository.findById(anyInt())).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(ResourceNotFound.class, () -> customerService.updateCustomer(customerDTO, 1));
    }

    @Test
    void testViewAllCustomer_Success() throws ResourceNotFound {
        // Arrange
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer());
        when(customerRepository.findAll()).thenReturn(customerList);

        // Act
        List<CustomerDTO> result = customerService.viewAllCustomer();

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    void testViewAllCustomer_EmptyList() {
        // Arrange
        when(customerRepository.findAll()).thenReturn(new ArrayList<>());

        // Act and Assert
        assertThrows(ResourceNotFound.class, () -> customerService.viewAllCustomer());
    }

    @Test
    void testViewCustomerById_Success() throws ResourceNotFound {
        // Arrange
        when(customerRepository.findById(anyInt())).thenReturn(Optional.of(new Customer()));

        // Act
        CustomerDTO result = customerService.viewCustomerById(1);

        // Assert
        assertNotNull(result);
    }

    @Test
    void testViewCustomerById_ResourceNotFound() {
        // Arrange
        when(customerRepository.findById(anyInt())).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(ResourceNotFound.class, () -> customerService.viewCustomerById(1));
    }

    @Test
    void testDeleteCustomerById_Success() throws ResourceNotFound {
        // Arrange
        when(customerRepository.findById(anyInt())).thenReturn(Optional.of(new Customer()));

        // Act
        String result = customerService.deleteCustomerById(1);

        // Assert
        assertEquals("Deleted Successfully", result);
        verify(customerRepository, times(1)).deleteById(anyInt());
    }

    @Test
    void testDeleteCustomerById_ResourceNotFound() {
        // Arrange
        when(customerRepository.findById(anyInt())).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(ResourceNotFound.class, () -> customerService.deleteCustomerById(1));
    }
}
