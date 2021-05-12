package com.we.cloud.user.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.we.cloud.core.utils.PageUtil;
import com.we.cloud.user.domain.SysTenant;
import com.we.cloud.user.service.SysTenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @ClassName SysTenantController
 * @description 租户Controller
 * @author wecloud
 */
@RestController
@RequestMapping("/api/sys/tenant")
public class SysTenantController {

    @Autowired
    private SysTenantService service;

    /**
     * queryData : 查询租户列表信息
     *
     * @author wecloud
     * @param tenantName 租户名称
     * @param companyName 公司名称
     * @param enabled 启用状态
     */
    @GetMapping("/query")
    public ResponseEntity<List<SysTenant>> queryData(@RequestParam(value = "tenantName", required = false) String tenantName,
                                                     @RequestParam(value = "companyName", required = false) String companyName,
                                                     @RequestParam(value = "enabled", required = false) Integer enabled,
                                                     @RequestParam(value = "page", defaultValue = "1") int page,
                                                     @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){

        Page mybatisPage = PageUtil.getPage(page, pageSize);

        return new ResponseEntity(service.queryData(mybatisPage, tenantName, companyName, enabled), PageUtil.getTotalHeader(mybatisPage),HttpStatus.OK);
    }

    /**
     * submitData : 提交租户信息
     *
     * @author wecloud
     * @param data 租户信息
     */
    @PostMapping("/submit")
    public ResponseEntity submitData(@RequestBody SysTenant data){

        service.submitData(data);
        return ResponseEntity.ok(true);
    }

    /**
     * deleteData : 删除租户信息
     *
     * @author wecloud
     * @param ids 租户ID
     */
    @PostMapping("/delete")
    public ResponseEntity deleteData(@RequestBody List<Long> ids){
        service.deleteData(ids);
        return ResponseEntity.ok(true);
    }
}