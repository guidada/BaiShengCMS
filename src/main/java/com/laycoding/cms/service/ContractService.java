package com.laycoding.cms.service;

import com.laycoding.cms.pojo.Contract;

import java.util.List;

public interface ContractService {
    int clearFranchisee(int sys_ct_num);
    List<String> getImageByNum(int sys_ct_num);
    int addImage(int sys_ct_num,String sys_ct_image);

}
