package com.example.springboot20200107.request;

import lombok.Data;

@Data
public class RegisterUserRequest {

    private String userName;

    private String password;

    private String nickName;

    private String phoneNum;

}
