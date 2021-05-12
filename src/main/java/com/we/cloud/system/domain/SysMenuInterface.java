package com.we.cloud.system.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

// API接口
@Data
@TableName("sys_menu_interface")
public class SysMenuInterface {

    /**
     * ID
     */
    @TableId
    private Long id;

    /**
     * 所属页面编码
     */
    @TableField
    private Long pageId;

    /**
     * 编码
     */
    @TableField
    private String interfaceCode;

    /**
     * 名称
     */
    @TableField
    private String interfaceName;

    /**
     * 请求类型：GET/POST
     */
    @TableField
    private String requestType;

    /**
     * api地址
     */
    @TableField
    private String requestApi;



}
