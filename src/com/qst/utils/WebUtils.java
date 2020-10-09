package com.qst.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class WebUtils {
    public  static <T> T  copyParamToBean(Map  value, T bean){

        try {

            System.out.println("注入之前"+bean);
            BeanUtils.populate(bean,value);
            System.out.println("注入之后"+bean);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bean;
    }

    //将字符串转换成为int形数据
    public static int parseInt(String strInt,int defaultValue){

        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
         /*   e.printStackTrace();*/
        }
        return defaultValue;
    }



}
