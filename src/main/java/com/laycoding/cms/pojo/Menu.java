package com.laycoding.cms.pojo;

import java.io.Serializable;

public class Menu implements Serializable {
    private int id;
    private int pid;
    private String title;
    private String icon;
    private String url;
    private int is_show;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getIs_show() {
        return is_show;
    }

    public void setIs_show(int is_show) {
        this.is_show = is_show;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", pid=" + pid +
                ", title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                ", url='" + url + '\'' +
                ", is_show=" + is_show +
                '}';
    }
}
