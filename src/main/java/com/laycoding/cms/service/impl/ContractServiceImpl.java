package com.laycoding.cms.service.impl;

import com.laycoding.cms.mapper.ContractMapper;
import com.laycoding.cms.pojo.Contract;
import com.laycoding.cms.service.ContractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Resource
    private ContractMapper contractMapper;

    @Override
    public int clearFranchisee(int sys_ct_num) {
        return contractMapper.clearFranchisee(sys_ct_num);
    }

    @Override
    public List<String> getImageByNum(int sys_ct_num) {
         return contractMapper.getImageByNum(sys_ct_num);
    }
    @Override
    public int addImage(int sys_ct_num, String sys_ct_image) {
        return contractMapper.addImage(sys_ct_num,sys_ct_image);
    }
}
