package com.startpanla.dto;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {

    private String name;
    private String email;
    private int age;
    private String location;
    private String role;
    private String username;
    private String passowrd;
}
