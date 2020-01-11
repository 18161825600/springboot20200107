package com.example.springboot20200107.request;

import lombok.Data;

@Data
public class ChangeUserPhoneNumRequest {

    private String userName;

    private String password;

    private String phoneNum;
}
