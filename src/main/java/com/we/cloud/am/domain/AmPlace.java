package com.we.cloud.am.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.we.cloud.core.base.BaseDomain;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("am_place")
public class AmPlace extends BaseDomain implements Serializable {

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
     * 名称
     */
    @TableField
    private String placeName;

    /**
     * 租户ID
     */
    @TableField
    private Long tenantId;

}