package com.bookmail.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author wxy
 * @title: ToBeanUtils
 * @description: TODO
 * @date 2021/7/1821:32
 */
public class ToBeanUtils {

    public static <T> T paramToBean(Map value, T bean){
        try {
            System.out.println("注入前：" + bean);
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("注入后：" + bean);
        return bean;
    }
}
