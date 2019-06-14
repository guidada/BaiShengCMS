package com.laycoding.cms.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Created by fuxiaoj on 2018/04/17 15:11
 */
public class ShiroToken extends UsernamePasswordToken {

    private String authCode;

    public ShiroToken(String username, String password, String authCode) {
        super(username, password);
        this.authCode = authCode;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
}
