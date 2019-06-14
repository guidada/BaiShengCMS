package com.laycoding.cms.service.impl;


import com.laycoding.cms.mapper.RoleMapper;
import com.laycoding.cms.pojo.Role;
import com.laycoding.cms.pojo.RolePermission;
import com.laycoding.cms.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<RolePermission> getRolePermission() {
        return roleMapper.getRolePermission();
    }
    @Override
    public List<String> getAllRoles() {
        return roleMapper.getAllRoles();
    }
    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }
    @Override
    public List<String> getRoleByUserId(int id) {

        return roleMapper.getRoleByUserId(id);
    }
    @Override
    public int editRole(int id, String name, String sn) {

        return roleMapper.editRole(id,name,sn);
    }
}
