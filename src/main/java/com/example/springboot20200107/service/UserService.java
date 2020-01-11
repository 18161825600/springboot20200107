package com.example.springboot20200107.service;

import com.example.springboot20200107.pojo.User;
import com.example.springboot20200107.request.ChangeUserPasswordRequest;
import com.example.springboot20200107.request.ChangeUserPhoneNumRequest;
import com.example.springboot20200107.request.RegisterUserRequest;
import com.example.springboot20200107.request.UpdateUserRequest;
import com.example.springboot20200107.response.UserResponse;

import java.util.List;

public interface UserService {

    User loginUser(String userName, String password);
    Integer registerUser(RegisterUserRequest registerUserRequest);
    Integer deleteUserByUserName(String userName);
    Integer updateByUserNameSelective(UpdateUserRequest updateUserRequest, String userName);
    Integer updateByUserIdSelective(User user);
    Integer changeUserPassword(ChangeUserPasswordRequest cUPRequest);
    Integer changeUserPhoneNum(ChangeUserPhoneNumRequest changeUserPhoneNumRequest);
    User selectUserById(Long id);
    UserResponse selectUserByUserName(String userName);
    List<UserResponse> selectUserByNickName(String nickName);
    List<UserResponse> selectAllUser(Integer pageNum);
    Long countAllUser();
    Long countByStudent();

}
