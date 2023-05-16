package com.example.strongtestassignment.dto;

import lombok.Value;

@Value
public class RegisterRequest {

    String firstname;
    String lastname;
    String email;
    String password;
}
