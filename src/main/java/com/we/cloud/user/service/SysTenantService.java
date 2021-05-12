package com.we.cloud.user.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.we.cloud.user.domain.SysTenant;
import com.we.cloud.user.mapper.SysTenantMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysTenantService extends ServiceImpl<SysTenantMapper, SysTenant> {


    public List<SysTenant> queryTenantById(List<Long> tenantIds){
        return list(new QueryWrapper<SysTenant>().in("ID", tenantIds));
    }

    /**
     * queryData : 查询租户列表信息
     *
     * @author wecloud
     * @param tenantName 租户名称
     * @param companyName 公司名称
     * @param enabled 启用状态
     */
    public List<SysTenant> queryData(Page mybatisPage, String tenantName, String companyName, Integer enabled){

        Page<SysTenant> results = page(mybatisPage,new QueryWrapper<SysTenant>()
                .like(StringUtils.isNotEmpty(tenantName),"TENANT_NAME", tenantName)
                .like(StringUtils.isNotEmpty(companyName),"COMPANY_NAME", companyName)
                .eq(null != enabled,"ENABLED", enabled));

        return results.getRecords();
    }

    /**
     * submitData : 提交租户信息
     *
     * @author wecloud
     * @param data 租户信息
     */
    public void submitData(SysTenant data){

        if(StringUtils.isEmpty(data.getCompanyName())){
            data.setCompanyName(data.getTenantName());
        }

        saveOrUpdate(data);

        // TODO: 给该租户初始化一条角色信息

    }

    /**
     * deleteData : 删除租户信息
     *
     * @author wecloud
     * @param ids 租户ID
     */
    public void deleteData(List<Long> ids){

        removeByIds(ids);
    }
}
