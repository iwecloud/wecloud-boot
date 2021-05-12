package com.we.cloud.user.web;

import com.we.cloud.user.domain.SysUser;
import com.we.cloud.user.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/sys/user")
public class SysUserController {

    @Autowired
    private SysUserService service;

    /**
     * querySysUser : 查询用户信息
     *
     * @author wecloud
     * @param loginname 登录名
     * @param name 用户名
     * @param sex 性别
     * @param phone 电话
     * @param enabled 启用状态
     */
    @PostMapping("/query")
    public ResponseEntity<List<SysUser>> querySysUser(@RequestParam(value = "loginname", required = false) String loginname,
                                                       @RequestParam(value = "name", required = false) String name,
                                                       @RequestParam(value = "sex", required = false) String sex,
                                                       @RequestParam(value = "phone", required = false) String phone,
                                                       @RequestParam(value = "enabled", required = false) Integer enabled){

        return new ResponseEntity(service.querySysUser(loginname, name, sex, phone, enabled), HttpStatus.OK);
    }

    /**
     * submitSysUser : 提交用户信息
     *
     * @author wecloud
     * @param sysUser 用户信息
     */
    @PostMapping("/submit")
    public ResponseEntity submitSysUser(@RequestBody SysUser sysUser){

        service.submitSysUser(sysUser);
        return ResponseEntity.ok(true);
    }
}
