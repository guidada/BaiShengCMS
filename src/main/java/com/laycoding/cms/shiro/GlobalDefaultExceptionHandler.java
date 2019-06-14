package com.laycoding.cms.shiro;

import com.laycoding.cms.tools.JsonResult;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    public ModelAndView defaultExceptionHandler(HttpServletRequest req, HttpServletResponse response, Exception e) {
        ModelAndView mv = new ModelAndView("page/tpl/error-403");
        return mv;
    }
   @ExceptionHandler(UnknownAccountException.class)
    public Object UnknownAccountException(HttpServletRequest req, HttpServletResponse response, Exception e) {
        System.out.println("密码错误");
        return JsonResult.jsonResult(-1,"登入失败，账号或密码错误","登入失败，账号不存在！",null);
    }
    @ExceptionHandler(IncorrectCredentialsException.class)
    public Object IncorrectCredentialsException(HttpServletRequest req, HttpServletResponse response, Exception e) {
        System.out.println("密码错误");
        return JsonResult.jsonResult(-2,"登入失败，密码错误","登入失败,密码错误！",null);
    }
    @ExceptionHandler(Exception.class)
    public ModelAndView resultErro(HttpServletRequest req, HttpServletResponse response, Exception e) {
        ModelAndView mv = new ModelAndView("page/tpl/error-500");
        return mv;
    }
}
