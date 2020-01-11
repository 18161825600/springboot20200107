package com.example.springboot20200107.request;

import lombok.Data;

@Data
public class ChangeUserPasswordRequest {

    private String userName;

    private String newPassword;

    private String copyPassword;

    private String safetyCode;
}
