package com.example.alpersonlogdemo.mapper;

import com.example.alpersonlogdemo.UserDto.UserRequestDTO;
import com.example.alpersonlogdemo.UserDto.UserResponseDTO;
import com.example.alpersonlogdemo.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

import static org.hibernate.validator.internal.engine.messageinterpolation.el.RootResolver.FORMATTER;
@Component
public class UserMapper {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public UserEntity toEntity(UserRequestDTO dto){
        if(dto == null)
            return null;

        return UserEntity.builder()
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .password(dto.getPassword()) //bu hisse security service terefinden hash edilecek
                .role(dto.getRole())
                .isActive(true)
                .build();
    }


    public UserResponseDTO toDto(UserEntity user){
        if(user ==null)
            return null;


        return UserResponseDTO.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .role(user.getRole())
                .isActive(user.getIsActive())
                .createdAt(user.getCreatedAt() != null ? user.getCreatedAt().format(DateTimeFormatter.ofPattern(FORMATTER)) : null)
                .updatedAt(user.getUpdatedAt() != null ? user.getUpdatedAt().format(DateTimeFormatter.ofPattern(FORMATTER)) : null)
                .build();
    }

}

