package com.startpanla.jute.service;

import java.util.List;

import com.startpanla.jute.dto.UserRequest;
import com.startpanla.jute.dto.UserResponse;

public interface UserService {

    UserResponse createUser(UserRequest userRequest);
    List<UserResponse> getAllUsers();
    UserResponse getUserById(String id);
    UserResponse updateUser(String id,UserRequest userRequest);
    void deleteUser(String id);


}
