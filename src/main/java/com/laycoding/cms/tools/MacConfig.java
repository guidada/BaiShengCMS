package com.laycoding.cms.tools;

import java.math.BigInteger;

public class MacConfig {
    /**
     * 生成mac地址核心逻辑
     *
     * @Description:
     * @author 666
     * @date Apr 4, 2018
     * @param start
     * @param count
     */
    public static String printWifi() {
        String arr[]={"TP-Link","Fast","cdddang","sggddt","sur","绝味鸭脖","从头做起","匆匆食品","ct-yang","sechrt","tthhh","skkskd"};
        String str[]={"-","_"};
        int sum=(int)(0+Math.random()*11);
        int sum1=(int)(0+Math.random()*1);
        int sum2=(int)(999+Math.random()*100000);
        String wifi1=arr[sum].concat(str[sum1]);
        String wifi=wifi1.concat(String.valueOf(sum2));
        return wifi;
    }
    public static String printMac(String start, int count) {
            int num1=count-1;
            int sum=(int)(0+Math.random()*num1);
            start = start.replaceAll(":", "");
            BigInteger num = new BigInteger(start, 16);
            BigInteger addNum = new BigInteger("1");
            String result = "";
            for (int i = 0; i < count; i++) {
                result = num.toString(16);//.toUpperCase()
                for (int j = 12 - result.length(); j > 0; j--) {
                    result = "0" + result;
                }
                if (i==sum){
                    return getMacAdr(result);
                }
                num = num.add(addNum);
            }
            return  "";
    }

    /**
     * 组成mac地址
     *
     * @Description:
     * @author 666
     * @date Apr 4, 2018
     * @param str
     * @return
     */
    public static String getMacAdr(String str) {
        StringBuilder result = new StringBuilder("");
        for (int i = 1; i <= 12; i++) {
            result.append(str.charAt(i - 1));
            if (i % 2 == 0) {
                result.append(":");
            }
        }
        return result.substring(0, 17);
    }
}
