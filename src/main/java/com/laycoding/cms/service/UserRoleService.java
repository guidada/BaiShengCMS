package com.laycoding.cms.service;

import com.laycoding.cms.pojo.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleService {
    int addRole(@Param("user_id")  int user_id,@Param("role_id")  int role_id);
    List<UserRole> checkRoleById(@Param("user_id")  int user_id);
}
