package com.we.cloud.core.user.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.we.cloud.core.base.BaseDomain;
import lombok.Data;

/**
 * @ClassName SysUser
 * @description
 * @author wecloud
 */
@Data
@TableName("SYS_USER")
public class SysUser extends BaseDomain {

    /**
     * 用户ID
     */
    @TableId
    private long userId;

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
     * 锁定
     */
    @TableField
    private String locked;

    /**
     * 禁用
     */
    @TableField
    private String disabled;
}