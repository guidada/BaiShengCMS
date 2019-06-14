package com.laycoding.cms.controller;

import com.laycoding.cms.pojo.UserRole;
import com.laycoding.cms.service.UserRoleService;
import com.laycoding.cms.tools.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sys/userRole")
public class UserRoleController {
     @Resource
     private UserRoleService userRoleService;
     @RequestMapping("/checkRoleById")
     public String checkRoleById(int user_id){
         List<UserRole> list=userRoleService.checkRoleById(user_id);
         if (list.size()>0){
             return JsonResult.jsonResult(0,"succse",list,null);
         }else {
             return JsonResult.jsonResult(-1,"erro",null,null);
         }
     }

    @RequestMapping("/addRole")
    public String addRole(int user_id,int role_id) {
        int res = userRoleService.addRole(user_id, role_id);
        if (res>0){
            return JsonResult.jsonResult(0, "succse", null, null);
        }else {
            return JsonResult.jsonResult(-1, "erro", null, null);
        }
    }
}
