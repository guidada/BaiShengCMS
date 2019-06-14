package com.laycoding.cms.pojo;

import java.io.Serializable;

public class Franchisee implements Serializable{
    private int id;
    private int sys_cs_id;
    private  String sys_cs_name;
    private  String sys_cs_company;
    private  String sys_cs_type;
    private  String sys_cs_num;
    private  String sys_cs_money;
    private  int sys_cs_project;
    private  String sys_cs_status;
    private  String sys_cs_remarks;
    private  String sys_cs_phone;
    private  String sys_cs_license;
    private  String sys_cs_idcard;
    private  String sys_cs_address;
    private  String sys_cs_zipcode;
    private  String sys_cs_email;
    private  String sys_cs_region;
    private  String sys_create_time;
    private  String sys_over_time;
    private  String sys_company_address;
    private  int sys_cs_sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSys_cs_id() {
        return sys_cs_id;
    }

    public void setSys_cs_id(int sys_cs_id) {
        this.sys_cs_id = sys_cs_id;
    }

    public String getSys_cs_name() {
        return sys_cs_name;
    }

    public void setSys_cs_name(String sys_cs_name) {
        this.sys_cs_name = sys_cs_name;
    }

    public String getSys_cs_company() {
        return sys_cs_company;
    }

    public void setSys_cs_company(String sys_cs_company) {
        this.sys_cs_company = sys_cs_company;
    }

    public String getSys_cs_type() {
        return sys_cs_type;
    }

    public void setSys_cs_type(String sys_cs_type) {
        this.sys_cs_type = sys_cs_type;
    }

    public String getSys_cs_num() {
        return sys_cs_num;
    }

    public void setSys_cs_num(String sys_cs_num) {
        this.sys_cs_num = sys_cs_num;
    }

    public String getSys_cs_money() {
        return sys_cs_money;
    }

    public void setSys_cs_money(String sys_cs_money) {
        this.sys_cs_money = sys_cs_money;
    }

    public int getSys_cs_project() {
        return sys_cs_project;
    }

    public void setSys_cs_project(int sys_cs_project) {
        this.sys_cs_project = sys_cs_project;
    }

    public String getSys_cs_status() {
        return sys_cs_status;
    }

    public void setSys_cs_status(String sys_cs_status) {
        this.sys_cs_status = sys_cs_status;
    }

    public String getSys_cs_remarks() {
        return sys_cs_remarks;
    }

    public void setSys_cs_remarks(String sys_cs_remarks) {
        this.sys_cs_remarks = sys_cs_remarks;
    }

    public String getSys_cs_phone() {
        return sys_cs_phone;
    }

    public void setSys_cs_phone(String sys_cs_phone) {
        this.sys_cs_phone = sys_cs_phone;
    }

    public String getSys_cs_license() {
        return sys_cs_license;
    }

    public void setSys_cs_license(String sys_cs_license) {
        this.sys_cs_license = sys_cs_license;
    }

    public String getSys_cs_idcard() {
        return sys_cs_idcard;
    }

    public void setSys_cs_idcard(String sys_cs_idcard) {
        this.sys_cs_idcard = sys_cs_idcard;
    }

    public String getSys_cs_address() {
        return sys_cs_address;
    }

    public void setSys_cs_address(String sys_cs_address) {
        this.sys_cs_address = sys_cs_address;
    }

    public String getSys_cs_zipcode() {
        return sys_cs_zipcode;
    }

    public void setSys_cs_zipcode(String sys_cs_zipcode) {
        this.sys_cs_zipcode = sys_cs_zipcode;
    }

    public String getSys_cs_email() {
        return sys_cs_email;
    }

    public void setSys_cs_email(String sys_cs_email) {
        this.sys_cs_email = sys_cs_email;
    }

    public String getSys_cs_region() {
        return sys_cs_region;
    }

    public void setSys_cs_region(String sys_cs_region) {
        this.sys_cs_region = sys_cs_region;
    }

    public String getSys_create_time() {
        return sys_create_time;
    }

    public void setSys_create_time(String sys_create_time) {
        this.sys_create_time = sys_create_time;
    }

    public String getSys_over_time() {
        return sys_over_time;
    }

    public void setSys_over_time(String sys_over_time) {
        this.sys_over_time = sys_over_time;
    }

    public String getSys_company_address() {
        return sys_company_address;
    }

    public void setSys_company_address(String sys_company_address) {
        this.sys_company_address = sys_company_address;
    }

    public int getSys_cs_sex() {
        return sys_cs_sex;
    }

    public void setSys_cs_sex(int sys_cs_sex) {
        this.sys_cs_sex = sys_cs_sex;
    }

    @Override
    public String toString() {
        return "Franchisee{" +
                "id=" + id +
                ", sys_cs_id=" + sys_cs_id +
                ", sys_cs_name='" + sys_cs_name + '\'' +
                ", sys_cs_company='" + sys_cs_company + '\'' +
                ", sys_cs_type='" + sys_cs_type + '\'' +
                ", sys_cs_num='" + sys_cs_num + '\'' +
                ", sys_cs_money='" + sys_cs_money + '\'' +
                ", sys_cs_project=" + sys_cs_project +
                ", sys_cs_status='" + sys_cs_status + '\'' +
                ", sys_cs_remarks='" + sys_cs_remarks + '\'' +
                ", sys_cs_phone='" + sys_cs_phone + '\'' +
                ", sys_cs_license='" + sys_cs_license + '\'' +
                ", sys_cs_idcard='" + sys_cs_idcard + '\'' +
                ", sys_cs_address='" + sys_cs_address + '\'' +
                ", sys_cs_zipcode='" + sys_cs_zipcode + '\'' +
                ", sys_cs_email='" + sys_cs_email + '\'' +
                ", sys_cs_region='" + sys_cs_region + '\'' +
                ", sys_create_time='" + sys_create_time + '\'' +
                ", sys_over_time='" + sys_over_time + '\'' +
                ", sys_company_address='" + sys_company_address + '\'' +
                ", sys_cs_sex=" + sys_cs_sex +
                '}';
    }
}
