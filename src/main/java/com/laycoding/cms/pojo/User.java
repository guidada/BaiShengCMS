package com.laycoding.cms.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private  String sys_user;
    private  String sys_password;
    private  String sys_nick;
    private  int sys_status;
    private  String sys_create_time;
    private  String sys_update_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSys_user() {
        return sys_user;
    }

    public void setSys_user(String sys_user) {
        this.sys_user = sys_user;
    }

    public String getSys_password() {
        return sys_password;
    }

    public void setSys_password(String sys_password) {
        this.sys_password = sys_password;
    }
    public String getSys_nick() {
        return sys_nick;
    }

    public void setSys_nick(String sys_nick) {
        this.sys_nick = sys_nick;
    }

    public int getSys_status() {
        return sys_status;
    }
    public void setSys_status(int sys_status) {
        this.sys_status = sys_status;
    }
    public String getSys_create_time() {
        return sys_create_time;
    }
    public void setSys_create_time(String sys_create_time) {
        this.sys_create_time = sys_create_time;
    }
    public String getSys_update_time() {
        return sys_update_time;
    }
    public void setSys_update_time(String sys_update_time) {
        this.sys_update_time = sys_update_time;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", sys_user='" + sys_user + '\'' +
                ", sys_password='" + sys_password + '\'' +
                ", sys_nick='" + sys_nick + '\'' +
                ", sys_status=" + sys_status +
                ", sys_create_time='" + sys_create_time + '\'' +
                ", sys_update_time='" + sys_update_time + '\'' +
                '}';
    }
}