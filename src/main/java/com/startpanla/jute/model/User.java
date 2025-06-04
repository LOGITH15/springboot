package com.startpanla.jute.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection="users")
public class User {
    @Id
    private String id;

    private String name;
    private String email;
    private int age;
    private String location;
    private String role;
    private String username;
    private String passowrd;



}
