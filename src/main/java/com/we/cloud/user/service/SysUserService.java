package com.we.cloud.user.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.we.cloud.user.domain.SysUser;
import com.we.cloud.user.mapper.SysUserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService extends ServiceImpl<SysUserMapper, SysUser> {

    /**
     * querySysUser : 查询用户信息
     *
     * @author wecloud
     * @param loginname 登录名
     * @param name 用户名
     * @param sex 性别
     * @param phone 电话
     * @param enabled 启用状态
     */
    public List<SysUser> querySysUser(String loginname, String name, String sex, String phone, Integer enabled){

        return list(new QueryWrapper<SysUser>().like(StringUtils.isNotEmpty(loginname), "LOGINNAME", loginname)
                .like(StringUtils.isNotEmpty(name),"NAME", name)
                .eq(StringUtils.isNotEmpty(sex), "SEX", sex)
                .like(StringUtils.isNotEmpty(phone), "PHONE", phone)
                .eq(null != enabled, "ENABLED", enabled));
    }

    /**
     * submitSysUser : 提交用户信息
     *
     * @author wecloud
     * @param sysUser 用户信息
     */
    public void submitSysUser(SysUser sysUser){

        if(null == sysUser.getId()){
            // 生成密码
            String password = sysUser.getPassword();
            sysUser.setPassword("{bcrypt}" + new BCryptPasswordEncoder().encode(password));
        }else{
            // 清空密码
            sysUser.setPassword(null);
        }

        saveOrUpdate(sysUser);
    }

    public List<SysUser> queryUserByLoginname(String loginName){

        List<SysUser> userList = baseMapper.selectList(new QueryWrapper<SysUser>().eq("LOGINNAME", loginName));
        return userList;
    }
}
