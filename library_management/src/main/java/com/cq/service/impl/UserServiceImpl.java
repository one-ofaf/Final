package com.cq.service.impl;

import com.cq.mapper.UserMapper;
import com.cq.pojo.User;
import com.cq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserMapper userMapper; // 注入UserMapper接口

    // 添加用户

    @Override
    public User login(User user) {

        return   userMapper.getByIdandpassword(user);
    }

    @Override
    public void save(User user) {
       userMapper.insert(user);
    }

    @Override
    public void delete(List<Integer> ids) {
        userMapper.delete(ids);
    }

    @Override
    public List<User> find() {
        List<User> list = userMapper.find();
        return list;
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public User registService(User user) {
        if(userMapper.findByUname(user.getUserName())!=0){
            // 无法注册
            return null;
        }else{
            //返回创建好的用户对象(带uid)
            userMapper.insert(user);
            return user;
        }

    }

    // 其他业务逻辑方法...
}
