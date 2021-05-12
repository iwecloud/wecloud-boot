package com.we.cloud.user.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.we.cloud.core.utils.PageUtil;
import com.we.cloud.user.domain.SysUserRole;
import com.we.cloud.user.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/sys/user/role")
public class SysUserRoleController {

    @Autowired
    private SysUserRoleService service;

    @GetMapping("/query")
    public ResponseEntity<List<SysUserRole>> queryData(@RequestParam(value = "page", defaultValue = "1") int page,
                                                       @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){

        Page mybatisPage = PageUtil.getPage(page, pageSize);

        return new ResponseEntity(service.queryData(mybatisPage), PageUtil.getTotalHeader(mybatisPage),HttpStatus.OK);
    }

    @PostMapping("/submit")
    public ResponseEntity submitData(@RequestBody SysUserRole data){

        service.submitData(data);
        return ResponseEntity.ok(true);
    }


    @PostMapping("/delete")
    public ResponseEntity deleteData(@RequestBody List<Long> ids){
        service.deleteData(ids);
        return ResponseEntity.ok(true);
    }
}