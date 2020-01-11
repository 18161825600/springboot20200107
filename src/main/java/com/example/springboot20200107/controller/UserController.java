package com.example.springboot20200107.controller;

import com.example.springboot20200107.dao.UserDao;
import com.example.springboot20200107.pojo.User;
import com.example.springboot20200107.request.ChangeUserPasswordRequest;
import com.example.springboot20200107.request.ChangeUserPhoneNumRequest;
import com.example.springboot20200107.request.RegisterUserRequest;
import com.example.springboot20200107.request.UpdateUserRequest;
import com.example.springboot20200107.response.UserResponse;
import com.example.springboot20200107.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;

    //登陆
    @GetMapping(value = "login/user")
    public String loginUser(@RequestParam(value = "userName",required = true)String userName,@RequestParam(value = "password",required = true) String password){
        User user = userService.loginUser(userName, password);
        if (user==null){
            return "用户名或密码错误";
        }else
            return "登陆成功";
    }

    //注册
    @PostMapping(value = "register/user")
    public String registerUser(@RequestBody RegisterUserRequest registerUserRequest){
        try {
            Integer integer = userService.registerUser(registerUserRequest);
            if (integer == 1) {
                List<User> users = userDao.selectUserByUserName(registerUserRequest.getUserName());
                User user = new User();
                if (!CollectionUtils.isEmpty(users)) {
                     user = users.get(0);
                }
                return "注册成功!      "+"请牢记你的安全码:"+user.getSafetyCode()+"。在你修改密码时会用到。";
            }
        }
        catch (Exception e){
                return "用户名已存在";
        }
        return "错误";
    }

    //通过用户名删除用户
    @DeleteMapping(value = "delete/user/by/userName")
    public Integer deleteUserByUserName(String userName){
        return userService.deleteUserByUserName(userName);
    }

    //通过用户名修改用户信息
    @PutMapping(value = "update/user/by/userName")
    public Integer updateByUserNameSelective(@RequestBody UpdateUserRequest updateUserRequest, String userName){
        return userService.updateByUserNameSelective(updateUserRequest,userName);
    }

    //通过主键修改用户信息
    @PutMapping(value = "update/by/userId")
    public Integer updateByUserIdSelective(@RequestBody User user){
        return userService.updateByUserIdSelective(user);
    }

    //通过用户名查找用户信息
    @GetMapping(value = "select/user/by/userName")
    public UserResponse selectUserByUserName(String userName){
        return userService.selectUserByUserName(userName);
    }

    //通过昵称查找用户
    @GetMapping(value = "select/user/by/nickName")
    public List<UserResponse> selectUserByNickName(String nickName){
        return userService.selectUserByNickName(nickName);
    }

    //查找全部用户
    @GetMapping(value = "select/all/user")
    public List<UserResponse> selectAllUser(Integer pageNum){
        return userService.selectAllUser(pageNum);
    }

    //查看有多少用户
    @GetMapping(value = "count/all/user")
    public Long countAllUser(){
        return userService.countAllUser();
    }

    //查看用户中有多少学生
    @GetMapping(value = "count/by/student")
    public Long countByStudent(){
        return userService.countByStudent();
    }

    //改密码
    @PutMapping(value = "change/passsword")
    public String changeUserPassword(ChangeUserPasswordRequest cUPRequest){
        Integer integer = userService.changeUserPassword(cUPRequest);
        if(integer==1){
            return "密码更改成功！";
        }else if(integer==0){
            return "两次输入的密码不一致";
        }else if(integer==-1){
            return "新密码不能与旧密码一样";
        }else if(integer==-2){
            return "安全码错误，请输入正确的安全码！";
        }else return "服务器错误";
    }

    //改手机号
    @PutMapping(value = "change/phoneNum")
    public String changeUserPhoneNum(ChangeUserPhoneNumRequest changeUserPhoneNumRequest){
        Integer integer = userService.changeUserPhoneNum(changeUserPhoneNumRequest);
        if(integer==1){
            return "手机号更改成功";
        }else if (integer==-1){
            return "用户名错误，请重试！";
        }else if(integer==-2){
            return "密码错误，请重试！";
        }else return "服务器错误";
    }
}
