package com.laycoding.cms.controller;

import com.github.pagehelper.PageHelper;
import com.laycoding.cms.pojo.Contract;
import com.laycoding.cms.service.ContractService;
import com.laycoding.cms.tools.FileUitl;
import com.laycoding.cms.tools.JsonResult;
import com.laycoding.cms.tools.MyPageInfo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sys/contract")
public class ContractController {
    @Resource
    private ContractService contractService;
    @RequestMapping(value = "/getImageByNum",method = RequestMethod.POST)
    public List<String> getImageByNum(int sys_ct_num){
        List<String> list=contractService.getImageByNum(sys_ct_num);
        return list;
    }
    @RequestMapping("/clearFranchisee")
    public String clearFranchisee(int sys_ct_num){
       String filePath1 = "/var/local/upload/"+sys_ct_num+"/";
        //String filePath1 = "D://upload//"+sys_ct_num+"//";
        FileUitl.delFolder(filePath1);
        int res=contractService.clearFranchisee(sys_ct_num);
        return JsonResult.jsonResult(0,"succse",null,null);
    }
}
