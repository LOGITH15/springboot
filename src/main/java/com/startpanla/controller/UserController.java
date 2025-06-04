package com.startpanla.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.startpanla.dto.UserRequest;
import com.startpanla.dto.UserResponse;
import com.startpanla.service.UserService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;

    }
@PostMapping
public ResponseEntity<UserResponse> createUSer(@RequestBody UserRequest userRequest) {
    return ResponseEntity.ok(userService.createUser(userRequest));
}
@GetMapping
public ResponseEntity<List<UserResponse>>getAllUser() {

    return ResponseEntity.ok(userService.getAllUsers());
}
@GetMapping("/{id}")
public ResponseEntity<UserResponse>getUserById(@PathVariable String id) {

    return ResponseEntity.ok(userService.getUserById(id));
}
@PutMapping("/{id}")
public ResponseEntity<UserResponse>updateUser(@PathVariable String id,@RequestBody UserRequest userRequest){
    return ResponseEntity.ok(userService.updateUser(id,userRequest));
}
@DeleteMapping("/{id}")
public ResponseEntity<?>deleteUser(@PathVariable String id){
userService.deleteUser(id);
    return ResponseEntity.noContent().build();

}

}