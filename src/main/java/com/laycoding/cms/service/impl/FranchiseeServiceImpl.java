package com.laycoding.cms.service.impl;

import com.laycoding.cms.mapper.FranchiseeMapper;
import com.laycoding.cms.pojo.Contract;
import com.laycoding.cms.pojo.Franchisee;
import com.laycoding.cms.service.FranchiseeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class FranchiseeServiceImpl implements FranchiseeService {
    @Resource
    private FranchiseeMapper franchiseeMapper;

    @Override
    public List<Franchisee> getAllContract(int sys_cs_id, String sys_cs_name, int sys_cs_status) {
        return franchiseeMapper.getAllContract(sys_cs_id,sys_cs_name,sys_cs_status);
    }
    @Override
    public List<String> getRegion() {
        return franchiseeMapper.getRegion();
    }

    @Override
    public int updateFranchisee(Franchisee franchisee) {
        return franchiseeMapper.updateFranchisee(franchisee);
    }

    @Override
    public int addFranchisee(Franchisee franchisee) {
        return franchiseeMapper.addFranchisee(franchisee);
    }

    @Override
    public int updateContract(int id) {
        return franchiseeMapper.updateContract(id);
    }

    @Override
    public int deleteFranchisee(int sys_cs_id) {
        return franchiseeMapper.deleteFranchisee(sys_cs_id);
    }


    @Override
    public int updateStatus(@Param("sys_cs_id") int sys_cs_id,@Param("sys_cs_status") int sys_cs_status) {
        return franchiseeMapper.updateStatus(sys_cs_id,sys_cs_status);
    }

    @Override
    public List<Franchisee> getByRegion(String sys_cs_region,int sys_cs_project) {
        return franchiseeMapper.getByRegion(sys_cs_region,sys_cs_project);
    }

    @Override
    public List<Franchisee> getFranchiseeById(@Param("sys_cs_id") int sys_cs_id) {
        return franchiseeMapper.getFranchiseeById(sys_cs_id);
    }

    @Override
    public List<Franchisee> getFranchiseeByIf(int sys_cs_id, String sys_cs_name, String sys_cs_company, String sys_cs_phone) {
        return franchiseeMapper.getFranchiseeByIf(sys_cs_id,sys_cs_name,sys_cs_company,sys_cs_phone);
    }
}
