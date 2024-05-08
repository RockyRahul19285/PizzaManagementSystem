package com.onlinepizza.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import com.onlinepizza.dao.IAdminService;
import com.onlinepizza.dao.ICustomerService;
import com.onlinepizza.dto.AdminDTO;
import com.onlinepizza.dto.CustomerDTO;
import com.onlinepizza.exception.ResourceNotFound;
import com.onlinepizza.controller.AdminController;

@ExtendWith(MockitoExtension.class)
class AdminControllerTest {

    @Mock
    private IAdminService adminService;

    @Mock
    private ICustomerService customerService;

    @InjectMocks
    private AdminController adminController;

    @Test
    void testRegisterAdmin() throws MethodArgumentNotValidException {
        // Arrange
        AdminDTO adminDTO = new AdminDTO();
        when(adminService.registerAdmin(any())).thenReturn(adminDTO);

        // Act
        ResponseEntity<AdminDTO> response = adminController.registerAdmin(adminDTO);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(adminDTO, response.getBody());
    }

    @Test
    void testShowAdmin() throws ResourceNotFound {
        // Arrange
        List<AdminDTO> adminList = new ArrayList<>();
        when(adminService.viewAllAdmin()).thenReturn(adminList);

        // Act
        ResponseEntity<List<AdminDTO>> response = adminController.showAdmin(null);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(adminList, response.getBody());
    }

    @Test
    void testAdminById() throws ResourceNotFound {
        // Arrange
        AdminDTO adminDTO = new AdminDTO();
        when(adminService.viewAdminById(anyInt())).thenReturn(adminDTO);

        // Act
        ResponseEntity<AdminDTO> response = adminController.adminById(1);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(adminDTO, response.getBody());
    }

    @Test
    void testDeleteAdminById() throws ResourceNotFound {
        // Arrange
        when(adminService.deleteAdminById(anyInt())).thenReturn("Deleted Successfully");

        // Act
        ResponseEntity<String> response = adminController.deleteAdminById(1);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Deleted Successfully", response.getBody());
    }

    @Test
    void testUpdateAdmin() throws ResourceNotFound {
        // Arrange
        AdminDTO adminDTO = new AdminDTO();
        when(adminService.updateAdmin(any(), anyInt())).thenReturn(adminDTO);

        // Act
        ResponseEntity<AdminDTO> response = adminController.updateAdmin(adminDTO, 1);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(adminDTO, response.getBody());
    }

    @Test
    void testGetAllCustomers() throws ResourceNotFound {
        // Arrange
        List<CustomerDTO> customerList = new ArrayList<>();
        when(customerService.viewAllCustomer()).thenReturn(customerList);

        // Act
        ResponseEntity<List<CustomerDTO>> response = adminController.getAllCustomers();

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customerList, response.getBody());
    }

    @Test
    void testGetByCustomerPhone() throws ResourceNotFound {
        // Arrange
        CustomerDTO customerDTO = new CustomerDTO();
        when(customerService.viewCustomerByPhone(anyLong())).thenReturn(customerDTO);

        // Act
        ResponseEntity<CustomerDTO> response = adminController.getByCustomerPhone(1234567890L);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customerDTO, response.getBody());
    }

    @Test
    void testDeleteCustomerById() throws ResourceNotFound {
        // Arrange
        when(customerService.deleteCustomerById(anyInt())).thenReturn("Deleted Successfully");

        // Act
        ResponseEntity<String> response = adminController.deleteCustomerById(1);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Deleted Successfully", response.getBody());
    }

    // Add more test cases as needed...

}
