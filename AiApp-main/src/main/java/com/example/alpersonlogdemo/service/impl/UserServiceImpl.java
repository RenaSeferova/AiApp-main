package com.example.alpersonlogdemo.service.impl;

import com.example.alpersonlogdemo.UserDto.UserRequestDTO;
import com.example.alpersonlogdemo.UserDto.UserResponseDTO;
import com.example.alpersonlogdemo.entity.UserEntity;
import com.example.alpersonlogdemo.mapper.UserMapper;
import com.example.alpersonlogdemo.repository.UserRepository;
import com.example.alpersonlogdemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDTO createUser(UserRequestDTO request){
//        if (userRepository.existsByEmail(request.getEmail())){
//            throw new IllegalArgumentException("Bu email ilə artıq istifadeçi movcuddur!");
//        }
        UserEntity user = userMapper.toEntity(request);
        UserEntity saveUser = userRepository.save(user);
          return userMapper.toDto(saveUser);
    }


    @Override
    public UserResponseDTO getUserById(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow(()-> new ResourceAccessException("İstifadəçi tapılmadı id:" +id));
        return userMapper.toDto(user);
    }

//    @Override
//    public UserResponseDTO getUserById(Long id){
//    UserEntity user = userRepository.findById(id)
//            .orElseThrow(()-> new ResourceAccessException("İstifadəçi tapılmadı id :" + id)) ;
//    return userMapper.toDto(user);
//    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO request) {
        UserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceAccessException("İstifadəçi tapılmadı id: " + id));
        existingUser.setFullName(request.getFullName());
        existingUser.setEmail(request.getEmail());
        existingUser.setPassword(request.getPassword()); // Hash olunmuş formada saxlamaq daha yaxşıdır
        UserEntity updatedUser = userRepository.save(existingUser);
        return userMapper.toDto(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceAccessException("İstifadəçi tapılmadı id: " + id);
        }
        userRepository.deleteById(id);
    }
}
