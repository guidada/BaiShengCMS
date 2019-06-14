package com.laycoding.cms.pojo;

import java.io.Serializable;

public class RolePermission implements Serializable {
    private int id;
    private int pid;
    private int role_id;
    private int permission_id;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(int permission_id) {
        this.permission_id = permission_id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public String toString() {
        return "RolePermission{" +
                "id=" + id +
                ", pid=" + pid +
                ", role_id=" + role_id +
                ", permission_id=" + permission_id +
                ", title='" + title + '\'' +
                '}';
    }
}
