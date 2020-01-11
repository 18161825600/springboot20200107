package com.example.springboot20200107.service.impl;

import com.example.springboot20200107.dao.UserDao;
import com.example.springboot20200107.pojo.User;
import com.example.springboot20200107.request.ChangeUserPasswordRequest;
import com.example.springboot20200107.request.ChangeUserPhoneNumRequest;
import com.example.springboot20200107.request.RegisterUserRequest;
import com.example.springboot20200107.request.UpdateUserRequest;
import com.example.springboot20200107.response.UserResponse;
import com.example.springboot20200107.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User loginUser(String userName, String password) {
        return userDao.loginUser(userName, password);
    }

    @Override
    public Integer registerUser(RegisterUserRequest registerUserRequest) {
        User user = new User();
        user.setUserName(registerUserRequest.getUserName());
        user.setPassword(registerUserRequest.getPassword());
        user.setNickName(registerUserRequest.getNickName());
        user.setPhoneNum(registerUserRequest.getPhoneNum());
        user.setCreateTime(new Date());
        user.setSafetyCode(randomSafetyCode());
        return userDao.registerUser(user);
    }

    @Override
    public Integer deleteUserByUserName(String userName) {
        return userDao.deleteUserByUserName(userName);
    }

    @Override
    public Integer updateByUserNameSelective(UpdateUserRequest updateUserRequest, String userName) {
        User user = new User();
        user.setNickName(updateUserRequest.getNickName());
        user.setUserImg(updateUserRequest.getUserImg());
        user.setIsStudent(updateUserRequest.getIsStudent());
        user.setUpdateTime(new Date());
        return userDao.updateByUserNameSelective(user, userName);
    }

    @Override
    public Integer updateByUserIdSelective(User user) {
        return userDao.updateByUserIdSelective(user);
    }

    @Override
    public Integer changeUserPassword(ChangeUserPasswordRequest cUPRequest) {
        List<User> users = userDao.selectUserByUserName(cUPRequest.getUserName());
        User user = new User();
        if (!CollectionUtils.isEmpty(users)){
             user = users.get(0);
        }
        if(cUPRequest.getSafetyCode().equals(user.getSafetyCode())){
            if(cUPRequest.getNewPassword().equals(user.getPassword())){
                return -1;//新密码不能与旧密码一样
            }else{
                if(cUPRequest.getCopyPassword().equals(cUPRequest.getNewPassword())){
                    user.setPassword(cUPRequest.getNewPassword());
                    userDao.updateByUserNameSelective(user,cUPRequest.getUserName());
                    return 1;//密码更改成功
                }else{
                    return 0;//两次密码不一致
                }
            }
        }else return -2;//安全码错误
    }

    @Override
    public Integer changeUserPhoneNum(ChangeUserPhoneNumRequest changeUserPhoneNumRequest) {
        List<User> users = userDao.selectUserByUserName(changeUserPhoneNumRequest.getUserName());
        if(CollectionUtils.isEmpty(users)){
            return -1;
        }else {
            User user = users.get(0);
            if(changeUserPhoneNumRequest.getPassword().equals(user.getPassword())) {
                user.setPhoneNum(changeUserPhoneNumRequest.getPhoneNum());
                return userDao.updateByUserIdSelective(user);
            }else return -2;
        }
    }

    @Override
    public User selectUserById(Long id) {
        return userDao.selectUserById(id);
    }

    @Override
    public UserResponse selectUserByUserName(String userName) {
        List<User> users = userDao.selectUserByUserName(userName);
        if (!CollectionUtils.isEmpty(users)){
            User user = users.get(0);
            UserResponse userResponse = new UserResponse();
            BeanUtils.copyProperties(user,userResponse);
            return userResponse;
        }
        return null;
    }

    @Override
    public List<UserResponse> selectUserByNickName(String nickName) {
        List<User> users = userDao.selectUserByNickName(nickName);
        return searchUser(users);
    }

    @Override
    public List<UserResponse> selectAllUser(Integer pageNum) {
        List<User> users = userDao.selectAllUser(pageNum);
        return searchUser(users);
    }

    @Override
    public Long countAllUser() {
        return userDao.countAllUser();
    }

    @Override
    public Long countByStudent() {
        return userDao.countByStudent();
    }

    public List<UserResponse> searchUser(List<User> users){
        List<UserResponse> list = new ArrayList<>();
        for (User user:users) {
            UserResponse userResponse = new UserResponse();
            userResponse.setUserName(user.getUserName());
            userResponse.setNickName(user.getNickName());
            userResponse.setIsStudent(user.getIsStudent());
            userResponse.setPhoneNum(user.getPhoneNum());
            userResponse.setUserImg(user.getUserImg());
            list.add(userResponse);
        }
        return list;
    }

    public String randomSafetyCode(){
        char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        int count = 0;
        int i;
        int maxNum = 62;
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        while(count < 8){
            i = Math.abs(random.nextInt(maxNum));
            if (i >= 0 && i < str.length) {
                stringBuffer.append(str[i]);
                count ++;
            }
        }
        return stringBuffer.toString();
    }
}
