package com.we.cloud.am.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.we.cloud.core.base.BaseDomain;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("am_apply")
public class AmApply extends BaseDomain{

    /**
     * ID
     */
    @TableId
    private Long id;

    /**
     * 编码
     */
    @TableField
    private String applyCode;

    /**
     * 申请地点
     */
    @TableField
    private String placeCode;

    /**
     * 使用时间
     */
    @TableField
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date applyDay;

    /**
     * 开始时间
     */
    @TableField
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startDate;

    /**
     * 结束时间
     */
    @TableField
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endDate;

    /**
     * 申请人
     */
    @TableField
    private Long userId;

    @TableField(exist = false)
    private Long userName;

    /**
     * 参与人数
     */
    @TableField
    private Long joinNum;

    /**
     * 现场负责人
     */
    @TableField
    private String chargeName;

    /**
     * 现场负责人联系方式
     */
    @TableField
    private String chargePhone;

    /**
     * 附件OID
     */
    @TableField
    private String oid;

    /**
     * 智能审批状态: 0:未审批 1:审批通过 2:审批拒绝
     */
    @TableField
    private Long smartStatus;

    /**
     * 智能审批意见
     */
    @TableField
    private String smartComments;

    /**
     * 人工审批状态: 0:未审批 1:审批通过 2:审批拒绝
     */
    @TableField
    private Long approvalStatus;

    /**
     * 审批人ID
     */
    @TableField
    private Long approvalUserId;

    /**
     * 审批意见
     */
    @TableField
    private String approvalComments;

    /**
     * 租户ID
     */
    @TableField
    private Long tenantId;

}