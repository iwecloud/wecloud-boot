package com.we.cloud.user.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.we.cloud.core.base.BaseDomain;
import lombok.Data;

@Data
@TableName("sys_organization")
public class SysOrganization extends BaseDomain {

    /**
     * ID
     */
    @TableId
    private Long id;

    /**
     * 组织名称
     */
    @TableField
    private String organizationName;

    /**
     * 父级组织ID
     */
    @TableField
    private Long parentId;

    /**
     * 排序号
     */
    @TableField
    private Long sortNum;

}
