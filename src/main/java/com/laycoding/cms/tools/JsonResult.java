package com.laycoding.cms.tools;

import com.alibaba.fastjson.JSONObject;

public class JsonResult {
    public static String jsonResult(int code, String msg, Object data,Object redisData){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",code);
        jsonObject.put("msg",code);
        jsonObject.put("data",data);
        jsonObject.put("count",redisData);
        return jsonObject.toString();
    }
}
