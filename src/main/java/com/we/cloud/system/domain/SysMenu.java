package com.we.cloud.system.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

// 菜单
@Data
@TableName("sys_menu")
public class SysMenu {

    /**
     * ID
     */
    @TableId
    private Long id;

    /**
     * 编码
     */
    @TableField
    private String menuCode;

    /**
     * 名称
     */
    @TableField
    private String menuName;

    /**
     * 菜单类型：GROUP:菜单组，MENU:菜单
     */
    @TableField
    private String menuType;

    /**
     * 父级菜单ID
     */
    @TableField
    private Long parentMenuId;

    /**
     * 排序号
     */
    @TableField
    private Long sort;
}
