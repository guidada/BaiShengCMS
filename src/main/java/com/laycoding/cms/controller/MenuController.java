package com.laycoding.cms.controller;

import com.alibaba.fastjson.JSONObject;
import com.laycoding.cms.pojo.Menu;
import com.laycoding.cms.service.MenuService;
import com.laycoding.cms.tools.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sys")
public class MenuController {
    @Resource
    private MenuService menuService;
    @RequestMapping(value = "/getMenu",produces = "application/json; charset=utf-8",method = RequestMethod.GET)
    public String getMenu(){
        List<Menu> list=menuService.getAllMenu();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("data",list);
        return jsonObject.toString();
    }
    @RequestMapping(value = "/getMenu",produces = "application/json; charset=utf-8",method = RequestMethod.POST)
    public String addMenu(Menu menu){
        System.out.println(menu);
        int res=menuService.addMenu(menu);
        return JsonResult.jsonResult(0,"sussce",null,null);
    }
    @RequestMapping(value = "/getAllMenu",produces = "application/json; charset=utf-8",method = RequestMethod.GET)
    public List<Menu> getAllMenu(){
        List<Menu> list=menuService.getAllMenu();
        return list;
    }
}
