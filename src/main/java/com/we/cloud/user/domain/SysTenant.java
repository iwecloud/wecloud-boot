package com.we.cloud.user.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.we.cloud.core.base.BaseDomain;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName SysTenant
 * @description 租户信息
 * @author wecloud
 */
@Data
@TableName("sys_tenant")
public class SysTenant extends BaseDomain implements Serializable {

    /**
     * 租户ID
     */
    @TableId
    private Long id;

    /**
     * 租户名称
     */
    @TableField
    private String tenantName;

    /**
     * 公司名称
     */
    @TableField
    private String companyName;

    /**
     * 用户数限制
     */
    @TableField
    private Long userLimit;

    /**
     * 启用状态, 1:启用, 0:禁用
     */
    @TableField
    private Integer enabled;

}