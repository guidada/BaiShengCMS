package com.laycoding.cms.shiro;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统登录认证
 * Created by fuxiaoj on 2018/03/27 15:28
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String authCode = request.getParameter("authCode");
        return new ShiroToken(username, password, authCode);
    }

    /**
     * 未登录或无权限处理
     * @param servletRequest
     * @param servletResponse
     * @return
     * @throws Exception
     */
//    @Override
//    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
//        System.out.println("未登录或者无权限处理");
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        //验证码验证
//        String severAuthCode = (String) request.getSession().getAttribute(Constants.AUTH_CODE_SESSION_KEY);
//        String clientAuthCode = request.getParameter("authCode");
//        if((StringUtils.isBlank(clientAuthCode)) || (severAuthCode != null && !severAuthCode.equalsIgnoreCase(clientAuthCode))) {
//            request.setAttribute("shiroLoginFailure", "kaptchaValidateFailed");
//            return true;
//        }
//        return super.onAccessDenied(request, response);
//    }

    /**
     * 登录成功
     * @param token
     * @param subject
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        System.out.println("登录成功");
        Session session = subject.getSession();
        Map<Object, Object> attributes = new HashMap<>();
        Collection<Object> keys = session.getAttributeKeys();
        for (Object key : keys) {
            attributes.put(key, session.getAttribute(key));
        }
        session.stop();
        //重写session
        session = subject.getSession();
        for (Map.Entry<Object, Object> entry : attributes.entrySet()) {
            session.setAttribute(entry.getKey(), entry.getValue());
        }
        return super.onLoginSuccess(token, subject, request, response);
    }
    /**
     * 登录重定向
     * @param request
     * @param response
     * @throws Exception
     */
    @Override
    protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
        System.out.println("重定向");
        String successUrl = getSuccessUrl();
        if (successUrl == null) {
            throw new IllegalStateException();
        }
        WebUtils.issueRedirect(request, response, successUrl, null, true);
    }
}
