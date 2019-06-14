package com.laycoding.cms.mapper;

import com.laycoding.cms.pojo.Contract;

import java.util.List;

public interface ContractMapper {
      List<String> getImageByNum(int sys_ct_num);
      int clearFranchisee(int sys_ct_num);
      int addImage(int sys_ct_num,String sys_ct_image);
}
