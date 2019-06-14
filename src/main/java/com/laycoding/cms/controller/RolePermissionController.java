package com.laycoding.cms.controller;

import com.laycoding.cms.pojo.RolePermission;
import com.laycoding.cms.service.RoleService;
import com.laycoding.cms.tools.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sys/role")
public class RolePermissionController {
    @Resource
    private RoleService roleService;

    @RequestMapping("/getRolePermission")
    public String getRolePermission(){
        List<RolePermission> list=roleService.getRolePermission();
        return JsonResult.jsonResult(0,"succse",list,list.size());
    }
}
