package com.laycoding.cms.shiro;

import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 统一异常处理
 * Created by fuxiaoj on 2018/04/11 15:48
 */
public class MyExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        ModelAndView mv = new ModelAndView();
        if (ex instanceof UnauthenticatedException) {
            mv.addObject("code", "1000001");
            mv.addObject("msg", "token错误");
        } else if (ex instanceof UnauthorizedException) {
            mv.addObject("code", "403");
            mv.addObject("msg", "用户无权限");
        } else {
            mv.addObject("code", "500");
            mv.addObject("msg", "服务器内部错误");
        }
        mv.setViewName("views/404.html");
        return mv;
    }
}
