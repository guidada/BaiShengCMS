package com.laycoding.cms.service;

import com.laycoding.cms.pojo.Role;
import com.laycoding.cms.pojo.RolePermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {
    List<RolePermission> getRolePermission();
    public List<String> getAllRoles();
    public List<Role> findAll();
    public List<String> getRoleByUserId(int id);
    public int editRole(@Param("id") int id, @Param("name") String name, @Param("sn") String sn);
}
