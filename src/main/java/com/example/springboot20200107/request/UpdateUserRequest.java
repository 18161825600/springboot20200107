package com.example.springboot20200107.request;


import lombok.Data;

@Data
public class UpdateUserRequest {

    private String nickName;

    private String userImg;

    private Short isStudent;
}
