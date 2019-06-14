package com.laycoding.cms.service;

import com.laycoding.cms.pojo.User;

import java.util.List;


public interface UserService {
    public List<User> getAll();
    int deleteUserById(int id);
    int addUser(User user);
    User getByUserName(String sys_user);
}
