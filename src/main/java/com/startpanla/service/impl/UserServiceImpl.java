package com.startpanla.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.startpanla.dto.UserRequest;
import com.startpanla.dto.UserResponse;
import com.startpanla.model.User;
import com.startpanla.repository.UserRepository;
import com.startpanla.service.UserService;

//import lombok.RequiredArgsConstructor;

@Service
//@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;        
    }


    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User user=convertToEntity(userRequest);
        return convertToResponse(userRepository.save(user));
    }

    @Override
    public List<UserResponse> getAllUsers() {
       return userRepository.findAll().stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserById(String id) {
        User user=userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
        return convertToResponse(user);
    }

    @Override
    public UserResponse updateUser(String id, UserRequest userRequest) {
       User user=userRepository.findById(id).orElseThrow(()-> new RuntimeException("user not found"));
       user.setName(userRequest.getName());
       user.setEmail(user.getEmail());
       user.setAge(userRequest.getAge());
       user.setLocation(userRequest.getLocation());
       user.setRole(userRequest.getRole());
       user.setUsername(userRequest.getUsername());
       user.setPassowrd(user.getPassowrd());
       return convertToResponse(userRepository.save(user));

    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
    private User convertToEntity(UserRequest userRequest){
        return User.builder()
        .name(userRequest.getName())
        .email(userRequest.getEmail())
        .age(userRequest.getAge())
        .location(userRequest.getLocation())
        .role(userRequest.getRole())
        .username(userRequest.getUsername())
        .passowrd(userRequest.getPassowrd())
        .build();
    }
    private UserResponse convertToResponse(User user){
        return UserResponse.builder()
        .id(user.getId())
        .name(user.getName())
        .email(user.getEmail())
        .age(user.getAge())
        .location(user.getLocation())
        .role(user.getRole())
        .build();
    }


}
