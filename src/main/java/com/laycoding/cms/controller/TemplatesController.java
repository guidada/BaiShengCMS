package com.laycoding.cms.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplatesController {
    @RequestMapping(value={"/", "login","login.html"})
    public String index(){
        return "login";
    }
    @RequestMapping(value="/admin/index")
    public String adminView(){
        return "admin/index";
    }
    @RequestMapping(value="/admin/console")
    public String adminView1(){
        return "admin/console";
    }
    @RequiresPermissions("customer:query")
    @RequestMapping(value="/admin/supplier")
    public String adminView2(){
        return "admin/supplier";
    }
    @RequiresPermissions("region:query")
    @RequestMapping(value="/admin/region")
    public String adminView3(){
        return "admin/region";
    }
    @RequiresPermissions("contract:query")
    @RequestMapping(value="/admin/contract")
    public String adminView4(){
        return "admin/contract";
    }
    @RequiresPermissions("contract:add")
    @RequestMapping(value="/admin/contract-add")
    public String adminView5(){
        return "admin/contract-add";
    }
    @RequiresPermissions("affiliate:distribution")
    @RequestMapping(value="/admin/regional-distribution")
    public String adminView6(){
        return "admin/regional-distribution";
    }
    @RequiresPermissions("count:money")
    @RequestMapping(value="/admin/money")
    public String adminView7(){
        return "admin/money";
    }
    @RequestMapping(value="/admin/contract-edit")
    public String adminView8(){
        return "admin/contract-edit";
    }
    @RequestMapping(value="/admin/contract-preview")
    public String adminView9(){
        return "admin/contract-preview";
    }
    @RequiresPermissions("user:management")
    @RequestMapping(value="/page/system/user")
    public String pageView(){
        return "page/system/user";
    }
    @RequiresPermissions("privilege:management")
    @RequestMapping(value="/page/system/role")
    public String pageView1(){
        return "page/system/role";
    }
    @RequiresPermissions("login:log")
    @RequestMapping(value="/page/system/loginRecord")
    public String pageView2(){
        return "page/system/loginRecord";
    }
    @RequestMapping(value="/page/tpl/tpl-note")
    public String pageView3(){
        return "page/tpl/tpl-note";
    }
    @RequestMapping(value="/page/tpl/tpl-theme")
    public String pageView4(){
        return "page/tpl/tpl-theme";
    }
}
