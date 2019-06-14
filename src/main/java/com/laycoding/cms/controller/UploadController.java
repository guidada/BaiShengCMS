package com.laycoding.cms.controller;

import com.laycoding.cms.service.ContractService;
import com.laycoding.cms.tools.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/file")
public class UploadController {
    @Resource
    private ContractService contractService;
    @RequestMapping(value = "/fileUploads", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") MultipartFile[] files,int sys_cs_num, HttpServletRequest request) {
        String fileName1="";
        //String filePath = "/var/local/upload/";linux下
        if(files != null && files.length != 0){
            if(null != files && files.length > 0){
                //遍历并保存文件
                for(MultipartFile file : files){
                    fileName1 = file.getOriginalFilename();
                    String suffixName1 = fileName1.substring(fileName1.lastIndexOf("."));
                 // String filePath1 = "D://upload//"+sys_cs_num+"//";
                    String filePath1 = "/var/local/upload/"+sys_cs_num+"/";
                    fileName1 = UUID.randomUUID() + suffixName1;
                    File dest1 = new File(filePath1 + fileName1);
                    if (!dest1.getParentFile().exists()) {
                        dest1.getParentFile().mkdirs();
                    }
                    try {
                        file.transferTo(dest1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        int res=contractService.addImage(sys_cs_num,fileName1);
        if (res>0){
            return JsonResult.jsonResult(0,"succse",fileName1,null);
        }else {
            return JsonResult.jsonResult(-1,"erro",null,null);
        }
    }
    private Boolean isImageFile(String fileName) {
        String[] img_type = new String[]{".jpg", ".jpeg", ".png", ".gif", ".bmp"};
        if (fileName == null) {
            return false;
        }
        fileName = fileName.toLowerCase();
        for (String type : img_type) {
            if (fileName.endsWith(type)) {
                return true;
            }
        }
        return false;
    }
    /**
     * 获取文件后缀名
     *
     * @param fileName
     * @return
     */
    private String getFileType(String fileName) {
        if (fileName != null && fileName.indexOf(".") >= 0) {
            return fileName.substring(fileName.lastIndexOf("."), fileName.length());
        }
        return "";
    }
}
