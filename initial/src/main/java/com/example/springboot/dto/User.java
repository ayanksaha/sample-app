package com.example.springboot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String userName;
    private String password;
    private Long userId;
    private String status;
}
