package com.laycoding.cms.pojo;

import java.io.Serializable;

public class Contract implements Serializable {
    private  int sys_ct_num;//合同唯一编号
    private  String sys_ct_image;//合同照

    public int getSys_ct_num() {
        return sys_ct_num;
    }

    public void setSys_ct_num(int sys_ct_num) {
        this.sys_ct_num = sys_ct_num;
    }

    public String getSys_ct_image() {
        return sys_ct_image;
    }

    public void setSys_ct_image(String sys_ct_image) {
        this.sys_ct_image = sys_ct_image;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "sys_ct_num=" + sys_ct_num +
                ", sys_ct_image='" + sys_ct_image + '\'' +
                '}';
    }
}
