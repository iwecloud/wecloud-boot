package com.we.cloud.core.utils;

import com.we.cloud.core.security.CustomUser;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @ClassName LoginContext
 * @description 当前登录用户信息获取工具类
 * @author wecloud
 */
public class LoginContext {


    public static CustomUser getUser(){
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        try{
            CustomUser user = (CustomUser) obj;
            return user;
        }catch (Exception e){
            return null;
        }
    }

    public static Long getUserId(){
        CustomUser customUser = getUser();
        if(null == customUser){
            return null;
        }

        return customUser.getId();
    }

    /**
     * getTenantId : 获取当前登录用户租户ID
     *
     * @author wecloud
     */
    public static Long getTenantId(){
        CustomUser user = getUser();

        if(null == user){
            return -1L;
        }
        return user.getTenant().getId();
    }
}
