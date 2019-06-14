package com.laycoding.cms.service.impl;

import com.laycoding.cms.mapper.UserRoleMapper;
import com.laycoding.cms.pojo.User;
import com.laycoding.cms.pojo.UserRole;
import com.laycoding.cms.service.UserRoleService;
import com.laycoding.cms.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Resource
    private UserRoleMapper userRoleMapper;
    @Override
    public int addRole(int user_id, int role_id) {
        return userRoleMapper.addRole(user_id,role_id);
    }
    @Override
    public List<UserRole> checkRoleById(@Param("user_id") int user_id) {
        return userRoleMapper.checkRoleById(user_id);
    }
}
