package com.laycoding.cms.mapper;
import com.laycoding.cms.pojo.Role;
import com.laycoding.cms.pojo.RolePermission;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface RoleMapper {
    List<RolePermission> getRolePermission();
    List<String> getAllRoles();
    List<Role> findAll();
    List<String> getRoleByUserId(int id);
    int editRole(@Param("id") int id, @Param("name") String name, @Param("sn") String sn);
}
