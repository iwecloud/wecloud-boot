package com.we.cloud.user.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.we.cloud.user.domain.SysUserRole;
import com.we.cloud.user.mapper.SysUserRoleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserRoleService extends ServiceImpl<SysUserRoleMapper, SysUserRole> {


    public List<SysUserRole> queryData(Page mybatisPage){

        Page<SysUserRole> results = page(mybatisPage,new QueryWrapper<SysUserRole>());

        return results.getRecords();
    }

    public void submitData(SysUserRole data){

        saveOrUpdate(data);
    }

    public void deleteData(List<Long> ids){

        removeByIds(ids);
    }
}
