package com.we.cloud.user.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.we.cloud.core.base.BaseDomain;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("sys_user_role")
public class SysUserRole extends BaseDomain implements Serializable {

    /**
     * ID
     */
    @TableId
    private Long id;

    /**
     * 角色ID
     */
    @TableField
    private Long roleId;

    /**
     * 用户ID
     */
    @TableField
    private Long userId;

    /**
     * 租户ID
     */
    @TableField
    private Long tenantId;

}