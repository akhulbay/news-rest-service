package com.example.strongtestassignment.dto;

import lombok.Value;

@Value
public class AuthenticationRequest {

    String email;
    String password;
}
