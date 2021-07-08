package com.we.cloud.am.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.we.cloud.core.base.BaseDomain;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("am_auto_approval_rule")
public class AmAutoApprovalRule extends BaseDomain implements Serializable {

    /**
     * ID
     */
    @TableId
    private Long id;

    /**
     * 编码
     */
    @TableField
    private String placeCode;


    /**
     * 租户ID
     */
    @TableField
    private Long tenantId;

}