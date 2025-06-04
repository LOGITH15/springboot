package com.startpanla.service;

import java.util.List;

import com.startpanla.dto.UserRequest;
import com.startpanla.dto.UserResponse;

public interface UserService {

    UserResponse createUser(UserRequest userRequest);
    List<UserResponse> getAllUsers();
    UserResponse getUserById(String id);
    UserResponse updateUser(String id,UserRequest userRequest);
    void deleteUser(String id);


}
