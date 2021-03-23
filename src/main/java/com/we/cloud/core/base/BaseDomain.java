package com.we.cloud.core.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class BaseDomain {

    /**
     * 创建人ID
     */
    //@TableField(fill = FieldFill.INSERT)
    @JsonIgnore
    private Long createdBy;

    /**
     * 创建时间
     */
    //@TableField(fill = FieldFill.INSERT)
    @JsonIgnore
    private ZonedDateTime createdDate;

    /**
     * 更新人ID
     */
    //@TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonIgnore
    private Long lastUpdatedBy;

    /**
     * 更新时间
     */
    //@TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonIgnore
    private ZonedDateTime lastUpdatedDate;
}
