package com.max99.max99.services;

import com.max99.max99.dto.UserDTO;
import com.max99.max99.entity.UserEntity;
import com.max99.max99.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private  final ModelMapper modelMapper;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(userEntity -> modelMapper.map(userEntity,UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO createNewUser(UserDTO inputUser) {
        UserEntity userEntity=modelMapper.map(inputUser,UserEntity.class);
        return modelMapper.map(userRepository.save(userEntity), UserDTO.class);
    }

    @Override
    public UserDTO getUserById(Long userId) {
        UserEntity userEntity= userRepository.findById(userId).orElseThrow();
        return modelMapper.map(userEntity,UserDTO.class);
    }

    @Override
    public UserDTO updateUser(UserDTO inputUser, Long userId) {
        UserEntity olderUser = userRepository.findById(userId).orElseThrow();
        inputUser.setId(userId);
        modelMapper.map(inputUser, olderUser);
        UserEntity savedUserEntity = userRepository.save(olderUser);
        return modelMapper.map(savedUserEntity, UserDTO.class);
    }
}