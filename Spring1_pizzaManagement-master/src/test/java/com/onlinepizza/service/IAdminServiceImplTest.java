package com.onlinepizza.service;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

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

import com.onlinepizza.dao.IAdminService;
import com.onlinepizza.dto.AdminDTO;
import com.onlinepizza.entity.Admin;
import com.onlinepizza.exception.ResourceNotFound;
import com.onlinepizza.repository.AdminRepository;

@ExtendWith(MockitoExtension.class)
class IAdminServiceImplTest {

    @Mock
    private AdminRepository adminRepository;

    @InjectMocks
    private IAdminServiceImpl adminService;

    @Test
    void testRegisterAdmin() {
        // Arrange
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setUserName("TestAdmin");
        when(adminRepository.save(any(Admin.class))).thenReturn(new Admin());

        // Act
        AdminDTO result = adminService.registerAdmin(adminDTO);

        // Assert
        assertNotNull(result);
        assertEquals("TestAdmin", result.getUserName());
    }

    @Test
    void testUpdateAdmin_Success() throws ResourceNotFound {
        // Arrange
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setUserName("UpdatedAdmin");
        when(adminRepository.findById(anyInt())).thenReturn(Optional.of(new Admin()));

        // Act
        AdminDTO result = adminService.updateAdmin(adminDTO, 1);

        // Assert
        assertNotNull(result);
        assertEquals("UpdatedAdmin", result.getUserName());
    }

    @Test
    void testUpdateAdmin_ResourceNotFound() {
        // Arrange
        AdminDTO adminDTO = new AdminDTO();
        when(adminRepository.findById(anyInt())).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(ResourceNotFound.class, () -> adminService.updateAdmin(adminDTO, 1));
    }

    @Test
    void testViewAllAdmin_Success() throws ResourceNotFound {
        // Arrange
        List<Admin> adminList = new ArrayList<>();
        adminList.add(new Admin());
        when(adminRepository.findAll()).thenReturn(adminList);

        // Act
        List<AdminDTO> result = adminService.viewAllAdmin();

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    void testViewAllAdmin_EmptyList() {
        // Arrange
        when(adminRepository.findAll()).thenReturn(new ArrayList<>());

        // Act and Assert
        assertThrows(ResourceNotFound.class, () -> adminService.viewAllAdmin());
    }

    @Test
    void testViewAdminById_Success() throws ResourceNotFound {
        // Arrange
        when(adminRepository.findById(anyInt())).thenReturn(Optional.of(new Admin()));

        // Act
        AdminDTO result = adminService.viewAdminById(1);

        // Assert
        assertNotNull(result);
    }

    @Test
    void testViewAdminById_ResourceNotFound() {
        // Arrange
        when(adminRepository.findById(anyInt())).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(ResourceNotFound.class, () -> adminService.viewAdminById(1));
    }

    @Test
    void testDeleteAdminById_Success() throws ResourceNotFound {
        // Arrange
        when(adminRepository.findById(anyInt())).thenReturn(Optional.of(new Admin()));

        // Act
        String result = adminService.deleteAdminById(1);

        // Assert
        assertEquals("Deleted Successfully", result);
        verify(adminRepository, times(1)).deleteById(anyInt());
    }

    @Test
    void testDeleteAdminById_ResourceNotFound() {
        // Arrange
        when(adminRepository.findById(anyInt())).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(ResourceNotFound.class, () -> adminService.deleteAdminById(1));
    }
}

