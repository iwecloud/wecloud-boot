package com.we.cloud.user.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.we.cloud.user.domain.SysRole;
import com.we.cloud.user.domain.SysUserRole;
import com.we.cloud.user.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysRoleService extends ServiceImpl<SysRoleMapper, SysRole> {

    @Autowired
    private SysUserRoleService userRoleService;

    public List<SysRole> queryData(Page mybatisPage){

        Page<SysRole> results = page(mybatisPage,new QueryWrapper<SysRole>());

        return results.getRecords();
    }

    public List<SysRole> queryUserRoleList(Long userId, Long tenantId){

        List<SysUserRole> userRoles = userRoleService.list(new QueryWrapper<SysUserRole>().eq("USER_ID", userId).eq("TENANT_ID", tenantId));
        if(CollectionUtils.isEmpty(userRoles)){
            return null;
        }

        List<Long> roleIds = userRoles.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());

        return listByIds(roleIds);
    }

    public void submitData(SysRole data){

        saveOrUpdate(data);
    }

    public void deleteData(List<Long> ids){

        removeByIds(ids);
    }
}
