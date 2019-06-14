package com.laycoding.cms.pojo;

import java.io.Serializable;

public class UserRole implements Serializable {
    private int user_id;
    private int role_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "user_id=" + user_id +
                ", role_id=" + role_id +
                '}';
    }
}
