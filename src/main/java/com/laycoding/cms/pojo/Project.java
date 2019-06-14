package com.laycoding.cms.pojo;

import java.io.Serializable;

public class Project implements Serializable {
    private int id;
    private String sys_project_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSys_project_name() {
        return sys_project_name;
    }

    public void setSys_project_name(String sys_project_name) {
        this.sys_project_name = sys_project_name;
    }
    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", sys_project_name='" + sys_project_name + '\'' +
                '}';
    }
}
