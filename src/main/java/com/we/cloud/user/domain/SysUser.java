package com.we.cloud.user.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.we.cloud.core.base.BaseDomain;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName SysUser
 * @description
 * @author wecloud
 */
@Data
@TableName("sys_user")
public class SysUser extends BaseDomain implements Serializable {

    /**
     * 用户ID
     */
    @TableId
    private Long id;

    /**
     * 租户ID
     */
    @TableField
    private Long tenantId;

    /**
     * 登录名
     */
    @TableField
    private String loginname;

    /**
     * 密码
     */
    @TableField
    private String password;

    /**
     * 用户姓名
     */
    @TableField
    private String name;

    /**
     * 性别：W/M
     */
    @TableField
    private String sex;

    /**
     * 电话
     */
    @TableField
    private String phone;

    /**
     * 邮箱
     */
    @TableField
    private String email;

    /**
     * 锁定：1: 锁定/ 0: 未锁定
     */
    @TableField
    private Integer locked;

    /**
     * 是否启用: 1:启用/ 0:禁用
     */
    @TableField
    private Integer enabled;
}