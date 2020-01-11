package com.example.springboot20200107.response;

import lombok.Data;

@Data
public class UserResponse {

    private String userName;

    private String nickName;

    private String userImg;

    private Short isStudent;

    private String phoneNum;

}
