package com.laycoding.cms.service;

import com.laycoding.cms.pojo.Contract;
import com.laycoding.cms.pojo.Franchisee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FranchiseeService {
    List<Franchisee> getAllContract(int sys_cs_id,String sys_cs_name,int sys_cs_status);
    List<String> getRegion();
    int updateFranchisee(Franchisee franchisee);
    int addFranchisee(Franchisee franchisee);
    int updateContract(int id);
    int deleteFranchisee(int sys_cs_id);
    int updateStatus(@Param("sys_cs_id") int sys_cs_id,@Param("sys_cs_status") int sys_cs_status);
    List<Franchisee> getByRegion(String sys_cs_region,int sys_cs_project);
    List<Franchisee> getFranchiseeById(@Param("sys_cs_id") int sys_cs_id);
    List<Franchisee> getFranchiseeByIf(int sys_cs_id,String sys_cs_name,String sys_cs_company,String sys_cs_phone);
}
