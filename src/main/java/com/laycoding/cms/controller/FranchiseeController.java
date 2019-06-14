package com.laycoding.cms.controller;

import com.github.pagehelper.PageHelper;
import com.laycoding.cms.pojo.Franchisee;
import com.laycoding.cms.service.FranchiseeService;
import com.laycoding.cms.tools.FileUitl;
import com.laycoding.cms.tools.JsonResult;
import com.laycoding.cms.tools.MyPageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sys/franchisee")
public class FranchiseeController {
    @Resource
    private FranchiseeService franchiseeService;
    @RequestMapping("/getByRegion")
    public MyPageInfo<Franchisee> getByRegion(int page,int limit,String region,int sys_cs_project){
        PageHelper.startPage(page,limit);
        List<Franchisee> list=franchiseeService.getByRegion(region,sys_cs_project);
        MyPageInfo<Franchisee> pageInfo=new MyPageInfo<>(list);
        return pageInfo;
    }
    @RequestMapping("/getFranchiseeByIf")
    public MyPageInfo<Franchisee> getFranchiseeByIf(int page,int limit,String searchKey,String searchValue){
        PageHelper.startPage(page,limit);
        Map<String, String> map = new HashMap<String, String>();
        map.put(searchKey,searchValue);
        int res=0;
        if (map.get("sys_cs_id")!=null){
            res=Integer.parseInt(map.get("sys_cs_id"));
        }
        List<Franchisee> list=franchiseeService.getFranchiseeByIf(res,map.get("sys_cs_name"),map.get("sys_cs_company"),map.get("sys_cs_phone"));
        MyPageInfo<Franchisee> pageInfo=new MyPageInfo<>(list);
        return pageInfo;
    }
    @RequestMapping("/getFranchiseeById")
    public String getFranchiseeById(@RequestParam("sys_ct_num") int sys_ct_num){
        List<Franchisee> list=franchiseeService.getFranchiseeById(sys_ct_num);
       // System.out.println(franchisee.getSys_cs_name());
       if (list.size()>0){
           return JsonResult.jsonResult(0,"succse",list,null);
       }else {
           return JsonResult.jsonResult(-1,"erro",null,null);
       }
    }
    @RequestMapping(value = "/getAllFranchisee",method = RequestMethod.POST)
    public String getAllFranchisee(){
        return JsonResult.jsonResult(0,"succse",null,null);
    }
    @RequestMapping(value = "/getRegion",method = RequestMethod.GET)
    public List<String> getRegion(){
        List<String> list=franchiseeService.getRegion();
        return list;
    }
    @RequestMapping("/getAllContract")
    public MyPageInfo<Franchisee> getAllContract(int page,int limit,int sys_ct_num,String sys_ct_name,int sys_ct_status){
        PageHelper.startPage(page,limit);
        List<Franchisee> list=franchiseeService.getAllContract(sys_ct_num,sys_ct_name,sys_ct_status);
        MyPageInfo<Franchisee> pageInfo=new MyPageInfo<>(list);
        return pageInfo;
    }
    @RequestMapping(value = "/addFranchisee",method = RequestMethod.POST)
    public String addFranchisee(Franchisee franchisee){
       System.out.println(franchisee);
       int res=franchiseeService.addFranchisee(franchisee);
       return JsonResult.jsonResult(0,"succse",null,null);
    }
    @RequestMapping("/updateStatus")
    public String updateStatus(int sys_cs_id,int sys_cs_status){
        int res=franchiseeService.updateStatus(sys_cs_id,sys_cs_status);
        return JsonResult.jsonResult(0,"succse",null,null);
    }

    @RequestMapping("/updateFranchisee")
    public String updateFranchisee(Franchisee franchisee){
        int res=franchiseeService.updateFranchisee(franchisee);
        return JsonResult.jsonResult(0,"succse",null,null);
    }
    @RequestMapping("/updateContract")
    public String updateContract(int id){
        int res=franchiseeService.updateContract(id);
        return JsonResult.jsonResult(0,"succse",null,null);
    }
    @RequestMapping("/deleteFranchisee")
     public String deleteFranchisee(int sys_cs_id){
        int res=franchiseeService.deleteFranchisee(sys_cs_id);
        if (res>0){
            return JsonResult.jsonResult(0,"succse",null,null);
        }else {
            return JsonResult.jsonResult(-1,"erro",null,null);
        }
     }
}
