package com.laycoding.cms.mapper;

import com.laycoding.cms.pojo.User;

import java.util.List;

public interface UserMapper {
    public List<User> getAll();
    int deleteUserById(int id);
    int addUser(User user);
    User getByUserName(String sys_user);
}
