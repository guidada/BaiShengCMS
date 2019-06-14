package com.laycoding.cms.service.impl;

import com.laycoding.cms.mapper.UserMapper;
import com.laycoding.cms.pojo.User;
import com.laycoding.cms.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public int deleteUserById(int id) {
        return userMapper.deleteUserById(id);
    }
    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public User getByUserName(String sys_user) {
        return userMapper.getByUserName(sys_user);
    }
}
