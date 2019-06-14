package com.laycoding.cms.mapper;

import com.laycoding.cms.pojo.Permission;
import com.laycoding.cms.pojo.RolePermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper {
    /*
    * 保存权限*/
    void save(Permission permission);
    List<String> getAllresources();
    List<String> getAllresourcesName();
    int addPermission(RolePermission rolePermission);
    int deleteRolePermission(int id);
    List<String> getPermissionResourceByUseId(@Param("id") int id);
}
