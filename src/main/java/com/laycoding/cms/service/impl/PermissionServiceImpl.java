package com.laycoding.cms.service.impl;

import com.laycoding.cms.mapper.PermissionMapper;
import com.laycoding.cms.pojo.Permission;
import com.laycoding.cms.pojo.RolePermission;
import com.laycoding.cms.service.PermissionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionMapper permissionMapper;
    @Override
    public void save(Permission permission) {
      permissionMapper.save(permission);
    }

    @Override
    public List<String> getAllresources() {
        return permissionMapper.getAllresources();
    }

    @Override
    public List<String> getAllresourcesName() {
        return permissionMapper.getAllresourcesName();
    }

    @Override
    public int addPermission(RolePermission rolePermission) {
        return permissionMapper.addPermission(rolePermission);
    }

    @Override
    public int deleteRolePermission(int id) {
        return permissionMapper.deleteRolePermission(id);
    }

    @Override
    public List<String> getPermissionResourceByUseId(@Param("id") int id) {
        return permissionMapper.getPermissionResourceByUseId(id);
    }
}
