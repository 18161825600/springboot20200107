package com.example.springboot20200107.dao;

import com.example.springboot20200107.mapper.UserMapper;
import com.example.springboot20200107.pojo.User;
import com.example.springboot20200107.pojo.UserExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public User loginUser(String userName, String password){
        return userMapper.loginUser(userName, password);
    }

    public Integer registerUser(User user){
            return userMapper.insert(user);
    }

    public Integer deleteUserByUserName(String userName){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(userName);
        return userMapper.deleteByExample(userExample);
    }

    public Integer updateByUserNameSelective(User user,String userName){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(userName);
        return userMapper.updateByExampleSelective(user,userExample);
    }

    public Integer updateByUserIdSelective(User user){
        user.setUpdateTime(new Date());
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public User selectUserById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> selectUserByUserName(String userName){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(userName);
        return userMapper.selectByExample(userExample);
    }

    public List<User> selectUserByNickName(String nickName){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andNickNameLike("%"+nickName+"%");
        return userMapper.selectByExample(userExample);
    }

    public List<User> selectAllUser(Integer pageNum){
        PageHelper.startPage(pageNum,5);
        UserExample userExample = new UserExample();
        List<User> users = userMapper.selectByExample(userExample);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo.getList();
    }

    public Long countAllUser() {
        UserExample userExample = new UserExample();
        return userMapper.countByExample(userExample);
    }

    public Long countByStudent(){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIsStudentEqualTo((short)0);
        return userMapper.countByExample(userExample);
    }
}
