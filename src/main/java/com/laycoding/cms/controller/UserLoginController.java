package com.laycoding.cms.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.laycoding.cms.pojo.Franchisee;
import com.laycoding.cms.pojo.User;
import com.laycoding.cms.service.UserService;
import com.laycoding.cms.tools.CaptchaUtil;
import com.laycoding.cms.tools.CodeMd5;
import com.laycoding.cms.tools.JsonResult;
import com.laycoding.cms.tools.MyPageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserLoginController {
    @Resource
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(UserLoginController.class);
    @RequestMapping(value="/userLogin",produces = "application/json; charset=utf-8",method = RequestMethod.POST)
    @ResponseBody
    public String login(HttpServletRequest request,String username,String password,String code){
        //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, CodeMd5.StringToMd5(password));
        subject.login(token);
        if (!CaptchaUtil.ver(code, request)) {
            CaptchaUtil.clear(request);
           return JsonResult.jsonResult(-3,"验证码不正确",null,null);
        }else {
            return JsonResult.jsonResult(0,"sussce","admin/index",null);
        }
    }
    @RequestMapping("/getAll")
    @ResponseBody
    public MyPageInfo<User> getAll(int page,int limit){
        PageHelper.startPage(page,limit);
        List<User> list=userService.getAll();
        MyPageInfo<User> pageInfo=new MyPageInfo<>(list);
        return pageInfo;
    }
    @RequestMapping("/deleteUserById")
    @ResponseBody
    public String deleteUserById(int id){
        int res=userService.deleteUserById(id);
        if (res>0){
            return JsonResult.jsonResult(0,"succse",null,null);
        }else {
            return JsonResult.jsonResult(-1,"erro",null,null);
        }

    }
    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(User user){
        User user1=new User();
        user1.setSys_user(user.getSys_user());
        user1.setSys_password(CodeMd5.StringToMd5(user.getSys_password()));
        user1.setSys_nick(user.getSys_nick());
        int res=userService.addUser(user1);
        if (res>0){
            return JsonResult.jsonResult(0,"succse",null,null);
        }else {
            return JsonResult.jsonResult(-1,"erro",null,null);
        }
    }
    @RequestMapping("/images/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CaptchaUtil.out(request, response);
    }
}
