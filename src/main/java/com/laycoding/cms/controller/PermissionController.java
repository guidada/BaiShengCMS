package com.laycoding.cms.controller;

import com.laycoding.cms.mapper.PermissionMapper;
import com.laycoding.cms.pojo.RolePermission;
import com.laycoding.cms.service.PermissionService;
import com.laycoding.cms.tools.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sys/permission")
public class PermissionController {
    @Resource
    private PermissionService permissionService;
    @RequestMapping("/getAllresources")
    public List<String> getAllresources(){
        List<String> list=permissionService.getAllresourcesName();
        return list;
    }
    @RequestMapping("/addPermission")
    public String addPermission(RolePermission rolePermission){
        int res=permissionService.addPermission(rolePermission);
        if (res>0){
            return JsonResult.jsonResult(0,"succse",null,null);
        }else {
            return JsonResult.jsonResult(-1,"erro",null,null);
        }
    }
    @RequestMapping("/deleteRolePermission")
    public String deleteRolePermission(int id){
        int res=permissionService.deleteRolePermission(id);
        if (res>0){
            return JsonResult.jsonResult(0,"succse",null,null);
        }else {
            return JsonResult.jsonResult(-1,"erro",null,null);
        }
    }
}
