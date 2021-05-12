package com.we.cloud.system.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

// 菜单
@Data
@TableName("sys_menu_page")
public class SysMenuPage {

    /**
     * ID
     */
    @TableId
    private Long id;

    /**
     * 编码
     */
    @TableField
    private String pageCode;

    /**
     * 名称
     */
    @TableField
    private String pageName;

    /**
     * 页面文件地址
     */
    @TableField
    private String pageComponent;

}
