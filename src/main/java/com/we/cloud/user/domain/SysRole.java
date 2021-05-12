package com.we.cloud.user.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.we.cloud.core.base.BaseDomain;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("sys_role")
public class SysRole extends BaseDomain implements Serializable {

    /**
     * ID
     */
    @TableId
    private Long id;

    /**
     * 编码
     */
    @TableField
    private String roleCode;

    /**
     * 名称
     */
    @TableField
    private String roleName;

    /**
     * 租户ID
     */
    @TableField
    private Long tenantId;

}