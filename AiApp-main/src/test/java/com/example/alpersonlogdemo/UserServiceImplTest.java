package com.example.alpersonlogdemo.service.impl;

import com.example.alpersonlogdemo.UserDto.UserRequestDTO;
import com.example.alpersonlogdemo.UserDto.UserResponseDTO;
import com.example.alpersonlogdemo.entity.UserEntity;
import com.example.alpersonlogdemo.mapper.UserMapper;
import com.example.alpersonlogdemo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    private UserEntity userEntity;
    private UserRequestDTO userRequestDTO;
    private UserResponseDTO userResponseDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setFullName("John Doe");
        userEntity.setEmail("john@example.com");
        userEntity.setPassword("12345");

        userRequestDTO = new UserRequestDTO();
        userRequestDTO.setFullName("John Doe");
        userRequestDTO.setEmail("john@example.com");
        userRequestDTO.setPassword("12345");

        userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(1L);
        userResponseDTO.setFullName("John Doe");
        userResponseDTO.setEmail("john@example.com");
    }

    @Test
    void createUser_ShouldSaveAndReturnDto() {
        // Arrange
        when(userMapper.toEntity(userRequestDTO)).thenReturn(userEntity);
        when(userRepository.save(userEntity)).thenReturn(userEntity);
        when(userMapper.toDto(userEntity)).thenReturn(userResponseDTO);

        // Act
        UserResponseDTO result = userService.createUser(userRequestDTO);

        // Assert
        assertNotNull(result);
        assertEquals("John Doe", result.getFullName());
        verify(userRepository, times(1)).save(userEntity);
    }

    @Test
    void getUserById_ShouldReturnUser_WhenFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(userEntity));
        when(userMapper.toDto(userEntity)).thenReturn(userResponseDTO);

        UserResponseDTO result = userService.getUserById(1L);

        assertEquals("John Doe", result.getFullName());
        verify(userRepository).findById(1L);
    }

    @Test
    void getUserById_ShouldThrowException_WhenNotFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        ResourceAccessException exception = assertThrows(ResourceAccessException.class,
                () -> userService.getUserById(1L));

        assertTrue(exception.getMessage().contains("İstifadəçi tapılmadı"));
    }

    @Test
    void getAllUsers_ShouldReturnListOfUsers() {
        List<UserEntity> entities = Arrays.asList(userEntity);
        List<UserResponseDTO> dtos = Arrays.asList(userResponseDTO);

        when(userRepository.findAll()).thenReturn(entities);
        when(userMapper.toDto(userEntity)).thenReturn(userResponseDTO);

        List<UserResponseDTO> result = userService.getAllUsers();

        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getFullName());
    }

    @Test
    void updateUser_ShouldUpdateAndReturnDto() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(userEntity));
        when(userRepository.save(any(UserEntity.class))).thenReturn(userEntity);
        when(userMapper.toDto(any(UserEntity.class))).thenReturn(userResponseDTO);

        UserResponseDTO result = userService.updateUser(1L, userRequestDTO);

        assertEquals("John Doe", result.getFullName());
        verify(userRepository).save(any(UserEntity.class));
    }

    @Test
    void updateUser_ShouldThrowException_WhenNotFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceAccessException.class,
                () -> userService.updateUser(1L, userRequestDTO));

        verify(userRepository, never()).save(any());
    }

    @Test
    void deleteUser_ShouldDelete_WhenExists() {
        when(userRepository.existsById(1L)).thenReturn(true);

        userService.deleteUser(1L);

        verify(userRepository).deleteById(1L);
    }

    @Test
    void deleteUser_ShouldThrowException_WhenNotExists() {
        when(userRepository.existsById(1L)).thenReturn(false);

        assertThrows(ResourceAccessException.class, () -> userService.deleteUser(1L));

        verify(userRepository, never()).deleteById(anyLong());
    }
}
